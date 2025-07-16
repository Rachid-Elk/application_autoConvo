//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rachid.demo.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rachid.demo.dynamique.CandidatSpecification;
import rachid.demo.model.dto.CandidatDTO;
import rachid.demo.model.dto.CandidatSearchCriteria;
import rachid.demo.model.entity.Candidat;
import rachid.demo.repository.CandidatRepository;

@Service
public class CandidatServiceImpl implements CandidatService {
    @Autowired
    private CandidatRepository candidatRepository;

    public List<Candidat> listerCandidats() {
        return (List<Candidat>) this.candidatRepository.findAll();
    }

    public Page<Candidat> getFilteredCandidats(CandidatSearchCriteria criteria, Pageable pageable) {
        return candidatRepository.findAll(new CandidatSpecification(criteria), pageable);
    }




    /**
     * Convert a Candidat entity to a CandidatDTO.
     *
     * @param candidat The Candidat entity to convert
     * @return The converted CandidatDTO
     */
    private CandidatDTO convertToDTO(Candidat candidat) {
        CandidatDTO candidatDTO = new CandidatDTO();
        BeanUtils.copyProperties(candidat, candidatDTO);
        return candidatDTO;
    }

    /**
     * Convert a CandidatDTO to a Candidat entity.
     *
     * @param candidatDTO The CandidatDTO to convert
     * @return The converted Candidat entity
     */
    private Candidat convertToEntity(CandidatDTO candidatDTO) {
        Candidat candidat = new Candidat();
        BeanUtils.copyProperties(candidatDTO, candidat);
        return candidat;
    }

    /**
     * Get all people with pagination.
     *
     * @param pageable Pagination information
     * @return A page of PersonneDTO objects
     */
//    @Transactional(readOnly = true)
//    public Page<CandidatDTO> getAllCandidats(Pageable pageable) {
//        return candidatRepositoryJPA.findAll(pageable)
//                .map(this::convertToDTO);
//    }
}
