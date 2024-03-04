package tn.esprit.copi.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.copi.Entity.PokerPlanning;
import tn.esprit.copi.Repository.PokerPlanningRepository;

import java.util.List;

@RestController
@RequestMapping("/poker-planning")
@CrossOrigin(origins = "http://localhost:4200")
public class PokerPlanningController {
    @Autowired
    private PokerPlanningRepository pokerPlanningRepository;

    @GetMapping("/getAll")
    public List<PokerPlanning> getAllPokerPlanning() {
        return pokerPlanningRepository.findAll();
    }

    @PostMapping("/add")
    public PokerPlanning addPokerPlanning(@RequestBody PokerPlanning pokerPlanning) {
        return pokerPlanningRepository.save(pokerPlanning);
    }
}
