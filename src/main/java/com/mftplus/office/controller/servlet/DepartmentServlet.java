package com.mftplus.office.controller.servlet;

import java.io.IOException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.HttpConstraint;
import com.mftplus.office.model.entity.Department;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.HttpMethodConstraint;
import com.mftplus.office.model.service.DepartmentService;
import com.mftplus.office.controller.validation.BeanValidator;


@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {"department"}
        ),

        httpMethodConstraints =
        @HttpMethodConstraint(
                value = "GET",
                rolesAllowed = {"department"}
        )
)

@WebServlet("/department.do")
public class DepartmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Department department1 =
                    Department
                            .builder()
                            .departmentName("aaa")
                            .descriptionDepartment("ddd")
                            .build();

            Department department2 =
                    Department
                            .builder()
                            .departmentName("ccc")
                            .descriptionDepartment("bbb")
                            .build();


            BeanValidator<Department> departmentBeanValidator = new BeanValidator<>();
            if (departmentBeanValidator.validate(department1).isEmpty()) {
                assert DepartmentService.getService() != null;
                System.out.println(DepartmentService.getService().save(department1));
            } else {
                System.out.println(departmentBeanValidator.validate(department1));
            }

            assert DepartmentService.getService() != null;
            System.out.println(DepartmentService.getService().save(department2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


