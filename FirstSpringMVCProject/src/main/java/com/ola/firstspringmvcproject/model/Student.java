/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ola.firstspringmvcproject.model;

import com.ola.firstspringmvcproject.annotation.IsValidHobby;
import java.util.ArrayList;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;




/**
 *
 * @author Olaa
 */
public class Student {
    
    @Pattern(regexp="[^0-9]*") //ciag zera lub wiecej wystapien znaku, ktory nie jest cyfra
    private String studentName;
    @Size(min=2,max=30/*,message="please enter a value for student hobby field between {min} and {max}"*/)//hobby studenta nie moze miec mniej niz 2 znaki i nie wiecej niz 30 znakow, dodaj w dependencies hibernate-validator
    @IsValidHobby(listOfValidHobbies="Music|Football|Cricket|Hockey") //chyba musi byc po @Size, bo inaczej mi nie poszlo :/
    private String studentHobby;
    @Max(999999999)
    private Long studentMobile;
    @Past//data musi byc z przeszlosci
    private Date studentDOB;
    private ArrayList<String> studentSkills;
    private Address studentAddress;

    public Address getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(Address studentAddress) {
        this.studentAddress = studentAddress;
    }
    
    public Date getStudentDOB() {
        return studentDOB;
    }

    public void setStudentDOB(Date studentDOB) {
        this.studentDOB = studentDOB;
    }
    
    public Long getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(Long studentMobile) {
        this.studentMobile = studentMobile;
    }

    public ArrayList<String> getStudentSkills() {
        return studentSkills;
    }

    public void setStudentSkills(ArrayList<String> studentSkills) {
        this.studentSkills = studentSkills;
    }
    
    

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentHobby() {
        return studentHobby;
    }

    public void setStudentHobby(String studentHobby) {
        this.studentHobby = studentHobby;
    }
    
    
}
