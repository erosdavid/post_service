package com.dislinkt.postservice.repository;

import com.dislinkt.postservice.model.LikePost;
import com.dislinkt.postservice.model.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikePostRepository extends JpaRepository<LikePost, Long> {


}
