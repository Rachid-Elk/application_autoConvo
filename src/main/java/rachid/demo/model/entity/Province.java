//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rachid.demo.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Generated;

@Entity
@Table(
        name = "province"
)
public class Province {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private @Size(
            min = 3,
            max = 50
    ) String nom;
    @OneToMany(
            mappedBy = "province",
            cascade = {CascadeType.ALL},
            orphanRemoval = true
    )
    private List<Candidat> candidats;

    public Province(Long id, String nom, List<Candidat> candidats) {
        this.id = id;
        this.nom = nom;
        this.candidats = candidats;
    }

    public Province(String provinceA) {
    }

    public Province(long l, String provinceA) {
    }

    @Generated
    public static ProvinceBuilder builder() {
        return new ProvinceBuilder();
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Province)) {
            return false;
        } else {
            Province other = (Province)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$nom = this.getNom();
                Object other$nom = other.getNom();
                if (this$nom == null) {
                    if (other$nom != null) {
                        return false;
                    }
                } else if (!this$nom.equals(other$nom)) {
                    return false;
                }

                Object this$candidats = this.getCandidats();
                Object other$candidats = other.getCandidats();
                if (this$candidats == null) {
                    if (other$candidats != null) {
                        return false;
                    }
                } else if (!this$candidats.equals(other$candidats)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof Province;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $nom = this.getNom();
        result = result * 59 + ($nom == null ? 43 : $nom.hashCode());
        Object $candidats = this.getCandidats();
        result = result * 59 + ($candidats == null ? 43 : $candidats.hashCode());
        return result;
    }

    @Generated
    public Province() {
    }

    @Generated
    public void setId(final Long id) {
        this.id = id;
    }

    @Generated
    public void setNom(final String nom) {
        this.nom = nom;
    }

    @Generated
    public void setCandidats(final List<Candidat> candidats) {
        this.candidats = candidats;
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public String getNom() {
        return this.nom;
    }

    @Generated
    public List<Candidat> getCandidats() {
        return this.candidats;
    }

    @Generated
    public String toString() {
        Long var10000 = this.getId();
        return "Province(id=" + var10000 + ", nom=" + this.getNom() + ")";
    }

    @Generated
    public static class ProvinceBuilder {
        @Generated
        private Long id;
        @Generated
        private String nom;
        @Generated
        private List<Candidat> candidats;

        @Generated
        ProvinceBuilder() {
        }

        @Generated
        public ProvinceBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public ProvinceBuilder nom(final String nom) {
            this.nom = nom;
            return this;
        }

        @Generated
        public ProvinceBuilder candidats(final List<Candidat> candidats) {
            this.candidats = candidats;
            return this;
        }

        @Generated
        public Province build() {
            return new Province(this.id, this.nom, this.candidats);
        }

        @Generated
        public String toString() {
            Long var10000 = this.id;
            return "Province.ProvinceBuilder(id=" + var10000 + ", nom=" + this.nom + ", candidats=" + String.valueOf(this.candidats) + ")";
        }
    }
}
