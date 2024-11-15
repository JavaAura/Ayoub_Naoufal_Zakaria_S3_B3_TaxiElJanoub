package mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

import model.Vehicle;
import dto.request.VehicleRequest;
import dto.response.VehicleResponse;

@Component
@RequiredArgsConstructor
public class VehicleMapper {

    private final ModelMapper modelMapper;

    public Vehicle toEntity(VehicleRequest request) {
        return modelMapper.map(request, Vehicle.class);
    }

    public VehicleResponse toResponse(Vehicle vehicle) {
        return modelMapper.map(vehicle, VehicleResponse.class);
    }
}
