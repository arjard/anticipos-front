package com.ph.anticipos.models;

import java.io.Serializable;
import java.util.List;

import com.ph.anticipos.utiles.BeanFramework;

public class Paquete<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idPaquete;
	private List<? extends BeanFramework> listado;
	private String ipDestino;
	private String ipOrigen;
	private Status status;
	private Operacion operacion;
	private String query;
	
	
	
	public Paquete() {
		super();
	}
	
	
	public List<? extends BeanFramework> getListado() {
		return listado;
	}
	public void setListado(List<? extends BeanFramework> listado) {
		this.listado = listado;
	}
	public String getIpDestino() {
		return ipDestino;
	}
	public void setIpDestino(String ipDestino) {
		this.ipDestino = ipDestino;
	}
	public String getIpOrigen() {
		return ipOrigen;
	}
	public void setIpOrigen(String ipOrigen) {
		this.ipOrigen = ipOrigen;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Integer getIdPaquete() {
		return idPaquete;
	}
	public void setIdPaquete(Integer idPaquete) {
		this.idPaquete = idPaquete;
	}
	
	public String getQuery() {
		return query;
	}


	public void setQuery(String query) {
		this.query = query;
	}
	


	public Operacion getOperacion() {
		return operacion;
	}


	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}


	@Override
	public String toString() {
		return "Paquete [objeto=" + listado + ", ipDestino=" + ipDestino + ", ipOrigen=" + ipOrigen + ", status="
				+ status + "]";
	}
	
}
