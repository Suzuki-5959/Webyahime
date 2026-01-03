package jp.webyahime.api.controller.advicd;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jp.webyahime.api.dto.ErrorResponse;
import jp.webyahime.api.exception.ResourceNotFoundException;

/**
 * 全Controller共通の例外ハンドリングクラス
 */
@RestControllerAdvice
public class GlobalExceptionhandler {

    /**
     * 対象のリソースが存在しなかったときに404として返す。
     * 
     * @param e URI上で表現するリソースが存在しなかったときの例外
     * @return
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFound(ResourceNotFoundException e) {
        return new ErrorResponse("NOT_FOUND", e.getMessage());
    }
}
