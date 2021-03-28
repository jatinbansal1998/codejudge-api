package org.codejudge.sb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

import static org.codejudge.sb.constants.JPADataTypeConstants.VARCHAR2_DEFAULT_LENGTH;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "QUIZ")
@SequenceGenerator(name = "default_gen", sequenceName = "QUIZ_SEQ", allocationSize = 1)
public class Quiz extends BaseEntity {
    @Column(name = "QUIZ_NAME", length = VARCHAR2_DEFAULT_LENGTH)
    private String name;
    @Column(name = "QUIZ_DESCRIPTION", length = VARCHAR2_DEFAULT_LENGTH)
    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUIZ_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private List<Question> questionList;
}
