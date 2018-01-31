package org.kx;

import com.alibaba.fastjson.JSON;
import org.kx.conf.Aname;
import org.kx.conf.SystemConf;
import org.kx.conf.SystemMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

/**
 * create by sunkx on 2018/1/11
 */

@SpringBootApplication
@ComponentScan(basePackages = {"org.kx.conf"})
@ImportResource({"classpath:spring-disconf.xml"})
@RestController
public class ConfApplication {

    @Autowired
    SystemConf systemConf;
    @Autowired
    SystemMap systemMap;
    @Autowired(required = false)
    Aname aname;


    public static void main(String[] args) {
        SpringApplication.run(ConfApplication.class, args);
    }

    @RequestMapping("/p")
    public String p() {
        return JSON.toJSONString(systemConf);
    }
    @RequestMapping("/m")
    public String m() {
        return JSON.toJSONString(systemMap.getProperties());
    }

    @RequestMapping("/b") //this.getClass().getResource(".").getPath()+
    public String b() {
        return readToString("/Users/sunkaixiang/IdeaProjects/spring-clouds-nick/springboot-disconf/target/classes/bean.xml");
    }

    public String readToString(String fileName) {
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }

}