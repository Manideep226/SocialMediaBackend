package com.manideep.socialmedia.repository;

import com.manideep.socialmedia.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    @Query(value="select p from User p")
    List<User> getAllUsers();
}
