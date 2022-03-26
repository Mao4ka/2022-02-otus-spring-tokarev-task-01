import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.application.Application;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        Application application = context.getBean(Application.class);
        application.studentSurvey();
    }

}
