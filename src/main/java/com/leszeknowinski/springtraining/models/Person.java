package com.leszeknowinski.springtraining.models;

public class Person {
    private String name;
    private String surname;
    private int age;
    private String number;
    private String email;

    public Person(String name, String surname, int age, String number, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
        this.email = email;
    }

    public Person(){}

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
    }
}
