package user_system.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Password {
    String message() default "Invalid password format";

    class PasswordValidator {
        private static final int MIN_LENGTH = 6;
        private static final int MAX_LENGTH = 50;

        public static boolean isValid(String password) {
            if (password == null || password.length() < MIN_LENGTH || password.length() > MAX_LENGTH) {
                return false;
            }

            String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+<>?]).+$";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(password);
            return matcher.matches();
        }
    }
}
