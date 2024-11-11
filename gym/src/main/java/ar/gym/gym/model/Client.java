package ar.gym.gym.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<ClientStatus> statuses;
    private String goal;
    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;
    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
    @ManyToOne
    @JoinColumn(name = "nutritionist_id")
    private Nutritionist nutritionist;
    @OneToMany(mappedBy = "client")
    private List<Routine>routines;
    @OneToMany(mappedBy = "client")
    private List<NutritionalPlan>nutritionalPlans;
    @OneToMany(mappedBy = "client")
    private List<TrainingDiary>trainingDiaryList;
    @OneToMany(mappedBy = "client")
    private List<NutritionalDiary>nutritionalDiaryList;
    @OneToMany(mappedBy = "client")
    private List<Notification> notifications;
    private Boolean active = true;
}
