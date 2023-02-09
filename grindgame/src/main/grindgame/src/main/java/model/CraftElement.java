package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CraftElement {
    private Long craftElementId;
    private String craftElementName;
    private  Integer quantity;
}
