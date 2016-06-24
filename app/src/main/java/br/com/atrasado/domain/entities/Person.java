package br.com.atrasado.domain.entities;

import java.util.Date;

public class Person {

    private long id;
    private String fullname, email, document, expirationMonth, expirationYear, creditCardNumber;
    private Date birthdate;

    public Person() {
    }

    public Person(long id, String fullName, String email, String document, Date birthdate) {
        this.id = id;
        this.fullname = fullName;
        this.email = email;
        this.document = document;
        this.birthdate = birthdate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", fullName='").append(fullname).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", document='").append(document).append('\'');
        sb.append(", birthdate=").append(birthdate);
        sb.append('}');
        return sb.toString();
    }
}
