//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rachid.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import lombok.Generated;

@Entity
public class JourExclue {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Temporal(TemporalType.DATE)
    @JsonFormat(
            shape = Shape.STRING,
            pattern = "yyyy-MM-dd"
    )
    private LocalDate jourFerie;
    private String description;

    public JourExclue(LocalDate of) {
    }

    @Generated
    public static JourExclueBuilder builder() {
        return new JourExclueBuilder();
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof JourExclue)) {
            return false;
        } else {
            JourExclue other = (JourExclue)o;
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

                Object this$jourFerie = this.getJourFerie();
                Object other$jourFerie = other.getJourFerie();
                if (this$jourFerie == null) {
                    if (other$jourFerie != null) {
                        return false;
                    }
                } else if (!this$jourFerie.equals(other$jourFerie)) {
                    return false;
                }

                Object this$description = this.getDescription();
                Object other$description = other.getDescription();
                if (this$description == null) {
                    if (other$description != null) {
                        return false;
                    }
                } else if (!this$description.equals(other$description)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof JourExclue;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $jourFerie = this.getJourFerie();
        result = result * 59 + ($jourFerie == null ? 43 : $jourFerie.hashCode());
        Object $description = this.getDescription();
        result = result * 59 + ($description == null ? 43 : $description.hashCode());
        return result;
    }

    @Generated
    public JourExclue() {
    }

    @Generated
    public JourExclue(final Long id, final LocalDate jourFerie, final String description) {
        this.id = id;
        this.jourFerie = jourFerie;
        this.description = description;
    }

    @Generated
    public void setId(final Long id) {
        this.id = id;
    }

    @JsonFormat(
            shape = Shape.STRING,
            pattern = "yyyy-MM-dd"
    )
    @Generated
    public void setJourFerie(final LocalDate jourFerie) {
        this.jourFerie = jourFerie;
    }

    @Generated
    public void setDescription(final String description) {
        this.description = description;
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public LocalDate getJourFerie() {
        return this.jourFerie;
    }

    @Generated
    public String getDescription() {
        return this.description;
    }

    @Generated
    public String toString() {
        Long var10000 = this.getId();
        return "JourExclue(id=" + var10000 + ", jourFerie=" + String.valueOf(this.getJourFerie()) + ", description=" + this.getDescription() + ")";
    }

    @Generated
    public static class JourExclueBuilder {
        @Generated
        private Long id;
        @Generated
        private LocalDate jourFerie;
        @Generated
        private String description;

        @Generated
        JourExclueBuilder() {
        }

        @Generated
        public JourExclueBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @JsonFormat(
                shape = Shape.STRING,
                pattern = "yyyy-MM-dd"
        )
        @Generated
        public JourExclueBuilder jourFerie(final LocalDate jourFerie) {
            this.jourFerie = jourFerie;
            return this;
        }

        @Generated
        public JourExclueBuilder description(final String description) {
            this.description = description;
            return this;
        }

        @Generated
        public JourExclue build() {
            return new JourExclue(this.id, this.jourFerie, this.description);
        }

        @Generated
        public String toString() {
            Long var10000 = this.id;
            return "JourExclue.JourExclueBuilder(id=" + var10000 + ", jourFerie=" + String.valueOf(this.jourFerie) + ", description=" + this.description + ")";
        }
    }
}
