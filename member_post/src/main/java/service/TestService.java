package service;

import java.util.List;

import vo.Post;

public interface TestService {
	List<Post> list();
	
	Post findBy(Long pno);
	
	String now();
	
	int write (Post post);
}
