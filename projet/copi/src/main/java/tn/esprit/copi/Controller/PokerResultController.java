package tn.esprit.copi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.copi.Entity.Poker_Result;
import tn.esprit.copi.Repository.PokerResultRepository;

import java.util.List;

@RestController
@RequestMapping("/poker-results")
@CrossOrigin(origins = "http://localhost:4200")
public class PokerResultController {
    @Autowired
    private PokerResultRepository pokerResultRepository;

    @GetMapping("/getAll")
    public List<Poker_Result> getAllPokerResults() {
        return pokerResultRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Poker_Result getPokerResultById(@PathVariable Long id) {
        return pokerResultRepository.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public Poker_Result addPokerResult(@RequestBody Poker_Result pokerResult) {
        return pokerResultRepository.save(pokerResult);
    }

    @PutMapping("/put/{id}")
    public Poker_Result updatePokerResult(@PathVariable Long id, @RequestBody Poker_Result updatedPokerResult) {
        if (pokerResultRepository.existsById(id)) {
            updatedPokerResult.setId(id);
            return pokerResultRepository.save(updatedPokerResult);
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deletePokerResult(@PathVariable Long id) {
        pokerResultRepository.deleteById(id);
    }
}
