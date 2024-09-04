package com.mftplus.office.controller.servlet;

import com.mftplus.office.controller.validation.BeanValidator;
import com.mftplus.office.model.entity.Employee;
import com.mftplus.office.model.entity.WorkLog;
import com.mftplus.office.model.service.EmployeeService;
import com.mftplus.office.model.service.WorkLogService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {"workLog"}
        ),

        httpMethodConstraints =
        @HttpMethodConstraint(
                value = "GET",
                rolesAllowed = {"workLog"}
        )
)

@WebServlet("/workLog.do")
public class WorkLogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            WorkLog workLog1 =
                    WorkLog
                            .builder()
             //               .checkInTime()
              //              .checkOutTime()
                           .build();
            WorkLog workLog2 =
                    WorkLog
                            .builder()
                  //          .checkInTime()
                    //        .checkOutTime()
                            .build();

            BeanValidator<WorkLog> workLogBeanValidator = new BeanValidator<>();
            if (workLogBeanValidator.validate(workLog1).isEmpty()) {
                System.out.println(WorkLogService.getService().save(workLog1));
            } else {
                System.out.println(workLogBeanValidator.validate(workLog1));
            }

            System.out.println(WorkLogService.getService().save(workLog1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


