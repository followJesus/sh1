package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Hope;

public interface HopeService {
	List<Hope> findByLevel(int level);

}
