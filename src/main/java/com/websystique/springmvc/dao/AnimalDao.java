package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Animal;
 
/**
 * @author zhangcunli
 * 动物数据操作的接口
 */
public interface AnimalDao {
	 /**
	 * @param id 根据动物Id删除这个动物
	 */
	void deleteAnimalById(int id);
	
	 /**
	 * @param id
	 * @return 根据id查看动物信息
	 */ 
	Animal findById(int id);
 
	/**
	 * @param employee 添加动物信息
	 */
	void saveAnimal(Animal animal);
    /**
     * @return 查询所有动物信息
     */
    List<Animal> findAllAnimals();
 
 
}
