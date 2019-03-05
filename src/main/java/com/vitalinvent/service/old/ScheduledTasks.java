package com.vitalinvent.service.old;

import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
//
//    @Autowired
//    private AnalyticsService analyticsService;
//
//    public static String dateTimeISO8601() {
//        DateTimeFormatter dtf = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
//        return OffsetDateTime.now().format(dtf);
//    }
//
//    //@Scheduled(fixedRate = 120000)
//    @Scheduled(fixedRate = 1000)
//    public void checkTasks(){
//        List<Analytics> tasks = this.analyticsService.getAllFromTableByName();
//        for (Analytics task:tasks) {
//            DateTime taskDateTime= DateTime.parse(task.getTimestamp());
//            DateTime currentDateTime= DateTime.parse(dateTimeISO8601());
//            int seconds = Seconds.secondsBetween(taskDateTime,currentDateTime).getSeconds();
//            if ((seconds>120) && (task.getStatus().contains(Status.created.toString()))){
//                task.setStatus(Status.running);
//                task.setTimestamp();
//                analyticsService.save(task);
//            }else if ((seconds>120) && (task.getStatus().contains(Status.running.toString()))){
//                task.setStatus(Status.finished);
//                task.setTimestamp();
//                analyticsService.save(task);
//            }
//        }
//    }
}
