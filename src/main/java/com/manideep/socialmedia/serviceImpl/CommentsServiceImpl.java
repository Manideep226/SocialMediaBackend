package com.manideep.socialmedia.serviceImpl;

import com.manideep.socialmedia.model.Comments;
import com.manideep.socialmedia.repository.CommentsRepository;
import com.manideep.socialmedia.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public Comments createComment(Comments comments) {
        Comments c = commentsRepository.save(comments);
        c.setCommentId(c.getId());

        return commentsRepository.save(c);
    }

    @Override
    public Comments replyToComment(Comments comments) {
        Comments c = commentsRepository.save(comments);
        return c;
    }

    @Override
    public List<Comments> getCommentsonPost(int postid) {
        List<Comments> comments = commentsRepository.findByPostId(postid);
        if(comments.size()!=0)
            return comments;
        else
            return null;
    }
}
