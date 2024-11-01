package ar.gym.gym.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoutineResponseDto {
    private Long id;
    private String clientDNI;
    private String name;
    private LocalDate creationDate;
    private boolean active;
}
