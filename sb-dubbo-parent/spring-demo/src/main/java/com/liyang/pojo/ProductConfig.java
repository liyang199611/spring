package com.liyang.pojo;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackageClasses =com.liyang.pojo.Product.class) //代表进行扫描，默认是扫描当前包的路径，扫描所有带有 @Component 注解的 POJO。
public class ProductConfig {
}
