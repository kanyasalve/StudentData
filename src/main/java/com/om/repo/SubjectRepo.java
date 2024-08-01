package com.om.repo;


import com.om.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo  extends JpaRepository<Subject, Long> {
}
