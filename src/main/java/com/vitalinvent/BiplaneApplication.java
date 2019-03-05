package com.vitalinvent;
import jdk.nashorn.internal.objects.annotations.Function;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import java.io.File;

@SpringBootApplication
//@EnableScheduling
@EnableJpaRepositories
//@EnableTransactionManagement
public class BiplaneApplication {
    public static Variables variables = new Variables();
    public static void main(String[] args) {


//        try {
//            Functions.addSoftwareLibrary(new File("C:\\dev\\java\\biplane_postgresql_uploader\\biplane_postgresql_uploader\\OBJ\\objects.jar"));
//            //C:\dev\java\biplane_postgresql_uploader\biplane_postgresql_uploader\OBJ\objects.jar
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        DynamicCompilerLoader.LoadClassesJPA();

        SpringApplication.run(BiplaneApplication.class,args);
//        DynamicCompilerLoader.LoadClassesHibernate();

    }

}