package cn.yznu.service;

import java.util.List;
import java.util.Map;

import cn.yznu.entity.User;

 
public interface UserService {

	 
	public User findById(String id);
	
	public List<User> find(Map<String,Object> map);
	
	 
	public Long getTotal(Map<String,Object> map);
	
	 
	public int delete(String id);
	
	 
	public int update(User user);
	
	 
	public int add(User user);
}
