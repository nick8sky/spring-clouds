package org.kx.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.cloud.task.repository.TaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * create by sunkx on 2018/1/5
 */
@SpringBootApplication
//@EnableTask
@Slf4j
public class TaskApplication {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    //@Bean
    public CommandLineRunner commandLineRunner() {
        System.out.println("jdbcTemplate is null ?"+(jdbcTemplate ==null));
        System.out.println("dataSource is null ?"+(dataSource ==null));
        return new HelloWorldCommandLineRunner();
    }

    public static void main(String[] args) {


        SpringApplication.run(TaskApplication.class, args);
    }

    public static class HelloWorldCommandLineRunner implements CommandLineRunner {
        //TaskRepository
        @Override
        public void run(String... strings) throws Exception {
            System.out.println("Hello World!");
        }
    }
}
