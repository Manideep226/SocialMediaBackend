package com.manideep.socialmedia.repository;

import com.manideep.socialmedia.model.GroupUsers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupsUsersRepository extends CrudRepository<GroupUsers,Integer> {

    @Query(value = "select p from GroupUsers p where p.groupid=:groupid and p.userid=:userid")
    GroupUsers findUserinGroup(@Param("groupid")int groupid,@Param("userid") int userid);

    @Query(value = "select p from GroupUsers p")
    List<GroupUsers> getAllGroupsUsers();
}
