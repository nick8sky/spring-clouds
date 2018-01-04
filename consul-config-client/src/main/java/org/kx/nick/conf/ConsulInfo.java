package org.kx.nick.conf;


import consul.KeyValue;

/**
 * create by sunkx on ${date}
 */
public class ConsulInfo {
    private String keyName;
    private KeyValue keyValue;

    public ConsulInfo(String keyName, KeyValue keyValue) {
        this.keyName = keyName;
        this.keyValue = keyValue;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public KeyValue getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(KeyValue keyValue) {
        this.keyValue = keyValue;
    }
}
