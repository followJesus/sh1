package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.HopeDao;
import com.websystique.springmvc.model.Hope;
 
@Service("hopeService")
@Transactional
public class HopeServiceImpl implements HopeService {
 
    @Autowired
    private HopeDao hopeDao;

	public List<Hope> findByLevel(int level) {
		return hopeDao.findByLevel(level);
	}
     
    
 
}