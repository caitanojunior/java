package pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Individuals {

    String name = "";
    String cpf = "";
    String address = "";
    
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
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
