package com.br.entity;

import java.sql.Date;


public class Functionary {

    private int id;
    private String name;
    private String cpf;
    private Date date_birth;
    private String address;
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(Date date_birth) {
        this.date_birth = date_birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    

    @Override
    public String toString() {
        return "Information \n[\n id = " + id + ";\n Name = " + name + ";\n CPF = " + cpf + 
                 ";\n Date Birth = " + date_birth + ";\n Role = " + role +
                 ";\n Address = " + address + "]";
    }  
}
