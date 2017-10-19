package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import entities.JPAPOIEntity;

import java.util.List;

public interface JPAPOIRepository extends JpaRepository<JPAPOIEntity, Long>  {
	@Query("select u from Object u where (u.X >= :X1 and u.X <= :X2) and (u.Y >= :Y1 and u.Y <= :Y2)")
	List<JPAPOIEntity> getByBounds(@Param("X1") double X1,
								   @Param("Y1") double Y1,
								   @Param("X2") double X2,
								   @Param("Y2") double Y2);

}
