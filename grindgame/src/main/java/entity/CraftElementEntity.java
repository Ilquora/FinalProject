package entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.CraftElement;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "craft_element")
public class CraftElementEntity {
    @Id
    private Long craftElementId;
    @Column
    private String craftElementName;
    @Column
    private Integer quantity;


}
