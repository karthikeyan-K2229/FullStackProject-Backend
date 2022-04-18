package com.project.babynaming.Services;

import com.project.babynaming.Entity.EventModel;
import com.project.babynaming.repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public EventModel saveUser(EventModel event)
    {
        return eventRepository.save(event);
    }


    public List<EventModel> fetchByApplicantId(Long id) {

        return (List<EventModel>)eventRepository.findByuserId(id);
    }
    public EventModel fetchByEventId(Long id) {

        return (EventModel)eventRepository.findByeventid(id);
    }


    public void deleteById(Long id) {
        EventModel event= eventRepository.findByeventid(id);
        eventRepository.delete(event);
    }
    public EventModel editEventById(Long id, EventModel event) {
        EventModel newEvent = event;


        return eventRepository.save(newEvent);
    }

}

