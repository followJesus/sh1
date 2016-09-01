package com.websystique.springmvc.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.websystique.springmvc.model.Book;
import com.websystique.springmvc.service.BookService;

@Controller
@RequestMapping("/BookController")
public class BookController {
	
	 @Autowired
	  BookService bookService;
	/*
	 * 这个方法将会显示所有存在的员工
	 */
	@RequestMapping(value = { "/books" }, method = RequestMethod.GET)
	public void books(ModelMap model, HttpServletResponse response) {
//		response.setCharacterEncoding("utf-8");
		List<Book> books = new ArrayList<Book>();
//		Book b1 = new Book(100, "毕加索树叶","img/p1.png",12);
//		Book b2 = new Book(200, "蓝天中的白鸽","img/p2.jpg");
//		Book b3 = new Book(300, "这是什么？","img/p3.png");
//		books.add(b1);
//		books.add(b2);
//		books.add(b3);

		Gson gson = new Gson();
		String js = gson.toJson(books);// 把list集合转换成json格式，以便网络传输

		try {
			PrintWriter printWriter = response.getWriter();
			printWriter.write(js);
			printWriter.flush();
			printWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	 @RequestMapping(value = { "/{bookName}/bk" }, method = RequestMethod.GET)
	    public void deleteEmployee(@PathVariable String bookName, HttpServletResponse response) {
		 response.setContentType("text/html;charset=utf-8");
		 
		 System.out.println("-------------bookName-------- "+bookName);
		 
		 List<Book> books = bookService.findByBookName(bookName);
//		 List<Book> books = new ArrayList<Book>();
//			Book b1 = new Book(100, bookName,"/img/p1.png");
//			
//			books.add(b1);
			

			Gson gson = new Gson();
			String js = gson.toJson(books);// 把list集合转换成json格式，以便网络传输

			try {
				PrintWriter printWriter = response.getWriter();
				printWriter.write(js);
				printWriter.flush();
				printWriter.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	 }
	 
	
}
