package com.leszeknowinski.springtraining.models;

public class Contact {
    private String name;
    private String surname;
    private String email;
    private String message;

    public Contact(){}

    private Contact(Builder builder) {
        name = builder.name;
        surname = builder.surname;
        email = builder.email;
        message = builder.message;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Builder{
        private String name;
        private String surname;
        private String email;
        private String message;

        public Builder(String name){
            this.name = name;
        }

        public Builder surname(String surname){
            this.surname = surname;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder message(String message){
            this.message = message;
            return this;
        }

        public Contact build(){
            return new Contact(this);
        }
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
