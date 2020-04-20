package com.zk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zk.bean.Zkinfo;
import com.zk.service.ZkService;

@Controller
public class ZkController {
	
	@Autowired
	private ZkService service;
	
	//http://localhost:8080/ZkProvide/monitor
	@RequestMapping("/monitor/{s}")
	public ModelAndView fun(@PathVariable("s") String s,HttpServletResponse response) throws IOException{	
		System.out.println("参数为：----"+s);
		List<Zkinfo> list = service.getInfo(s);	
		JSONArray array=new JSONArray();
		for (Zkinfo zkinfo : list) {
			JSONObject object=new JSONObject();
			object.put("time", zkinfo.getTime());
			object.put("item", zkinfo.getItem());
			object.put("value", zkinfo.getValue());			
			object.put("ip", zkinfo.getHostip());
			object.put("port", zkinfo.getPort());
			object.put("itemid", zkinfo.getItemid());
			object.put("hostname", zkinfo.getHostname());			
			object.put("short_name", zkinfo.getShort_name());
			object.put("online_time", zkinfo.getOnline_time());
			object.put("sys3_A", zkinfo.getSys3_A());			
			object.put("system_id", zkinfo.getSystem_id());
			object.put("system_name", zkinfo.getSystem_name());
			
			array.add(object);
		}
		response.getWriter().write(array.toJSONString());;
		return null;
	}

}
