package com.ph.anticipos.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ph.anticipos.models.Anticipo;

@Repository
public class AnticipoDAOImpl implements AnticipoDAO {

	private ServerListener<Anticipo> anticipos;

	public AnticipoDAOImpl() {
		anticipos = new ServerListener<Anticipo>();
		Thread h1 = new Thread(anticipos);
		h1.start();
	}

	/**
	 *Conseguimos lista de anticipos
	 */
	@Override
	public List<Anticipo> getAnticipos() {

		if (anticipos.getListado() == null) {
			anticipos.getElements("");
			
			//Esperamos a que el server nos responda
			while (anticipos.getListado() == null) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		return anticipos.getListado();
	}

}
