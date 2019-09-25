package jud.cloud.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jud.cloud.common.security.component.JudCloudAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

@JsonSerialize(using = JudCloudAuth2ExceptionSerializer.class)
public class MethodNotAllowedException extends JudCloudAuth2Exception {
    public MethodNotAllowedException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "method_not_allowed";
    }

    @Override
    public int getHttpErrorCode() {
        return HttpStatus.METHOD_NOT_ALLOWED.value();
    }
}
