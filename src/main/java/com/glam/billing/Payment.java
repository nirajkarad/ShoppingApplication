package com.glam.billing;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.skife.config.ConfigurationObjectFactory;

import com.google.inject.Provider;

public class Payment implements Provider<DBConfig> {
	
	private static Logger logger= Logger.getLogger(Main.class);
	

	@Override
	public DBConfig get() {
		Properties p = new Properties();
		try
		{
		FileReader reader = new FileReader("DB.properties");
		p.load(reader);
		}
		catch(IOException io)
		{
			logger.info("Catching Exception : "+io.getMessage());
		}
		ConfigurationObjectFactory c = new	ConfigurationObjectFactory(p);
		
		String dbname = System.getProperty("db_name");
		logger.info("Payment Through "+dbname);
		
		DBConfig d = c.buildWithReplacements(DBConfig.class,Collections.singletonMap("db_name", dbname));
		return d;
	}

}
