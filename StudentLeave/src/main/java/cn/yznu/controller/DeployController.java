package cn.yznu.controller;

import java.util.List;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.yznu.entity.PageBean;
import cn.yznu.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

  
@Controller
@RequestMapping("/deploy")
public class DeployController {

	@Resource
	private RepositoryService repositoryService;
	
	 
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String rows,String s_name,HttpServletResponse response)throws Exception{
		if(s_name==null){
			s_name="";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		List<Deployment> deploymentList=repositoryService.createDeploymentQuery().orderByDeploymenTime().desc().deploymentNameLike("%"+s_name+"%")  
					.listPage(pageBean.getStart(), pageBean.getPageSize()); 
		long total=repositoryService.createDeploymentQuery().deploymentNameLike("%"+s_name+"%").count(); 
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[]{"resources"});
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(deploymentList,jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/deploy")
	public String deploy(@RequestParam("deployFile") MultipartFile deployFile,HttpServletResponse response)throws Exception{
		repositoryService.createDeployment() // 创建部署
				.name(deployFile.getOriginalFilename()) // 流程名称
				.addZipInputStream(new ZipInputStream(deployFile.getInputStream())) // 添加zip输入流
				.deploy(); // 部署
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids",required=false)String ids,HttpServletResponse response)throws Exception{
		String []idsStr=ids.split(",");
		for(int i=0;i<idsStr.length;i++){
			repositoryService.deleteDeployment(idsStr[i], true);
		}
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
