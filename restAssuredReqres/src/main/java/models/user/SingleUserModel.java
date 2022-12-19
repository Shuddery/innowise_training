package models.user;

import lombok.Data;
import models.SupportModel;
import models.user.UsersModel;

@Data
public class SingleUserModel {
    private UsersModel data;
    private SupportModel support;
}
