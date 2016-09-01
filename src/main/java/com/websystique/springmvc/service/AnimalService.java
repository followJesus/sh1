package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Animal;

public interface AnimalService {
	/**
	 * @param id 更加动物Id删除这个动物
	 */
	void deleteAnimalById(int id);
	 /**
	 * @param animal 更新动物信息
	 */
	void updateAnimal(Animal animal);
	/**
	 * @param id
	 * @return 根据id查看动物信息
	 */
	Animal findById(int id);

	/**
	 * @param employee
	 *            添加动物信息
	 */
	void saveAnimal(Animal animal);

	/**
	 * @return 查询所有动物信息
	 */
	List<Animal> findAllAnimals();

}
