package com.om.controller;

import com.om.baseclasses.BaseResponse;
import com.om.baseclasses.Constants;
import com.om.baseclasses.EndPointRefer;
import com.om.model.Subject;
import com.om.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    SubjectService subjectService;
    @PostMapping(EndPointRefer.SUBJECTS)
    public BaseResponse subjects(@RequestBody Subject subject){
        log.info(EndPointRefer.SUBJECTS + Constants.CONTROLLER_STARTED);
        return subjectService.subjects(subject);
    }
    @GetMapping(EndPointRefer.LIST_OF_ALL_SUBJECTS)
    public BaseResponse getAllSubjects(){
        log.info(EndPointRefer.LIST_OF_ALL_SUBJECTS + Constants.CONTROLLER_STARTED);
        return subjectService.getAllSubjects();
    }
}
