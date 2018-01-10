package org.kx.rules;

import lombok.Data;

/**
 * create by sunkx on 2018/1/10
 */
@Data
public class Product {
    /**
     * 钻石
     */
    public static final String DIAMOND = "DIAMOND";
    /**
     * 黄金
     */
    public static final String GOLD = "GOLD";
    /**
     * 类型
     */
    private String type;
    /**
     * 折扣
     */
    private int discount;


}
