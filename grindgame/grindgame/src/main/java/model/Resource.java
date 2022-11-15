package model;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Resource {
    private Long resourceId;
    private String ResourceName;
    private int quantity;
}
