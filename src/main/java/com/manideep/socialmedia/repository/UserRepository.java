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

    List<User> findUserByNameContainingIgnoreCase(String name);

    @Query(value="select p from User p where p.name LIKE CONCAT('%',:name,'%') and p.mobile LIKE CONCAT('%',:mobile,'%')")
    List<User> findUserByMultiParam(String name, String mobile);

}
