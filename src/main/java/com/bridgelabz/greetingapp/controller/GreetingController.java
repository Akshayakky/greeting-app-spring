package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.GreetingDTO;
import com.bridgelabz.greetingapp.dto.UserDTO;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetingcontroller")
public class GreetingController {

    @Autowired
    private IGreetingService greetingService;

    @RequestMapping("/home/{id}")
    public Greeting greeting(@PathVariable Long id) {
        return greetingService.getGreeting(id);
    }

    @GetMapping("/greeting")
    public Greeting greetingParam(@RequestParam(value = "id", defaultValue = "") Long id) {
        return greetingService.getGreeting(id);
    }

    @PostMapping("/post")
    public Greeting greeting(@RequestBody UserDTO user) {
        return greetingService.addGreeting(user);
    }

    @PutMapping("/put/{name}")
    public GreetingDTO greeting(@PathVariable String name, @RequestParam(value = "id") long id) {
        return new GreetingDTO(greetingService.updateGreeting(name));
    }

    @PutMapping("/put/{firstName}/{lastName}")
    public GreetingDTO greeting(@PathVariable String firstName, @PathVariable String lastName
            , @RequestParam(value = "id") long id) {
        return new GreetingDTO(greetingService.updateGreeting(firstName, lastName));
    }

    @DeleteMapping("/delete/{name}")
    public GreetingDTO greetingDelete(@PathVariable String name) {
        return new GreetingDTO(greetingService.deleteGreeting(name));
    }

    @DeleteMapping("/delete/{firstName}/{lastName}")
    public GreetingDTO greetingDelete(@PathVariable String firstName, @PathVariable String lastName) {
        return new GreetingDTO(greetingService.deleteGreeting(firstName, lastName));
    }
}
