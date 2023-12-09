package org.example.hibernate;

import org.example.props.PropertyReader;
import org.flywaydb.core.Flyway;

public class DbMigration {
    public static void flywayMigration() {
        String connectionUrl =  PropertyReader.getConnectionUrlForPostgres();
        String username =  PropertyReader.getUserForPostgres();
        String password = PropertyReader.getPasswordForPostgres();
        Flyway flyway = Flyway.configure().dataSource(connectionUrl, username, password).load();
        flyway.migrate();
    }
}
