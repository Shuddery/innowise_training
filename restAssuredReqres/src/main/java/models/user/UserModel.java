package models.user;

import java.util.List;
import lombok.Data;
import models.SupportModel;

@Data
public class UserModel {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<UsersModel> data;
    private SupportModel support;
}