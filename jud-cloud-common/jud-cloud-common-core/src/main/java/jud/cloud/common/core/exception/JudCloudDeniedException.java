package jud.cloud.common.core.exception;

import lombok.NoArgsConstructor;

/**
 * 授权拒绝403
 */
@NoArgsConstructor
public class JudCloudDeniedException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public JudCloudDeniedException(String message) {
        super(message);
    }

    public JudCloudDeniedException(Throwable cause) {
        super(cause);
    }

    public JudCloudDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public JudCloudDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
