package rocketseat.com.passin.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.RequiredArgsConstructor;
import rocketseat.com.passin.dto.attendee.AttendeeIdDTO;
import rocketseat.com.passin.dto.attendee.AttendeeRequestDTO;
import rocketseat.com.passin.dto.attendee.AttendeesListResponseDTO;
import rocketseat.com.passin.dto.event.EventIdDTO;
import rocketseat.com.passin.dto.event.EventRequestDTO;
import rocketseat.com.passin.dto.event.EventResponseDto;
import rocketseat.com.passin.services.AttendeeService;
import rocketseat.com.passin.services.EventService;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;
    private final AttendeeService attendeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDto> getEventDetails(@PathVariable String id) {
        EventResponseDto eventDetails = this.eventService.getEventDetails(id);
        return ResponseEntity.ok(eventDetails);
    }

    @GetMapping("/{id}/attendees")
    public ResponseEntity<AttendeesListResponseDTO> getEventsAttendee(@PathVariable String id) {
        AttendeesListResponseDTO event = this.attendeeService.getEventsAttendee(id);
        return ResponseEntity.ok(event);
    }

    @PostMapping
    public ResponseEntity<EventIdDTO> createEvent(@RequestBody EventRequestDTO body, UriComponentsBuilder uriComponentsBuilder) {
        EventIdDTO eventId = this.eventService.createEvent(body);
        
        var uri = uriComponentsBuilder.path("/events/{id}").buildAndExpand(eventId.eventId()).toUri();
        return ResponseEntity.created(uri).body(eventId);
    }


    @PostMapping("/{id}/attendees")
    public ResponseEntity<AttendeeIdDTO> registerAttendeeOnEvent(@PathVariable String id, @RequestBody AttendeeRequestDTO body, UriComponentsBuilder uriComponentsBuilder) {
        AttendeeIdDTO attendeeIdDTO =  this.eventService.registerAttendeeOnEvent(id, body);

        var uri = uriComponentsBuilder.path("/attendees/{id}/badge").buildAndExpand(attendeeIdDTO.AttendeeId()).toUri();

        return ResponseEntity.created(uri).body(attendeeIdDTO);
    }
}
