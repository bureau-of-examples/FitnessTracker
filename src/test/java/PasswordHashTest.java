import org.junit.Test;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashTest {

    @Test
    public void testMd5Hash(){
        Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
        String hash = passwordEncoder.encodePassword("zhy2002", null);
        System.out.println(hash);

        hash = passwordEncoder.encodePassword("zhy2003", null);
        System.out.println(hash);
    }

    @Test
    public void testBcrypt(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hash = passwordEncoder.encode("zhy2002");
        System.out.println(hash);

        hash = passwordEncoder.encode("zhy2003");
        System.out.println(hash);

        hash = passwordEncoder.encode("zhy2004");
        System.out.println(hash);
    }
}
