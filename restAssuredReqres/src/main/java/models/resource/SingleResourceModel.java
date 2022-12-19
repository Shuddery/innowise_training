package models.resource;

import lombok.Data;
import models.SupportModel;
import models.resource.ResourcesModel;

@Data
public class SingleResourceModel {
    private ResourcesModel data;
    private SupportModel support;
}