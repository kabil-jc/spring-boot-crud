package com.example.spring_boot_demo;

public class DriverTest {

        public static void main(String[] args) throws Exception {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully!");
        }
    }


