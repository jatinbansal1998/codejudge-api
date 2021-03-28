package org.codejudge.sb.validator;

import org.codejudge.sb.ExceptionHandling.UdaanBusinessException;
import org.codejudge.sb.dto.quiz.CreateQuizDetailsRequestMO;
import org.springframework.stereotype.Component;

@Component
public class QuizValidator {
    public void validateQuizDetails(CreateQuizDetailsRequestMO createQuizDetailsRequestMO) {
        if (createQuizDetailsRequestMO == null || createQuizDetailsRequestMO.getDescription() == null || createQuizDetailsRequestMO.getDescription().isEmpty())
            throw new UdaanBusinessException("description should not be empty and null");
        if (createQuizDetailsRequestMO == null || createQuizDetailsRequestMO.getName() == null || createQuizDetailsRequestMO.getName().isEmpty())
            throw new UdaanBusinessException("name should not be empty and null");
    }

    public void validateGetRequestQuizDetails(Long id) {
        if (id == null)
            throw new UdaanBusinessException("id should not be null or blank");
    }
}
