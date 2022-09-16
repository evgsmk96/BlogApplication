package com.example.blogapplication.repo;

import com.example.blogapplication.models.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Posts, Long> {
}
