package jud.cloud.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jud.cloud.common.security.component.JudCloudAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

@JsonSerialize(using = JudCloudAuth2ExceptionSerializer.class)
public class UnauthorizedException extends JudCloudAuth2Exception {
    public UnauthorizedException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "unauthorized";
    }

    @Override
    public int getHttpErrorCode() {
        return HttpStatus.UNAUTHORIZED.value();
    }
}
