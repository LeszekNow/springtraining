package com.leszeknowinski.springtraining.controllers;

import com.leszeknowinski.springtraining.models.SimpleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class MainController {

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
}