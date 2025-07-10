package rachid.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rachid.demo.repository.CentreRepository;

import java.util.List;

@Service
public class CentreServiceImpl implements CentreService {

    private final CentreRepository centreRepository;


    @Autowired
    public CentreServiceImpl(CentreRepository centreRepository) {
        this.centreRepository = centreRepository;
    }

    @Override
    public List<String> getAllNom() {
        return centreRepository.findAllNoms();
    }
}