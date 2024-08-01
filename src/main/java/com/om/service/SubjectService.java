package com.om.service;

import com.om.baseclasses.BaseResponse;
import com.om.model.Subject;

public interface SubjectService {
    BaseResponse subjects(Subject subject);

    BaseResponse getAllSubjects();
}
