package com.database.springbootjpaskeleton;

import com.database.springbootjpaskeleton.jdbc.PersonJdbcDAO;
import com.database.springbootjpaskeleton.jdbc.entity.Person;
import com.database.springbootjpaskeleton.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringBootJpaSkeletonApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJpaRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaSkeletonApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("User id 10001 -> {}", repository.findById(10001));
        /*
        logger.info("All users -> {}", repository.findAll());
        logger.info("User name SWEN -> {}", repository.findByName("GUILLERMO"));
        logger.info("Deleting 10003 -> No of Rows Deleted - {}", repository.deleteById(10003));
        logger.info("Deleting 10003 -> No of Rows Deleted - {}", repository.deleteAll());
        logger.info("Inserting 10005 -> {}", repository.insert(new Person(10005, "ERDEM", "ISTANBUL", new Date())));
        logger.info("Updating 10005 -> {}", repository.update(new Person(10005, "İBRAHİM ERDEM", "KADIKÖY", new Date())));
         */
    }
}
