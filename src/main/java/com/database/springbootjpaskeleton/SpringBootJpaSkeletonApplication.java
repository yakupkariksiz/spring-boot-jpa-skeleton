package com.database.springbootjpaskeleton;

import com.database.springbootjpaskeleton.jdbc.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaSkeletonApplication implements CommandLineRunner {

    @Autowired
    PersonJdbcDAO dao;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaSkeletonApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}", dao.findAll());
        logger.info("User id 10001 -> {}", dao.findById(10001));
        logger.info("User name SWEN -> {}", dao.findByName("GUILLERMO"));
        logger.info("Deleting 10003 -> No of Rows Deleted - {}", dao.deleteById(10003));
        logger.info("Deleting 10003 -> No of Rows Deleted - {}", dao.deleteAll());
    }
}
