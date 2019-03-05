package com.vitalinvent.rest;

//import com.vitalinvent.model.Analytics;
//import com.vitalinvent.service.AnalyticsServiceImpl;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vitalinvent.Functions;
import com.vitalinvent.service.DynamicServiceHybernateImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * REST controller for {@link Analytics} connected requests.
 *
 * 
 *
 */
@CrossOrigin(origins = "http://localhost:8433", maxAge = 3600)
@RestController
@RequestMapping("/opensprav1c")
public class RestControllerOpensprav1c {
    public final static Logger logger = Logger.getLogger(RestControllerOpensprav1c.class);
//    @Autowired
//    private AnalyticsServiceImpl analyticsService;

    @Autowired
    private DynamicServiceHybernateImpl dynamicServiceHybernate;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getAllFromTableByNameREST (@RequestHeader HttpHeaders headers) {
        Object retVal=null;
        long userAgent = headers.getContentLength();;//.getHeader("user-agent");
        String tableName=headers.get("parameter1").get(0);
//        Integer analyticCode = this.analyticsService.getByName(tableName);
        Integer analyticCode = -1;
        String tableNameResponse="";
        List<Object> list = null;
        if (analyticCode>0) { //найдена в аналитике
            tableNameResponse="fl"+tableName;
            list = this.dynamicServiceHybernate.getAllFromTableByName(tableName);
        } else if (analyticCode==-1) { //не найдена в аналитике
            tableNameResponse=tableName;
            list = this.dynamicServiceHybernate.getAllFromTableByName(tableName);
        }
        if (list==null) {
            list = getMunisOne();
            retVal="-1";
        }
//        {spr: spr, maxLvl: maxLvl, head: head, dat: dat}, где
//                spr = 'fl'+код таблицы, если код = -1, то Parameter1
//                maxLvl = максимальный уровень вложенности в справочнике. В нашем случае это пока будет 2
//        head = массив - это заголовок таблицы типа [ ['Код' , 'Дата' ], [....], .... ]
//        dat = массив - это данные таблицы типа [ [ уровень, 'строка', 'строка', ], [.....], .... ]
        JsonObject gson = new JsonObject();
        gson.addProperty("spr",tableNameResponse);
        gson.addProperty("maxLvl",2);
        JsonObject head = new JsonObject();
        JsonArray headArr = new JsonArray();
        for (Field field:list.get(0).getClass().getDeclaredFields()) {
            headArr.add(field.getName());
        }
        gson.add("head",headArr);
        JsonObject dat = new JsonObject();
        List<JsonArray>  jsonObjects = new ArrayList<JsonArray>();
        JsonArray datRow = null;
        int rowArray=0;
        for (Object obj :list) {
            datRow = new JsonArray();
            datRow.add(rowArray);
            for (Field field: obj.getClass().getDeclaredFields()) {
                Method method = null;
                try {
                    method = obj.getClass().getMethod("get"+Functions.ToUpperFirstLetter(field.getName()));
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                try {
                    Object value = method.invoke(obj);
                    if (value == null){
//                        datRow.add(value.toString());
                    } else {
                        datRow.add(value.toString());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            dat.add(String.valueOf(rowArray), datRow);
            rowArray++;
        }
        gson.add("dat", dat);
        return new ResponseEntity<String>(Functions.SerializeGson(gson), HttpStatus.OK);
    }
//    @CrossOrigin
//    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity<Integer> getCode (@RequestHeader HttpHeaders headers) {
//        long userAgent = headers.getContentLength();;//.getHeader("user-agent");
//        Integer analytic = this.analyticsService.getByName(headers.get("parameter1").get(0));
////        Integer analytic = this.dynamicRepository.getByName(headers.get("parameter1").get(0));
//        return new ResponseEntity<Integer>(analytic, HttpStatus.OK);
//
//    }
    private List<Object> getMunisOne(){
        List<Object> objects = new ArrayList<Object>();
        objects.add("-1");
        return objects;
    }
}
