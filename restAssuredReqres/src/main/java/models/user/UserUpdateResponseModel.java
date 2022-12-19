package models.user;

import lombok.Data;

@Data
public class UserUpdateResponseModel {
    String name;
    String job;
    String updatedAt;
}
