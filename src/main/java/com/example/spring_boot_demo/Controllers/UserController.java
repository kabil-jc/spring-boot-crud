package com.example.spring_boot_demo.Controllers;

import com.example.spring_boot_demo.Entity.UserEntity;
import com.example.spring_boot_demo.Exception.ResourceNotFoundException;
import com.example.spring_boot_demo.repositry.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepositry userRepositry;
    @GetMapping
    public List<UserEntity> getUsers(){
//        return Arrays.asList(new User(1L,"kabilan","kabilan@gmail"),new User(2L,"gokul","gokul@gmail.com"));
        return userRepositry.findAll();

    }
    @PostMapping
    public UserEntity createuser(@RequestBody UserEntity user){
       return userRepositry.save(user);
    }
    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id){
        return userRepositry.findById(id).orElseThrow(()-> new ResourceNotFoundException("User doesnt exist in this is"+id));
    }
    @PutMapping("/{id}")
    public UserEntity upadteUser(@PathVariable Long id, @RequestBody UserEntity user){
        UserEntity userData = userRepositry.findById(id).orElseThrow(()-> new ResourceNotFoundException("User doesnt exist in this is"+id));
        userData.setEmail(user.getEmail());
        userData.setName(user.getName());
      return  userRepositry.save(userData);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delteUser(@PathVariable Long id){
        UserEntity userData =userRepositry.findById(id).orElseThrow(()-> new ResourceNotFoundException("User doesnt exist in this is"+id));
        userRepositry.delete(userData);
        return ResponseEntity.ok().build();
    }
}
