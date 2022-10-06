package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
@Getter
@Setter
public class Building {

   private long id;
    private String name;
   private List<Resource> needs ;
    private List <Resource> gives;
}
