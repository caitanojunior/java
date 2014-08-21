package br.com.serverHTTP;


import java.io.BufferedReader;

import java.io.DataOutputStream;

import java.io.IOException;

/**
 * 
 * This class represents the request of the Client
 * 
 * @author Caitano Junior
 * 
 */

public class HTTPRequest {

	private String header;

	public HTTPRequest(){

     header = "";

   }

	public void httpHandler(BufferedReader input, DataOutputStream output) throws IOException{
     

     while (input.ready()){

       header += input.readLine()+"\n";

     }    
     
   }

	// Setters and Getters

	public String getHeadline() {

		return this.header;

	}

}