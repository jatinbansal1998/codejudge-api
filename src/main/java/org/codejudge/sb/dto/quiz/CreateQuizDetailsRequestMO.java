package org.codejudge.sb.dto.quiz;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class CreateQuizDetailsRequestMO {
    @ApiModelProperty(required = true, value = "", dataType = "String", example = "QUIZ-1")
    private String name;
    @ApiModelProperty(required = true, value = "", dataType = "String", example = "this is a sample quiz")
    private String description;
}
