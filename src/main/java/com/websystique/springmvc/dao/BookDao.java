package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Book;

//书本接口
public interface BookDao {
	// 根据书名查询想要的数据
	List<Book> findByName(String bookName);

}
