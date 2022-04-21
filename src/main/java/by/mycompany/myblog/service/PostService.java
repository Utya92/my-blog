package by.mycompany.myblog.service;

import by.mycompany.myblog.entity.Post;
import by.mycompany.myblog.repository.PostRepository;

import java.util.List;

public class PostService {

    private PostRepository postRepository = new PostRepository();

    public Post getPostById(Integer id) throws Exception {
        Post myPost = postRepository.selectPostById(id);
        return myPost;
    }

    public List<Post> getAllPosts() throws Exception {
        List<Post> list = postRepository.selectAllPosts();
        return list;
    }

    public static void main(String[] args) throws Exception {
        PostService postService = new PostService();
        // проверяем getPostById сервиса
        System.out.println(postService.getPostById(2));

    }
}
