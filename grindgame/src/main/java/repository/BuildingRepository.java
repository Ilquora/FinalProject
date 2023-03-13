package repository;

import entity.BuildingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends CrudRepository <BuildingEntity,Long> {
}
