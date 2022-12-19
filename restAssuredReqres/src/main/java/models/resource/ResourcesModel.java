package models.resource;

import lombok.Data;

@Data
public class ResourcesModel {
    private int id;
    private String name;
    private int year;
    private String color;
    private String pantone_value;
}