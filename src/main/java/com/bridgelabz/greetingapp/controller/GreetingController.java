package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.GreetingDTO;
import com.bridgelabz.greetingapp.dto.UserDTO;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greetingcontroller")
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingService greetingService;

    @RequestMapping("/home/{name}")
    public GreetingDTO greeting(@PathVariable String name) {
        return new GreetingDTO(counter.incrementAndGet(), greetingService.getGreeting(name));
    }

    @RequestMapping("/home/{firstName}/{lastName}")
    public GreetingDTO greeting(@PathVariable String firstName, @PathVariable String lastName) {
        return new GreetingDTO(counter.incrementAndGet(), greetingService.getGreeting(firstName, lastName));
    }

    @GetMapping("/greeting")
    public GreetingDTO greetingParam(@RequestParam(value = "firstName", defaultValue = "") String firstName,
                                     @RequestParam(value = "lastName", defaultValue = "") String lastName) {
        return new GreetingDTO(counter.incrementAndGet(), greetingService.getGreeting(firstName, lastName));
    }

    @PostMapping("/post")
    public Greeting greeting(@RequestBody UserDTO user) {
        return greetingService.addGreeting(user);
    }

    @PutMapping("/put/{name}")
    public GreetingDTO greeting(@PathVariable String name, @RequestParam(value = "id") long id) {
        return new GreetingDTO(id, greetingService.updateGreeting(name));
    }

    @PutMapping("/put/{firstName}/{lastName}")
    public GreetingDTO greeting(@PathVariable String firstName, @PathVariable String lastName
            , @RequestParam(value = "id") long id) {
        return new GreetingDTO(id, greetingService.updateGreeting(firstName, lastName));
    }

    @DeleteMapping("/delete/{name}")
    public GreetingDTO greetingDelete(@PathVariable String name) {
        return new GreetingDTO(counter.incrementAndGet(), greetingService.deleteGreeting(name));
    }

    @DeleteMapping("/delete/{firstName}/{lastName}")
    public GreetingDTO greetingDelete(@PathVariable String firstName, @PathVariable String lastName) {
        return new GreetingDTO(counter.incrementAndGet(), greetingService.deleteGreeting(firstName, lastName));
    }
}
