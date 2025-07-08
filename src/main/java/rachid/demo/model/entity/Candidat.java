
package rachid.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Generated;

@Entity
@Table(
        name = "candidat"
)
public class Candidat {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private @NotEmpty @Size(
            min = 4,
            max = 8
    ) String cin;
    private @NotEmpty @Size(
            min = 3,
            max = 50
    ) String nom;
    private @NotEmpty @Size(
            min = 3,
            max = 50
    ) String prenom;
    @JsonFormat(
            shape = Shape.STRING,
            pattern = "yyyy-MM-dd"
    )
    private LocalDate dateAttribuee;
    @ManyToOne
    @JoinColumn(
            name = "province_id"
    )
    private Province province;

    public Candidat(String cin, String nom, String prenom, Province province) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.province = province;
    }

    public Candidat(String cin, String nom, String prenom, Province province, LocalDate dateAttribuee) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.province = province;
        this.dateAttribuee = dateAttribuee;
    }

    @Generated
    public static CandidatBuilder builder() {
        return new CandidatBuilder();
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public String getCin() {
        return this.cin;
    }

    @Generated
    public String getNom() {
        return this.nom;
    }

    @Generated
    public String getPrenom() {
        return this.prenom;
    }

    @Generated
    public LocalDate getDateAttribuee() {
        return this.dateAttribuee;
    }

    @Generated
    public Province getProvince() {
        return this.province;
    }

    @Generated
    public void setId(final Long id) {
        this.id = id;
    }

    @Generated
    public void setCin(final String cin) {
        this.cin = cin;
    }

    @Generated
    public void setNom(final String nom) {
        this.nom = nom;
    }

    @Generated
    public void setPrenom(final String prenom) {
        this.prenom = prenom;
    }

    @JsonFormat(
            shape = Shape.STRING,
            pattern = "yyyy-MM-dd"
    )
    @Generated
    public void setDateAttribuee(final LocalDate dateAttribuee) {
        this.dateAttribuee = dateAttribuee;
    }

    @Generated
    public void setProvince(final Province province) {
        this.province = province;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Candidat)) {
            return false;
        } else {
            Candidat other = (Candidat)o;
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

                Object this$cin = this.getCin();
                Object other$cin = other.getCin();
                if (this$cin == null) {
                    if (other$cin != null) {
                        return false;
                    }
                } else if (!this$cin.equals(other$cin)) {
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

                Object this$prenom = this.getPrenom();
                Object other$prenom = other.getPrenom();
                if (this$prenom == null) {
                    if (other$prenom != null) {
                        return false;
                    }
                } else if (!this$prenom.equals(other$prenom)) {
                    return false;
                }

                Object this$dateAttribuee = this.getDateAttribuee();
                Object other$dateAttribuee = other.getDateAttribuee();
                if (this$dateAttribuee == null) {
                    if (other$dateAttribuee != null) {
                        return false;
                    }
                } else if (!this$dateAttribuee.equals(other$dateAttribuee)) {
                    return false;
                }

                Object this$province = this.getProvince();
                Object other$province = other.getProvince();
                if (this$province == null) {
                    if (other$province != null) {
                        return false;
                    }
                } else if (!this$province.equals(other$province)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof Candidat;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $cin = this.getCin();
        result = result * 59 + ($cin == null ? 43 : $cin.hashCode());
        Object $nom = this.getNom();
        result = result * 59 + ($nom == null ? 43 : $nom.hashCode());
        Object $prenom = this.getPrenom();
        result = result * 59 + ($prenom == null ? 43 : $prenom.hashCode());
        Object $dateAttribuee = this.getDateAttribuee();
        result = result * 59 + ($dateAttribuee == null ? 43 : $dateAttribuee.hashCode());
        Object $province = this.getProvince();
        result = result * 59 + ($province == null ? 43 : $province.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        Long var10000 = this.getId();
        return "Candidat(id=" + var10000 + ", cin=" + this.getCin() + ", nom=" + this.getNom() + ", prenom=" + this.getPrenom() + ", dateAttribuee=" + String.valueOf(this.getDateAttribuee()) + ")";
    }

    @Generated
    public Candidat() {
    }

    @Generated
    public Candidat(final Long id, final String cin, final String nom, final String prenom, final LocalDate dateAttribuee, final Province province) {
        this.id = id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.dateAttribuee = dateAttribuee;
        this.province = province;
    }

    @Generated
    public static class CandidatBuilder {
        @Generated
        private Long id;
        @Generated
        private String cin;
        @Generated
        private String nom;
        @Generated
        private String prenom;
        @Generated
        private LocalDate dateAttribuee;
        @Generated
        private Province province;

        @Generated
        CandidatBuilder() {
        }

        @Generated
        public CandidatBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public CandidatBuilder cin(final String cin) {
            this.cin = cin;
            return this;
        }

        @Generated
        public CandidatBuilder nom(final String nom) {
            this.nom = nom;
            return this;
        }

        @Generated
        public CandidatBuilder prenom(final String prenom) {
            this.prenom = prenom;
            return this;
        }

        @JsonFormat(
                shape = Shape.STRING,
                pattern = "yyyy-MM-dd"
        )
        @Generated
        public CandidatBuilder dateAttribuee(final LocalDate dateAttribuee) {
            this.dateAttribuee = dateAttribuee;
            return this;
        }

        @Generated
        public CandidatBuilder province(final Province province) {
            this.province = province;
            return this;
        }

        @Generated
        public Candidat build() {
            return new Candidat(this.id, this.cin, this.nom, this.prenom, this.dateAttribuee, this.province);
        }

        @Generated
        public String toString() {
            Long var10000 = this.id;
            return "Candidat.CandidatBuilder(id=" + var10000 + ", cin=" + this.cin + ", nom=" + this.nom + ", prenom=" + this.prenom + ", dateAttribuee=" + String.valueOf(this.dateAttribuee) + ", province=" + String.valueOf(this.province) + ")";
        }
    }
}
