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
    private static final String template = "Hello, %s!";
    private static AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingRepository greetingRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Greeting getGreeting(long id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public List<Greeting> getAllGreeting() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting addGreeting(UserDTO userDTO) {
        String name = "";
        name += (userDTO.getFirstName() != null) ? (userDTO.getLastName() != null) ?
                userDTO.getFirstName() + " " + userDTO.getLastName() : userDTO.getFirstName() : "";
        name = (name.equals("")) ? "World" : name;
        Greeting greeting = modelMapper.map(new GreetingDTO(String.format(template, name)), Greeting.class);
        return greetingRepository.save(greeting);
    }

    @Override
    public Greeting updateGreeting(long id, String name) {
        Greeting greeting = greetingRepository.findById(id).get();
        greeting.setMessage(String.format(template, name));
        return greetingRepository.save(greeting);
    }

    @Override
    public void deleteGreeting(long id) {
        greetingRepository.delete(greetingRepository.getOne(id));
    }
}
