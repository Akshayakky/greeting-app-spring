package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.UserDTO;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greetingcontroller")
public class GreetingController {

    @Autowired
    private IGreetingService greetingService;

    @RequestMapping("/get/{id}")
    public Greeting greeting(@PathVariable long id) {
        return greetingService.getGreeting(id);
    }

    @GetMapping("/get")
    public Greeting greetingParam(@RequestParam(value = "id", defaultValue = "") Long id) {
        return greetingService.getGreeting(id);
    }

    @GetMapping("/get/all")
    public List<Greeting> greetingParam() {
        return greetingService.getAllGreeting();
    }

    @PostMapping("/post")
    public Greeting greeting(@RequestBody UserDTO user) {
        return greetingService.addGreeting(user);
    }

    @PutMapping("/put/{name}")
    public Greeting greeting(@PathVariable String name, @RequestParam(value = "id") long id) {
        return greetingService.updateGreeting(id, name);
    }

    @DeleteMapping("/delete/{id}")
    public void greetingDelete(@PathVariable long id) {
        greetingService.deleteGreeting(id);
    }
}
