package com.firstspringboot.firstspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PojoBean {
    @Autowired // search by class type
    @Qualifier("PojoBean2") // search by name
    PojoBean2 bean2;

    public PojoBean(){
        System.out.println("PojoBean constructor");
    }
    
    public void show(){
        System.out.println("PojoBean show");
        bean2.show();
    }
}
