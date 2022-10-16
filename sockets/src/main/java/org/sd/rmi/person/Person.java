package org.sd.rmi.person;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 
 * @author 
 */
public class Person implements Serializable{
    private Long id;
    private String name;
    private String surname;
    private String document;
    private Date birthDate;

    public Person(Long id, String name, String surname, String document, Date birthDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.document = document;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person { " + "id: " + id + ", name: " + name + ", surname: " + surname 
                + ", document: " + document + ", birthDate: " + birthDate + " }";
    }
}
