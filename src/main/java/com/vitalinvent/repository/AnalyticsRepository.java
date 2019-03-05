package com.vitalinvent.repository;

import com.vitalinvent.model.Analytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

/**
 * Repository interface for {@link Analytics} class.
 *
 *
 *
 */
public interface AnalyticsRepository extends JpaRepository<Analytics, UUID> {

    @Query(value = "select a.code from analytics a where a.naimenovaniedb = ?1", nativeQuery = true)
    Integer getByName(String name);

}
