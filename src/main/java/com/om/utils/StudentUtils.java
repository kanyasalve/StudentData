package com.om.utils;

import com.om.baseclasses.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.util.Collection;
import java.util.Collections;


@Slf4j
public class StudentUtils {
    public static BaseResponse getBaseResponse(CustomHttpStatus httpStatus, Collection<Errors> errors) {

        return BaseResponse.builder()
                .status(Status.builder()
                        .statusCode(httpStatus.value()).statusValue(httpStatus.name()).build())
                .errors(errors)
                .build();
    }

    public static BaseResponse getBaseResponse(HttpStatus httpStatus, Object buzResponse) {
        if (null == buzResponse)
            buzResponse = Collections.emptyMap();

        return BaseResponse.builder()
                .payload(new Payload<>(buzResponse))
                .status(
                        Status.builder()
                                .statusCode(httpStatus.value())
                                .statusValue(httpStatus.name()).build())
                .build();
    }



}
