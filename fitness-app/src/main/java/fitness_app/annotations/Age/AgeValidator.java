package fitness_app.annotations.Age;

import fitness_app.annotations.AnnotationsUtil;
import fitness_app.exception_messages.AgeExceptions;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, CharSequence> {
    private int minAge;
    private int maxAge;
    @Override
    public void initialize(final Age age) {
        this.minAge = age.minAge();
        this.maxAge = age.maxAge();
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        int age = Integer.parseInt(value.toString());

        if (age < this.minAge) {
            AnnotationsUtil.setErrorMessage(context, AgeExceptions.INVALID_AGE_MIN);
            return false;
        } else if (age > this.maxAge) {
            AnnotationsUtil.setErrorMessage(context, AgeExceptions.INVALID_AGE_MAX);
            return false;
        }

        return true;
    }
}
