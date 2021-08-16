package Hello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello Example
 *
 * @author 恒宇少年
 */
@RestController
public class HelloExample {

    @GetMapping
    public String hello() {
        return "hello world!";
    }
}
