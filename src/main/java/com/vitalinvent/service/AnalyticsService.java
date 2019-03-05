package com.vitalinvent.service;

import com.vitalinvent.model.Analytics;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service interface for {@link Analytics} class.
 *
 *
 *
 */

public interface AnalyticsService {


    Optional<Analytics> getById(UUID id);

    Integer getByName(String name);

    void save(Analytics task);

    List<Analytics> getAll();
}
