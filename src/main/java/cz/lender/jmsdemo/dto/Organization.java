package cz.lender.jmsdemo.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Organization {

    private String code;

    private String name;

    private String abbrevation;

    private String identifier;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbrevation() {
        return abbrevation;
    }

    public void setAbbrevation(String abbrevation) {
        this.abbrevation = abbrevation;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
