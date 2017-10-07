package cn.yznu.service;

import java.util.Map;

import cn.yznu.entity.MemberShip;

 
	public interface MemberShipService {

	 
	public MemberShip login(Map<String,Object> map);
	

	public int deleteAllGroupsByUserId(String userId);
	
	 
	public int add(MemberShip memberShip);
}
