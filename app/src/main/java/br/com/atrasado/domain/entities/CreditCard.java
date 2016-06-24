package br.com.atrasado.domain.entities;


public class CreditCard {

    private String month, year, number;

    public CreditCard() {
    }

    public CreditCard(String month, String year, String number) {
        this.month = month;
        this.year = year;
        this.number = number;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreditCard{");
        sb.append("month='").append(month).append('\'');
        sb.append(", year='").append(year).append('\'');
        sb.append(", number='").append(number).append('\'');
        sb.append('}');
        return sb.toString();
    }
}