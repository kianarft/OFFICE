package com.mftplus.office.controller.servlet;
import com.mftplus.office.controller.validation.BeanValidator;
import  com.mftplus.office.model.entity.Employee;
import com.mftplus.office.model.service.EmployeeService;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {"employee"}
        ),

        httpMethodConstraints =
        @HttpMethodConstraint(
                value = "GET",
                rolesAllowed = {"employee"}
        )
)

@WebServlet("/employee.do")
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Employee employee1 =
                    Employee
                            .builder()
                            .nameEmployee("aaa")
                            .positionEmployee("bbb")
                            .hourlyPayment(12)
                            .build();

            Employee employee2 =
                    Employee
                            .builder()
                            .nameEmployee("ccc")
                            .positionEmployee("ddd")
                            .hourlyPayment(5)
                            .build();

            BeanValidator<Employee> employeeBeanValidator = new BeanValidator<>();
            if (employeeBeanValidator.validate(employee1).isEmpty()) {
                assert EmployeeService.getService() != null;
                System.out.println(EmployeeService.getService().save(employee1));
            } else {
                System.out.println(employeeBeanValidator.validate(employee1));
            }

            assert EmployeeService.getService() != null;
            System.out.println(EmployeeService.getService().save(employee2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


