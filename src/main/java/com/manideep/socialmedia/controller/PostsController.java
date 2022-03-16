package com.manideep.socialmedia.controller;

import com.manideep.socialmedia.model.PostsDetails;
import com.manideep.socialmedia.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value="/socialmedia/posts")
public class PostsController {

    @Autowired
    private PostsService postsService;

    //create post
    @PostMapping("/create")
    public ResponseEntity<PostsDetails> createPost(@RequestBody PostsDetails postsDetails){
        PostsDetails p = postsService.createPost(postsDetails);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    //fetch posts by user
    @GetMapping("/getByUser/{userid}")
    public ResponseEntity<?> getPostsByUser(@PathVariable int userid){
        List<PostsDetails> postsDetails = postsService.getPostsByUser(userid);
        if(Objects.nonNull(postsDetails))
            return new ResponseEntity<>(postsDetails,HttpStatus.OK);
        else
            return new ResponseEntity<>("No posts by user",HttpStatus.NOT_FOUND);
    }

    //fetch posts by group
    @GetMapping("/getByGroup/{groupid}")
    public ResponseEntity<?> getPostsByGroup(@PathVariable int groupid){
        List<PostsDetails> postsDetails = postsService.getPostsByGroup(groupid);
        if(Objects.nonNull(postsDetails))
            return new ResponseEntity<>(postsDetails,HttpStatus.OK);
        else
            return new ResponseEntity<>("No posts in the group",HttpStatus.NOT_FOUND);
    }

    //fetch all posts
    @GetMapping("/get")
    public ResponseEntity<?> getAllPosts(){
        List<PostsDetails> postsDetails = postsService.getAllPosts();
        if(Objects.nonNull(postsDetails))
            return new ResponseEntity<>(postsDetails,HttpStatus.OK);
        else
            return new ResponseEntity<>("No posts yet",HttpStatus.NOT_FOUND);
    }

    //fetch all posts
    @GetMapping("/get-by-keyword")
    public ResponseEntity<?> getPostsByKeyword(@RequestParam(value = "keyword", required = true) String keyword){
        List<PostsDetails> postsDetails = postsService.getPostsByKeyword(keyword);
        if(Objects.nonNull(postsDetails))
            return new ResponseEntity<>(postsDetails,HttpStatus.OK);
        else
            return new ResponseEntity<>("No posts with keyword : "+keyword,HttpStatus.NOT_FOUND);
    }
}
