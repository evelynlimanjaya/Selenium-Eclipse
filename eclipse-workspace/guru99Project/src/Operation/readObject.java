package Operation;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class readObject {
	Properties p = new Properties();
    public Properties getObjectRepository() throws IOException{
        //Read object repository file
        InputStream stream = new FileInputStream(new File("C:\\Users\\Eien\\Selenium-Eclipse\\eclipse-workspace\\guru99Project\\src\\objects\\object.properties"));
        //lcd seload all objects
        p.load(stream);
         return p;
    }
}
