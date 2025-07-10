package rachid.demo.dynamique;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import rachid.demo.model.dto.CandidatFilter;
import rachid.demo.model.entity.Candidat;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.criteria.Predicate ;

public  class CandidatSpecification implements Specification<Candidat> {
    private final CandidatFilter filter;

    public CandidatSpecification(CandidatFilter filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<Candidat> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (filter.getProvince() != null && !filter.getProvince().isEmpty()) {
            predicates.add(cb.equal(root.get("province").get("nom"), filter.getProvince()));
        }

        if (filter.getCentre() != null && !filter.getCentre().isEmpty()) {
            predicates.add(cb.equal(root.get("centre").get("nom"), filter.getCentre()));
        }

        if (filter.getSexe() != null && !filter.getSexe().isEmpty()) {
            predicates.add(cb.equal(root.get("sexe"), filter.getSexe()));
        }

        if (filter.getCategorie() != null) {
            predicates.add(cb.equal(root.get("categorie"), filter.getCategorie()));
        }

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
