package com.rental.carshowroom.repository;

import com.rental.carshowroom.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    List<User> findAll();

    Optional<User> findByUsername(String username);
}
