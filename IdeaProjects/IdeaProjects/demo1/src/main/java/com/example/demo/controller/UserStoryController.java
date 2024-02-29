package com.example.demo.controller;

import com.example.demo.entity.UserStory;
import com.example.demo.exceptions.UserStoryNotFoundException;
import com.example.demo.repository.UserStoryRepository;
import org.springframework.web.bind.annotation.*;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.List;

@RestController
public class UserStoryController {
    private final UserStoryRepository repository;

    public UserStoryController(UserStoryRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/userstory")
    List<UserStory> getAll() {
        return repository.findAll();
    }
    @PostMapping("/userstory")
    UserStory newUserStory(@RequestBody UserStory story) {
        NotifyAssignedTo(story);
        return repository.save(story);
    }
    @GetMapping("/userstory/{id}")
    UserStory getOne(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new UserStoryNotFoundException(id));
    }
    @PutMapping("/userstory/{id}")
    UserStory replaceUserStory(@RequestBody UserStory newUserStory, @PathVariable Long id) {

        return repository.findById(id)
                .map(story -> {
                    NotifyAssignedTo(story);
                    story.setTitle(newUserStory.getTitle());
                    story.setDescription(newUserStory.getDescription());
                    story.setPriority(newUserStory.getPriority());
                    story.setStatus(newUserStory.getStatus());
                    story.setAssigned_to(newUserStory.getAssigned_to());
                    story.setAcceptance_criteria(newUserStory.getAcceptance_criteria());
                    return repository.save(story);
                })
                .orElseThrow(() -> new UserStoryNotFoundException(id));
    }
    private void NotifyAssignedTo(@RequestBody UserStory newUserStory) {
        Twilio.init(com.example.demo.env.Twilio.ACCOUNT_SID, com.example.demo.env.Twilio.AUTH_TOKEN);
        String number = newUserStory.getAssigned_to().getNumber();
        Message message = Message.creator(
                        new PhoneNumber(com.example.demo.env.Twilio.PHONE_NUMBER),
                        new PhoneNumber(number),
                        "New User Story assigned to you! "+newUserStory.getTitle()+", Best of luck.")
                .create();
    }
    @DeleteMapping("/userstory/{id}")
    void deleteUserStory(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
