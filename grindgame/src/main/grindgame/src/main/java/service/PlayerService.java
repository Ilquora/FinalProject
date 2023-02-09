package service;

import cache.PlayerCache;
import converter.BuildingConverter;
import converter.PlayerConverter;
import entity.BuildingEntity;
import entity.PlayerEntity;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import model.Building;
import model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import repository.BuildingRepository;
import repository.PlayerRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
@ComponentScan
@EnableAutoConfiguration
public class PlayerService {
    private final PlayerConverter playerConverter;
    private final PlayerRepository playerRepository;
    private final PlayerCache playerCache;
private  final ResourceConverter resourceConverter;
    private final BuildingRepository buildingsRepository;
    private final BuildingConverter buildingConverter;
    private  final ResourceRepository resourceRepository;
    private  final ResourceEntity resourceEntity;
    private final Building building;
    private final BuildingService buildingService;
    @Autowired
    private PlayerService(PlayerConverter playerConverter,
                          PlayerRepository playerRepository, ResourceEntity resourceEntity,
                          PlayerCache playerCache
               , BuildingRepository buildingRepository,BuildingService buildingService, Building building, BuildingConverter buildingConverter,ResourceRepository resourceRepository,ResourceConverter resourceConverter) {
        this.playerConverter = playerConverter;
        this.playerRepository = playerRepository;
        this.playerCache = playerCache;
this.resourceRepository = resourceRepository;
        this.buildingConverter = buildingConverter;
        this.buildingsRepository = buildingRepository;
this.resourceConverter = resourceConverter;
this.resourceEntity = resourceEntity;
this.building = building;
this.buildingService = buildingService;
    }
@PostConstruct
private void init (){
    playerRepository.findAll().forEach(this::fillThePlayerCache);
}
private  void  fillThePlayerCache (PlayerEntity playerEntity) {
   List <Building> buildingsList = Stream.of(buildingsRepository.findAll())
            .map(buildingEntity->buildingConverter.convert(buildingEntity.iterator().next()))
            .filter(building->playerEntity.getBuildingsId().contains(building.getId()))
            .collect(Collectors.toList());

    playerCache.addPlayer(playerConverter.convertToModel(playerEntity, buildings));
}
@Transactional
    public  void createBuilding(Long playerId,Long resourceId) {
    ResourceEntity resourceEntity = resourceRepository.findById(resourceId).orElse(null);
    if (resourceEntity == null) {
        log.info("unknown type of request");
        return;
    }
    Player player = playerCache.getPlayer(playerId);
    if (player==null) {
        log.info("Player not found");
        return;
    }
    List <Building> buildingList = player.getBuildings();
    if (buildingList == null || buildingList.isEmpty()){
        log.info("Player doesnt have any buildings yet");
        return;
    }
    Resource resource = resourceConverter.convert(resourceEntity);
    for (Resource component : building.getNeeds()){
        Building building = buildingList.stream().filter(pr ->pr.getId().equals (component.getResourceId())).findAny().orElse(null);
        if (building == null) {
            log.info("Player have no : {} ",component.getResourceName());
            return;
        }
if (resource.getQuantity()< component.getQuantity()){
    log.info("not enough : {} ",component.getResourceName());
    return;
}
buildingOperations(building,component,player);
    }
    BuildingEntity buildingEntity = buildingService.addBuilding(new Building(null,building.getName(),building.getNeeds(),building.getGives(),building.getPrice()));

}


private void ComponentOperations (Building building,Resource resource,Player player){

        int newResourceQuantity = building.getNeeds(resource.getQuantity());
        if (newResourceQuantity <= 0){
            List <Building> buildingList = player.getBuildings();
            buildingList.remove(building);
            player.setBuildings(buildingList);
            buildingService.deleteById(building.getId());
        }
}

}




//
