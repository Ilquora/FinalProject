package model;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@ToString
public class Player {
    private long id;
    private BigDecimal gold;
private int food;
private int wood;
private List<Building> buildings;


}

