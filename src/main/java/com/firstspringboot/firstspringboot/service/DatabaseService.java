package com.firstspringboot.firstspringboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    @Value("${db.user}")
    private String dbUser;

    @Value("${db.password}")
    private String dbPassword;

    @Value("${db.host}")
    private String dbHost;

    @Value("${db.port}")
    private String dbPort;

    @Value("${db.url}")
    private String dbUrl;

    public String toString() {
        return "DatabaseService{" +
                "dbUser='" + dbUser + '\'' +
                ", dbPassword='" + dbPassword + '\'' +
                ", dbUrl='" + dbUrl + '\'' +
                ", dbPort='" + dbPort + '\''
                + '}';
    }

}
