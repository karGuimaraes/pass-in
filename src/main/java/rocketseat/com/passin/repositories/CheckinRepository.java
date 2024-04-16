package rocketseat.com.passin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import rocketseat.com.passin.domain.checkin.Checkin;

public interface CheckInRepository extends JpaRepository<Checkin, Integer>{
    Optional<Checkin> findByAttendeeId(String attendeeId);
}
