package com.jfp.datamiddle.test.iotest;

import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class RandomAccessFileTest {

    public static void main(String[] args) throws FileNotFoundException, SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://106.53.239.39:13306/datamiddle?characterEncoding=utf8&useSSL=true&rewriteBatchedStatements=true", "root", "root");
        Statement statement = connection.createStatement();

        for (int i = 1001; i < 100001; i++) {
            String format = MessageFormat.format("insert into user values({0},''{1}'',{2},''{3}'',''{4}'')", i+"",i+"",i+"",i+"",i+"");
            statement.addBatch(format);
            if(i %2000 == 0){
                statement.executeBatch();
                statement.clearBatch();
                System.out.println(i);
            }
        }

        System.out.println("结束");


    }

    private static void test1(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl("jdbc:mysql://106.53.239.39:13306/datamiddle?characterEncoding=utf8&useSSL=true&rewriteBatchedStatements=true");
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");
        jdbcTemplate.setDataSource(driverManagerDataSource);

        for (int i = 200; i < 10000; i++) {
            String format = MessageFormat.format("insert into user values({0},''{1}'',{2},''{3}'',''{4}'')", i+"",i+"",i+"",i+"",i+"");
            try{
                jdbcTemplate.execute(format);
            } catch (Exception e){

            }
        }

        System.out.println("结束");
    }
}
