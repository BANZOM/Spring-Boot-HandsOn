package com.firstspringboot.firstspringboot.service;

import org.springframework.stereotype.Service;

@Service
public class GetFactorial {
    public int find (int n) {
        // return factorial
        if(n==1) return 1;
        return n*find(n-1);
    }
}
