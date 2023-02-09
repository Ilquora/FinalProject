package repository;
import entity.PlayerEntity;
import org.springframework.data.repository.CrudRepository;
import repository.PlayerRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PlayerRepository extends CrudRepository <PlayerEntity,Long> {
}
