package ar.gym.gym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "nutritional_diary")
public class NutritionalDiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "Client_id")
    private Client client;

    private LocalDateTime date;
    private float totalCaloriesConsumed;
    private String observations;
    private boolean completed;
}
