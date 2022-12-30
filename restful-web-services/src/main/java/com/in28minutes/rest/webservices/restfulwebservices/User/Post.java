package com.in28minutes.rest.webservices.restfulwebservices.User;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Integer id;
    @Size(min = 10)
    private String description;

    // we don't want to fetch user details with the post (eager)
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post() {
    }

    public Post(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(description, post.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
