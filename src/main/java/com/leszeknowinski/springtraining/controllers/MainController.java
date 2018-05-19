package com.leszeknowinski.springtraining.controllers;

import com.leszeknowinski.springtraining.PersonRepository;
import com.leszeknowinski.springtraining.models.Contact;
import com.leszeknowinski.springtraining.models.Person;
import com.leszeknowinski.springtraining.models.forms.PersonForm;
import com.leszeknowinski.springtraining.models.SimpleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class MainController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    SimpleBean simpleBean;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model) {
        LocalDateTime now = LocalDateTime.now();
        if(now.getHour() >= 16) {
            model.addAttribute("someString", "a");
        }else{
            model.addAttribute("someString", "b");
        }

        return "index";
    }

    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @ResponseBody
    public String data(@RequestParam(value = "name", required = false) String nameFromForm,
                       @RequestParam(value = "surname", required = false) String surnameFromForm,
                       @RequestParam(value = "age", required = false) int ageFromForm) {
        return (ageFromForm >= 18) ? nameFromForm + " " + surnameFromForm + " is an adult!" : nameFromForm + " " + surnameFromForm + " is a kid!";
    }

    @RequestMapping(value = "/newform", method = RequestMethod.GET)
    public String newform(Model model){
        model.addAttribute("personObject", new PersonForm());
        return "form";
    }

    @RequestMapping(value = "/newform", method = RequestMethod.POST)
    public String newformPost(@ModelAttribute("personObject") @Valid PersonForm personForm, BindingResult result){
       if(result.hasErrors()){
           return "form";
       }
        Person personObject = new Person(personForm);
        personRepository.save(personObject);

       return "result";

       // return "New class: " + person.getName();
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contactform(Model model){
        model.addAttribute("contactObject", new Contact());
        return "contactform";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    @ResponseBody
    public String contactformPost(Contact contact){
        return contact.toString();
    }

    private void testBuilder(){
        PersonForm person = new PersonForm.Builder("Leszek")
                .surname("Nowinski")
                .age(35)
                .number("444666777")
                .email("lechu.now@gmail.com")
                .build();

    }

}