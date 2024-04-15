package rocketseat.com.passin.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.RequiredArgsConstructor;
import rocketseat.com.passin.dto.event.EventIdDTO;
import rocketseat.com.passin.dto.event.EventRequestDTO;
import rocketseat.com.passin.dto.event.EventResponseDto;
import rocketseat.com.passin.services.EventService;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDto> getEventDetails(@PathVariable String eventId) {
        EventResponseDto eventDetails = this.eventService.getEventDetails(eventId);
        return ResponseEntity.ok(eventDetails);
    }

    @PostMapping
    public ResponseEntity<EventIdDTO> createEvent(@RequestBody EventRequestDTO body, UriComponentsBuilder uriComponentsBuilder) {
        EventIdDTO eventId = this.eventService.createEvent(body);
        
        var uri = uriComponentsBuilder.path("/events/{id}").buildAndExpand(eventId.eventId()).toUri();
        return ResponseEntity.created(uri).body(eventId);
    }
}
