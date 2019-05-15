package com.ph.anticipos.dao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import com.ph.anticipos.models.Operacion;
import com.ph.anticipos.models.Paquete;
import com.ph.anticipos.models.Status;
import com.ph.anticipos.utiles.Resources;

public class ServerListener<T> implements Runnable, Resources{

	private Paquete<T> paqueteRecibido;
	private ServerSeacher<T> search;
	private Thread hilo2;
	private int assignId;
	private boolean activo;
	private List<T> listado;
	/**
	 * @param server
	 * Se recibe parametro segun sea cliente o servidor
	 */
	public ServerListener() {
		super();
		this.search = new ServerSeacher<T>();
		this.activo = true;
		
		hilo2 = new Thread(search);
		hilo2.start();
	}

	/**
	 *Recibimos el paquete y lo redireccionamos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		ServerSocket server;
		try {
			//Levantamos el puerto de la aplicacion
//			server = new ServerSocket(serverUrl?PORT_SERVER:PORT_CLIENTE);
			server = new ServerSocket(PORT_CLIENTE);
			
			while(this.activo) {
			
				Socket socket = server.accept();
				
				ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
				
				paqueteRecibido = (Paquete<T>) entrada.readObject();
				
				switch(paqueteRecibido.getStatus()) {	
					case CLIENT:				
					break;
					case SERVER://El server nos responde
						
						this.assignId = paqueteRecibido.getIdPaquete();
						paqueteRecibido.setStatus(Status.CONNECT);
						this.hilo2.interrupt();
						
						Socket socketReenvio = new Socket(IP_SERVER, PORT_SERVER);
						
						ObjectOutputStream respuestaAConectar = new ObjectOutputStream(socketReenvio.getOutputStream());
						
						respuestaAConectar.writeObject(paqueteRecibido);
						
						System.out.println(this.hilo2.getState());
						System.out.println("-------------------------------Servidor contectado---------------------------------------");
						
					break;
					case CONNECT:
					break;
					case RESPONSE://Obtenemos respouesta del servidor
						
						System.out.println(paqueteRecibido.getListado());
						this.listado = (List<T>) paqueteRecibido.getListado();
						
					break;
					case DISCONNECT:
					break;
					case REQUEST:
					break;
					case NOTFOUND:
					break;
				}
				
				
				entrada.close();
				socket.close();
			
			}
			
		} catch ( IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @param query
	 * Consultamos en cualquier tabla
	 */
	public void getElements(String query) {
		
		Socket socketReenvio;
		
		try {
				socketReenvio = new Socket(IP_SERVER, PORT_SERVER);
				
				ObjectOutputStream salida = new ObjectOutputStream(socketReenvio.getOutputStream());
				
				paqueteRecibido.setStatus(Status.REQUEST);
				paqueteRecibido.setOperacion(Operacion.SELECT);
				
				salida.writeObject(paqueteRecibido);
				
				salida.close();
				socketReenvio.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public int getAssignId() {
		return assignId;
	}

	public void setAssignId(int assignId) {
		this.assignId = assignId;
	}

	public List<T> getListado() {
		return listado;
	}

	public void setListado(List<T> listado) {
		this.listado = listado;
	}

	

}
