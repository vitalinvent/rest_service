package com.vitalinvent;

import org.apache.log4j.Logger;
import org.hibernate.*;
//import org.hibernate.query.Query;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HibernateEngine {
//    public Configuration configuration;
    public SessionFactory sessionFactory;
    public ServiceRegistry serviceRegistry;
    public Session session;
    //public Transaction transaction=null;

    public void HibernateEngine(){
        //*******HIBERNATE
//        configuration = new Configuration().configure();
//        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(Variables.configuration.getProperties()).build();
//        sessionFactory = Variables.configuration.buildSessionFactory(serviceRegistry);
//        session = sessionFactory.openSession();
    }
    public final static Logger logger = Logger.getLogger(HibernateEngine.class);
    //    public void UpdateDatabase(){
//        UpdateDatabase(Variables.LoadedObjectsArrayListDataForDb);
//    }
    public void UpdateDatabase(List<Object> arrayListObjectsForDb){
//        SessionFactory sessionFactory = Variables.configuration.buildSessionFactory();
//        Session session = sessionFactory.openSession();
        sessionFactory = Variables.configuration.buildSessionFactory();
        session = sessionFactory.openSession();
//                    Query query = session.createQuery("FROM DicNomenclaturesEntity ");
//            List nomenclatures = query.list();
//            try {
//                ParsingEngine.serializeToXML(nomenclatures);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        Transaction transaction = null;
        int items=0;
        Object objOnError=null;
        try {
            transaction = session.beginTransaction();
            for (Object obj:arrayListObjectsForDb) {
                //session.save(obj);
                try {
                    objOnError=obj;
//                    replicate(Object, ReplicationMode) — преобразует объект из detached в persistent, при этом у объекта обязательно должен быть заранее установлен Id. Данный метод предназначен для сохранения в БД объекта с заданным Id, чего не позволяют сделать persist() и merge(). Если объект с данным Id уже существует в БД, то поведение определяется согласно правилу из перечисления org.hibernate.ReplicationMode:
//                    ReplicationMode.IGNORE — ничего не меняется в базе.
//                    ReplicationMode.OVERWRITE — объект сохраняется в базу вместо существующего.
//                    ReplicationMode.LATEST_VERSION — в базе сохраняется объект с последней версией.
//                    ReplicationMode.EXCEPTION — генерирует исключение.
                    //session.replicate(obj,ReplicationMode.OVERWRITE);
                    //merge(Object) — преобразует объект из transient или detached в persistent. Если из transient, то работает аналогично persist() (генерирует для объекта новый Id, даже если он задан), если из detached — загружает объект из БД, присоединяет к сессии, а при сохранении выполняет запрос update
                    //session.merge(obj);
                    session.saveOrUpdate(obj);
                } catch (EntityNotFoundException ex){
                    logger.error(ex);
                } catch (IllegalArgumentException ex){
                    logger.error(ex);
                } catch (Exception ex){
                    logger.error(ex);
                }
            }
            session.flush();
            session.getTransaction().commit();
            session.clear();
        } catch (HibernateException e){
            logger.error(e);
            //if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        } catch (PersistenceException ex){
            logger.error(ex);
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }

    public List<Object> getAllByName(String nameTable){
        if (sessionFactory == null) {
//            DynamicCompilerLoader.LoadClassesHibernate();
//            Variables.configuration = new Configuration().configure(); НЕ ПЕРЕИНИЦИАЛИЗИРОВАТЬ ТЕРЯЕТ СОЕДИНЕНИЯ ОБЪЕКТОВ
            sessionFactory = Variables.configuration.buildSessionFactory();}
        session = sessionFactory.openSession();
        List<Object> result = new ArrayList<Object>();
        try{
            result = session.createQuery("from "+nameTable).list();
        } catch (Exception ex){
            logger.error(ex);
        }
        return  result;
    }
}
