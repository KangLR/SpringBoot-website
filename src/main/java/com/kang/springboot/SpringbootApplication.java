package com.kang.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//程序的主入口
//点进去会发现@Component ,这个类本身就是spring的一个组件
@SpringBootApplication  //这个注解标注这个类是一个springboot的应用
public class SpringbootApplication {

    public static void main(String[] args) {
        //通过这个静态方法将sb应用启动
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
