package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
public class Craft {
private long id;
private String name;
List <Resource> resources;
private int cost;
private int resourceQuantity;
}
