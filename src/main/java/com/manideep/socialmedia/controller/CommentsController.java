package com.manideep.socialmedia.controller;

import com.manideep.socialmedia.model.Comments;
import com.manideep.socialmedia.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value="/socialmedia/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    // create a comment
    @PostMapping(value="/create")
    public ResponseEntity<Comments> createComment(@RequestBody Comments comments){
        Comments c = commentsService.createComment(comments);
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

    // create a sub - comment  -> we will get comment id from client side
    @PostMapping(value="/reply")
    public ResponseEntity<Comments> replyToComment(@RequestBody Comments comments){
        Comments c = commentsService.replyToComment(comments);
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

    //get all comments on a post
    @GetMapping(value="/get/{postid}")
    public ResponseEntity<?> getAllCommentsonPost(@PathVariable int postid){
        List<Comments> c = commentsService.getCommentsonPost(postid);
        if(Objects.nonNull(c))
            return new ResponseEntity<>(c, HttpStatus.OK);
        else
            return new ResponseEntity<>("No Comments",HttpStatus.NOT_FOUND);
    }

}
