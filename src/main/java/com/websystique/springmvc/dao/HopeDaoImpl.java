package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Hope;

@Repository("hopeDao")
public class HopeDaoImpl extends AbstractDao<Integer, Hope> implements HopeDao {

	@SuppressWarnings("unchecked")
	public List<Hope> findByLevel(int level) {
		Criteria criteria = createEntityCriteria();// 存放客户提交的信息
		criteria.add(Restrictions.eq("level", level));// 添加查询条件
		return (List<Hope>) criteria.list();// 查询符合上面条件的相关信息
	}

}
