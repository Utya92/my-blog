package by.mycompany.myblog.controller;

import by.mycompany.myblog.entity.Post;
import by.mycompany.myblog.service.PostService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MainController extends HttpServlet {

    private PostService postService = new PostService();
    //available commands: MAIN, ALL_POSTS, POST_BY_ID

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = request.getParameter("command_name") != null
                ? request.getParameter("command_name")
                : "";
        String page = "start.jsp";
        try {
            switch (commandName) {
                case "main": {
                    page = "start.jsp";
                }
                break;
                case "all_posts": {
                    List<Post> list = postService.getAllPosts();
                    request.setAttribute("myattribute", list);
                    page = "posts.jsp";
                }
                break;
                case "post_by_id": {
                    String postId = request.getParameter("postId");
                    Post post = postService.getPostById(Integer.valueOf(postId));
                    request.setAttribute("post", post);
                    page = "post.jsp";
                }
                break;
                default:
                    break;
            }

        } catch (Exception e) {
            page = "error.jsp";
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
        requestDispatcher.forward(request, response);
    }
}
