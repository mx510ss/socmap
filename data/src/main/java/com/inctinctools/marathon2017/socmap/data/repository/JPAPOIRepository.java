package com.inctinctools.marathon2017.socmap.data.repository;

import com.inctinctools.marathon2017.socmap.core.enums.POITypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.inctinctools.marathon2017.socmap.data.entities.JPAPOIEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPAPOIRepository extends JpaRepository<JPAPOIEntity, Long>  {
	@Query("select u from POI u where (u.x >= :x1 and u.x <= :x2) and (u.y >= :y1 and u.y <= :y2) and u.type = :type")
	List<JPAPOIEntity> getByBounds(@Param("x1") double x1, @Param("y1") double y1,
								   @Param("x2") double x2, @Param("y2") double y2,
								   @Param("type")POITypes type);

}
