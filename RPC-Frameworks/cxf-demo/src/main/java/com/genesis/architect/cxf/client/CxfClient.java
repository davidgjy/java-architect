package com.genesis.architect.cxf.client;

import com.genesis.architect.cxf.service.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author KG created on 16/12/4
 */
public class CxfClient {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:cxf-client.xml");
        HelloService client = (HelloService) context.getBean("helloClient");
        System.out.println(client.sayHello("Master HaKu"));
    }

}
