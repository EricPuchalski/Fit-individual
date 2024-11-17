package ar.gym.gym.dto.request;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionRequestDto {
    @Min(value = 1, message = "El número de series debe ser al menos 1")
    private int sets;
    @Min(value = 0, message = "El número de repeticiones no puede ser negativo")
    private int reps;
    @NotNull(message = "El tiempo de descanso no puede ser nulo")
    private LocalTime restTime;
    private boolean completed;
    @NotBlank( message = "El nombre del ejercicio no puede estar vacío")
    private String exerciseName;


}
