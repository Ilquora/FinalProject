package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Table(name = "e_building")
public class BuildingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @ElementCollection
    @Column(name = "resource_gives")
    private Set<Long> givesList = new HashSet<>();
    @ElementCollection
    @Column(name = "resource_needs")
    private Set<Long> needsList = new HashSet<>();
    @Column
    private int price;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Long> getGivesList() {
        return givesList;
    }

    public Set<Long> getNeedsList(Resource resource) {
      resource.getQuantity(int);
    }

    public int getPrice() {
        return price;
    }
}


