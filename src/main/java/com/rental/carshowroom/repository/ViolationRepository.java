package com.rental.carshowroom.repository;

import com.rental.carshowroom.model.User;
import com.rental.carshowroom.model.Violation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ViolationRepository extends PagingAndSortingRepository<Violation, Long> {
    List<Violation> findAll();

    List<Violation> findAllByViolatingUserAndViolationStartAfter(User user, LocalDateTime date);
}
