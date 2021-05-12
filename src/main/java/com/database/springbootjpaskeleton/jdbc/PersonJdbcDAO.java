package com.database.springbootjpaskeleton.jdbc;

import com.database.springbootjpaskeleton.jdbc.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // select * from person
    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from person where id=?", new BeanPropertyRowMapper<>(Person.class), new Object[]{id});
    }

    public List<Person> findByName(String name) {
        return jdbcTemplate.query("select * from person where name=?", new BeanPropertyRowMapper<>(Person.class), new Object[]{name});
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id=?", new Object[]{id});
    }

    public int deleteAll() {
        return jdbcTemplate.update("delete from person");
    }
}
