package com.exam.JsonMap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.JsonMap.domain.Posts;
import com.exam.JsonMap.repository.PostsRepository;

@Service
public class PostsService {

	@Autowired
    private PostsRepository postRepository;

    public PostsService(PostsRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Iterable<Posts> list() {
        return postRepository.findAll();
    }

    public Posts save(Posts user) {
        return postRepository.save(user);
    }

   public Iterable<Posts> save(List<Posts> users){
	   return postRepository.saveAll(users);
   }
}
