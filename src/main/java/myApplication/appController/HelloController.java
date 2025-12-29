package myApplication.appController;

import myApplication.exception.AppException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String age
    ) {

        // Validate name
        if (name == null || name.isEmpty()) {
            throw new AppException("Name is required");
        }
        if (!name.matches("[a-zA-Z]+")) {
            throw new AppException("Name should contain only letters");
        }

        // Validate age
        if (age == null || age.isEmpty()) {
            throw new AppException("Age is required");
        }
        if (!age.matches("\\d+")) {
            throw new AppException("Age should be a number");
        }
        int ageValue = Integer.parseInt(age);

        // Validate email
        if (email == null || email.isEmpty()) {
            throw new AppException("Email is required");
        }
        if (!email.endsWith("@gmail.com")) {
            throw new AppException("Email must end with @gmail.com");
        }

        return "Name: " + name + "<br>" +
                "Email: " + email + "<br>" +
                "Age: " + ageValue;
    }

}