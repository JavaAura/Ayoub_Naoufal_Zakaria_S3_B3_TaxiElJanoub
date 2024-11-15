package dto.request;

import lombok.Data;
import model.enums.Status;
import model.enums.Type;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class VehicleRequest {
    @NotBlank
    private String model;
    
    @NotBlank
    private String registrationNumber;
    
    @NotNull
    private Double mileage;
    
    @NotNull
    private Status status;
    
    @NotNull
    private Type type;
}