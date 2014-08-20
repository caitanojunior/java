package com.br.entity;

/**
 *
 * @author indra
 */
public class Address {
    
    private String  street;
    private int number;
    private String district;
    private String cep;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public String toString(){
        return street + " - " + number
                + ";\n District = " + district + ";\n Cep = " + cep + ".\n";
    }    
}
