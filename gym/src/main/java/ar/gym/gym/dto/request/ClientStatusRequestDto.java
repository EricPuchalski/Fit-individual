package ar.gym.gym.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientStatusRequestDto {
    @Min(value = 0, message = "El peso debe ser mayor que cero")
    private Double weight;
    @Min(value = 0, message = "La altura debe ser mayor que cero")
    private Double height;
    @Min(value = 0, message = "La masa corporal debe ser mayor que cero")
    private Double bodymass;
    @Min(value = 0, message = "El porcentaje de grasa corporal debe ser mayor que cero")
    @Max(value = 100, message = "El porcentaje de grasa corporal no debe ser mayor que 100%")
    private Double bodyfat;

}
