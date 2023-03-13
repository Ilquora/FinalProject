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
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String receiptName;
  @Column
    private int price;
@Column
private int quantity ;
    @OneToMany
    private List<CraftElementEntity> craftElementList;

    }




