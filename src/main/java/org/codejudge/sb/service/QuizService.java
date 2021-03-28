package org.codejudge.sb.service;

import org.codejudge.sb.businessObject.IQuizBusinessObject;
import org.codejudge.sb.dto.quiz.CreateQuizDetailsRequestMO;
import org.codejudge.sb.entity.Quiz;
import org.codejudge.sb.validator.QuizValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service("quizService")
public class QuizService implements IQuizService {

    @Autowired
    private IQuizBusinessObject quizBusinessObject;

    @Autowired
    private QuizValidator quizValidator;

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Optional<Quiz> findById(Long id) {
        quizValidator.validateGetRequestQuizDetails(id);
        return quizBusinessObject.findById(id);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Quiz save(CreateQuizDetailsRequestMO createQuizDetailsRequestMO) {
        quizValidator.validateQuizDetails(createQuizDetailsRequestMO);
        return quizBusinessObject.save(createQuizDetailsRequestMO);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Optional<Quiz> getQuizWithQuestions(Long id) {
        quizValidator.validateGetRequestQuizDetails(id);
        return quizBusinessObject.getQuizWithQuestions(id);
    }
}
