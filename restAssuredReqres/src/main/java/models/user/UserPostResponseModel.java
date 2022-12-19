package models.user;

import lombok.Data;

@Data
public class UserPostResponseModel {
    String name;
    String job;
    String id;
    String createdAt;
}
