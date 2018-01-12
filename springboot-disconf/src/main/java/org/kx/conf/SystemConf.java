package org.kx.conf;


import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import org.springframework.stereotype.Component;

/**
 * create by sunkx on 2018/1/11
 */

@DisconfFile(filename = "system.properties")
@Component
public  class SystemConf {

    private  String name;


    @DisconfFileItem(name = "name", associateField = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
