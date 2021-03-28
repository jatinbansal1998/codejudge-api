package org.codejudge.sb.dto.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codejudge.sb.dto.BaseResponseEntityMO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseQuestionDetailsMO extends BaseResponseEntityMO {
    private long id;
    private String name;
    private String options;
    private int correct_option;
    private Long quiz;
    private int points;
}
