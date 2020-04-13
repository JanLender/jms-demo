package cz.lender.jmsdemo.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Person {

    private String firstname;

    private String surname;

    private String identifier;

    private String emailAddress;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
