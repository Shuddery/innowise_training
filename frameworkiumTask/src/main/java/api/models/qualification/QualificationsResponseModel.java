package api.models.qualification;

import java.util.List;
import lombok.Data;

@Data
public class QualificationsResponseModel {
    private List<QualificationTypesResponse> data;
    public Object metadata;
    public Object errors;
    public Object message;
    public boolean isSuccess;
    public String status;
    public boolean success;
}