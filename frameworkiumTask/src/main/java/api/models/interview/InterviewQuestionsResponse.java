package api.models.interview;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class InterviewQuestionsResponse {

    private int interview_question_id;
    private Object value;
    public InterviewQuestionsResponse(int interview_question_id, Object value) {
        this.interview_question_id = interview_question_id;
        this.value = value;
    }


    public static List<InterviewQuestionsResponse> generate(String state) {
        List<InterviewQuestionsResponse> list = new ArrayList<>();
        list.add(new InterviewQuestionsResponse(15, 60));
        list.add(new InterviewQuestionsResponse(16, 60));
        list.add(new InterviewQuestionsResponse(17, "0"));
        list.add(new InterviewQuestionsResponse(18, "0"));
        list.add(new InterviewQuestionsResponse(19, "0"));
        list.add(new InterviewQuestionsResponse(20, "0"));
        list.add(new InterviewQuestionsResponse(21, null));
        list.add(new InterviewQuestionsResponse(22, "0"));
        list.add(new InterviewQuestionsResponse(3, "state " + state));
        list.add(new InterviewQuestionsResponse(4, "More than 10 shifts"));
        list.add(new InterviewQuestionsResponse(14, "Daytime, Evening, Overnight, Weekday, Weekend"));
        list.add(new InterviewQuestionsResponse(13, "Yes"));
        list.add(new InterviewQuestionsResponse(6, "4:00 PM - 5:00 PM"));
        list.add(new InterviewQuestionsResponse(11, "Yes, and I have the documentation"));
        list.add(new InterviewQuestionsResponse(12, "Yes, and I have the documentation"));
        list.add(new InterviewQuestionsResponse(10, "Yes"));
        return list;
    }
}