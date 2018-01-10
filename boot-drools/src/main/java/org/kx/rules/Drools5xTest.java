package org.kx.rules;

import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import java.util.Collection;

/**
 * create by sunkx on 2018/1/10
 */
public class Drools5xTest {
    public static void main(String[] args) {
        Drools5xTest test = new Drools5xTest();
        test.oldExecuteDrools();
    }

    private void oldExecuteDrools() {
        //KnowledgeBuilder 收集规则，并对规则文件进行编译，生成编译好的KnowledgePackage集合，提供给其他API使用
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("rules/product.drl", this.getClass()), ResourceType.DRL);
        if (kbuilder.hasErrors()) {
            System.out.println(kbuilder.getErrors().toString());
        }
        //KnowledgePackage	存放编译之后规则的对象
        Collection<KnowledgePackage> pkgs = kbuilder.getKnowledgePackages();
        //KnowledgeBase	收集应用当中知识（knowledge）定义的知识库对象（KnowledgePackage），
        // 在一个 KnowledgeBase 当中可以包含普通的规则（rule）、 规则流(rule flow)、函数定义(function)、
        // 用户自定义对象（type model）等，并创建session对象（StatefulKnowledgeSession和 StatelessKnowledgeSession）
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        // 将KnowledgePackage集合添加到KnowledgeBase当中
        kbase.addKnowledgePackages(pkgs);
        //StatefulKnowledgeSession	接收外部插入的数据fact对象（POJO），
        // 将编译好的规则包和业务数据通过fireAllRules()方法触发所有的规则执行。使用完成需调用dispose()方法以释放相关内存资源。

        //StatelessKnowledgeSession	对StatefulKnowledgeSession的封装实现，
        // 与其对比不需要调用dispose()方法释放内存，只能插入一次fact对象。
        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
        Product product = new Product();
        product.setType(Product.GOLD);
        ksession.insert(product);
        ksession.fireAllRules();
        ksession.dispose();

        System.out.println("The discount for the product " + product.getType().toString()
                + " is " + product.getDiscount()+"%");
    }
}