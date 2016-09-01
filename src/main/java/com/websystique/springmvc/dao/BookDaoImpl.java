package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Book;

//售卖书本数据接口的实现
@Repository("bookDao")
public class BookDaoImpl extends AbstractDao<Integer, Book> implements BookDao {

//	根据条件查询想要的书本信息
	@SuppressWarnings("unchecked")
	public List<Book> findByName(String bookName) {
		Criteria criteria = createEntityCriteria();// 存放客户提交的信息
		criteria.add(Restrictions.like("name", "%"+bookName+"%"));// 添加查询条件
		return (List<Book>) criteria.list();// 查询符合上面条件的相关信息
	}

}
