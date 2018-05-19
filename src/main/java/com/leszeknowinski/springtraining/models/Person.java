package com.leszeknowinski.springtraining.models;

import com.leszeknowinski.springtraining.models.forms.PersonForm;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //@Column(name = "nameOfColumnFromDB") - jeśli zaprojektoeana dla nas baza danych nie jest dostosowana do naszych nazw w klasie
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

    public Person(PersonForm personForm){
        name = personForm.getName();
        surname = personForm.getSurname();
        age = personForm.getAge();
        number = personForm.getNumber();
        email = personForm.getEmail();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
