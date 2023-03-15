package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class readPropertyFiles {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("E:\\upwork_projects\\AxtriaAutomationBS\\src\\test\\resources\\configfiles\\config.properties");

        Properties p = new Properties();

        p.load(fr);

    }

}
