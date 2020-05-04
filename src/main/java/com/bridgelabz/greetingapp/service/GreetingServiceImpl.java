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
        StringBuffer name = new StringBuffer();
        //Check if firstName provided and add To greeting
        if (userDTO.getFirstName() != null)
            name.append(userDTO.getFirstName());
        //Check if lastName provided and add to greeting after firstName
        if (userDTO.getLastName() != null)
            name.append((name.length() == 0) ? userDTO.getLastName() : " " + userDTO.getLastName());
        //If firstName and lastName not provided then take world as name
        if (name.length() == 0)
            name = new StringBuffer("World");
        Greeting greeting = modelMapper.map(new GreetingDTO(String.format(template, name)), Greeting.class);
        return greetingRepository.save(greeting);
    }

    @Override
    public Greeting updateGreeting(long id, String name) {
        //Find record to be updated using id
        Greeting greeting = greetingRepository.findById(id).get();
        //Change Message of that record
        greeting.setMessage(String.format(template, name));
        //Save modified record to repository
        return greetingRepository.save(greeting);
    }

    @Override
    public void deleteGreeting(long id) {
        greetingRepository.delete(greetingRepository.getOne(id));
    }
}
