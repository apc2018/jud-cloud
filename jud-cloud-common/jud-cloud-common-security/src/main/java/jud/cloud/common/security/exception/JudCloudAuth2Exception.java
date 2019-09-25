package jud.cloud.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jud.cloud.common.security.component.JudCloudAuth2ExceptionSerializer;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

@JsonSerialize(using = JudCloudAuth2ExceptionSerializer.class)
public class JudCloudAuth2Exception extends OAuth2Exception {
    @Getter
    private String errorCode;

    public JudCloudAuth2Exception(String msg) {
        super(msg);
    }

    public JudCloudAuth2Exception(String msg, String errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }
}
