package org.kx.rules;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * create by sunkx on 2018/1/10
 */

public class Drools7Test {

    @Test
    public void testRules() {
        // 构建KieServices
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        // 获取kmodule.xml中配置中名称为ksession-rule的session，默认为有状态的。
        KieSession kSession = kieContainer.newKieSession("ksession-rule");

        Product product = new Product();
        product.setType(Product.DIAMOND);

        Product product2 = new Product();
        product2.setType(Product.GOLD);

        kSession.insert(product);
        kSession.insert(product2);
        int count = kSession.fireAllRules();
        System.out.println("命中了" + count + "条规则！");
        System.out.println("商品" +product.getType() + "的商品折扣为" + product.getDiscount() + "%。");
        System.out.println("商品" +product2.getType() + "的商品折扣为" + product2.getDiscount() + "%。");

    }
}
