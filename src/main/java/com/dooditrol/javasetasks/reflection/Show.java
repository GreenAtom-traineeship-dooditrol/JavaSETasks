package com.dooditrol.javasetasks.reflection;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Show {
    boolean isStdout() default true;
}
