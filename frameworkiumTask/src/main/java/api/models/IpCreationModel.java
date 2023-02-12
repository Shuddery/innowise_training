package api.models;

import lombok.Data;

@Data
public class IpCreationModel {
    private String section;
    private String email;
    private String password;
    private String referralCode;

    public static IpCreationModel generate(String email, String password) {
        IpCreationModel ipCreationModel = new IpCreationModel();
        ipCreationModel.setSection("new");
        ipCreationModel.setEmail(email);
        ipCreationModel.setPassword(password);
        ipCreationModel.setReferralCode("null");
        return ipCreationModel;
    }
}