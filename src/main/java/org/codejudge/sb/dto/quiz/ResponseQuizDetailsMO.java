package org.codejudge.sb.dto.quiz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codejudge.sb.dto.BaseResponseEntityMO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseQuizDetailsMO extends BaseResponseEntityMO {
    private Long id;
    private String name;
    private String description;
}
