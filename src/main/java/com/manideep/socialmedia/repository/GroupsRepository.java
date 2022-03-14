package com.manideep.socialmedia.repository;

import com.manideep.socialmedia.model.Groups;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupsRepository extends CrudRepository<Groups, Integer> {

    @Query(value="select p from Groups p")
    List<Groups> findAllGroups();
}
