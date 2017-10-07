package cn.yznu.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yznu.dao.UserDao;
import cn.yznu.entity.User;
import cn.yznu.service.UserService;

 
@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	
	public User findById(String id) {
		return userDao.findById(id);
	}

	public List<User> find(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.find(map);
	}

	public Long getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.getTotal(map);
	}

	public int delete(String id) {
		// TODO Auto-generated method stub
		return userDao.delete(id);
	}

	public int update(User user) {
		// TODO Auto-generated method stub
		return userDao.update(user);
	}

	public int add(User user) {
		// TODO Auto-generated method stub
		return userDao.add(user);
	}

}
