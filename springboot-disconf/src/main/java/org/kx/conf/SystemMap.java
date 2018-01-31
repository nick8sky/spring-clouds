package org.kx.conf;


import com.alibaba.fastjson.JSON;
import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * create by sunkx on 2018/1/11
 */

@Service
@DisconfFile(filename = "map.properties")
@DisconfUpdateService(classes = {SystemMap.class})
public class SystemMap implements IDisconfUpdate {
    private static final String CONFIG_FILENAME = "/map.properties";
    private static Properties properties = null;
    private static final Logger logger = LoggerFactory.getLogger(SystemMap.class);

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    @Override
    public void reload() {
        try {
            Properties cfgProp = new Properties();
            String uri = SystemMap.class.getResource(CONFIG_FILENAME).getPath();
            cfgProp.load(new FileInputStream(uri));
            properties = cfgProp;
            logger.info("[new map is reload![{}]", JSON.toJSONString(properties));
        } catch (Exception e) {
            logger.error("[new map  reload error !", e);
        }
    }

    @PostConstruct
    public void init() {
        reload();
    }

    public static Properties getProperties() {
        return properties;
    }

}