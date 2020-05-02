package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.Greeting;
import com.bridgelabz.greetingapp.dto.User;
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
    IGreetingService greetingService;

    @RequestMapping("/home/{name}")
    public Greeting greeting(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(), greetingService.getGreeting());
    }

    @GetMapping("/greeting")
    public Greeting greetingParam(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), greetingService.getGreeting());
    }

    @PostMapping("/post")
    public Greeting greeting(@RequestBody User user) {
        return new Greeting(counter.incrementAndGet(), greetingService.addGreeting());
    }

    @PutMapping("/put/{name}")
    public Greeting greeting(@PathVariable String name, @RequestParam(value = "id") long id) {
        return new Greeting(id, greetingService.updateGreeting());
    }

    @DeleteMapping("/delete/{name}")
    public Greeting greetingDelete(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(), greetingService.deleteGreeting());
    }
}
