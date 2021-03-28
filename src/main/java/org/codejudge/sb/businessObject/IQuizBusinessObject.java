package org.codejudge.sb.businessObject;

import org.codejudge.sb.dto.quiz.CreateQuizDetailsRequestMO;
import org.codejudge.sb.entity.Quiz;

import java.util.Optional;

public interface IQuizBusinessObject {
    Optional<Quiz> findById(Long id);

    Quiz save(CreateQuizDetailsRequestMO createQuizDetailsRequestMO);

    Optional<Quiz> getQuizWithQuestions(Long id);
}
