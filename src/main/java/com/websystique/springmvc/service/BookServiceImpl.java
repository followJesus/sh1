package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.BookDao;
import com.websystique.springmvc.model.Book;
 
//售卖书本的逻辑实现类
@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {
 
    @Autowired
    private BookDao bookDao;

//    根据书名查询相关书本信息
	public List<Book> findByBookName(String bookName) {
		return bookDao.findByName(bookName);
	}
     
    
 
}