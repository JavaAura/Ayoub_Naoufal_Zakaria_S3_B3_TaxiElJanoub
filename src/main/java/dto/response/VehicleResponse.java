package dto.response;

import lombok.Data;
import model.enums.Status;
import model.enums.Type;

@Data
public class VehicleResponse {
    private Long id;
    private String model;
    private String registrationNumber;
    private Double mileage;
    private Status status;
    private Type type;
}