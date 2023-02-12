package api.models.qualification;

import java.util.List;
import lombok.Data;

@Data
public class QualificationTypesResponse {
    private String qualificationTypeId;
    private String qualificationTypeKey;
    private String qualificationTypeName;
    private String qualificationTypeLabel;
    private List<Object> stateSpecificLabel;
}