package ar.gym.gym.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseRequestDto {
    @NotBlank(message = "El nombre del ejercicio no puede estar vacío")
    private String name;
    private String equipment;
    private String muscleGroup;
}
