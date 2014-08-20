package com.br.core;

import com.br.entity.Address;
import com.br.entity.Functionary;
import com.br.util.Directory;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Java2Json {

    private static final Directory dir = new Directory();
    private static final Address address = new Address();
    private static final Functionary functionary = new Functionary();

    public static void main(String[] args) throws ParseException, IOException {

        Gson gson = new Gson();

        address.setStreet("Rua Floriano Peixoto");
        address.setNumber(1234);
        address.setDistrict("TownCenter");
        address.setCep("58.400-000");

        // Instantiating the object
        functionary.setId(9);
        functionary.setName("Fulano de Tal");
        functionary.setCpf("123.456.789-10");
        functionary.setRole("Programer");
 
        functionary.setDate_birth(transformaData("01/06/1980"));
        functionary.setAddress(address.toString());

        /*Creating the file name that will be generated*/
        StringBuilder file = new StringBuilder();
        file.append("testJson.json");

        // transforms Java objects to JSON and returns JSON as a String
        String json = gson.toJson(functionary);

        try {
            //Write Json converted into file named "testJson.json" 
             FileWriter writer = new FileWriter(dir.getDirectory() + file);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
        }
        System.out.println("File generated successfully: " + dir.getDirectory());
        System.out.println("With the following information: \n " + json);
    }

    public static Date transformaData(String dataNasc) throws ParseException {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

        Date data;
        data = new Date(formatador.parse(dataNasc).getTime());

        return data;
    }
}
