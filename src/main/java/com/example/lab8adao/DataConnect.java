package com.example.lab8adao;

import org.postgresql.ds.PGSimpleDataSource;
import javax.sql.DataSource;
public class DataConnect {
    public static DataSource createDataSource(){
        final String url= "jdbc:postgresql://localhost:5432/javaLab8a?user=postgres&password=123";
        final PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setURL(url);
        return dataSource;
    }
}
