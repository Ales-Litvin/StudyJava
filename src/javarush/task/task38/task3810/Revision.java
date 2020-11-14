package javarush.task.task38.task3810;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value = ElementType.ANNOTATION_TYPE)
public @interface Revision {
    int revision();

    Date date();

    String comment() default "";

    Author[] authors() default {};
}
