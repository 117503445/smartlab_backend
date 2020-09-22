package com.wizzstudio.smartlab.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "push")
public class EnvironmentConfig {

    private List<String> serverChan;

    public List<String> getServerChan() {
        return serverChan;
    }

    public void setServerChan(List<String> serverChan) {
        this.serverChan = serverChan;
    }
}
