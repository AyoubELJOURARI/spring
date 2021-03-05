package com.first.firstapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public String addUser(@RequestParam String first, @RequestParam String last, @RequestParam Integer age) {
        User user = new User();
        user.setFirstName(first);
        user.setLastName(last);
        user.setAge(age);
        userRepository.save(user);
        return "Added new user to repo: " + user.getFirstName() + " " + user.getLastName();
    }

    @GetMapping("/list")
    public Iterable<User> getUser() {
        return userRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public User findUser(@PathVariable Integer id) {
        return userRepository.findUsersById(id);
    }

    @GetMapping("/update")
    public User findUserByprop(@RequestParam Integer id, @RequestParam String first, @RequestParam String last, @RequestParam Integer age) {
        User user = new User();
        user = userRepository.findUsersById(id);
        user.setFirstName(first);
        user.setLastName(last);
        user.setAge(age);
        userRepository.save(user);

        return userRepository.findUsersById(id);
    }

}
