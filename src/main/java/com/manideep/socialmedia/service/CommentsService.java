package com.manideep.socialmedia.service;

import com.manideep.socialmedia.model.Comments;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentsService {

    Comments createComment(Comments comments);

    Comments replyToComment(Comments comments);

    List<Comments> getCommentsonPost(int postid);
}
