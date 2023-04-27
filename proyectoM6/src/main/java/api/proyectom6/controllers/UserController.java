package api.proyectom6.controllers;

import api.proyectom6.models.User;
import api.proyectom6.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class UserController {
    private UserService userService;

    @GetMapping("/allUser")
    public List<User> getAllUser() {
        return userService.listUser();
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.findUserById(id);
    }
    @PostMapping("/user")
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Integer id){
        try{
            User userExist = userService.findUserById(user.getId());
            userExist.setName(user.getName());
            userExist.setLastName(user.getLastName());
            userService.saveUser(userExist);
            return new ResponseEntity<User>( userExist, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
