package com.vitalinvent;

import com.google.gson.Gson;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

public class Functions {
    public static void addSoftwareLibrary(File file) throws Exception {
        Method method = URLClassLoader.class.getDeclaredMethod("addURL", new Class[]{URL.class});
        method.setAccessible(true);
        method.invoke(ClassLoader.getSystemClassLoader(), new Object[]{file.toURI().toURL()});
    }
    public static String SerializeGson(List<Object> obj){
    Gson gson = new Gson();
    String retVal = gson.toJson(obj);
    return  retVal;
    }
    public static String SerializeGson(Object obj){
        Gson gson = new Gson();
        String retVal = gson.toJson(obj);
        return  retVal;
    }
    public static String ToUpperFirstLetter(String string){
        try {
            return string.substring(0, 1).toUpperCase() + string.substring(1);
        } catch (Exception ex){
            ex.printStackTrace();
            return string;
        }
    }
}
