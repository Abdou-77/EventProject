package com.atlas.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class DatabaseConnectionTest implements CommandLineRunner {
    private final DataSource dataSource;
    public DatabaseConnectionTest(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public void run(String... args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("✅ Connection successful to: " + connection.getMetaData().getURL());
            System.out.println("User: " + connection.getMetaData().getUserName());
        } catch (Exception e) {
            System.out.println("❌ Connection failed: " + e.getMessage());
        }
    }
}
