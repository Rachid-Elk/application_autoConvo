//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rachid.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rachid.demo.model.entity.Candidat;
import rachid.demo.repository.CandidatRepository;

@Service
public class CandidatServiceImpl implements CandidatService {
    @Autowired
    private CandidatRepository candidatRepository;

    public List<Candidat> listerCandidats() {
        return this.candidatRepository.findAll();
    }
}
