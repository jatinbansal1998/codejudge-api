package org.codejudge.sb.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel
public class ErrorResponseMO extends BaseResponseEntityMO {
    private String status;
    private String reason;
}
