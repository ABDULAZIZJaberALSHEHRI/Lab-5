package com.example.q3lab5.Controller;

import com.example.q3lab5.Apiresponse.ApiResponse;
import com.example.q3lab5.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/api/v1/event")
@RestController
public class EventController {
    ArrayList<Event> events = new ArrayList<Event>();

    @PostMapping("/add-event")
    public ApiResponse addEvent(@RequestBody Event event) {
        events.add(event);
        return new ApiResponse("Successfully added event");
    }

    @GetMapping("/display-events")
    public ArrayList<Event> getEvents() {
        return events;
    }

    @PutMapping("/update-event/{index}")
    public ApiResponse updateEvent(@PathVariable int index, @RequestBody Event event) {
        events.set(index, event);
        return new ApiResponse("Successfully updated event");
    }

    @DeleteMapping("/delete-event/{index}")
    public ApiResponse deleteEvent(@PathVariable int index) {
        events.remove(index);
        return new ApiResponse("Successfully deleted event");
    }

    @PutMapping("/change-capacity/{index}")
    public ApiResponse changeCapacity(@PathVariable int index, @RequestBody Event event) {
        events.get(index).setCapacity(event.getCapacity());
        return new ApiResponse("Successfully changed event");
    }

    @GetMapping("/find")
    public ArrayList<Event> searchTasks(@RequestBody Event id) {
        ArrayList<Event> result = new ArrayList<>();
        for (Event e : events) {
            if(e.getId() == (id.getId())) {
                result .add(e);
            }
        }
        return result;
    }
}
