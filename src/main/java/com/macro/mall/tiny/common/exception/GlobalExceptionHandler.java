package com.macro.mall.tiny.common.exception;

import cn.hutool.json.JSONObject;
import com.macro.mall.tiny.common.api.CommonResult;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<CommonResult<JSONObject>> handle(ApiException e) {
        if (e.getErrorCode() != null && e.getMessage() != null) {
            return CommonResult.codeFailed(e.getErrorCode(), e.getMessage());
        }
        if (e.getErrorCode() != null) {
            return CommonResult.failed(e.getErrorCode());
        }
        return CommonResult.failed(e.getMessage());
    }

    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<CommonResult<JSONObject>> handleMultipartException(MultipartException ex) {
        return CommonResult.failed(ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<CommonResult<JSONObject>> handleValidException(MethodArgumentNotValidException e) {
        return getCommonResultResponseEntity(e.getBindingResult());
    }

    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public ResponseEntity<CommonResult<JSONObject>> handleValidException(BindException e) {
        return getCommonResultResponseEntity(e.getBindingResult());
    }

    private ResponseEntity<CommonResult<JSONObject>> getCommonResultResponseEntity(BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        String message = fieldErrors.stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(","));
        return CommonResult.validateFailed(message);
    }
}
