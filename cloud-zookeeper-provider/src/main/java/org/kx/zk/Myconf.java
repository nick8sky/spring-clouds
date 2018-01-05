package org.kx.zk;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * create by sunkx on 2018/1/5
 */
@Data
//可以动态修改值,不需要重启
@ConfigurationProperties()
public class Myconf {
    private String name;
}
