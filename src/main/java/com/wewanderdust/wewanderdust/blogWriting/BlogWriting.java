package com.wewanderdust.wewanderdust.blogWriting;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Arrays;

@Entity
@Table
public class BlogWriting {
    @Id
    @SequenceGenerator(
            name = "blogwriting_sequence",
            sequenceName = "blogwriting_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "blogwriting_sequence"
    )

    private int blogId;
    private String title;
    private String author;
    private String content;
    private LocalDate date;
    private String[] tags;

    public BlogWriting() {
    }

    public BlogWriting(int blogId, String title, String author, String content, LocalDate date, String[] tags) {
        this.blogId = blogId;
        this.title = title;
        this.author = author;
        this.content = content;
        this.date = date;
        this.tags = tags;
    }

    public BlogWriting(String title, String author, String content, LocalDate date, String[] tags) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.date = date;
        this.tags = tags;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "BlogWriting{" +
                "blogId=" + blogId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }
}
