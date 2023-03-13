package converter;

import entity.BuildingEntity;
import model.Building;
import model.CraftElement;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuildingConverter {


    public BuildingEntity convert(Building building){
        return new BuildingEntity(building.getId(), building.getName(),building.getPrice(), building.getAmt());

    }
    public Building convert(BuildingEntity entity) {
        return new Building(entity.getId(), entity.getName(), entity.getPrice(),entity.getAmt());

    }
}