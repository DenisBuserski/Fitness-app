package fitness_app.annotations.Age;

import fitness_app.exception_messages.AgeExceptions;
import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component
@Constraint(validatedBy = AgeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Age {
    String message() default AgeExceptions.INVALID_EMAIL_FORMAT;

    int minUserNameLength() default 1;

    int maxUserNameLength() default 50;
}
