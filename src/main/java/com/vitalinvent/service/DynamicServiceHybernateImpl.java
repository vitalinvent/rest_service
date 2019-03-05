package com.vitalinvent.service;

import com.vitalinvent.HibernateEngine;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public class DynamicServiceHybernateImpl implements DynamicServiceHybernate {
    public final static Logger logger = Logger.getLogger(DynamicServiceHybernateImpl.class);

    private HibernateEngine hibernateEngine=new HibernateEngine();

    @Override
    public Object getById(UUID id) {
        return "";
    }

    @Override
    public Integer getByName(String name) {
        return null;
    }

    @Override
    public void save(Object obj) {}

    @Override
    public List<Object> getAllFromTableByName(String name) {
        return  hibernateEngine.getAllByName(name);
    }

}
