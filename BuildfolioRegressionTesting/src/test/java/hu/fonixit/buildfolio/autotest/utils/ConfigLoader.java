package hu.fonixit.buildfolio.autotest.utils;

import hu.fonixit.buildfolio.autotest.constants.EnvType;


import java.util.Properties;

public class ConfigLoader {
    private Properties properties;
    private static ConfigLoader configLoader; //type of the variable can be the class as well

    private ConfigLoader() { //a konstruktor nem lesz elérhető, mivel private; nem akarjuk másik class ebben a frameworkben elérje ezt a konstruktort
        String env = System.getProperty("env", String.valueOf(EnvType.STAGE));
        switch (EnvType.valueOf(env)) {
          case STAGE -> properties = PropertyUtils.propertyLoader("src/test/resources/test01.properties");
            case PRODUCTION ->
                    properties = PropertyUtils.propertyLoader("");
            default -> throw new IllegalStateException("Invalid env type: " + env);
        }
    }

    public static ConfigLoader getInstance(){ //when this will be called at the second time, the configloader will be not null anymore, the second instance of this class will be not created
        if(configLoader == null) { //checking if the configloader is null
            configLoader = new ConfigLoader();  //if null, we are creating a new instance
        }
        return configLoader; //there will be only one instance of this class
    }

//FOR EACH CONFIG PROPERTY WE CAN CREATE A METHOD

    public String getBaseUrl() {
        String prop = properties.getProperty("baseUrl");
        if (prop != null)
            return prop;
        else throw new RuntimeException("property baseUrl is not specified in the config.properties file");}
}

