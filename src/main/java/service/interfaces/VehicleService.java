package service.interfaces;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import dto.request.VehicleRequest;
import dto.response.VehicleResponse;
import model.enums.Status;
import model.enums.Type;
import dto.response.VehicleAnalyticsResponse;

public interface VehicleService {
    List<VehicleResponse> findAll();
    Optional<VehicleResponse> findById(Long id);
    VehicleResponse save(VehicleRequest vehicleRequest);
    void deleteById(Long id);
    VehicleResponse update(Long id, VehicleRequest vehicleRequest);
    boolean isAvailable(Long vehicleId, LocalDateTime dateTime);
    VehicleAnalyticsResponse getAnalytics();
    Long countByStatus(Status status);
    Double getAverageMileage();
    Type getMostPopularType();
}
