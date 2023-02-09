package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
