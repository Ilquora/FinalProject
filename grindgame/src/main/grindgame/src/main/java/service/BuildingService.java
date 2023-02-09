package service;

import converter.BuildingConverter;
import entity.BuildingEntity;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import model.Building;
import org.springframework.stereotype.Service;
import repository.BuildingRepository;

@Slf4j
@Service
public class BuildingService {
    private final BuildingConverter buildingConverter;
private final BuildingRepository buildingRepository;

public BuildingService (BuildingConverter buildingConverter,BuildingRepository buildingRepository) {
    this.buildingConverter = buildingConverter;
    this.buildingRepository = buildingRepository;
}
@Transactional
    public BuildingEntity addBuilding (Building building) {
    BuildingEntity buildingEntity = buildingRepository.save(buildingConverter.convert(building));
    log.info("Building created : {} ",buildingEntity);
    return buildingEntity;
}
public void deleteById (Long id){
    buildingRepository.deleteById(id);
}
}
