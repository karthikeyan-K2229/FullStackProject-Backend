package com.project.babynaming.Controller;

import com.project.babynaming.Services.EventService;
import com.project.babynaming.Entity.EventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class EventController {


    @Autowired
    private EventService eventService;

    @PostMapping("/user/bookTheme")
    public ResponseEntity<EventModel> userbookevent(@RequestBody EventModel user)throws Exception
    {
        try {
            //user.setUserId(logincontroller.car.getId());
            System.out.println();
            EventModel userObj = null;
            userObj = eventService.saveUser(user);
            System.out.println("book event ey na?");
            return new ResponseEntity<EventModel>(userObj,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user/viewBookedTheme/{id}")
    //@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<EventModel>> getByEmail(@PathVariable Long id) throws Exception
    {
        System.out.println(id+" "+id);
        List<EventModel> EventList = eventService.fetchByApplicantId(id);
        System.out.println(EventList.toString()+" "+ "testing");
        return new ResponseEntity<List<EventModel>>(EventList, HttpStatus.OK);
    }

    @DeleteMapping("/user/deleteEvent/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void DeleteByEventId(@PathVariable Long id) throws Exception
    {
        eventService.deleteById(id);
    }


    @GetMapping("/user/getBookedTheme/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<EventModel> getByEventId(@PathVariable Long id) throws Exception
    {
        System.out.println(id+" "+id);
        EventModel Event = eventService.fetchByEventId(id);
        return new ResponseEntity<EventModel>(Event, HttpStatus.OK);
    }


    @PutMapping("/user/UpdateBookedTheme/{id}")
    public ResponseEntity<EventModel> UpdateEvent(@RequestBody EventModel user) throws Exception{
        EventModel event = eventService.editEventById(user.getEventid(),user);
        System.out.println("event"+event.toString());
        return new ResponseEntity<EventModel>(event,HttpStatus.OK);
    }
}



