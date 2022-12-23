package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // To be valid during the runtime
public @interface Entity {
    String name(); // Table name
}
