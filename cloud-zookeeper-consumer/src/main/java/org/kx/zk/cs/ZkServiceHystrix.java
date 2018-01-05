package org.kx.zk.cs;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * create by sunkx on 2018/1/5
 */


@Component
public class ZkServiceHystrix implements ZkServiceProviderClient{

    @Override
    public String what() {
        return "error";
    }
}