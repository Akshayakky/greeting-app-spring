package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.GreetingDTO;
import com.bridgelabz.greetingapp.dto.UserDTO;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.repository.GreetingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingServiceImpl implements IGreetingService {
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingRepository greetingRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String getGreeting(String... name) {
        String greeting = "Hello";
        greeting += (name.length > 0) ? " " + name[0] : "";
        greeting += (name.length > 1) ? " " + name[1] : "";
        greeting = (greeting.equals("Hello")) ? "Hello World" : greeting;
        return greeting;
    }

    @Override
    public Greeting addGreeting(UserDTO userDTO) {
        String message = "Hello";
        message += (userDTO.getFirstName() != null) ? " " + userDTO.getFirstName() : "";
        message += (userDTO.getLastName() != null) ? " " + userDTO.getLastName() : "";
        message = (message.equals("Hello")) ? "Hello World" : message;
        Greeting greeting = modelMapper.map(new GreetingDTO(counter.incrementAndGet(), message), Greeting.class);
        return greetingRepository.save(greeting);
    }

    @Override
    public String updateGreeting(String... name) {
        String greeting = "Hello";
        greeting += (name.length > 0) ? " " + name[0] : "";
        greeting += (name.length > 1) ? " " + name[1] : "";
        greeting = (greeting.equals("Hello")) ? "Hello World" : greeting;
        return greeting;
    }

    @Override
    public String deleteGreeting(String... name) {
        String greeting = "Hello";
        greeting += (name.length > 0) ? " " + name[0] : "";
        greeting += (name.length > 1) ? " " + name[1] : "";
        greeting = (greeting.equals("Hello")) ? "Hello World" : greeting;
        return greeting;
    }
}
