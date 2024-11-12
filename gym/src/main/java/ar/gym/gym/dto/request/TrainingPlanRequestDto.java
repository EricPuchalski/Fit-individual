package ar.gym.gym.dto.request;

import ar.gym.gym.dto.response.ClientResponseDto;
import ar.gym.gym.dto.response.RoutineResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingPlanRequestDto {
    private String clientDni;  // Este plan está asociado a un cliente
    private String name;  // Nombre del plan de entrenamiento
    private String description;  // Descripción general del plan
}
