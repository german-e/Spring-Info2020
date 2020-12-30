package com.informatorio.miblog.controller;

import com.informatorio.miblog.models.User;
import com.informatorio.miblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/API/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        System.out.print(userRepository.findAll());
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);

    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        String rta = "";
        try {
            userRepository.save(user);
            rta = "Agregado correctamente";
        } catch ( Exception ex){
            rta = ex.getMessage();
        }
        return rta;
    }

    @PutMapping("edit/{userid}")
    public ResponseEntity<?> editUser(@PathVariable Long userid, @RequestBody User u) {
        User userForEdit = userRepository.getOne(userid);
        userForEdit.setCity(u.getCity());
        userForEdit.setCountry(u.getCountry());
        userForEdit.setEmail(u.getEmail());
        userForEdit.setState(u.getState());
        userForEdit.setFirstName(u.getFirstName());
        userForEdit.setLastName(u.getLastName());
        

        return new ResponseEntity<>(userRepository.save(userForEdit), HttpStatus.OK);

    }


}
