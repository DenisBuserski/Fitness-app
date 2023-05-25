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
    @Enumerated(value = EnumType.STRING) // Will show the value name; Example - ADMIN
    private UserType userType;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Age
    private int age;
    // private Diary diary;

    public User() {}
    public User(String username, String password, String email, UserType userType, String firstName, String lastName, int age) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
