package ir.codefather.rest.controller;

import ir.codefather.rest.model.User;
import ir.codefather.rest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserRepository repo;


    @RequestMapping("/save")
    @ResponseBody
    public String saveUser(User user) {
        repo.save(user);
        return user.getName() + " saved";
    }

    @PutMapping("/save")
    @ResponseBody
    public String updateUser(User user) {
        repo.save(user);
        return user.getName() + " saved";
    }


    @RequestMapping("/user/{id}")
    @ResponseBody
    public User findUser(@PathVariable("id") int id) {
        return repo.findById(id).orElse(new User());
    }


    @RequestMapping("/all")
    @ResponseBody
    public List<User> getAll() {
        return repo.findAll();
    }


    @DeleteMapping("/user/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable("id") int id) {
        User user = repo.findById(id).get();

        repo.delete(user);

        return id + " deleted";
    }
}
