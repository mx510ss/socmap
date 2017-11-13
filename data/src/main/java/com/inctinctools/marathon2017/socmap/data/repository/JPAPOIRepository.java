package com.inctinctools.marathon2017.socmap.data.repository;

import com.inctinctools.marathon2017.socmap.core.enums.POITypes;
import com.sun.istack.internal.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.inctinctools.marathon2017.socmap.data.entities.JPAPOIEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPAPOIRepository extends JpaRepository<JPAPOIEntity, Long> {
    @Query("select u from JPAPOIEntity u where (u.x >= :x1 and u.x <= :x2) and (u.y >= :y1 and u.y <= :y2) and u.type = :type")
    @NotNull
    List<JPAPOIEntity> getByBounds(@Param("x1") final double x1, @Param("y1") final double y1,
                                   @Param("x2") final double x2, @Param("y2") final double y2,
                                   @Param("type") @NotNull final POITypes type);
}
