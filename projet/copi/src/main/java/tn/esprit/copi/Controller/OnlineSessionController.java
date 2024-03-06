package tn.esprit.copi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.copi.Entity.OnlineSession;
import tn.esprit.copi.Repository.OnlineSessionRepository;

import java.util.List;

@RestController
@RequestMapping("/online-sessions")
@CrossOrigin(origins = "http://localhost:4200")
public class OnlineSessionController {
    @Autowired
    private OnlineSessionRepository onlineSessionRepository;

    @GetMapping("/getAll")
    public List<OnlineSession> getAllOnlineSessions() {
        return onlineSessionRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public OnlineSession getOnlineSessionById(@PathVariable Long id) {
        return onlineSessionRepository.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public OnlineSession addOnlineSession(@RequestBody OnlineSession onlineSession) {
        return onlineSessionRepository.save(onlineSession);
    }

    @PutMapping("/put/{id}")
    public OnlineSession updateOnlineSession(@PathVariable Long id, @RequestBody OnlineSession updatedOnlineSession) {
        if (onlineSessionRepository.existsById(id)) {
            updatedOnlineSession.setId(id);
            return onlineSessionRepository.save(updatedOnlineSession);
        } else {
            // Gérer le cas où la session n'existe pas
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOnlineSession(@PathVariable Long id) {
        onlineSessionRepository.deleteById(id);
    }
}
