package entity;

import jakarta.persistence.*;
import lombok.*;
import model.CraftElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Table(name="entity_receipt")
public class CraftReceiptEntity {
    @Id
    private Long id;
    @Column
    private String receiptName;
    @OneToMany
    private List <CraftElementEntity> craftElementEntityList;

// @ElementCollection
// @Column (name = "item")
//private Set<Long> items = new HashSet<>();
    public Long getId() {
        return id;
    }
}

