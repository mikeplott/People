package com.company;

/**
 * Created by michaelplott on 9/26/16.
 */
public class Person implements Comparable{
    public String personID;
    String firstName;
    public String lastName;
    String email;
    public String country;
    String ip;

    public Person() {

    }

    public Person(String personID, String firstName, String lastName, String email, String country, String ip) {
        this.personID = personID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.ip = ip;
    }

    public String getPersonID() {
        return personID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getIp() {
        return ip;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personID='" + personID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        return this.lastName.compareTo(p.lastName);
    }
}
