package ar.gym.gym.dto.request;


import ar.gym.gym.model.Exercise;
import ar.gym.gym.model.Routine;
import ar.gym.gym.model.TrainingDiary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionRequestDto {
    private int sets;
    private int reps;
    private LocalTime restTime;
    private boolean completed;
    private String exerciseName;
}
