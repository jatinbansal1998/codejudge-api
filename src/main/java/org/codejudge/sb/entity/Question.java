package org.codejudge.sb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codejudge.sb.constants.JPADataTypeConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "QUESTION")
@SequenceGenerator(name = "default_gen", sequenceName = "QUESTION_SEQ", allocationSize = 1)
public class Question extends BaseEntity {
    @Column(name = "NAME")
    private String name;
    @Column(name = "OPTIONS")
    private String options;
    @Column(name = "CORRECT_OPTION")
    private int correct_option;
    @Column(name = "POINTS")
    private int points;
    @Column(name = "QUIZ_ID", columnDefinition = JPADataTypeConstants.ID)
    private Long quizID;

    @ManyToOne
    @JoinColumn(name = "QUIZ_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Quiz quiz;
}
