package jud.cloud.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jud.cloud.common.security.component.JudCloudAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

@JsonSerialize(using = JudCloudAuth2ExceptionSerializer.class)
public class ForbiddenException extends JudCloudAuth2Exception {
    public ForbiddenException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "access_denied";
    }

    @Override
    public int getHttpErrorCode() {
        return HttpStatus.FORBIDDEN.value();
    }
}
