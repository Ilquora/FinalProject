package repository;

import entity.CraftEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CraftRepository extends CrudRepository <CraftEntity,Long>{
}
