package com.glam.billing;

import org.skife.config.Config;
import org.skife.config.Default;
import org.skife.config.DefaultNull;

//Using Config Annotation for configuration
public interface DBConfig {
   
    @Config({"${db_name}_url","default_url"})
    @Default("www.payment.com")
    public abstract String getURL();

    @Config({"${db_name}_user","default_user"})
    public abstract String getDBUser();

    @Config({"${db_name}_pass","default_pass"})
    @DefaultNull()
    public abstract String getDBPass(); 

}

