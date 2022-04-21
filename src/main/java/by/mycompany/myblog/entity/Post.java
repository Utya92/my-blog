package by.mycompany.myblog.entity;
// в этомпакете entity лежат джава-классы для отображения данных из таблиц

import java.util.Date;

public class Post {
    Integer id;
    String title;
    Date created;
    Date updated;
    String text;

    public Post(Integer id, String title, Date created, Date updated, String text) {
        this.id = id;
        this.title = title;
        this.created = created;
        this.updated = updated;
        this.text = text;
    }

    public Post() {

    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public String getText() {
        return text;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title +
                ", created=" + created +
                ", updated=" + updated +
                ", text='" + text +
                '}';
    }
}
