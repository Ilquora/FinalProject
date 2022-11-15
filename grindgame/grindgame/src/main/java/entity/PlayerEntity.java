package entity;

import jakarta.persistence.*;
import lombok.*;
import model.Building;
import model.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
    private Set<Long> buildings = new HashSet<>();
    }







