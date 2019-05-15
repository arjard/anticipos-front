package com.ph.anticipos.utiles;

import java.sql.ResultSet;

public interface BeanFramework {

	public void doBinding(ResultSet rs);
	public String getNameTable();
}
