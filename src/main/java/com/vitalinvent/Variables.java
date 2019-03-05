package com.vitalinvent;

import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Variables {
    public static Configuration configuration;
    public static String SETTINGS_COMMENT ="Main settigs for biplane rest service.";
    public static String SETTINGS_FILE="settings.txt";
    public static String postgresql_user="multiuser";
    public static String postgresql_password="123";
    public static String PORT="8433";
    public static String APP_PATH ="";
    public static String CLASSES_ENTITIES_OBJECTS_FOLDER_NAME ="objects";
    public static String CLASSES_ENTITIES_OBJECTS_FULL_PATH="";
    public static ArrayList<Class<?>> classesLoaded =null;
    public  Variables(){
        classesLoaded = new ArrayList<Class<?>>();
        configuration = new Configuration().configure();
        try {
            APP_PATH =new File(".").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //CLASSES_ENTITIES_OBJECTS_FULL_PATH = APP_PATH +"\\"+CLASSES_ENTITIES_OBJECTS_FOLDER_NAME+"\\";
        try {
            Files.createDirectories(Paths.get(CLASSES_ENTITIES_OBJECTS_FULL_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        CLASSES_ENTITIES_OBJECTS_FULL_PATH=Settings.Get("CLASSES_ENTITIES_OBJECTS_FULL_PATH",Variables.APP_PATH +"\\"+Variables.CLASSES_ENTITIES_OBJECTS_FOLDER_NAME+"\\");
        Settings.Set("valueName1","value");
        String val1=Settings.Get("valueName1","value");
        Settings.Set("valueName2",true);
        Boolean val2=Settings.Get("valueName2",true);
        Settings.Set("valueName3",100);
        Integer val3=Settings.Get("valueName3",100);

        DynamicCompilerLoader.LoadClassesHibernate();
        DynamicCompilerLoader.LoadClassesJPA();

//        Variables.CLASSES_ENTITIES_OBJECTS_FULL_PATH=Settings.Get("CLASSES_ENTITIES_OBJECTS_FULL_PATH",Variables.APP_PATH +"\\"+Variables.CLASSES_ENTITIES_OBJECTS_FOLDER_NAME+"\\");
//        DynamicCompilerLoader.LoadClasses();

    }
}
