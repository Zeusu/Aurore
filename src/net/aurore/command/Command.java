package net.aurore.command;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

@Retention(RUNTIME)
public @interface Command {
	String value();
	boolean local() default true;
}
