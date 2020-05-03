package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.GreetingDTO;
import com.bridgelabz.greetingapp.dto.UserDTO;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.repository.GreetingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingServiceImpl implements IGreetingService {
    private static final String template = "Hello,%s!";
    private static AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingRepository greetingRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Greeting getGreeting(Long... id) {
        return greetingRepository.findById(id[0]).get();
    }

    @Override
    public List<Greeting> getAllGreeting() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting addGreeting(UserDTO userDTO) {
        String name = "";
        name += (userDTO.getFirstName() != null) ? " " + userDTO.getFirstName() : "";
        name += (userDTO.getLastName() != null) ? " " + userDTO.getLastName() : "";
        name = (name.equals("")) ? "World" : name;
        Greeting greeting = modelMapper.map(new GreetingDTO(String.format(template, name)), Greeting.class);
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
