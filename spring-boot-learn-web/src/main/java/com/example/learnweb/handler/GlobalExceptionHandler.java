package com.example.learnweb.handler;

import com.example.learnweb.exception.ApiException;
import com.example.learnweb.result.ApiModel;
import com.example.learnweb.result.ApiStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.StringJoiner;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义异常
     * ApiException
     */
    @ExceptionHandler(value = ApiException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ApiModel<String> apiExceptionHandler(ApiException e) {
        logger.error(e.getMessage(), e);
        return ApiModel.fail(e.getMessage(), ApiStatus.FAIL);
    }

    /**
     * 参数绑定
     * BindException
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ApiModel<String> bindExceptionHandler(BindException e) {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        fieldErrors.forEach(temp -> stringJoiner.add(temp.getField() + ":" + temp.getDefaultMessage()));
        String msg = stringJoiner.toString();
        logger.error(msg);
        return ApiModel.fail(msg, ApiStatus.VALIDATION);
    }

    /**
     * NullPointerException
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ApiModel<String> nullPointerExceptionHandler(NullPointerException e) {
        logger.error(e.getMessage(), e);
        return ApiModel.fail(e.getMessage(), ApiStatus.NULL_POINTER_EXCEPTION);
    }

    /**
     * Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiModel<String> exceptionHandler(Exception e) {
        logger.error(e.getMessage(), e);
        return ApiModel.fail(e.getMessage(), ApiStatus.ERROR);
    }

}
