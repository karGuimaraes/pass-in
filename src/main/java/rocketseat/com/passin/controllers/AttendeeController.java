package rocketseat.com.passin.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import rocketseat.com.passin.dto.attendee.AttendeeBadgeResponseDTO;
import rocketseat.com.passin.services.AttendeeService;

@Tag(name = "Attendees", description = "Attendees related endpoints")
@RestController
@RequestMapping("/attendees")
@RequiredArgsConstructor
public class AttendeeController {
    private final AttendeeService attendeeService;
    
    @GetMapping("/{id}/badge")
    public ResponseEntity<AttendeeBadgeResponseDTO> getAttendeeBadge(@PathVariable String id, UriComponentsBuilder uriComponentsBuilder) {
        AttendeeBadgeResponseDTO response = this.attendeeService.getAttendeeBadge(id, uriComponentsBuilder);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/check-in")
    public ResponseEntity<Void> registerCheckIn(@PathVariable String id, UriComponentsBuilder uriComponentsBuilder) {
        this.attendeeService.checkIn(id);
        var uri = uriComponentsBuilder.path("/attendees/{id}/badge").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }
}
