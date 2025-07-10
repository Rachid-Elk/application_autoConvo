package rachid.demo.model.dto;

import java.time.LocalDate;

public class AttributionResultDTO {
    private String centre;
    private String province;
    private LocalDate dateAttribuee;
    private Long total;

    public AttributionResultDTO(String centre, String province, LocalDate dateAttribuee, Long total) {
        this.centre = centre;
        this.province = province;
        this.dateAttribuee = dateAttribuee;
        this.total = total;
    }

    // Getters et Setters
    public String getCentre() {
        return centre;
    }

    public void setCentre(String centre) {
        this.centre = centre;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public LocalDate getDateAttribuee() {
        return dateAttribuee;
    }

    public void setDateAttribuee(LocalDate dateAttribuee) {
        this.dateAttribuee = dateAttribuee;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
