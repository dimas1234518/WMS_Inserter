package zhevakin.net.configure;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class TGWDriver {


    public static DataSource TGWDataSource() throws IOException {

        Properties properties = new Properties();
        properties.load(new InputStreamReader(new FileInputStream("src/main/resources/application.properties"), StandardCharsets.UTF_8));

        String login = properties.getProperty("TGWLogin");
        String password = properties.getProperty("TGWPassword");
        String server = properties.getProperty("TGWServer");
        String database = properties.getProperty("TGWDatabase");

        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setUser(login);
        dataSource.setPassword(password);
        dataSource.setServerName(server);
        dataSource.setDatabaseName(database);

        return dataSource;

    }

}
