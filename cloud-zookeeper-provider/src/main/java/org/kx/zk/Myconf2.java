package org.kx.zk;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * create by sunkx on 2018/1/5
 */
@Data
//可以动态修改值,不需要重启
@ConfigurationProperties(prefix = "datasource")
public class Myconf2 {
    private String url;
    private String pass;
}
