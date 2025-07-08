//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rachid.demo.model.dto;

import java.time.LocalDate;
import lombok.Generated;

public class AttributionResultDTO {
    private Long provinceId;
    private String provinceNom;
    private LocalDate dateAttribuee;
    private Long totalCandidats;

    public AttributionResultDTO(Long provinceId, String provinceNom, LocalDate dateAttribuee, Long totalCandidats) {
        this.provinceId = provinceId;
        this.provinceNom = provinceNom;
        this.dateAttribuee = dateAttribuee;
        this.totalCandidats = totalCandidats;
    }

    @Generated
    public Long getProvinceId() {
        return this.provinceId;
    }

    @Generated
    public String getProvinceNom() {
        return this.provinceNom;
    }

    @Generated
    public LocalDate getDateAttribuee() {
        return this.dateAttribuee;
    }

    @Generated
    public Long getTotalCandidats() {
        return this.totalCandidats;
    }

    @Generated
    public void setProvinceId(final Long provinceId) {
        this.provinceId = provinceId;
    }

    @Generated
    public void setProvinceNom(final String provinceNom) {
        this.provinceNom = provinceNom;
    }

    @Generated
    public void setDateAttribuee(final LocalDate dateAttribuee) {
        this.dateAttribuee = dateAttribuee;
    }

    @Generated
    public void setTotalCandidats(final Long totalCandidats) {
        this.totalCandidats = totalCandidats;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof AttributionResultDTO)) {
            return false;
        } else {
            AttributionResultDTO other = (AttributionResultDTO)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$provinceId = this.getProvinceId();
                Object other$provinceId = other.getProvinceId();
                if (this$provinceId == null) {
                    if (other$provinceId != null) {
                        return false;
                    }
                } else if (!this$provinceId.equals(other$provinceId)) {
                    return false;
                }

                Object this$totalCandidats = this.getTotalCandidats();
                Object other$totalCandidats = other.getTotalCandidats();
                if (this$totalCandidats == null) {
                    if (other$totalCandidats != null) {
                        return false;
                    }
                } else if (!this$totalCandidats.equals(other$totalCandidats)) {
                    return false;
                }

                Object this$provinceNom = this.getProvinceNom();
                Object other$provinceNom = other.getProvinceNom();
                if (this$provinceNom == null) {
                    if (other$provinceNom != null) {
                        return false;
                    }
                } else if (!this$provinceNom.equals(other$provinceNom)) {
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

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof AttributionResultDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $provinceId = this.getProvinceId();
        result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
        Object $totalCandidats = this.getTotalCandidats();
        result = result * 59 + ($totalCandidats == null ? 43 : $totalCandidats.hashCode());
        Object $provinceNom = this.getProvinceNom();
        result = result * 59 + ($provinceNom == null ? 43 : $provinceNom.hashCode());
        Object $dateAttribuee = this.getDateAttribuee();
        result = result * 59 + ($dateAttribuee == null ? 43 : $dateAttribuee.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        Long var10000 = this.getProvinceId();
        return "AttributionResultDTO(provinceId=" + var10000 + ", provinceNom=" + this.getProvinceNom() + ", dateAttribuee=" + String.valueOf(this.getDateAttribuee()) + ", totalCandidats=" + this.getTotalCandidats() + ")";
    }

    @Generated
    public AttributionResultDTO() {
    }
}
