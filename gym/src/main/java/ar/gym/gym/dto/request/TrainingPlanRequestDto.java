package ar.gym.gym.dto.request;

import ar.gym.gym.dto.response.ClientResponseDto;
import ar.gym.gym.dto.response.RoutineResponseDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingPlanRequestDto {
    @Pattern(regexp = "^[0-9]{7,8}$", message = "El DNI debe tener entre 7 y 8 dígitos")
    private String clientDni;  // Este plan está asociado a un cliente
    @NotBlank(message = "El nombre del plan de entrenamiento no puede estar vacío")
    private String name;  // Nombre del plan de entrenamiento
    @NotBlank(message = "La descripción del plan de entrenamiento no puede estar vacía")
    private String description;  // Descripción general del plan
}
