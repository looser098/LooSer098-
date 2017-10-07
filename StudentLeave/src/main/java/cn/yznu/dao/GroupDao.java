package cn.yznu.dao;

import java.util.List;
import java.util.Map;

import cn.yznu.entity.Group;

public interface GroupDao {

	public List<Group> find(Map<String,Object> map);
	
	
	public Group findById(String id);
	
	
	public Long getTotal(Map<String,Object> map);
	 
	
	public int delete(String id);
	
	 
	public int update(Group group);
	
	 
	public int add(Group group);
	
	public List<Group> findByUserId(String userId);
}
