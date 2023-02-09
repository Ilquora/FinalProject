package repository;

import entity.CraftReceiptEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CraftElementRepository extends CrudRepository <CraftReceiptEntity,Long> {

}
