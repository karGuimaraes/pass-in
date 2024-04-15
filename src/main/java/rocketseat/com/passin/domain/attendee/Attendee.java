package rocketseat.com.passin.domain.attendee;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rocketseat.com.passin.domain.event.Event;

@Entity
@Table(name = "attendees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Attendee {

    @Id @Column(nullable = false) @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(nullable = false, name = "created_at")
    private LocalDate createdAt;
}
