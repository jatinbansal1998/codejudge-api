package org.codejudge.sb.controller;

import io.swagger.annotations.ApiOperation;
import org.codejudge.sb.ExceptionHandling.UdaanNotFoundException;
import org.codejudge.sb.dto.BaseResponseEntityMO;
import org.codejudge.sb.dto.quiz.CreateQuizDetailsRequestMO;
import org.codejudge.sb.dto.quiz.ResponseQuizDetailsMO;
import org.codejudge.sb.dto.quiz.ResponseQuizWithQuestionsMO;
import org.codejudge.sb.entity.Quiz;
import org.codejudge.sb.service.IQuizService;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class QuizController {

    @Autowired
    private IQuizService quizService;

    @ApiOperation("Get a quiz")
    @GetMapping(value = "/quiz/{id}")
    public ResponseEntity<BaseResponseEntityMO> getQuizDetails(@PathVariable(value = "id") Long id) {
        Optional<Quiz> quiz = quizService.findById(id);
        if (!quiz.isPresent()) {
            throw new UdaanNotFoundException("ID not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(transformQuiz(quiz.get()));
    }

    @ApiOperation("Create a quiz")
    @PostMapping(value = "/quiz")
    public ResponseEntity<BaseResponseEntityMO> saveQuizDetails(@RequestBody CreateQuizDetailsRequestMO createQuizDetailsRequestMO) {
        Quiz quiz = quizService.save(createQuizDetailsRequestMO);
        return ResponseEntity.status(HttpStatus.CREATED).body(transformQuiz(quiz));
    }

    @ApiOperation("Get all questions for a quiz")
    @GetMapping(value = "/quiz-questions/{id}")
    public ResponseEntity<BaseResponseEntityMO> getAllQuestionForQuiz(@PathVariable(value = "id") Long id) {
        Optional<Quiz> quiz = quizService.getQuizWithQuestions(id);
        if (!quiz.isPresent()) {
            throw new UdaanNotFoundException("ID not found");
        }
        ResponseQuizWithQuestionsMO responseQuizDetailsMO = ResponseQuizWithQuestionsMO.builder()
                .name(quiz.get().getName())
                .description(quiz.get().getDescription())
                .questions(quiz.get().getQuestionList().stream().map(QuestionController::transformQuestion).collect(Collectors.toList()))
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseQuizDetailsMO);
    }

    public static ResponseQuizDetailsMO transformQuiz(Quiz quiz) {
        return ResponseQuizDetailsMO.builder()
                .id(quiz.getId())
                .name(quiz.getName())
                .description(quiz.getDescription())
                .build();
    }
}
