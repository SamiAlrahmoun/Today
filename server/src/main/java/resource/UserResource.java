package resource;

import document.User;
import org.springframework.web.bind.annotation.*;
import repository.UserRepo;

import java.util.List;

@RestController
@RequestMapping("/rest/user")
public class UserResource {
    private UserRepo userRepo;

    public UserResource(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userRepo.findAll();
    }

}
