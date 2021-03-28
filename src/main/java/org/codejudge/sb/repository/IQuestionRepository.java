package org.codejudge.sb.repository;

import org.codejudge.sb.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionRepository extends JpaRepository<Question, Long> {
}
