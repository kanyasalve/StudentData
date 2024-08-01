package com.om.repo;

import com.om.baseclasses.BaseResponse;
import com.om.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StudentRepo extends JpaRepository<Student, Long> {
    // You can define custom queries here if needed
}




