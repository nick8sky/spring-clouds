package org.kx.redis.lua;


import java.util.List;

/**
 * create by sunkx on 2018/1/8
 */
public class KeyExample {
    public static void main(String[] args) {
        String tab = "order";
        long userId = 123456789;

        IdGenerator idGenerator = IdGenerator.builder()
                .addHost("192.168.1.101", 6379, "c5809078fa6d652e0b0232d552a9d06d37fe819c")
//              .addHost("127.0.0.1", 7379, "1abc55928f37176cb934fc7a65069bf32282d817")
//              .addHost("127.0.0.1", 8379, "b056d20feb3f89483b10c81027440cbf6920f74f")
                .build();

        long id = idGenerator.next(tab, userId);

        System.out.println("id:" + id);
        List<Long> result = IdGenerator.parseId(id);

        System.out.println("miliSeconds:" + result.get(0) + ", partition:"
                + result.get(1) + ", seq:" + result.get(2));
    }
}
        /*cd redis-directory/
        wget https://raw.githubusercontent.com/hengyunabc/redis-id-generator/master/redis-script-node1.lua
        ./redis-cli script load "$(cat /home/sunkx/22/redis-script-node1.lua)"
        c5809078fa6d652e0b0232d552a9d06d37fe819c*/