package ar.gym.gym.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GymRequestDto {
    @NotBlank(message = "El nombre del gimnasio no puede estar vacío")
    private String name;

    @NotBlank(message = "El número de teléfono no puede estar vacío")
    @Pattern(regexp = "^[0-9]{10}$", message = "El número de teléfono debe tener exactamente 10 dígitos")
    private String phone;

    @Email(message = "El correo electrónico debe ser válido")
    private String email;

    @NotBlank(message = "La dirección no puede estar vacía")
    private String address;
}
