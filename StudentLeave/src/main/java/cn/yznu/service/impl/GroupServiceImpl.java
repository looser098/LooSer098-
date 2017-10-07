package cn.yznu.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yznu.dao.GroupDao;
import cn.yznu.entity.Group;
import cn.yznu.service.GroupService;

 
@Service("groupService")
public  class GroupServiceImpl implements GroupService{

	@Resource
	private GroupDao groupDao;
	
	public List<Group> find(Map<String, Object> map) {
		return groupDao.find(map);
	}

	public Long getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return groupDao.getTotal(map);
	}

	public int delete(String id) {
		// TODO Auto-generated method stub
		return groupDao.delete(id);
	}

	public int update(Group group) {
		// TODO Auto-generated method stub
		return groupDao.update(group);
	}

	public int add(Group group) {
		// TODO Auto-generated method stub
		return groupDao.add(group);
	}

	public Group findById(String id) {
		// TODO Auto-generated method stub
		return groupDao.findById(id);
	}

	public List<Group> findByUserId(String userId) {
		// TODO Auto-generated method stub
		return groupDao.findByUserId(userId);
	}

}
