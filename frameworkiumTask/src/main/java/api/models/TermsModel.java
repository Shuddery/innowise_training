package api.models;

import lombok.Data;

@Data
public class TermsModel {
        private String uid;
        private String hash;
        private boolean termsAccept;
        private String platform;

        public static TermsModel generate(String uid) {
            TermsModel termsModel = new TermsModel();
            termsModel.setUid(uid);
            termsModel.setHash("undefined");
            termsModel.setTermsAccept(true);
            termsModel.setPlatform("Web");
            return termsModel;
        }
}