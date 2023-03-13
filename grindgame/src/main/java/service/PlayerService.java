package service;

import cache.PlayerCache;
import converter.BuildingConverter;
import converter.CraftElementConverter;
import converter.CraftReceiptConverter;
import converter.PlayerConverter;
import entity.BuildingEntity;
import entity.CraftElementEntity;
import entity.CraftReceiptEntity;
import entity.PlayerEntity;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import model.Building;
import model.CraftElement;
import model.CraftReceipt;
import model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import repository.BuildingRepository;
import repository.CraftElementRepository;
import repository.CraftReceiptRepository;
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
private  final CraftElementConverter craftElementConverter;
    private final BuildingRepository buildingsRepository;
    private final BuildingConverter buildingConverter;
    private  final CraftElementRepository craftElementRepository;
    private  final CraftElementEntity craftElement;
    private final Building building;
    private final CraftReceiptConverter craftReceiptConverter;
    private final CraftReceiptRepository craftReceiptRepository;
    private final BuildingService buildingService;
    @Autowired
    private PlayerService(PlayerConverter playerConverter,
                          PlayerRepository playerRepository, CraftElementEntity craftElement, CraftReceiptEntity craftReceiptEntity, CraftReceiptRepository craftReceiptRepository,
                          PlayerCache playerCache
               , BuildingRepository buildingRepository, BuildingService buildingService, Building building, BuildingConverter buildingConverter, CraftElementRepository craftElementRepository, CraftElementConverter craftElementConverter,
                          CraftReceiptConverter craftReceiptConverter) {
        this.playerConverter = playerConverter;
        this.playerRepository = playerRepository;
        this.playerCache = playerCache;
        this.craftReceiptConverter = craftReceiptConverter;
        this.craftReceiptRepository = craftReceiptRepository;
this.craftElementRepository = craftElementRepository;
        this.buildingConverter = buildingConverter;
        this.buildingsRepository = buildingRepository;
this.craftElementConverter = craftElementConverter;
this.craftElement = craftElement;
this.building = building;
this.buildingService = buildingService;
    }
@PostConstruct
private void init (){
    playerRepository.findAll().forEach(this::fillThePlayerCache);
}
private  void  fillThePlayerCache (PlayerEntity playerEntity) {
        List <Building> buildings = Stream.of(buildingsRepository.findAll())
                .map(buildingEntity -> buildingConverter.convert(buildingEntity.iterator().next()))
                .filter(building -> playerEntity.getBuildingsId().contains(building.getId()))
                .collect(Collectors.toList());
        playerCache.addPlayer(playerConverter.convertToModel(playerEntity,buildings));

        }
        @Transactional
    public  void addPlayer (Player player){
        PlayerEntity save = playerRepository.save(playerConverter.convertToEntity(player));
        player.setId(save.getId());
        playerCache.addPlayer(player);
        }
public  Player getPlayer (){
        return playerCache.getPlayer(null);
}

        @Transactional
    public  void createBuilding (Long playerId,Long craftReceiptId){
        CraftReceiptEntity craftReceiptEntity = craftReceiptRepository.findById(craftReceiptId).orElse(null);
            if (craftReceiptEntity == null) {
                log.info("Receipt of that kind of building is not found");
                return;
            }
            Player player = playerCache.getPlayer(playerId);
            if (player == null){
                log.info("Cant find him");
                return;
            }
            List <Building> buildings = player.getBuildings();
            if (buildings ==null || buildings.isEmpty()){
                log.info("Player haven't any building");
                return;
            }
            CraftReceipt craftReceipt = craftReceiptConverter.convert(craftReceiptEntity);
            for (CraftElement element : craftReceipt.getCraftElements()){
                Building building = buildings.stream().filter(pr -> pr.getId().equals(element.getCraftElementId()))
                        .findAny().orElse(null);
                if (building == null) {
                    log.info("Player have no : {}",element.getCraftElementName());
                    return;
                }
                if (building.getAmt()<element.getQuantity()){
                    log.info("not enough : {}",element.getCraftElementName());
                    return;
                }
                elementOperations (building,element,player);
            }
            BuildingEntity buildingEntity = buildingService.addBuilding(new Building(null,craftReceipt.getReceiptName(),craftReceipt.getPrice(),1 ));
       List <Building> playerBuildings = player.getBuildings();
       playerBuildings.add(buildingConverter.convert(buildingEntity));
       player.setBuildings(playerBuildings);
       playerCache.addPlayer(player);
       playerRepository.save(playerConverter.convertToEntity(player));
    }
    private void elementOperations (Building building,CraftElement element,Player player){
        int newBuildingAmount = building.getAmt() - element.getQuantity();
        if (newBuildingAmount<= 0) {
            List <Building> buildings = player.getBuildings();
            buildings.remove(building);
            player.setBuildings(buildings);
            buildingService.deleteById(building.getId());
        }
    }
    private void update (BuildingEntity update,CraftElement craftElement,BuildingRepository buildingRepository){
        BuildingEntity existedInDB = buildingRepository.findById(update.getId()).orElse(null);
        log.info("update : {} ",craftElement);
        if (update.getName()!=null){
            assert existedInDB != null;
            existedInDB.setName(update.getName());
        }
        if (update.getPrice()>=0){
            assert existedInDB != null;
            existedInDB.setPrice(update.getPrice());
        }
        if (update.getAmt() >= 0) {
            assert existedInDB != null;
            existedInDB.setAmt(update.getAmt());
        }
    }



}







