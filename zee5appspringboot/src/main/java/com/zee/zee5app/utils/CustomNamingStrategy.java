package com.zee.zee5app.utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CustomNamingStrategy extends PhysicalNamingStrategyStandardImpl {

	private final static String POSTFIX="_table";
	//by default all tables should be ended with name_table
  @Override
public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment context) {
	// TODO Auto-generated method stub
	  if(identifier == null) {
		  return null;
	  }
	  final String newName = identifier.getText()+POSTFIX;
//	return super.toPhysicalTableName(name, context);
	  return identifier.toIdentifier(newName);
	  
}
  @Override
public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment context) {
	// TODO Auto-generated method stub
//	return super.toPhysicalColumnName(name, context);
if(identifier == null) {
	return null;
}

return Identifier.toIdentifier(identifier.getText().toLowerCase());
  
  
  }
}
