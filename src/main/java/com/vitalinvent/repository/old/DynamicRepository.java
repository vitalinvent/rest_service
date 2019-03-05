//package com.vitalinvent.repository.old;
//
//import classesHibernate.BasicEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.UUID;
//
//public interface DynamicRepository extends JpaRepository<BasicEntity, UUID> {
//    @Query(value = "select b.code from bankovskie_scheta_kontragentov b where b.naimenovaniedb = ?1", nativeQuery = true)
//    Integer getByName(String name);
//
//}
