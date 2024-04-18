package aiss.restclient.controller;

import aiss.restclient.exception.UserNotFoundException;
import aiss.restclient.model.User;
import aiss.restclient.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserRepository repository;

    // GET http://localhost:8080/api/v1/users
    @GetMapping
    public List<User> findAll(){
        return repository.findAll();
    }

    // GET http://localhost:8080/api/v1/users/{userId}
    @GetMapping("/{id}")
    public User findOne(@PathVariable long id) throws UserNotFoundException {
        Optional<User> optionalUser = repository.findById(id);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException();
        }
        return optionalUser.get();
    }

    // POST http://localhost:8080/api/v1/users
    @GetMapping
    public User create(@Valid @RequestBody User user){
        return repository.save(new User(user.getName(), user.getUser_link(), user.getPicture_link()));
    }

    // PUT http://localhost:8080/api/v1/users/{userId}
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody User updUser, @PathVariable long id)
        throws UserNotFoundException{
        Optional<User> opUser = repository.findById(id);
        if(opUser.isEmpty()){
            throw new UserNotFoundException();
        }
        User user = opUser.get();
        user.setName(updUser.getName());
        user.setUser_link(updUser.getUser_link());
        user.setPicture_link(updUser.getPicture_link());
        repository.save(user);
    }

    // DELETE http://localhost:8080/api/v1/users/{userId}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }
}
