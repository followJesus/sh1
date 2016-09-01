package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Book;

//售卖书本的逻辑接口
public interface BookService {

	// 根据书名查询相关书本
	List<Book> findByBookName(String bookName);
}
