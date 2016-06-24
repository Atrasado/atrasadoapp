package br.com.atrasado.domain.entities;

import java.util.Date;

/**
 * Created by caue.ferreira on 6/24/16.
 */
public class Person {

    private long id;
    private String fullName, email, document;
    private Date birthdate;
    private CreditCard creditCard;

    public Person() {
    }



    public Person(long id, String fullName, String email, String document, Date birthdate, CreditCard creditCard) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.document = document;
        this.birthdate = birthdate;
        this.creditCard = creditCard;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", document='").append(document).append('\'');
        sb.append(", birthdate=").append(birthdate);
        sb.append(", creditCard=").append(creditCard);
        sb.append('}');
        return sb.toString();
    }
}
