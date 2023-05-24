package fitness_app.entities;

import fitness_app.annotations.Age;
import fitness_app.annotations.Email;
import fitness_app.annotations.Password;
import fitness_app.annotations.Username;
import fitness_app.enums.UserType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Username
    private String username;
    @Password
    private String password;
    @Email
    private String email;
    private UserType userType;
    private String firstName;
    private String lastName;
    @Age
    private int age;
    

}
