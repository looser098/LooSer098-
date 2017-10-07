package cn.yznu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.yznu.entity.Group;
import cn.yznu.entity.MemberShip;
import cn.yznu.entity.User;
import cn.yznu.service.MemberShipService;
import cn.yznu.util.ResponseUtil;
import cn.yznu.util.StringUtil;
import net.sf.json.JSONObject;

 
@Controller
@RequestMapping("/memberShip")
public class MemberShipController {

	@Resource
	private MemberShipService memberShipService;
	
	 
	@RequestMapping("/update")
	public String update(String userId,String groupsIds,HttpServletResponse response)throws Exception{
		memberShipService.deleteAllGroupsByUserId(userId);
		if(StringUtil.isNotEmpty(groupsIds)){
			String idsArr[]=groupsIds.split(",");
			for(String groupId:idsArr){
				User user=new User();user.setId(userId);
				Group group=new Group();group.setId(groupId);
				MemberShip memberShip=new MemberShip();
				memberShip.setUser(user);
				memberShip.setGroup(group);
				memberShipService.add(memberShip);
			}
		}
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	
}
