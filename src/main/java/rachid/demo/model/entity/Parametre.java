//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rachid.demo.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Generated;

@Entity
@Table(
        name = "parametre"
)
public class Parametre {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private int totalParJour;
    private int maxParProvinceParJour;
    private LocalDate dateDebut;

    @Generated
    public static ParametreBuilder builder() {
        return new ParametreBuilder();
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Parametre)) {
            return false;
        } else {
            Parametre other = (Parametre)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getTotalParJour() != other.getTotalParJour()) {
                return false;
            } else if (this.getMaxParProvinceParJour() != other.getMaxParProvinceParJour()) {
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

                Object this$dateDebut = this.getDateDebut();
                Object other$dateDebut = other.getDateDebut();
                if (this$dateDebut == null) {
                    if (other$dateDebut != null) {
                        return false;
                    }
                } else if (!this$dateDebut.equals(other$dateDebut)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof Parametre;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getTotalParJour();
        result = result * 59 + this.getMaxParProvinceParJour();
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $dateDebut = this.getDateDebut();
        result = result * 59 + ($dateDebut == null ? 43 : $dateDebut.hashCode());
        return result;
    }

    @Generated
    public Parametre() {
    }

    @Generated
    public Parametre(final Long id, final int totalParJour, final int maxParProvinceParJour, final LocalDate dateDebut) {
        this.id = id;
        this.totalParJour = totalParJour;
        this.maxParProvinceParJour = maxParProvinceParJour;
        this.dateDebut = dateDebut;
    }

    @Generated
    public void setId(final Long id) {
        this.id = id;
    }

    @Generated
    public void setTotalParJour(final int totalParJour) {
        this.totalParJour = totalParJour;
    }

    @Generated
    public void setMaxParProvinceParJour(final int maxParProvinceParJour) {
        this.maxParProvinceParJour = maxParProvinceParJour;
    }

    @Generated
    public void setDateDebut(final LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public int getTotalParJour() {
        return this.totalParJour;
    }

    @Generated
    public int getMaxParProvinceParJour() {
        return this.maxParProvinceParJour;
    }

    @Generated
    public LocalDate getDateDebut() {
        return this.dateDebut;
    }

    @Generated
    public String toString() {
        Long var10000 = this.getId();
        return "Parametre(id=" + var10000 + ", totalParJour=" + this.getTotalParJour() + ", maxParProvinceParJour=" + this.getMaxParProvinceParJour() + ", dateDebut=" + String.valueOf(this.getDateDebut()) + ")";
    }

    @Generated
    public static class ParametreBuilder {
        @Generated
        private Long id;
        @Generated
        private int totalParJour;
        @Generated
        private int maxParProvinceParJour;
        @Generated
        private LocalDate dateDebut;

        @Generated
        ParametreBuilder() {
        }

        @Generated
        public ParametreBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public ParametreBuilder totalParJour(final int totalParJour) {
            this.totalParJour = totalParJour;
            return this;
        }

        @Generated
        public ParametreBuilder maxParProvinceParJour(final int maxParProvinceParJour) {
            this.maxParProvinceParJour = maxParProvinceParJour;
            return this;
        }

        @Generated
        public ParametreBuilder dateDebut(final LocalDate dateDebut) {
            this.dateDebut = dateDebut;
            return this;
        }

        @Generated
        public Parametre build() {
            return new Parametre(this.id, this.totalParJour, this.maxParProvinceParJour, this.dateDebut);
        }

        @Generated
        public String toString() {
            Long var10000 = this.id;
            return "Parametre.ParametreBuilder(id=" + var10000 + ", totalParJour=" + this.totalParJour + ", maxParProvinceParJour=" + this.maxParProvinceParJour + ", dateDebut=" + String.valueOf(this.dateDebut) + ")";
        }
    }
}
