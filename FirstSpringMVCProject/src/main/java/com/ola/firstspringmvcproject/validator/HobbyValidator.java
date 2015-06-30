/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ola.firstspringmvcproject.validator;

import com.ola.firstspringmvcproject.annotation.IsValidHobby;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Olaa
 */
public class HobbyValidator implements ConstraintValidator<IsValidHobby, String>{

    private String listOfValidHobbies;
    
    @Override
    public void initialize(IsValidHobby isValidHobby) {
        this.listOfValidHobbies = isValidHobby.listOfValidHobbies();
    }
    
    @Override //zawsze przed ta metoda wywolywana jest metoda initialize
    public boolean isValid(String studentHobby, ConstraintValidatorContext ctx){
       
        if(studentHobby == null){
            return false;
        }
        
        if(studentHobby.matches(listOfValidHobbies)){
            return true;
        }else{
            return false;
        }
    }
    
}
