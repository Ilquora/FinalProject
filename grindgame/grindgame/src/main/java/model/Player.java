package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Data
@Getter
@Setter
@ToString
public class Player {
    private long id;
    private int gold;
private int food;
private int wood;
private List<Building> buildings;

    public Player(long id, int gold, int food, int wood, List<Building> buildings) {
        this.id = id;
        this.gold = gold;
        this.food = food;
        this.wood = wood;
        this.buildings = buildings;
    }
}
