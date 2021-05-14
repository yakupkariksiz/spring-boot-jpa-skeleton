package com.database.springbootjpaskeleton;

import com.database.springbootjpaskeleton.jdbc.PersonJdbcDAO;
import com.database.springbootjpaskeleton.jdbc.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class SpringBootJdbcSkeletonApplication implements CommandLineRunner {

    @Autowired
    PersonJdbcDAO dao;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcSkeletonApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}", dao.findAll());
        logger.info("User id 10001 -> {}", dao.findById(10001));
        logger.info("User name SWEN -> {}", dao.findByName("GUILLERMO"));
        logger.info("Deleting 10003 -> No of Rows Deleted - {}", dao.deleteById(10003));
        logger.info("Deleting 10003 -> No of Rows Deleted - {}", dao.deleteAll());
        logger.info("Inserting 10005 -> {}", dao.insert(new Person(10005, "ERDEM", "ISTANBUL", new Date())));
        logger.info("Updating 10005 -> {}", dao.update(new Person(10005, "İBRAHİM ERDEM", "KADIKÖY", new Date())));
    }
}
