package myApplication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Document(collection = "simusers")
public class SimUser {

    @Id
    private String id;
    private String name;
    private String phone;
    private String email;
    private String username;
    private String password;  // added for login

    public SimUser() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username; }   // ✔ needed
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }   // ✔ needed
    public void setPassword(String password) { this.password = password; }

}

