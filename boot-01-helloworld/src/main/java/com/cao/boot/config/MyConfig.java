package com.cao.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.cao.boot.bean.Pet;
import com.cao.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 1、@Bean注解标注在方法上注册组件，默认是singleton
 * 2、配置类本身也是一个组件
 * 3、proxyBeanMethods：代理Bean方法
 *      proxyBeanMethods = true：Full模式，外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
 *      proxyBeanMethods = false：lite模式，每个@Bean方法被调用多少次返回的组件都是新创建的
 * 4、@Import({User.class, DBHelper.class})
 *      给容器中自动创建这两个类型的组件
 */
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)//告诉SpringBoot这是一个配置类 == 配置文件
public class MyConfig {

    @Bean
    /*
        @Bean注解：
            默认是singleton
            给IOC容器中添加组件(bean)
            以方法名作为 bean 的 id
            以方法返回值类型作为 bean 的类型
            返回值就是容器中的一个 Bean
        这两个方法的作用和以下xml的配置相同：
            <bean id="userBean" class="com.cao.boot.bean.User" >
                <property name="name" value="ccc"/>
                <property name="age" value="22"/>
            </bean>
            <bean id="petBean" class="com.cao.boot.bean.Pet">
                <property name="name" value="汪汪"/>
                <property name="age" value="3"/>
            </bean>
     */
    public User userBean(){
        User clx = new User("clx", 22, petBean());
        return clx;
    }

    @Bean
    public Pet petBean(){
        return new Pet("汪汪",3);
    }
}
