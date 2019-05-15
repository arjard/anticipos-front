package com.ph.anticipos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ph.anticipos.dao.AnticipoDAO;
import com.ph.anticipos.models.Anticipo;

@Service
public class AnticiposServiceImpl implements AnticiposService{

	@Autowired
	AnticipoDAO anticipodao;
	
	@Override
	public List<Anticipo> getAnticipos() {
		// TODO Auto-generated method stub
		return anticipodao.getAnticipos();
	}

}
