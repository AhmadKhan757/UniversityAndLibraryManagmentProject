package firstproject.RestApplication.exception;

import org.slf4j.LoggerFactory;

import firstproject.RestApplication.Service.StudentService;
//import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.slf4j.Logger;




import java.util.Map;
import java.util.HashMap;

@RestControllerAdvice
public class StudentClassexceptions {

    private static final Logger log = LoggerFactory.getLogger(StudentService.class);

    @ExceptionHandler({Usernotfoundexception.class,IllegalArgumentException.class,NullPointerException.class})

    public ResponseEntity<Map<String,Object>> handlingExceptions(Exception exception) {
        HashMap<String, Object> errorResponse = new HashMap<>();
        log.error("Error" , exception);
        errorResponse.put("status", HttpStatus.BAD_REQUEST);
        errorResponse.put("error", " User not found OR Nullpointer exception");
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity <Map<String,Object>>
    handlemethodnotallowedException(Exception exception){
        Map <String,Object> errorResponse = new HashMap<>();
        log.error("Error",exception);
        errorResponse.put("error","Method not allowed");
        errorResponse.put("status",HttpStatus.METHOD_NOT_ALLOWED);

        return new ResponseEntity<>(errorResponse,HttpStatus.METHOD_NOT_ALLOWED);
    }




}
