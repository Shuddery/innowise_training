package api.models.interview;

import java.util.List;
import lombok.Data;

@Data
public class InterviewQuestionRoot {
    private int interviewFormId;
    private List<InterviewQuestionsResponse> responses;

    public static InterviewQuestionRoot generate(String state) {
        InterviewQuestionRoot interviewQuestionRoot = new InterviewQuestionRoot();
        interviewQuestionRoot.setInterviewFormId(1);
        interviewQuestionRoot.setResponses(InterviewQuestionsResponse.generate(state));
        return interviewQuestionRoot;
    }
}
