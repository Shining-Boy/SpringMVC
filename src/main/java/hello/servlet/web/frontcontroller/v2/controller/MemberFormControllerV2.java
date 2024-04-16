package hello.servlet.web.frontcontroller.v2.controller;

import java.io.IOException;

import javax.sql.rowset.serial.SerialException;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberFormControllerV2 implements ControllerV2{

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws SerialException, IOException {
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
    
}
