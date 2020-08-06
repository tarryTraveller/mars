import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test1 {

    @Test
    public void aa(){
        String str = "1234";
        StringBuffer stringBuffer = new StringBuffer("1234");
        System.out.println(str==stringBuffer.toString());
    }
}
