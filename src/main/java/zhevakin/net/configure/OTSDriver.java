package zhevakin.net.configure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

@Configuration
public class OTSDriver {

    @Value("${OTSLogin}")
    String login;

    @Value("${OTSPassword}")
    String password;

    @Value("${OTSServer}")
    String server;

    @Value("${OTSDatabase}")
    String database;


    @Bean
    public DataSource OTSDataSource() {

        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setUser(login);
        dataSource.setPassword(password);
        dataSource.setServerName(server);
        dataSource.setDatabaseName(database);

        return dataSource;

    }
}
