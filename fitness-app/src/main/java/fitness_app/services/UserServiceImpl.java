package fitness_app.services;

import fitness_app.annotations.*;
import fitness_app.entities.User;
import fitness_app.enums.UserType;
import fitness_app.exception_messages.AgeExceptions;
import fitness_app.exception_messages.EmailExceptions;
import fitness_app.exception_messages.PasswordExceptions;
import fitness_app.exception_messages.UsernameExceptions;
import fitness_app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(String username, String password, String email, UserType userType, String firstName, String lastName, int age) {
        boolean validUsername = this.userRepository.countByUsername(username) == 0;
        boolean validPassword = Password.PasswordValidator.isValidPassword(password);
        boolean validEmail = Email.EmailValidator.isValidEmail(email);
        boolean validAge = Age.AgeValidator.isValidAge(age);


        if (!validUsername) { // Validate username ** NOT READY **
            System.out.println(UsernameExceptions.USERNAME_ALREADY_EXISTS);
        } else if (!validPassword) { // Validate password
            System.out.println(PasswordExceptions.INVALID_PASSWORD);
        } else if (!validEmail) { // Validate email
            System.out.println(EmailExceptions.INVALID_EMAIL);
        } else if (!validAge) { // Validate age
            System.out.println(AgeExceptions.INVALID_AGE);
        } else { // Create user successfully
            User user = new User(username, password, email, userType, firstName, lastName, age);
            this.userRepository.save(user);
        }


    }
}
