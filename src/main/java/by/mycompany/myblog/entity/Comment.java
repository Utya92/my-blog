package by.mycompany.myblog.entity;
// в этомпакете entity лежат джава-классы для отображения данных из таблиц

import java.util.Date;

public class Comment {
    Integer id;
    String content;
    int rate;
    Date created;
    int postId;

    public Comment() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
