package rachid.demo.dynamique;

import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import rachid.demo.model.dto.CandidatSearchCriteria;
import rachid.demo.model.entity.Candidat;

import java.util.ArrayList;
import java.util.List;

import rachid.demo.model.entity.Centre;
import rachid.demo.model.entity.Province;

public class CandidatSpecification implements Specification<Candidat> {
    private final CandidatSearchCriteria criteria;

    public CandidatSpecification(CandidatSearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Candidat> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (criteria.getCin() != null && !criteria.getCin().isEmpty()) {
            predicates.add(cb.like(cb.lower(root.get("cin")), "%" + criteria.getCin().toLowerCase() + "%"));
        }

        if (criteria.getNom() != null && !criteria.getNom().isEmpty()) {
            predicates.add(cb.like(cb.lower(root.get("nom")), "%" + criteria.getNom().toLowerCase() + "%"));
        }

        if (criteria.getPrenom() != null && !criteria.getPrenom().isEmpty()) {
            predicates.add(cb.like(cb.lower(root.get("prenom")), "%" + criteria.getPrenom().toLowerCase() + "%"));
        }

        if (criteria.getSexe() != null && !criteria.getSexe().isEmpty()) {
            predicates.add(cb.equal(root.get("sexe"), criteria.getSexe()));
        }

        if (criteria.getCategorieList() != null && !criteria.getCategorieList().isEmpty()) {
            predicates.add(root.get("categorie").in(criteria.getCategorieList()));
        }

        if (criteria.getProvinceNomList() != null && !criteria.getProvinceNomList().isEmpty()) {
            predicates.add(root.get("province").get("nom").in(criteria.getProvinceNomList()));
        }

        if (criteria.getCentreNomList() != null && !criteria.getCentreNomList().isEmpty()) {
            predicates.add(root.get("province").get("centre").get("nom").in(criteria.getCentreNomList()));
        }

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}

