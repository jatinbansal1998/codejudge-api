package org.codejudge.sb.dto.quiz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codejudge.sb.dto.BaseResponseEntityMO;
import org.codejudge.sb.dto.question.ResponseQuestionDetailsMO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseQuizWithQuestionsMO extends BaseResponseEntityMO {
    private String name;
    private String description;
    private List<ResponseQuestionDetailsMO> questions;
}
