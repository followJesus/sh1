package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.AnimalDao;
import com.websystique.springmvc.model.Animal;
 
@Service("animalService")
@Transactional
public class AnimalServiceImpl implements AnimalService{
	
	@Autowired
    private AnimalDao animalDao;
     
    
	/* (non-Javadoc)查询所有动物信息
	 * @see com.websystique.springmvc.service.AnimalService#findAllAnimals()
	 */
	public List<Animal> findAllAnimals() {
		return animalDao.findAllAnimals();
	}


	/* (non-Javadoc)添加动物信息
	 * @see com.websystique.springmvc.service.AnimalService#saveAnimal(com.websystique.springmvc.model.Animal)
	 */
	public void saveAnimal(Animal animal) {
		animalDao.saveAnimal(animal);
	}


	/* (non-Javadoc)根据id查看动物信息
	 * @see com.websystique.springmvc.service.AnimalService#findById(int)
	 */
	public Animal findById(int id) {
		return animalDao.findById(id);
	}


	/* (non-Javadoc)更新动物信息
	 * @see com.websystique.springmvc.service.AnimalService#updateAnimal(com.websystique.springmvc.model.Animal)
	 */
	public void updateAnimal(Animal animal) {
		Animal entity = animalDao.findById(animal.getId());
		if (entity!=null) {
			entity.setKind(animal.getKind());
		}
	}


	/* (non-Javadoc)根据动物Id删除这个动物
	 * @see com.websystique.springmvc.service.AnimalService#deleteAnimalById(int)
	 */
	public void deleteAnimalById(int id) {
		animalDao.deleteAnimalById(id);
	}
 
  
     
}