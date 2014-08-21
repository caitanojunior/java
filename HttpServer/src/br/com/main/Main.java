package br.com.main;

import br.com.serverHTTP.HttpServer;

/**
 * @author Caitano Junior
 *
 */

public class Main {

	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		HttpServer server = new HttpServer(8091);

		server.start();

	}

}