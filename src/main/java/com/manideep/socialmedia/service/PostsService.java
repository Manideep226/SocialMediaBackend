package com.manideep.socialmedia.service;

import com.manideep.socialmedia.model.PostsDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostsService {
    PostsDetails createPost(PostsDetails postsDetails);

    List<PostsDetails> getPostsByUser(int userid);

    List<PostsDetails> getPostsByGroup(int groupid);

    List<PostsDetails> getAllPosts();

    List<PostsDetails> getPostsByKeyword(String keyword);
}
