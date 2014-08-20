package com.br.core;

import com.br.util.Directory;
import com.br.entity.Functionary;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import javax.xml.bind.JAXBException;

public class Json2Java {

    private static Directory dir = new Directory();

    public static Functionary deserialize() throws JAXBException {
        Functionary func = null;

        /*Creating the file name that will be returned*/
        StringBuilder file = new StringBuilder();
        file.append("testJson.json");

        /*checking if the file exists*/
        File file_ = new File(dir.getDirectory()+ file.toString());
        if (file_.exists()) {

            Gson gson = new Gson();
            try {
                BufferedReader br = new BufferedReader(new FileReader(
                        dir.getDirectory() + file.toString()));
                
                //Convert JSON String to Java object
                func = gson.fromJson(br, Functionary.class);
                //Parei aqui -- converter java.sql.date para java.util.date
            } catch (FileNotFoundException e) {
                System.err.println("Erro >>>" + e);
            }

        } else {
            func = null;
        }
        return func;
    }

    public static void main(String[] args) throws JAXBException {
        if (deserialize() != null) {
            System.out.println(deserialize().toString());
        } else {
            System.out.println("The file has been deleted or does not exist.");
        }
    }
}
