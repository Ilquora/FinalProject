package entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "e_resource")

public class ResourceEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int quantity;
    @Column
    private String name;
}
