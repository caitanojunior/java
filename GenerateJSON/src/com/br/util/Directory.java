package com.br.util;


import com.br.core.Java2Json;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caitanojunior
 */
public class Directory {

    //method that reads and returns the properties file to the directory
    public Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("src/com/br/util/directory.properties");
        props.load(file);
        return props;
    }

    /*method that returns a String with directory file*/
    public String getDirectory() {
        String directory;
        Properties prop = null;

        try {
            prop = getProp();
        } catch (IOException ex) {
            Logger.getLogger(Java2Json.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        /* gets the propertis file information where burn or recover 
         file 
         if using linux, replace "windows" with "linux" */
        directory = prop.getProperty("prop.directory.linux");
        return directory;
    }
}
