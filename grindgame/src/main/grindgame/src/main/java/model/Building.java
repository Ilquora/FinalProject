package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Building {

    private Long id;
    private String name;
    private List<CraftElement> gives;
    private int price;

}
