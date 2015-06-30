/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ola.firstspringmvcproject.annotation;

import com.ola.firstspringmvcproject.validator.HobbyValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Olaa
 */
@Documented
@Constraint(validatedBy = HobbyValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidHobby {
    
    String listOfValidHobbies() default "Music|Football|Cricket|Hockey"; //jezeli nie wprowadzimy parametru to bedziemy miec "parametr" defaultowy
    
    String message() default "Please provide a valid Hobby; accapeted Hobbies are: Music, Football, Cricket and Hockey (choose anyone)"; //default error massage
    
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};
}
