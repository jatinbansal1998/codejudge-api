package org.codejudge.sb.repository;

import org.codejudge.sb.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuizRepository extends JpaRepository<Quiz, Long> {
}
