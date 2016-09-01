package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Hope;

public interface HopeDao {
	List<Hope> findByLevel(int level);

}
