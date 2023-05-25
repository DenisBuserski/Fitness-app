package fitness_app.services;

import fitness_app.annotations.Age;
import fitness_app.entities.User;
import fitness_app.enums.UserType;
import fitness_app.exception_messages.AgeExceptions;
import fitness_app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(String username, String password, String email, UserType userType, String firstName, String lastName, int age) {
        int validAge = Age.AgeValidator.isValid(age);
        if (validAge == 1 || validAge == 2) { // Validate age
            System.out.println(AgeExceptions.INVALID_AGE);
        } else {
            User user = new User(username, password, email, userType, firstName, lastName, age);
            this.userRepository.save(user);
        }



    }
}
