package tn.esprit.pi2024.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pi2024.Entity.Reclamation;
import tn.esprit.pi2024.Repository.ReclamationRepo;

import java.util.List;

@Service
public class ReclamationServiceImp implements IReclamationService {
    @Autowired
    ReclamationRepo reclamationRepo;

    public List<Reclamation> retrieveAllReclamations() {
        return reclamationRepo.findAll();
    }

    public Reclamation retrieveReclamation(Long reclamationId) {
        return reclamationRepo.findById(reclamationId).get();
    }
    public Reclamation addReclamation(Reclamation r) {
        return reclamationRepo.save(r);
    }
    public void removeReclamation(Long reclamationId) {
        reclamationRepo.deleteById(reclamationId);
    }
    public Reclamation modifyReclamation(Reclamation reclamation) {
        return reclamationRepo.save(reclamation);
    }


}
