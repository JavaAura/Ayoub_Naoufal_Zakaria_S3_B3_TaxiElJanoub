package dto.response;

import lombok.Data;
import model.enums.Type;

@Data
public class VehicleAnalyticsResponse {
    private Long totalVehicles;
    private Long availableVehicles;
    private Long reservedVehicles;
    private Long maintenanceVehicles;
    private Double averageMileage;
    private Type mostPopularType;
} 