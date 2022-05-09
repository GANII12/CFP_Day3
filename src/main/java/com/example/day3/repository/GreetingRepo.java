package com.example.day3.repository;


import com.example.day3.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepo extends JpaRepository<Greeting , Long> {
}
