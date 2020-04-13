package cz.lender.jmsdemo.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Table(name = "CORE_PERSON")
public class Person {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="FIRSTNAME")
    private String firstname;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "IDENTIFIER", unique = true)
    private String identifier;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
