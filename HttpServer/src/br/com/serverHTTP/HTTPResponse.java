package br.com.serverHTTP;


import java.io.DataOutputStream;

import java.io.IOException;

/**
 * 
 * This class represents the response of the Server
 * 
 * 
 * @author Caitano Junior
 * 
 */

public class HTTPResponse {

	private DataOutputStream output;

	private HTTPRequest request;

	public HTTPResponse(DataOutputStream output) {

		this.output = output;

	}

	public void setRequest(HTTPRequest request) {

		this.request = request;

	}

	public void sendsResponse() throws IOException{

     String headerHTML = "<html><head><title>Server Page</title></head>";

     String bodyHTML = "<body> <h1> Page found </h1> Welcome! <br />";

     bodyHTML += request.getHeadline()+ "</body></html>";

     
     output.writeBytes(buildHeaderHTTP(200));

     output.writeBytes(headerHTML+bodyHTML);

     output.close();
     

   }

	private String buildHeaderHTTP(int returnCode) {

     String header = "HTTP/1.0 ";


     switch (returnCode) {

     case 200:

       header += "200 OK";

       break;

     case 400:

       header += "400 Bad Request";

       break;

     case 403:

       header += "403 Forbidden";

       break;
     case 404:

       header += "404 Not Found";

       break;

     case 500:

       header += "500 Internal Server Error";

       break;

     case 501:

       header += "501 Not Implemented";

       break;

     }

     header += header + "\r\n";

     header += header + "Connection: close\r\n";

     header += header + "Server: Tutorial Servidor HTTP em Java v0\r\n";  

     header += header + "Content-Type: text/html\r\n";

     header += header + "\r\n";

     

     return header;

   }

}