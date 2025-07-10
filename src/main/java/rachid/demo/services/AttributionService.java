package rachid.demo.services;

import rachid.demo.model.dto.AttributionResultDTO;

import java.util.List;

public interface AttributionService {
    List<AttributionResultDTO> getAttributionResults();
    void attribuerDates();
}