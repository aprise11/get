package com.datorium.Datorium.API;

import com.datorium.Datorium.API.DTOs.Book;
import com.datorium.Datorium.API.DTOs.Credentials;
import com.datorium.Datorium.API.DTOs.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@CrossOrigin
public class DatoriumApiApplication {

    public static void main(String[] args) {
       System.out.println("asd");
       SpringApplication.run(DatoriumApiApplication.class, args);
    }


    @GetMapping("/ping")
    public String ping() {
       return "pong";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
       return String.format("Hello %s!", name); // "Hello " + name;
    }

    @GetMapping("/getbook")//localhost:8080/getBook
    public Book getbook(){
       var book = new Book();
       book.title = "book title";
       book.author = "book author";

       return book;
    }

    @PostMapping("/postexample")
    public Book addBook(@RequestBody Book book){
       book.title = book.title.toUpperCase();
       return book;
    }

    @GetMapping("/newendpoint")
    public String newEndpoint() {
        return "I'm off for today. Goodnight team 🌙";
    }

    //We want the user to be able to authorize, by using username and password
    // And then we provide a profile of the user (name, surname, age, email)
    @PostMapping("/authorize")
    public User authorize(@RequestBody Credentials credentials){
       if(credentials.username.equals("aprise") && credentials.password.equals("Password123")){
          var user = new User();
          user.name = "Agneta";
          return user;
       }
       return null;
    }
}
