package pro.sky.java.course2.homework10libraries;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotFoundEmployeeException extends RuntimeException {
}
