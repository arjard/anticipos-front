package com.ph.anticipos.dao;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.ph.anticipos.models.Paquete;
import com.ph.anticipos.models.Status;
import com.ph.anticipos.utiles.Resources;

public class ServerSeacher<T> implements Runnable, Resources{

	private Paquete<T> paquete;
	
	@Override
	public void run() {

			waitingConnection();
			
	}
	
	/**
	 * Espera la respuesta del server
	 */
	private void waitingConnection() {
		@SuppressWarnings("resource")
		Socket socket;
		try {
			socket = new Socket(IP_SERVER, PORT_SERVER);
			
			while(true) {
				paquete = new Paquete<T>();
				paquete.setIpOrigen(socket.getLocalAddress().getHostAddress());
				paquete.setStatus(Status.CLIENT);
						
				ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
						
				salida.writeObject(paquete);
						
				salida.close();
				socket.close();
			
			}
		} catch (UnknownHostException i) {
			// TODO Auto-generated catch block
			i.printStackTrace();
		} catch (ConnectException o) {
			System.out.println("Esperando");
			waitingConnection();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}


}
