package org.codejudge.sb.service;

import org.codejudge.sb.dto.question.CreateQuestionDetailsRequestMO;
import org.codejudge.sb.entity.Question;

import java.util.Optional;

public interface IQuestionService {
    Optional<Question> findById(Long id);

    Question save(CreateQuestionDetailsRequestMO createQuestionDetailsRequestMO);
}
