package api.models.user;

import java.util.List;
import lombok.Data;

@Data
public class UserRootModel {
    public String section;
    public UserInfoModel data;

    public static UserRootModel generate(List<LicType> licType, String uid) {
        UserRootModel userRootModel = new UserRootModel();
        userRootModel.setSection("profile");
        userRootModel.setData(UserInfoModel.generate(licType, uid));
        return userRootModel;
    }
}