package tn.esprit.copi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.copi.Entity.SessionParticipant;
import tn.esprit.copi.Repository.SessionParticipantRepository;

import java.util.List;

@RestController
@RequestMapping("/session-participants")
public class SessionParticipantController {
    @Autowired
    private SessionParticipantRepository sessionParticipantRepository;

    @GetMapping("/getAll")
    public List<SessionParticipant> getAllSessionParticipants() {
        return sessionParticipantRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public SessionParticipant getSessionParticipantById(@PathVariable Long id) {
        return sessionParticipantRepository.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public SessionParticipant addSessionParticipant(@RequestBody SessionParticipant sessionParticipant) {
        return sessionParticipantRepository.save(sessionParticipant);
    }

    @PutMapping("/put/{id}")
    public SessionParticipant updateSessionParticipant(@PathVariable Long id, @RequestBody SessionParticipant updatedSessionParticipant) {
        if (sessionParticipantRepository.existsById(id)) {
            updatedSessionParticipant.setId(id);
            return sessionParticipantRepository.save(updatedSessionParticipant);
        } else {
            // Gérer le cas où le participant de session n'existe pas
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSessionParticipant(@PathVariable Long id) {
        sessionParticipantRepository.deleteById(id);
    }
}
