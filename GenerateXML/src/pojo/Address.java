package pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Address {
    
    String cep = "";

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
}
