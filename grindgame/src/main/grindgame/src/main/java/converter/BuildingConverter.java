package converter;

import entity.BuildingEntity;
import model.Building;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuildingConverter {


    public Building convertToEntity(Building building){
        return new BuildingEntity(building.getId(), building.getName(),building.getPrice(),building.getNeeds().stream().map(Resource::getId).collect(Collectors.toSet()));

    }
    public BuildingEntity convertToModel(BuildingEntity entity, List<Building> buildingList) {
        return new BuildingEntity(entity.getId(), buildingList);

    }
}