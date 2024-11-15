package dto.response;

import lombok.Data;
import model.enums.Type;

@Data
public class VehicleAnalyticsResponse {
    private Long totalVehicles;
    private Long availableVehicles;
    private Long onTripVehicles;
    private Long unavailableVehicles;
    private Double averageMileage;
    private Type mostPopularType;
} 