package com.ph.anticipos.models;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ph.anticipos.utiles.BeanFramework;

public class Anticipo implements BeanFramework, Serializable{

	
//	POS_STORE                     
//	POS_TERMINAL                  
//	POS_TRANSACTION               
//	POS_CONSECUTIVE               
//	POS_SEQUENCE                  
//	POS_TRANSACTION_TYPE          
//	POS_BUSINESS_DATE             
//	POS_TENDER_IO_NEEDS_TOBE_FIRST
//	POS_TENDER_DELETED            
//	POS_TENDER_TYPE_CODE          
//	POS_AMOUNT_DUE                
//	POS_AMOUNT_TENDER             
//	POS_ACCOUNT_NUMBER            
//	POS_EXPIRATION_DATE           
//	POS_OVERRIDE_CODE             
//	POS_RESPONSE_CODE             
//	POS_AUTHORIZATION_CODE        
//	POS_TENDER_AUTHORIZATION_TEXT 
//	POS_REVERSAL_MESSAGE_TO_INFO  
//	POS_CHARGE_OPTIONS            
//	POS_CUSTOMER_NAME             
//	POS_CHECK_LAST_4_DIGITS       
//	POS_KEYED_SWIPED_FLAG         
//	POS_PVD_NUMBER                
//	POS_CHECK_CUSTOMER_NAME       
//	POS_CHECK_ADDRESS_1           
//	POS_CHECK_ADDRESS_2           
//	POS_CHECK_ADDRESS_3           
//	POS_CHECK_ADDRESS_4           
//	POS_CHECK_CUSTOMER_PHONE_NUM  
//	POS_CHECK_CUSTOMER_ID_NUMBER  
//	POS_CHECK_AUTHORIZING_PERSON  
//	POS_OVERRIDE_CODE_TRY         
//	POS_TENDER_AMOUNT_PAY         
//	POS_TENDER_ACCOUNT_NUMBER_PAY 
//	POS_PRICE_NO_REG_DC           
//	POS_IMP_DISCOUNT              
//	POS_IMP_MARKDOWNS             
//	POS_FOLIODEV                  
//	POS_AMOUNT_DLL                
//	POS_TOKEN_ACCOUNT             
//	POS_RETURNS_STATUS            
//	POS_CONSECUTIVE_ORIG          
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer tienda;

	private Integer terminal;

	private String folio;

	private String fecha;

	private Integer operacion;

	private String monto;
	
	
	
	public Anticipo() {
	}
	
	public Anticipo(Integer tienda, Integer terminal, String folio, String fecha, Integer operacion, String monto) {
		this.tienda = tienda;
		this.terminal = terminal;
		this.folio = folio;
		this.fecha = fecha;
		this.operacion = operacion;
		this.monto = monto;
	}

	public Integer getTienda() {
		return tienda;
	}

	public void setTienda(Integer tienda) {
		this.tienda = tienda;
	}

	public Integer getTerminal() {
		return terminal;
	}

	public void setTerminal(Integer terminal) {
		this.terminal = terminal;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getOperacion() {
		return operacion;
	}

	public void setOperacion(Integer operacion) {
		this.operacion = operacion;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Anticipo [tienda=" + tienda + ", terminal=" + terminal + ", folio=" + folio + ", fecha=" + fecha
				+ ", operacion=" + operacion + ", monto=" + monto + "]\n";
	}

	@Override
	public void doBinding(ResultSet rs) {
		try {
			this.setTienda(rs.getInt("POS_STORE"));
			this.setTerminal(rs.getInt("POS_TERMINAL"));
			this.setFecha(rs.getString("POS_BUSINESS_DATE"));
			this.setFolio(rs.getString("POS_FOLIODEV"));
			this.setOperacion(rs.getInt("POS_TRANSACTION"));
			this.setMonto(rs.getString("POS_AMOUNT_TENDER"));
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public String getNameTable() {
		return "online_pos_pagos";
	}
	
	
	
}
