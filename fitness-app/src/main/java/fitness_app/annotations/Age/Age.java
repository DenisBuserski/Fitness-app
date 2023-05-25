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
    String message() default AgeExceptions.INVALID_AGE;

    int minAge() default 10;

    int maxAge() default 100;
}
