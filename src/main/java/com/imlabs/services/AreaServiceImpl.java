package com.imlabs.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imlabs.model.AreaMysql;
import com.imlabs.model.CourseMysql;

import com.imlabs.repositories.AreaRepositoryMysqlPublisher;


@Service
public class AreaServiceImpl  implements AreaService{
	
	@Autowired
	AreaRepositoryMysqlPublisher areaRepositoryMysqlPublisher;
	


	@Override
	public void insertArea(AreaMysql area) {
	   areaRepositoryMysqlPublisher.save(area);
	   	
	}

	@Override
	public List<AreaMysql> findAllAreas() {
		return areaRepositoryMysqlPublisher.findAll();
		
	}

	@Override
	public void deleteArea(long id) {
		areaRepositoryMysqlPublisher.delete(id);

	}

	@Override
	public void updateArea(AreaMysql area) {
		 areaRepositoryMysqlPublisher.save(area);

		
	}

	@Override
	public AreaMysql getAreaById(long id) {
	   return areaRepositoryMysqlPublisher.findOne(id);	
	}

	

}
