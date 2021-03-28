package org.codejudge.sb.service;

import org.codejudge.sb.businessObject.IQuestionBusinessObject;
import org.codejudge.sb.dto.question.CreateQuestionDetailsRequestMO;
import org.codejudge.sb.entity.Question;
import org.codejudge.sb.validator.QuestionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service("questionService")
public class QuestionService implements IQuestionService {

    @Autowired
    private IQuestionBusinessObject questionBusinessObject;

    @Autowired
    private QuestionValidator questionValidator;

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Optional<Question> findById(Long id) {
        questionValidator.validateGetRequestQuestionDetails(id);
        return questionBusinessObject.findQuestionById(id);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Question save(CreateQuestionDetailsRequestMO createQuestionDetailsRequestMO) {
        questionValidator.validateMandatoryData(createQuestionDetailsRequestMO);
        questionValidator.validateCorrectOptionData(createQuestionDetailsRequestMO);
        return questionBusinessObject.save(createQuestionDetailsRequestMO);
    }
}
