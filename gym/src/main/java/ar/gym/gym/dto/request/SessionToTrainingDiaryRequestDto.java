package ar.gym.gym.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionToTrainingDiaryRequestDto {
    @Min(value = 0, message = "El número de repeticiones no puede ser negativo")
    private int reps;

    @NotBlank(message = "El nombre del ejercicio no puede estar vacío")
    private String exerciseName;

    @NotNull(message = "El peso no puede ser nulo")
    @Min(value = 0, message = "El peso no puede ser negativo")
    private Double weight;
}
