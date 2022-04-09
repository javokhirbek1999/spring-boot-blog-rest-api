package com.believer.springBootBlog.blog;


import com.believer.springBootBlog.user.User;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table
public class Blog {

    @Id
    @SequenceGenerator(
            name = "blog_sequence",
            sequenceName = "blog_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "blog_sequence"
    )
    private Long id;
    private String title;
    private String body;
    private Long contentAuthorId;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    private LocalDate datePosted;
    private LocalDate dateUpdated;

    public Blog() {

    }

    public Blog(Long id, String title, String body, Long contentAuthorId, LocalDate datePosted, LocalDate dateUpdated) {
        this.id = id;
        this.contentAuthorId = contentAuthorId;
        this.title = title;
        this.body = body;
        this.datePosted = datePosted;
        this.dateUpdated = dateUpdated;
    }

    public Blog(String title, String body, Long contentAuthorId, LocalDate datePosted, LocalDate dateUpdated) {
        this.contentAuthorId = contentAuthorId;
        this.title = title;
        this.body = body;
        this.datePosted = datePosted;
        this.dateUpdated = dateUpdated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }

    public LocalDate getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Long getContentAuthorId() {
        return contentAuthorId;
    }

    public void setContentAuthorId(Long contentAuthorId) {
        this.contentAuthorId = contentAuthorId;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", author=" + contentAuthorId +
                ", datePosted=" + datePosted +
                ", dateUpdated=" + dateUpdated +
                '}';
    }
}
