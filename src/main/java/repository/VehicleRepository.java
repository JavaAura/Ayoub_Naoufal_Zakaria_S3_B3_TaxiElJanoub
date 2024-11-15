package repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import model.Vehicle;
import model.enums.Status;
import model.enums.Type;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("SELECT CASE WHEN COUNT(r) = 0 THEN true ELSE false END " +
           "FROM Vehicle v LEFT JOIN v.reservations r " +
           "WHERE v.id = :vehicleId " +
           "AND r.startTime <= :dateTime " +
           "AND r.endTime >= :dateTime")
    boolean checkAvailability(@Param("vehicleId") Long id, @Param("dateTime") LocalDateTime dateTime);

    @Query("SELECT COUNT(v) FROM Vehicle v WHERE v.status = :status")
    Long countByStatus(@Param("status") Status status);

    @Query("SELECT AVG(v.mileage) FROM Vehicle v")
    Double getAverageMileage();

    @Query("SELECT v.type, COUNT(v) as count FROM Vehicle v GROUP BY v.type ORDER BY count DESC")
    List<Object[]> getMostPopularType();
}