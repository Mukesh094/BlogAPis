package com.blog.blogger.service;

import com.blog.blogger.dto_Or_Payload.PostDto;

import java.util.List;

public interface PostService {
    public PostDto createPost(PostDto postDto);


    void deletePost(long id);

    List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto updatePost(long postId, PostDto postDto);
}
