//package com.vitalinvent.rest;
//
//import com.vitalinvent.model.Analytics;
//import com.vitalinvent.service.AnalyticsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.*;
//
///**
// * REST controller for {@link Analytics} connected requests.
// *
// *
// *
// */
//@CrossOrigin(origins = "http://localhost:8433", maxAge = 3600)
//@RestController
//@RequestMapping("/analytics")
//public class RestControllerAnalytics {
//    @Autowired
//    private AnalyticsServiceImpl analyticsService;
//    @CrossOrigin
//    @RequestMapping(value = "/{guid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity<Analytics> getAnalytic(@PathVariable("guid") String taskId) {
//        if (taskId == null) {
//            return new ResponseEntity<Analytics>(HttpStatus.BAD_REQUEST);
//        }
//        try{
//            //UUID uuid = taskId;//UUID.fromString(taskId);
//        } catch (IllegalArgumentException exception){
//            return new ResponseEntity<Analytics>(HttpStatus.BAD_REQUEST);
//        }
//        Analytics task = this.analyticsService.getById(UUID.fromString(taskId));
//
//        if (task == null) {
//            return new ResponseEntity<Analytics>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<Analytics>(task, HttpStatus.OK);
//    }
//    @CrossOrigin
//    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity<List<Analytics>> getAll() {
//        List<Analytics> analytics = this.analyticsService.getAll();
//        return new ResponseEntity<List<Analytics>>(analytics, HttpStatus.OK);
//    }
////    @CrossOrigin
////    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
////    public ResponseEntity<Analytics> saveAnalytic() {
////        HttpHeaders headers = new HttpHeaders();
////        ObjectMapper mapper = new ObjectMapper();
////        Analytics analytic = null;
////        try {
////            analytic = mapper.readValue("{\n" +
////                    "    \"timestamp\": \""+dateTimeISO8601()+"\",\n" +
////                    "    \"status\": \"created\"\n" +
////                    "}", Analytics.class);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////
////        this.tasksService.save(analytic);
////        return new ResponseEntity<>(analytic, headers, HttpStatus.ACCEPTED);
////    }
//}
