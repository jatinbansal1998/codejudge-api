package org.codejudge.sb.dto.question;

import lombok.Data;

@Data
public class CreateQuestionDetailsRequestMO {
    private String name;
    private String options;
    private int correct_option;
    private Long quiz;
    private int points;
}
