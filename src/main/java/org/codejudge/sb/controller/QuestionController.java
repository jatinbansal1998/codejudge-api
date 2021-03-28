package org.codejudge.sb.controller;

import io.swagger.annotations.ApiOperation;
import org.codejudge.sb.ExceptionHandling.UdaanNotFoundException;
import org.codejudge.sb.dto.BaseResponseEntityMO;
import org.codejudge.sb.dto.question.CreateQuestionDetailsRequestMO;
import org.codejudge.sb.dto.question.ResponseQuestionDetailsMO;
import org.codejudge.sb.entity.Question;
import org.codejudge.sb.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;

    @ApiOperation("Get Question Details")
    @GetMapping("/questions/{id}")
    public ResponseEntity<BaseResponseEntityMO> getQuestionDetails(@PathVariable(value = "id") Long id) {
        Optional<Question> optionalQuestion = questionService.findById(id);
        if (!optionalQuestion.isPresent()) {
            throw new UdaanNotFoundException("ID not found");
        }
        Question question = optionalQuestion.get();
        return ResponseEntity.status(HttpStatus.OK).body(transformQuestion(question));
    }

    @ApiOperation("Create a Question")
    @PostMapping("/questions")
    public ResponseEntity<BaseResponseEntityMO> saveQuestionDetails(@RequestBody CreateQuestionDetailsRequestMO createQuestionDetailsRequestMO) {
        Question question = questionService.save(createQuestionDetailsRequestMO);
        return ResponseEntity.status(HttpStatus.CREATED).body(transformQuestion(question));
    }

    public static ResponseQuestionDetailsMO transformQuestion(Question question) {
        return ResponseQuestionDetailsMO.builder()
                .id(question.getId())
                .name(question.getName())
                .options(question.getOptions())
                .correct_option(question.getCorrect_option())
                .quiz(question.getQuizID())
                .points(question.getPoints())
                .build();
    }
}
