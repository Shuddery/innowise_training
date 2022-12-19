package models.resource;

import java.util.List;
import lombok.Data;
import models.SupportModel;

@Data
public class ResourceModel {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<ResourcesModel> data;
    private SupportModel support;
}