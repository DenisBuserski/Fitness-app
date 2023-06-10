package fitness_app.services;

import fitness_app.annotations.Age;
import fitness_app.annotations.Email;
import fitness_app.annotations.Password;
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
    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(String username, String password, String email, UserType userType, String firstName, String lastName, int age) {
        int validUsername = this.countByUsername(username);
        // validPassword
        boolean validPassword = Password.PasswordValidator.isValidPassword(password);
        boolean validEmail = Email.EmailValidator.isValidEmail(email);
        boolean validAge = Age.AgeValidator.isValidAge(age);


        if (!validAge) { // Validate age
            System.out.println(AgeExceptions.INVALID_AGE);
        } else if (validUsername == 1) { // Validate username
            System.out.println(UsernameExceptions.USERNAME_ALREADY_EXISTS);
        } else if (!validEmail) { // Validate email
            System.out.println(EmailExceptions.INVALID_EMAIL);
        } else if (validAge == age && validUsername == 0 && validEmail) { // Create user successfully
            User user = new User(username, password, email, userType, firstName, lastName, age);
            this.userRepository.save(user);
        } else if (!validPassword) {
            System.out.println(PasswordExceptions.INVALID_PASSWORD);
        }





    }

    @Override
    public int countByUsername(String username) {
        return this.userRepository.countByUsername(username);
    }
}
