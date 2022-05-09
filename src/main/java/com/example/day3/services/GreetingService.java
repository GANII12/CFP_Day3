package com.example.day3.services;

import com.example.day3.model.Greeting;
import com.example.day3.repository.GreetingRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Slf4j
public class GreetingService {
    private  static final String template = "hello , %s!";
    private  final AtomicLong counter = new AtomicLong();
   @Autowired
    public GreetingRepo greetingRepo;
    public List<Greeting> getAllUsers(){
        return greetingRepo.findAll();
    }

    public Greeting createContact(Greeting greeting){
        Greeting greetingData = new Greeting(greeting.getfName(), greeting.getlName());
        Greeting data = greetingRepo.save(greetingData);
        return data;
    }

    public Greeting addGreeting(Greeting greeting) {
        String message = String.format(template,(greeting.toString().isEmpty()) ? "Hello World" : greeting.toString());
        return greetingRepo.save(new Greeting(counter.incrementAndGet() , message));
    }

    public Optional<Greeting> editGreetingById(long id, String name) {
    }

    public void delete(long id) {
    }

//    @Override
//    public  Greeting getGreetingById(long id){
//        return greetingRepo.findById(id).get();
//    }
}
