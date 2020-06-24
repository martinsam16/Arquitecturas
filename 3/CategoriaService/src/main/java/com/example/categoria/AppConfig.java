package com.example.categoria;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.h2.tools.Server;
import java.sql.SQLException;

@Configuration
public class AppConfig {

    @Bean(initMethod = "start", destroyMethod = "stop")
    @Profile("!OtraInstancia")
    public Server inMemoryH2DatabaseServer() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "7575");
    }
}