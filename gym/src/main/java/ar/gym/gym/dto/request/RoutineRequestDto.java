package ar.gym.gym.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoutineRequestDto {
    @NotBlank(message = "El DNI del cliente no puede estar vacío")
    @Pattern(regexp = "^[0-9]{7,8}$", message = "El DNI debe tener entre 7 y 8 dígitos")
    private String clientDni; // Cambiar Client completo por solo el DNI
    @NotBlank(message = "El nombre de la rutina no puede estar vacío")
    private String name;

}
