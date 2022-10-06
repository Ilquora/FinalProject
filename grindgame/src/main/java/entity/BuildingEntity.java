package entity;

import jakarta.persistence.*;
import lombok.*;
import model.Resource;

import java.util.HashSet;
import java.util.List;
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
@Column(name ="gives")
private Set <Long> gives = new HashSet<>();
@ElementCollection
@Column (name = "needs")
private Set <Long> needs = new HashSet<>();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
