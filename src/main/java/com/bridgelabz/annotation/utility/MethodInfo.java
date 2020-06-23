package com.bridgelabz.annotation.utility;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo
{
    String author() default "Aniket";
    String date();
    int revision() default 2;
    String comments();
}
