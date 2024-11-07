package service;

import java.util.List;

import vo.Post;

public interface PostService {
	int write(Post post);
	
	int modify(Post post);
	
	int remove(Long pno);
	
	Post findBy(Long pno);
	
	List<Post> list();
	
	
}
