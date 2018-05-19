package com.leszeknowinski.springtraining.models.forms;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

//te adnotacje nad polami jest od validacji pól
//łączyć z validationMessages.properties

public class PersonForm {
    @NotEmpty(message = "{NotEmpty.person.name}")
    @Size(max=25, min=2, message = "{Size.person.name}")
    private String name;
    @NotEmpty(message = "{NotEmpty.person.surname}")
    @Size(max=25, min=2, message = "{Size.person.surname}")
    private String surname;
    @Range(max=130, min = 2, message = "{Range.person.age}")
    private int age;
    @NotEmpty(message = "{NotEmpty.person.number}")
    @Pattern(regexp = "[0-9]{3}-[0-9]{3}-[0-9]{3}")
    private String number;
    @NotEmpty(message = "{NotEmpty.person.email}")
    @Email
    private String email;

    public PersonForm(){}

    private PersonForm(Builder builder) {
        name = builder.name;
        surname = builder.surname;
        age = builder.age;
        number = builder.name;
        email = builder.email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static class Builder{
        private String name;
        private String surname;
        private int age;
        private String number;
        private String email;

        public Builder(String name){
            this.name = name;
        }

        public Builder surname(String surname){
            this.surname = surname;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder number(String number){
            this.number = number;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public PersonForm build(){
            return new PersonForm(this);
        }
    }
}
