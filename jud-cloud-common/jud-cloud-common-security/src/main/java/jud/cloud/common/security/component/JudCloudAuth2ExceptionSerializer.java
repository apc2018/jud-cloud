package jud.cloud.common.security.component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import jud.cloud.common.core.constant.CommonConstants;
import jud.cloud.common.security.exception.JudCloudAuth2Exception;

import java.io.IOException;

/**
 * 异常格式化
 */
public class JudCloudAuth2ExceptionSerializer extends StdSerializer<JudCloudAuth2Exception> {
    public JudCloudAuth2ExceptionSerializer() {
        super(JudCloudAuth2Exception.class);
    }

    @Override
    public void serialize(JudCloudAuth2Exception value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeObjectField("code", CommonConstants.FAIL);
        gen.writeStringField("msg", value.getMessage());
        gen.writeStringField("data", value.getErrorCode());
        gen.writeEndObject();
    }
}
