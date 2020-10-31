package fr.alma.today.resource;


import fr.alma.today.models.User;
import fr.alma.today.repository.UserRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/rest/user")
public class UserResource {
    private UserRepository userRepo;

    public UserResource(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userRepo.findAll();
    }

}
