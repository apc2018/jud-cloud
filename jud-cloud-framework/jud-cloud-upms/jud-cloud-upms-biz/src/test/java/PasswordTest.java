import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.ulisesbocchio.jasyptspringboot.encryptor.DefaultLazyEncryptor;
import jud.cloud.common.core.constant.SecurityConstants;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class PasswordTest {
//    public static void main(String[] args) {
//        PasswordEncoder ENCODER = new BCryptPasswordEncoder();
//        String pwd = ENCODER.encode("pig");
//        System.out.println(pwd);
//    }
//    public static void main(String[] args) {
//        BasicTextEncryptor encryptor = new BasicTextEncryptor();
//        encryptor.setPassword("pig");
//        String encrypted = encryptor.encrypt("pig");
//        System.out.println(encrypted);

//        String pwd = new BCryptPasswordEncoder().encode("jud");
//        System.out.println(pwd);

        // 对应application-dev.yml 中配置的根密码
//        System.setProperty("jasypt.encryptor.password", "pig");
//        StringEncryptor stringEncryptor = new DefaultLazyEncryptor(new StandardEnvironment());
//
//        //加密方法
//        System.out.println(stringEncryptor.encrypt("pig"));
//
//        //解密方法
//        System.out.println(stringEncryptor.decrypt("cGlnOnBpZw=="));
//    }

//    @Test
//    public void testJasypt() {
//        // 对应application-dev.yml 中配置的根密码
//        System.setProperty("jasypt.encryptor.password", "pigxpigxpigxpigx");
//        StringEncryptor stringEncryptor = new DefaultLazyEncryptor(new StandardEnvironment());
//
//        //加密方法
//        System.out.println(stringEncryptor.encrypt("pig"));
//
//        //解密方法
//        System.out.println(stringEncryptor.decrypt("cGlnOnBpZw=="));
//    }

    private static final String PASSWORD = "password";
    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/CBC/NOPadding";

    public static void main(String[] args) throws Exception {
        String pass = "judcloudjudcloud";
        String data = "HaUen78mePW36D2QTCLnTQ==";
        String password = null;

        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        SecretKeySpec keyspec = new SecretKeySpec(pass.getBytes(), KEY_ALGORITHM);
        IvParameterSpec ivspec = new IvParameterSpec(pass.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
        byte[] result = cipher.doFinal(Base64.decode(data.getBytes(CharsetUtil.UTF_8)));
        password = new String(result, CharsetUtil.UTF_8);
        System.out.println(password);
    }
}
