package com.imlabs.repositories;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.imlabs.model.AreaMysql;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface AreaRepositoryMysqlPublisher extends JpaRepository<AreaMysql, Long> {
	
	@Query(value="select cast(max(substring(id , 2 , length(id))) as unsigned) from area" ,nativeQuery=true)
	int findMaxArea();

}
