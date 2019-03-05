//package com.vitalinvent.service;
//
//import com.vitalinvent.repository.AnalyticsRepository;
//import com.vitalinvent.model.Analytics;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
///**
// * Implementations of {@link AnalyticsService} interface.
// *
// *
// *
// */
//
////@Service
//@Repository
//public class AnalyticsServiceImpl implements AnalyticsService {
//
//    @Autowired
//    AnalyticsRepository analyticsRepository;
//
//    @Override
//    public Optional<Analytics> getById(UUID guid) {
//        return analyticsRepository.findOne(guid);
//    }
//
////    @Override
////    public Analytics getByName(String name) {
////        return taskRepository.getByName(name);
////    }
//
//    @Override
//    public Integer getByName(String name) {
//        Integer retVal=analyticsRepository.getByName(name);
//        if (retVal != null){
//            return retVal;
//        } else {
//            return -1;
//        }
//    }
//
//    @Override
//    public void save(Analytics customer) {
//        analyticsRepository.save(customer);
//    }
//
//    @Override
//    public List<Analytics> getAll() {
//        return analyticsRepository.findAll();
//    }
//
////    @Override
////    public Analytics getByName(String name) {
//////        Transaction transaction = null;
//////        try{
////        // Create CriteriaBuilder
//////        CriteriaBuilder builder = BiplaneApplication.session.getCriteriaBuilder();
//////        CriteriaQuery<Analytics> criteria = builder.createQuery(Analytics.class);
////        //Criteria criteria = BiplaneApplication.session.createCriteria(Analytics.class);
////        //Analytics analytics = (Analytics) criteria.add(Restrictions.eq("yourField", name)).uniqueResult();
////         //  Criteria criteria = BiplaneApplication.session.createCriteria(YourClass.class);
//////        } catch (EntityNotFoundException ex){
//////        } catch (IllegalArgumentException ex){
//////        } catch (Exception ex){
//////        }
////        Query query = entityManager.createNativeQuery("SELECT projectId, projectName FROM projects");
////        List result = query.getResultList();
////        return analytics;
////    }
//
//}
