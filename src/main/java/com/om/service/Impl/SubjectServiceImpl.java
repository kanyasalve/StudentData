package com.om.service.Impl;

import com.om.baseclasses.BaseResponse;

import com.om.baseclasses.CustomHttpStatus;
import com.om.baseclasses.ErrorCode;
import com.om.baseclasses.Errors;
import com.om.model.Subject;
import com.om.repo.SubjectRepo;
import com.om.service.SubjectService;
import com.om.utils.StudentUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepo subjectRepo;

    @Override
    public BaseResponse subjects(Subject subject) {
        BaseResponse baseResponse=null;
        try {
            if (subject != null && subject.getName() != null) {
                baseResponse = StudentUtils.getBaseResponse(HttpStatus.OK, subjectRepo.save(subject));
            } else {
                log.error("Subject data is missing or invalid");
                Collection<Errors> errors = new ArrayList<>();
                errors.add(Errors.builder()
                        .message(ErrorCode.NAME_MISSING)
                        .errorCode(String.valueOf(Errors.ERROR_TYPE.SUBJECT.toCode()))
                        .errorType(Errors.SEVERITY.HIGH.name())
                        .build());
                baseResponse = StudentUtils.getBaseResponse(CustomHttpStatus.FAILURE, errors);
            }
        } catch (Exception e) {
            log.error("Exception occurred while creating subject {}", e.getMessage());
            throw new RuntimeException(e);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse getAllSubjects() {
        BaseResponse baseResponse=null;
        try {
            List<Subject> subjects = subjectRepo.findAll();
            baseResponse = StudentUtils.getBaseResponse(HttpStatus.OK, subjects);
        } catch (Exception e) {
            log.error("Exception occurred while fetching subjects {}", e.getMessage());
            throw new RuntimeException(e);
        }
        return baseResponse;
    }
}
