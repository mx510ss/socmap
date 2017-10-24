package repository;

import enums.POITypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import entities.JPAPOIEntity;

import java.util.List;

public interface JPAPOIRepository extends JpaRepository<JPAPOIEntity, Long>  {
	@Query("select u from Object u where (u.x >= :x1 and u.x <= :x2) and (u.y >= :y1 and u.y <= :y2) and u.type = :type")
	List<JPAPOIEntity> getByBounds(@Param("x1") double x1, @Param("y1") double y1,
								   @Param("x2") double x2, @Param("y2") double y2,
								   @Param("type")POITypes type);

}
