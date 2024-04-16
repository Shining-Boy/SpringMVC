package hello.servlet.web.frontcontroller.v2;

import java.io.IOException;
import javax.sql.rowset.serial.SerialException;
import hello.servlet.web.frontcontroller.MyView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ControllerV2 {
        MyView process(HttpServletRequest request, HttpServletResponse response) throws SerialException, IOException;
} 
