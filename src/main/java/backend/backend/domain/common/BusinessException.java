package backend.backend.domain.common;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{

    private final ResponseCode errorCode;

    public BusinessException(ResponseCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}

