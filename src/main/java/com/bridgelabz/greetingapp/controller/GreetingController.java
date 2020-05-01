package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.Greeting;
import com.bridgelabz.greetingapp.dto.User;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greetingcontroller")
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/home/{name}")
    public Greeting greeting(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/greeting")
    public Greeting greetingParam(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping("/post")
    public Greeting greeting(@RequestBody User user) {
        return new Greeting(counter.incrementAndGet(), String.format(template, user.getName()));
    }

    @PutMapping("/put/{name}")
    public Greeting greeting(@PathVariable String name, @RequestParam(value = "id") long id) {
        return new Greeting(id, String.format(template, name));
    }
}
