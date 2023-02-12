package api.models;

import lombok.Data;

@Data
public class SmsValidationModel {
    private String section;
    private String uid;
    private String validationCode;

    public static SmsValidationModel generate(String uid, String smsCode) {
        SmsValidationModel smsValidationModel = new SmsValidationModel();
        smsValidationModel.setSection("accountValidate");
        smsValidationModel.setUid(uid);
        smsValidationModel.setValidationCode(smsCode);
        return smsValidationModel;
    }
}