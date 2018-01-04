package org.kx.nick.conf;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicConfiguration;
import com.netflix.config.FixedDelayPollingScheduler;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;

/**
 * create by sunkx on ${date}
 */
public class ConsulPropertySource extends MapPropertySource {
    private DynamicConfiguration configuration;

    public ConsulPropertySource(String name, ConsulInfo consulInfo) {
        super(name, new HashMap<String, Object>());

        FixedDelayPollingScheduler scheduler = new FixedDelayPollingScheduler();
        scheduler.setIgnoreDeletesFromSource(true);
        DynamicConfiguration configuration = new DynamicConfiguration(
                new ConsulConfigurationSource(consulInfo), scheduler);
        ConfigurationManager.install(configuration);
        this.configuration = configuration;
    }

    @Override
    public Object getProperty(String name) {
        return configuration.getProperty(name);
    }
}
