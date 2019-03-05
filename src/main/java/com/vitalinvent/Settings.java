package com.vitalinvent;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;
public class Settings {
    public final static Logger logger = Logger.getLogger(Settings.class);
    public static String Get(String name,String defVal){
        File configFile = new File(Variables.SETTINGS_FILE);
        try {
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);
            reader.close();
            return props.getProperty(name);
        } catch (FileNotFoundException ex) {
            // file does not exist
            logger.error(ex);
            return defVal;
        } catch (IOException ex) {
            // I/O error
            logger.error(ex);
            return defVal;
        } catch (Exception ex){
            logger.error(ex);
            return defVal;
        }
    }
    public static Integer Get(String name,Integer defVal){
        File configFile = new File(Variables.SETTINGS_FILE);
        try {
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);
            reader.close();
            return Integer.valueOf(props.getProperty(name));
        } catch (FileNotFoundException ex) {
            // file does not exist
            logger.error(ex);
            return defVal;
        } catch (IOException ex) {
            // I/O error
            logger.error(ex);
            return defVal;
        } catch (Exception ex){
            logger.error(ex);
            return defVal;
        }
    }
    public static Boolean Get(String name,Boolean defVal){
        File configFile = new File(Variables.SETTINGS_FILE);
        try {
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);
            reader.close();
            return Boolean.valueOf(props.getProperty(name));
        } catch (FileNotFoundException ex) {
            // file does not exist
            logger.error(ex);
            return defVal;
        } catch (IOException ex) {
            // I/O error
            logger.error(ex);
            return defVal;
        } catch (Exception ex){
            logger.error(ex);
            return defVal;
        }
    }
    public static void Set(String name, String value){
        File configFile = new File(Variables.SETTINGS_FILE);
        try {
            Properties props = new Properties();
            FileReader reader = new FileReader(configFile);
            props.load(reader);
            props.setProperty(name, value.toString());
            FileWriter writer = new FileWriter(configFile);
            props.store(writer, Variables.SETTINGS_COMMENT);
            writer.close();
        } catch (FileNotFoundException ex) {
            // file does not exist
            logger.error(ex);
        } catch (IOException ex) {
            // I/O error
            logger.error(ex);
        } catch (Exception ex){
            logger.error(ex);
        }
    }
    public static void Set(String name, Integer value){
        File configFile = new File(Variables.SETTINGS_FILE);
        try {
            Properties props = new Properties();
            FileReader reader = new FileReader(configFile);
            props.load(reader);
            props.setProperty(name, value.toString());
            FileWriter writer = new FileWriter(configFile);
            props.store(writer,Variables.SETTINGS_COMMENT);
            writer.close();
        } catch (FileNotFoundException ex) {
            // file does not exist
            logger.error(ex);
        } catch (IOException ex) {
            // I/O error
            logger.error(ex);
        } catch (Exception ex){
            logger.error(ex);
        }
    }
    public static void Set(String name, Boolean value){
        File configFile = new File(Variables.SETTINGS_FILE);
        try {
            Properties props = new Properties();
            FileReader reader = new FileReader(configFile);
            props.load(reader);
            props.setProperty(name, value.toString());
            FileWriter writer = new FileWriter(configFile);
            props.store(writer,Variables.SETTINGS_COMMENT);
            writer.close();
        } catch (FileNotFoundException ex) {
            // file does not exist
            logger.error(ex);
        } catch (IOException ex) {
            // I/O error
            logger.error(ex);
        } catch (Exception ex){
            logger.error(ex);
        }
    }
}
