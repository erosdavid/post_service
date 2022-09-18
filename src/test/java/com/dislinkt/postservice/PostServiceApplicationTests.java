package com.dislinkt.postservice;

import com.dislinkt.postservice.model.Comment;
import com.dislinkt.postservice.model.DislikePost;
import com.dislinkt.postservice.model.LikePost;
import com.dislinkt.postservice.model.UserPost;
import com.dislinkt.postservice.repository.CommentRepository;
import com.dislinkt.postservice.repository.DislikePostRepository;
import com.dislinkt.postservice.repository.LikePostRepository;
import com.dislinkt.postservice.repository.UserPostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostServiceApplicationTests {

	@Autowired
	private UserPostRepository userPostRepository;

	@Autowired
	private LikePostRepository likePostRepository;

	@Autowired
	private DislikePostRepository dislikePostRepository;


	@Autowired
	private CommentRepository commentRepository;

	@Test
	public void testGetAllUserPosts(){
		List<UserPost> userPosts = userPostRepository.findAll();
		assertThat(userPosts).size().isGreaterThan(0);
	}

	@Test
	public void testGetAllLikePosts(){
		List<LikePost> likePosts = likePostRepository.findAll();
		assertThat(likePosts).size().isGreaterThan(0);
	}

	@Test
	public void testGetAllDislikePosts(){
		List<DislikePost> dislikePosts = dislikePostRepository.findAll();
		assertThat(dislikePosts).size().isGreaterThan(0);
	}

	@Test
	public void testGetAllComments(){
		List<Comment> comments = commentRepository.findAll();
		assertThat(comments).size().isGreaterThan(0);
	}


}
