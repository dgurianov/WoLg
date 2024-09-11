/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fun.gud.wolg.configuration;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Danylo
 */
public class Config {
    
    private Properties config ;

    public Config() {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        config = new Properties();
        try (InputStream is = new FileInputStream("c:\\conf\\workLogger.properties")){
            config.load(is);
        } catch (Exception e){
            System.out.println("#####################################################");
            System.out.println("No config present at c:\\conf\\workLogger.properties!!!");
            System.out.println("#####################################################");
        }
    }
    
    public Properties getConfig() {
        return config;
    }

    public void setConfig(Properties config) {
        this.config = config;
    }
    
    
    
    
    
}
