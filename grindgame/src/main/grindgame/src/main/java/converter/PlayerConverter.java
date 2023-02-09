package converter;

import entity.PlayerEntity;
import model.Building;
import model.Player;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerConverter {
    public PlayerEntity convertToEntity(Player player) {
        return new PlayerEntity(
                player.getId(), player.getBuildings().stream().map(Building::getId).collect(Collectors.toList()),
                player.getGold()
        );
    }
    public Player convertToModel (PlayerEntity entity, List<Building> buildingList) {
        return new Player(
        entity.getId(),buildingList,entity.getGold()
        );
    }
}
