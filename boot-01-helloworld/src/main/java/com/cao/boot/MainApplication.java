package com.cao.boot;

import com.cao.boot.bean.Pet;
import com.cao.boot.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序类
 * @SpringBootApplication: 这是一个 SpringBoot 应用
 */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        //获取容器中的组件
        User user1 = context.getBean("userBean", User.class);
        User user2 = context.getBean("userBean", User.class);
        System.out.println(user1 == user2);
        //获取
        User user = context.getBean("userBean", User.class);
        Pet pet = context.getBean("petBean", Pet.class);
        //proxyBeanMethods = true时， 从容器中取pet对象
        //proxyBeanMethods = false，重新new
        System.out.println(user.getPet() == pet);
        System.out.println("=================");
        String[] users = context.getBeanNamesForType(User.class);
        for (String s : users) {
            System.out.println(s);
        }
    }

}
