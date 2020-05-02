package com.bridgelabz.greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements IGreetingService {

    @Override
    public String getGreeting() {
        return "Hello World";
    }

    @Override
    public String addGreeting() {
        return "Hello World";
    }

    @Override
    public String updateGreeting() {
        return "Hello World";
    }

    @Override
    public String deleteGreeting() {
        return "Hello World";
    }
}
