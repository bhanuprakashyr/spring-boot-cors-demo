package com.example.springbootcorsdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ManageBooksController {

    @GetMapping(value = "/books")
    public List<String> getBooks() {
        return Arrays.asList("Clean Code", "Pragmatic programmer", "Accelerate");
    }

    @PostMapping(value = "/books")
    public List<String> getBooks(@RequestBody List<String> books) {
        System.out.println(Arrays.toString(books.toArray()));
        return books;
    }

}
