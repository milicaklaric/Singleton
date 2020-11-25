/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractProductB;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author MK
 */
public class SetProperties {
    public static void main(String[] args) {

	Properties prop = new Properties();
	OutputStream output = null;

	try {

		output = new FileOutputStream("config.properties");

		// set the properties value
		prop.setProperty("driver", "com.mysql.cj.jdbc.Driver");
		prop.setProperty("url", "jdbc:mysql://127.0.0.1:3306/skolaplesa_database?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		prop.setProperty("dbusername", "root");
                prop.setProperty("dbpassword", "root");

		// save properties to project root folder
		prop.store(output, null);

	} catch (IOException io) {
		
	} finally {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				
			}
		}

	}
  }
}
