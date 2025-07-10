package rachid.demo.model.dto;

import java.time.LocalDate;

public interface AttributionResult {
    String getCentre();
    String getProvince();
    LocalDate getDateAttribuee();
    Long getTotal();
}
