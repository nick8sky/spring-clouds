package org.kx.nick.conf;

/**
 * create by sunkx on ${date}
 */

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import com.netflix.config.PollResult;
import com.netflix.config.PolledConfigurationSource;
import com.orbitz.consul.Consul;
import com.orbitz.consul.KeyValueClient;
import org.apache.http.util.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 指定archaius读取配置的源头
 */
public class ConsulConfigurationSource implements PolledConfigurationSource {

    public static final Logger LOGGER = LoggerFactory.getLogger(ConsulConfigurationSource.class);
    private ConsulInfo consulInfo;

    public ConsulConfigurationSource(ConsulInfo consulInfo) {
        this.consulInfo = consulInfo;
    }

    /**
     *动态拉去配置，默认60s拉一次
     */
    @Override
    public PollResult poll(boolean initial, Object checkPoint) throws Exception {
        String str = null;
        try {
            Consul consul = Consul.builder().build();
            KeyValueClient kvClient = consul.keyValueClient();
            str = kvClient.getValueAsString(consulInfo.getKeyName()).get();
        } catch (Throwable e) {
            LOGGER.error("get property from consul error", e);
        }
        Map<String, Object> map = new HashMap<>();
        if (TextUtils.isBlank(str)) {
            return PollResult.createFull(map);
        } else {
            Properties properties = new Properties();
            properties.load(new StringReader(str));
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                map.put(entry.getKey().toString(), entry.getValue());
            }

            return PollResult.createFull(map);
        }
    }
}
