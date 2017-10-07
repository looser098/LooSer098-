package cn.yznu.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yznu.dao.MemberShipDao;
import cn.yznu.entity.MemberShip;
import cn.yznu.service.MemberShipService;

 
@Service("memberShipService")
public class MemberShipServiceImpl implements MemberShipService{

	@Resource
	private MemberShipDao memberShipDao;
	
	public MemberShip login(Map<String, Object> map) {
		return memberShipDao.login(map);
	}

	public int deleteAllGroupsByUserId(String userId) {
		// TODO Auto-generated method stub
		return memberShipDao.deleteAllGroupsByUserId(userId);
	}

	public int add(MemberShip memberShip) {
		// TODO Auto-generated method stub
		return memberShipDao.add(memberShip);
	}

}
