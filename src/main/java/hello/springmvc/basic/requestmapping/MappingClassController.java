package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    @GetMapping
    public String users() {
        return "get users";
    }

    @PostMapping
    public String addUser() {
<<<<<<< HEAD
        return "post user";
    }

    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId) {
=======
        return "post users";
    }

    @GetMapping("/{userId}")
    public String getUser(@PathVariable("userId") String userId) {
>>>>>>> ohvely22
        return "get userId=" + userId;
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "update userId=" + userId;
    }

    @DeleteMapping("/{userId}")
<<<<<<< HEAD
    public String deleteUser(@PathVariable String userId) {
        return "delete userId=" + userId;
    }
=======
    public String deleteUser(@PathVariable("userId") String userId) {
        return "delete userId=" + userId;
    }


>>>>>>> ohvely22
}
