package com.zk.serviceImpl;



import com.zk.bean.Zkinfo;
import com.zk.mapper.Zkmapper;
import com.zk.service.ZkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ZkServiceImpl implements ZkService {
	
    @Autowired
    private Zkmapper mapper;

	@Override
	public List<Zkinfo> getInfo(String s) {
		return mapper.getInfo(s);
	}





}
