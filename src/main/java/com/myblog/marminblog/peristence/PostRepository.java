package com.myblog.marminblog.peristence;

import com.myblog.marminblog.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity,Long> {

    @Query("SELECT p FROM posts p ORDER BY p.id DESC")
    List<PostEntity> findAllDesc();
}
