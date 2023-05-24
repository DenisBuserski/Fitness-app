package fitness_app.entities;

import fitness_app.annotations.Age;
import fitness_app.annotations.Email;
import fitness_app.annotations.Password;
import fitness_app.annotations.Username;
import fitness_app.enums.UserType;

import javax.persistence.*;

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
    @Column(name = "user_type")
    private UserType userType;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Age
    private int age;
    

}
