package com.manideep.socialmedia.repository;

import com.manideep.socialmedia.model.PostsDetails;
import com.manideep.socialmedia.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostsRepository extends CrudRepository<PostsDetails, Integer> {
    @Query(value = "select p from PostsDetails p where p.userid=:userid")
    List<PostsDetails> findByUserId(int userid);

    @Query(value = "select p from PostsDetails p where p.groupid=:groupid")
    List<PostsDetails> findByGroupId(int groupid);

    @Query(value = "select p from PostsDetails p")
    List<PostsDetails> findAllPosts();

    @Query(value = "select p from PostsDetails p where p.postcontent LIKE CONCAT('%',:keyword,'%')")
    List<PostsDetails> findPostsByKeyword(String keyword);

}
