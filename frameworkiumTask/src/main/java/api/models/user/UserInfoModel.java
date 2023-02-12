package api.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;
import utils.IConstants;

@Data
public class UserInfoModel {
    public String firstName;
    public String lastName;
    public String mobile;
    public String zip;
    public String state;
    public String lat;
    @JsonProperty("long")
    public String mylong;
    public String workExp;
    public List<LicType> licType;
    public ShiftType shiftType;
    public String city;
    public Object pid;
    public String uid;

    public static UserInfoModel generate(List<LicType> licType, String uid) {
        UserInfoModel userInfoModel = new UserInfoModel();
        userInfoModel.setFirstName("123");
        userInfoModel.setLastName("automation");
        userInfoModel.setMobile(IConstants.phoneNumber);
        userInfoModel.setZip(IConstants.zipCode);
        userInfoModel.setState(IConstants.state);
        userInfoModel.setLat(IConstants.lat);
        userInfoModel.setMylong(IConstants.lonG);
        userInfoModel.setWorkExp(IConstants.experience);
        userInfoModel.setLicType(licType);
        userInfoModel.setShiftType(ShiftType.generate());
        userInfoModel.setCity(IConstants.city);
        userInfoModel.setPid(null);
        userInfoModel.setUid(uid);
        return userInfoModel;
    }
}