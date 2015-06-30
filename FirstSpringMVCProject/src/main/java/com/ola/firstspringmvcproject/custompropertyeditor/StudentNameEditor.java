/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ola.firstspringmvcproject.custompropertyeditor;

import java.beans.PropertyEditorSupport;

/**
 *
 * @author Olaa
 */
public class StudentNameEditor extends PropertyEditorSupport{
    
    //when you will submit the admission form-->
    //spring MVC will run setAsText function of this class-->
    //Before performing data binding task for studentName property of student object
    
    @Override
    public void setAsText(String studentName) throws IllegalArgumentException{
        if(studentName.contains("Mr.")||studentName.contains("Ms.")){
            setValue(studentName);
        }else{
            studentName = "Ms. " + studentName;
            setValue(studentName); //What every value you will provide to setValue---spring MVC will use the
            //same value to perform data binding task for studentName property
        }
    }
}
