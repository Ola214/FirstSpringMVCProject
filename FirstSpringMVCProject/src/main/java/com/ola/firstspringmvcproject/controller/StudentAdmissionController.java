/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ola.firstspringmvcproject.controller;

import com.ola.firstspringmvcproject.custompropertyeditor.StudentNameEditor;
import com.ola.firstspringmvcproject.model.Student;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Olaa
 */
@Controller
public class StudentAdmissionController {
    
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        //webDataBinder.setDisallowedFields(new String[]{"studentMobile"} ); //dla studentMobile bedzie puste pole w AdmissionSuccess
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy****MM****dd");
        webDataBinder.registerCustomEditor(Date.class,"studentDOB", new CustomDateEditor(dateFormat,false));//dla pola studentDOB o typie Date, data musi byc w formacie dateFormat(jak wpiszesz domyslny format to bedzie blad!!)
        webDataBinder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
    }
    
    @RequestMapping(value="/admissionForm.html", method = RequestMethod.GET)//get jezeli jest taki patern to wolamy widok AdmissionForm
    public ModelAndView getAdmissionForm(){ 
        ModelAndView modelAndView = new ModelAndView("AdmissionForm");
        //modelAndView.addObject("headerMessage", "Gontu collage of Engeneering"); - jezleli uzyje metody adding... to nie potrzebuje tego
        return modelAndView;
    }
    
    @ModelAttribute//jezeli gdzies mamy w kontrolerze headerMessage to w kazdym RequestMapping bedzie to dostepne, najpierw wola ta metode przed innymi metodami
    public void addingCommonObjects(Model model){
        model.addAttribute("headerMessage", "Gontu collage of Engeneering");
    }
    
    @RequestMapping(value="/submitAdmissionForm.html", method = RequestMethod.POST)//post jezlei sobie wpiszemy w przegladarke .../sumbitAdmissionForm.html to wyskoczy blad, "do wyswietlania" nie wpisywania
    public ModelAndView submitAdmissionForm(/*@RequestParam(value="studentName", defaultValue="nic nie wpisales w pole name")String name, @RequestParam("studentHobby")String hobby*///"studentName" - pobiera z html wartosc studentName
    /*@RequestParam Map<String,String> reqParam*/
    @Valid @ModelAttribute("student") Student student, BindingResult result){ //@Valid m.in. do @Size w studencie, jezeli tego nie bedzie to zignoruje @Size, dodaj w dependencies hibernate-validator
        /*String name = reqParam.get("studentName");
        String hobby = reqParam.get("studentHobby");*/
        /*ModelAndView modelAndView = new ModelAndView("AdmissionSuccess");
        modelAndView.addObject("msg","Details sumbitted by you: Name: "+name+", hobby: "+hobby);
        return modelAndView;*/
        
        /*Student student = new Student();
        student.setStudentName(name);
        student.setStudentHobby(hobby); - niepotrzebne przy @ModelAttribute*/
       if(result.hasErrors()){ //jezeli mamy errory, np. do longa wpiszemy asd to wtedy ponownie wyswietlamy strone formularza do wypelnienia
        ModelAndView modelAndView = new ModelAndView("AdmissionForm");
        return modelAndView;
       }
       ModelAndView modelAndView = new ModelAndView("AdmissionSuccess");
        //modelAndView.addObject("headerMessage", "Gontu college of engenering");
        //modelAndView.addObject("student", student); - niepotrzebne przy @ModelAttribute 
        
        return modelAndView;
    }
    
}
