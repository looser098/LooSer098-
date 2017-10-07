package cn.yznu.dao;

import java.util.Map;

import cn.yznu.entity.MemberShip;

 
public interface MemberShipDao {

	 
	public MemberShip login(Map<String,Object> map);
	
	
	public int deleteAllGroupsByUserId(String userId);
	
	 
	public int add(MemberShip memberShip);
}
