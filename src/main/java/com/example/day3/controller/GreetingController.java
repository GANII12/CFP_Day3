package com.example.day3.controller;

import com.example.day3.model.Greeting;
import com.example.day3.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/hello")
public class GreetingController {
    private static final String template = "Hello %s";
    private static AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingService greetingService;

    @GetMapping(value = {"/"})
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "world") String name){
        Greeting greeting = new Greeting();
        greeting.setfName(name);
        return greetingService.addGreeting(greeting);
    }

    @PostMapping("/fullName")
    public Greeting sayWow(@RequestBody Greeting greeting){
        return greetingService.addGreeting(greeting);
    }

    @GetMapping("/find/{id}")
    public Optional<Greeting> greeting(@PathVariable(value = "id") long id){
        return greetingService.greetingRepo.findById(id);
    }

    @GetMapping("/all")
    public List<Greeting> getAll(){
    return greetingService.getAllUsers();
    }

//    @PutMapping("/editGreeting/{id}")
//    public Optional<Greeting> editGreetingById(@PathVariable("id") long id , @RequestParam(value = "name") String name){
//        return greetingService.editGreetingById(id , name);
//    }
    @DeleteMapping("/delete")
    public void deleteById(@RequestParam(name = "id") long id){
        greetingService.delete(id);
    }
//
    //
    @RequestMapping(value = {"","/","/home"})
    public String sayHello(){
        return "Hello from BridgeLabz!!!";
    }

    @RequestMapping(value = {"/query"},method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name") String name){
        return "Hello" + name + "!";
    }

    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name){
        return "Hello" + name + "!";
    }

//    @PostMapping("/post")
//    public String sayHello(@RequestParam Greeting greeting){
//        return "Hello" + greeting.getfName()+ " " + greeting.getlName()+ "!";
//    }

    @PutMapping("/put/firstName")
    public String sayHello(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName){
        return "Hello" + firstName+" " + lastName+"!";
    }

//    @GetMapping("/getGreeting")
//    public Greeting greeting(@RequestParam(value = "name" , defaultValue = "world") String name){
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }

    @PostMapping("/postGreeting")
    public Greeting sayHello(@RequestBody Greeting greeting){
        return new Greeting(counter.incrementAndGet(), String.format(template, greeting.getContent()));
    }

    @PutMapping("/putMapping/{counter}")
    public Greeting sayHello(@PathVariable long counter , @RequestParam(value = "content")String content){
        return new Greeting(counter, String.format(template , content));
    }

}
