package entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Table(name = "player_entity")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    @Column (name = "building")
    private List<Long> buildingsId ;
    @Column(name="gold",columnDefinition = "Decimal(10,2) default '0.00' ")
    private BigDecimal gold = BigDecimal.ZERO;
}







