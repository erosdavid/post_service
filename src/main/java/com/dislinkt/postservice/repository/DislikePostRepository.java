package com.dislinkt.postservice.repository;

import com.dislinkt.postservice.model.DislikePost;
import com.dislinkt.postservice.model.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DislikePostRepository extends JpaRepository<DislikePost, Long> {


}
