package com.firstspringboot.firstspringboot;

import org.springframework.stereotype.Component;

@Component("PojoBean2")
public class PojoBean2 {
    public PojoBean2(){
        System.out.println("PojoBean2 constructor");
    }
    public void show(){
        System.out.println("PojoBean2 show");
    }
}
