package service.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

import model.Vehicle;
import model.enums.Status;
import model.enums.Type;
import repository.VehicleRepository;
import exception.NotExistException;
import mapper.VehicleMapper;
import dto.request.VehicleRequest;
import dto.response.VehicleAnalyticsResponse;
import dto.response.VehicleResponse;
import service.interfaces.VehicleService;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    
    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    @Override
    public List<VehicleResponse> findAll() {
        return vehicleRepository.findAll().stream()
                .map(vehicleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<VehicleResponse> findById(Long id) {
        return vehicleRepository.findById(id)
                .map(vehicleMapper::toResponse);
    }

    @Override
    @Transactional
    public VehicleResponse save(VehicleRequest vehicleRequest) {
        Vehicle vehicle = vehicleMapper.toEntity(vehicleRequest);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return vehicleMapper.toResponse(savedVehicle);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new NotExistException("Vehicle not found with id: " + id);
        }
        vehicleRepository.deleteById(id);
    }

    @Override
    @Transactional
    public VehicleResponse update(Long id, VehicleRequest vehicleRequest) {
        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new NotExistException("Vehicle not found with id: " + id));
        
        Vehicle updatedVehicle = vehicleMapper.toEntity(vehicleRequest);
        updatedVehicle.setId(existingVehicle.getId());
        
        return vehicleMapper.toResponse(vehicleRepository.save(updatedVehicle));
    }

    @Override
    public boolean isAvailable(Long vehicleId, LocalDateTime dateTime) {
        return vehicleRepository.findById(vehicleId)
                .map(vehicle -> checkAvailability(vehicle, dateTime))
                .orElseThrow(() -> new NotExistException("Vehicle not found with id: " + vehicleId));
    }
    
    private boolean checkAvailability(Vehicle vehicle, LocalDateTime dateTime) {
        // Implement your availability logic here
        // For example, check if there are any overlapping bookings
        return vehicleRepository.checkAvailability(vehicle.getId(), dateTime);
    }

    @Override
    public VehicleAnalyticsResponse getAnalytics() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAnalytics'");
    }

    @Override
    public Long countByStatus(Status status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'countByStatus'");
    }

    @Override
    public Double getAverageMileage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAverageMileage'");
    }

    @Override
    public Type getMostPopularType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMostPopularType'");
    }
}
