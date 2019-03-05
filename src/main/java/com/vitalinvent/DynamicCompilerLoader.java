package com.vitalinvent;
import org.apache.log4j.Logger;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class DynamicCompilerLoader {
    public final static Logger logger = Logger.getLogger(DynamicCompilerLoader.class);
    public  static  void LoadClassesJPA(){
        final File folder = new File(Variables.CLASSES_ENTITIES_OBJECTS_FULL_PATH);
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
            } else {
                if (fileEntry.getName().endsWith(".class")) {
                    URLClassLoader classLoader = null;
                    try {
                        classLoader = new URLClassLoader(new URL[]{new File(Variables.CLASSES_ENTITIES_OBJECTS_FULL_PATH).toURI().toURL()});
                    } catch (MalformedURLException e) {
                        logger.error(e);
                    }
                    //classTOCreate = classLoader.loadClass("classes."+className);
                    Class<?> classTOCreate = null;
                    try {
                        classTOCreate = classLoader.loadClass(fileEntry.getName().replaceFirst("[.][^.]+$", ""));
                    } catch (ClassNotFoundException e) {
                        logger.error(e);
                    } catch (NoClassDefFoundError e){
                        logger.error(e);
                    }
                    Thread.currentThread().setContextClassLoader(classTOCreate.getClassLoader());
                    //Variables.configuration.addAnnotatedClass(classTOCreate);
                    logger.trace("Loaded class " + fileEntry);
                }
            }
        }
        //Variables.configuration.addAnnotatedClass(BasicEntity.class);
    }
    public  static  void LoadClassesHibernate(){
        final File folder = new File(Variables.CLASSES_ENTITIES_OBJECTS_FULL_PATH);
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
            } else {
                if (fileEntry.getName().endsWith(".class")) {
                    URLClassLoader classLoader = null;
                    try {
                        classLoader = new URLClassLoader(new URL[]{new File(Variables.CLASSES_ENTITIES_OBJECTS_FULL_PATH).toURI().toURL()});
                    } catch (MalformedURLException e) {
                        logger.error(e);
                    }
                    //classTOCreate = classLoader.loadClass("classes."+className);
                    Class<?> classTOCreate = null;
                    try {
                        classTOCreate = classLoader.loadClass(fileEntry.getName().replaceFirst("[.][^.]+$", ""));
                    } catch (ClassNotFoundException e) {
                        logger.error(e);
                    } catch (NoClassDefFoundError e){
                        logger.error(e);
                    }
                    //Thread.currentThread().setContextClassLoader(classTOCreate.getClassLoader());
                    Variables.configuration.addAnnotatedClass(classTOCreate);
                    logger.trace("Loaded class " + fileEntry);
                }
            }
        }
        //Variables.configuration.addAnnotatedClass(BasicEntity.class);
    }
}
