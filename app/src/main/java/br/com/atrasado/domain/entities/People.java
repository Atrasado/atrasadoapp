package br.com.atrasado.domain.entities;

/**
 * Created by caue.ferreira on 6/24/16.
 */
public class People {

    private long id;
    private String fullName, email, document;
    private CreditCard creditCard;

    public People() {
    }

    public People(long id, String fullName, String email, String document, CreditCard creditCard) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.document = document;
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

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("People{");
        sb.append("id=").append(id);
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", document='").append(document).append('\'');
        sb.append(", creditCard=").append(creditCard);
        sb.append('}');
        return sb.toString();
    }
}
