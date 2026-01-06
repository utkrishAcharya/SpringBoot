package myApplication.appController;

import myApplication.exception.AppException;
import myApplication.model.SimUser;
import myApplication.pojo.LoginRequest;
import myApplication.pojo.Response;
import myApplication.service.SimUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/simusers")
public class SimUserController {

    @Autowired
    private SimUserService simUserService;

    @PostMapping("/add")
    public Response addNewSimUser(@RequestBody SimUser simuser) {
        Response response = new Response();
        try {
            SimUser savedSimUser = simUserService.addNewSimUser(simuser);
            response.setStatus("Success");
            response.setMessage("New User Added Successfully");
            response.setData(savedSimUser);
        } catch (AppException e) {
            response.setStatus("Failed");
            response.setMessage("Failed to add: " + e.getMessage());
        }
        return response;
    }

    @PutMapping("/update/{simuserId}")
    public Response updateSimUserInfo(
            @PathVariable String simuserId,
            @RequestBody SimUser updateSimUser) {

        Response response = new Response();
        try {
            SimUser updated = simUserService.updateSimUserInfo(simuserId, updateSimUser);
            response.setStatus("Success");
            response.setMessage("User updated successfully");
            response.setData(updated);
        } catch (AppException e) {
            response.setStatus("Failure");
            response.setMessage("Update failed: " + e.getMessage());
        }
        return response;
    }



    @GetMapping("/{simuserId}")
    public Response getMemberInfo(@PathVariable String simuserId) {
        Response response = new Response();
        try {
            SimUser simuserObj = simUserService.getSimUserInfo(simuserId);
            response.setStatus("Success");
            response.setMessage("User Found");
            response.setData(simuserObj);
        } catch (AppException e) {
            response.setStatus("Failure");
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @GetMapping("/all")
    public Response getAllMembers() {
        Response response = new Response();
        try {
            List<SimUser> simuserList = simUserService.getAllSimUsers();
            response.setStatus("Success");
            response.setMessage("Users fetched successfully");
            response.setData(simuserList);
        } catch (AppException ex) {
            response.setStatus("Failure");
            response.setMessage("Error: " + ex.getMessage());
        }
        return response;
    }

    @DeleteMapping("/delete/{simuserId}")
    public Response deleteSimUser(@PathVariable String simuserId) {
        Response response = new Response();
        try {
            simUserService.deleteSimUser(simuserId);
            response.setStatus("Success");
            response.setMessage("Deleted with ID: " + simuserId);
        } catch (AppException ex) {
            response.setStatus("Failure");
            response.setMessage("Delete failed: " + ex.getMessage());
        }
        return response;
    }
    @PostMapping("/signup")
    public Response signup(@RequestBody SimUser simUser){
        Response response = new Response();
        // 1. Check if user with same username/email exists
        // 2. Encrypt password before save
        // 3. Save user

        // Simple example without encryption:
        SimUser savedUser = simUserService.addNewSimUser(simUser);

        response.setStatus("Success");
        response.setMessage("User registered successfully");
        response.setData(savedUser);
        return response;
    }
    @PostMapping("/login")
    public Response login(@RequestBody LoginRequest loginRequest){
        Response response = new Response();
        try {
            SimUser user = simUserService.findByUsername(loginRequest.getUsername());
            if(user == null || !user.getPassword().equals(loginRequest.getPassword())){
                throw new AppException("Invalid credentials");
            }

            // Generate unique token for login (can be JWT)
            String token = UUID.randomUUID().toString();  // simple token

            response.setStatus("Success");
            response.setMessage("Login successful");
            response.setData(token);  // return token
        } catch (AppException e){
            response.setStatus("Failed");
            response.setMessage("Login failed: " + e.getMessage());
        }
        return response;
    }


}
