package by.mycompany.myblog.repository;

import by.mycompany.myblog.entity.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    String hostName = "localhost";
    String dbName = "my_blog";
    String userName = "root";
    String password = "";

    String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

    public Post selectPostById(Integer postId) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        PreparedStatement statement = conn.prepareStatement("select * from post where id=?");
        statement.setInt(1, postId);
        ResultSet rs = statement.executeQuery();

        rs.next();
        Integer id = rs.getInt(1);
        String title = rs.getString(2);
        Date created = rs.getDate(3);
        Date updated = rs.getDate(4);
        String text = rs.getString(5);

        Post post = new Post(id, title, created, updated, text);

        rs.close();
        statement.close();
        conn.close();

        return post;
    }

    public List<Post> selectAllPosts() throws SQLException, ClassNotFoundException {
        Driver driver = new com.mysql.jdbc.Driver();
        DriverManager.registerDriver(driver);
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("select * from post");

        List<Post> postList = new ArrayList<>();
        while (rs.next()) {
//достаем данные из резалтсета(данные из табоицы)
            Integer id = rs.getInt(1);
            String title = rs.getString(2);
            Date created = rs.getDate(3);
            Date updated = rs.getDate(4);
            String text = rs.getString(5);
//сетаем в объект данные из резалтсета(из таблицы)
            Post myPost = new Post(id, title, created, updated, text);

            postList.add(myPost);
        }

        rs.close();
        statement.close();
        conn.close();

        return postList;
    }

    public static void main(String[] args) throws Exception {
        PostRepository postRepository = new PostRepository();
        //проверяем selectAllPosts репозитория
        List<Post> posts = postRepository.selectAllPosts();
        for (Post p : posts) {
            System.out.println(p);
        }

        //проверяем selectPostById репозитория
        System.out.println(postRepository.selectPostById(2));
    }


}
