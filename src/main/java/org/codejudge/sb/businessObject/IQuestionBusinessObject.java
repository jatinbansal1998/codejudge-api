package org.codejudge.sb.businessObject;

import org.codejudge.sb.dto.question.CreateQuestionDetailsRequestMO;
import org.codejudge.sb.entity.Question;

import java.util.Optional;

public interface IQuestionBusinessObject {
    Optional<Question> findQuestionById(Long id);

    Question save(CreateQuestionDetailsRequestMO createQuestionDetailsRequestMO);
}
