package jud.cloud.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jud.cloud.common.security.component.JudCloudAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

@JsonSerialize(using = JudCloudAuth2ExceptionSerializer.class)
public class ServerErrorException extends JudCloudAuth2Exception {
    public ServerErrorException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "server_error";
    }

    @Override
    public int getHttpErrorCode() {
        return HttpStatus.INTERNAL_SERVER_ERROR.value();
    }
}
