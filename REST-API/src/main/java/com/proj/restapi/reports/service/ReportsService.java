package com.proj.restapi.reports.service;

import general.SystemEvents;
import general.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class ReportsService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<SystemEvents> getSysEvents(int userId){
        String sql = "SELECT * FROM [SystemEvents] where userId=?";
        List<SystemEvents> sysEvent = jdbcTemplate.query(sql,new Object[] { userId },
                BeanPropertyRowMapper.newInstance(SystemEvents.class));
        return sysEvent;
    }
}
