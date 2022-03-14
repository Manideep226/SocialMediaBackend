package com.manideep.socialmedia.repository;

import com.manideep.socialmedia.model.Comments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends CrudRepository<Comments,Integer> {
    @Query(value = "select p from Comments p where p.postId=:postid")
    List<Comments> findByPostId(int postid);
}
