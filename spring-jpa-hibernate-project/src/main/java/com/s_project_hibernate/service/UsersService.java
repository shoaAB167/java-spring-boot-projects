package com.s_project_hibernate.service;

import com.s_project_hibernate.model.Users;

import com.s_project_hibernate.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/users")
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/all")
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    @GetMapping("/{name}")
    public List<Users> getUser(@PathVariable("name") final String name) {
        return usersRepository.findByName(name);

    }

    @GetMapping("/id/{id}")
    public Optional<Users> getId(@PathVariable("id") final Integer id) {
        return usersRepository.findById(id);
    }

    @GetMapping("/update/{id}/{name}")
    public ResponseEntity<Users> update(@PathVariable("id") final Integer id,
                                        @PathVariable("name") final String name) {

        // Fetch the user by ID
        Optional<Users> optionalUser = usersRepository.findById(id);

        // If user is not found, return 404 Not Found
        if (!optionalUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        // Get the user from the Optional
        Users user = optionalUser.get();

        // Update the user's name
        user.setName(name);

        // Save and return the updated user
        return ResponseEntity.ok(usersRepository.save(user));
    }
}