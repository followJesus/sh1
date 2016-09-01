package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Animal;
 
@Repository("animalDao")
public class AnimalDaoImpl extends AbstractDao<Integer, Animal> implements AnimalDao {
 
  
 
	/* (non-Javadoc)查询所有动物信息
	 * @see com.websystique.springmvc.dao.AnimalDao#findAllAnimals()
	 */
	@SuppressWarnings("unchecked")
	public List<Animal> findAllAnimals() {
		Criteria criteria = createEntityCriteria();//查询信息
        return (List<Animal>) criteria.list();//指定格式获取信息
	}

	/* (non-Javadoc)添加动物信息
	 * @see com.websystique.springmvc.dao.AnimalDao#saveAnimal(com.websystique.springmvc.model.Animal)
	 */
	public void saveAnimal(Animal animal) {
		 persist(animal);
	}

	/* (non-Javadoc)根据id查看动物信息
	 * @see com.websystique.springmvc.dao.AnimalDao#findById(int)
	 */
	public Animal findById(int id) {
		return getByKey(id);
	}

	/* (non-Javadoc)根据动物Id删除这个动物
	 * @see com.websystique.springmvc.dao.AnimalDao#deleteAnimalById(int)
	 */
	public void deleteAnimalById(int id) {
		Query query = getSession().createSQLQuery("delete from animal where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
		
	}
 
  
}
