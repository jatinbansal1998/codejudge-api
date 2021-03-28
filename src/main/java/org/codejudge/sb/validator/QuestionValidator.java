package org.codejudge.sb.validator;

import org.codejudge.sb.ExceptionHandling.UdaanBusinessException;
import org.codejudge.sb.dto.question.CreateQuestionDetailsRequestMO;
import org.springframework.stereotype.Component;

@Component
public class QuestionValidator {
    public void validateMandatoryData(CreateQuestionDetailsRequestMO createQuestionDetailsRequestMO) {
        if (createQuestionDetailsRequestMO.getName() == null || createQuestionDetailsRequestMO.getName().isEmpty())
            throw new UdaanBusinessException("Name should not be null or empty");
        if (createQuestionDetailsRequestMO.getOptions() == null || createQuestionDetailsRequestMO.getOptions().isEmpty())
            throw new UdaanBusinessException("Options should not be null or empty");
        String[] options = createQuestionDetailsRequestMO.getOptions().split(",");
        if (options.length < 2)
            throw new UdaanBusinessException("there should be more than one option and separated by ,");
        if (createQuestionDetailsRequestMO.getPoints() <= 0)
            throw new UdaanBusinessException("points should be positive");
    }

    public void validateCorrectOptionData(CreateQuestionDetailsRequestMO createQuestionDetailsRequestMO) {
        String[] options = createQuestionDetailsRequestMO.getOptions().split(",");
        if (createQuestionDetailsRequestMO.getCorrect_option() < 1 || createQuestionDetailsRequestMO.getCorrect_option() > options.length)
            throw new UdaanBusinessException("correct option should be between 1 & " + options.length);
    }

    public void validateGetRequestQuestionDetails(Long id) {
        if (id == null)
            throw new UdaanBusinessException("id should not be null or blank");
    }
}
