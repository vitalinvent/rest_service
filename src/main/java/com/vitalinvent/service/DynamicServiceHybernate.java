package com.vitalinvent.service;
import java.util.List;
import java.util.UUID;

public interface DynamicServiceHybernate {

    Object getById(UUID id);

    Integer getByName(String name);

    void save(Object task);

    List<Object> getAllFromTableByName(String name);

}
