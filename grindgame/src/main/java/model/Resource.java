package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Resource {
    private String ResourceName;
    private int quantity;
}
