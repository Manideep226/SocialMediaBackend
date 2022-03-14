package com.manideep.socialmedia.serviceImpl;

import com.manideep.socialmedia.model.PostsDetails;
import com.manideep.socialmedia.repository.PostsRepository;
import com.manideep.socialmedia.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.Optional;

@Service
public class PostsServiceImpl implements PostsService {
    @Autowired
    private PostsRepository postsRepository;

    @Override
    public PostsDetails createPost(PostsDetails postsDetails) {
        //todo - before saving the data check if user is present in the group or not
        PostsDetails p = postsRepository.save(postsDetails);
        return p;
    }

    @Override
    public List<PostsDetails> getPostsByUser(int userid) {
        List<PostsDetails> postsDetails = postsRepository.findByUserId(userid);
        if(postsDetails.size()!=0)
            return postsDetails;
        else
            return null;
    }

    @Override
    public List<PostsDetails> getPostsByGroup(int groupid) {
        List<PostsDetails> postsDetails = postsRepository.findByGroupId(groupid);
        if(postsDetails.size()!=0)
            return postsDetails;
        else
            return null;
    }

    @Override
    public List<PostsDetails> getAllPosts() {
        List<PostsDetails> postsDetails = postsRepository.findAllPosts();
        if(postsDetails.size()!=0)
            return postsDetails;
        else
            return null;
    }
}
