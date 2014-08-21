package br.com.serverHTTP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * This class will be responsible for initiating the connection.
 * 
 * In this first tutorial we will test the connection with the client 
 * 
 * and better understand the request of the HTTP protocol.
 * 
 * @author Caitano Junior
 * 
 * @since Creating an HTTP server in Java
 * 
 */

public class HttpServer {

	private int port;

	public HttpServer() {
		this.port = 80;
	}

	public HttpServer(int port) {
		this.port = port;
	}

	public void setPorta(int port) {
		this.port = port;
	}

	@SuppressWarnings("resource")
	public void start() {
		ServerSocket socketServer = null;
		System.out.println("Starting server…");
		try {
			System.out.println("Attempting to allocate a port…");
			socketServer = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("Fatal error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Fatal error: " + e.getMessage());
		}

		System.out.println("Server OK!");

		while (true) {
			System.out.println("Server is listening…");
			Socket socket = null;
			try {
				socket = socketServer.accept();
				InetAddress infoCliente = socket.getInetAddress();
				System.out.println("Client: " + infoCliente.getHostName()
						+ " connected to the server!");
				BufferedReader input = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));

				
				DataOutputStream output = new DataOutputStream(
						socket.getOutputStream());

				HTTPRequest requestClient = new HTTPRequest();

				requestClient.httpHandler(input, output);

				HTTPResponse response = new HTTPResponse(output);

				response.setRequest(requestClient);

				response.sendsResponse();

				System.out.println(requestClient.getHeadline());
				

				int requestLine = 0;
				while (input.ready()) {
					System.out
							.println(requestLine + " " + input.readLine());
					requestLine++;
				}
				socket.close();
			} catch (IOException e) {
				System.out.println("Connection error:" + e.getMessage());
			}
		}

	}
}