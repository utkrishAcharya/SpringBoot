package myApplication.appController;

import myApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/testdb")
    public String testDb() {
        long count = userRepository.count();
        return "Users in DB: " + count;
    }
}

