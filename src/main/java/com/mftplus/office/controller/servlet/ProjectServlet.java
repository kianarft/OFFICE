package com.mftplus.office.controller.servlet;

import com.mftplus.office.controller.validation.BeanValidator;
import com.mftplus.office.model.entity.Project;
import com.mftplus.office.model.service.ProjectService;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import static com.mftplus.office.model.service.ProjectService.getService;

@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {"project"}
        ),

        httpMethodConstraints =
        @HttpMethodConstraint(
                value = "GET",
                rolesAllowed = {"project"}
        )
)

@WebServlet("/project.do")
public class ProjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Project project1 =
                    Project
                            .builder()
                            .projectName("aaa")
//                            .projectStartDate()
//                            .projectEndDate()
                            .build();

            Project project2 =
                    Project
                            .builder()
                            .projectName("bbb")
//                            .projectStartDate()
//                            .projectEndDate()
                            .build();

            BeanValidator<Project> projectBeanValidator = new BeanValidator<>();
            if (projectBeanValidator.validate(project1).isEmpty()) {
//                assert getService() != null;
//                System.out.println(getService().save(project1));
            } else {
                System.out.println(projectBeanValidator.validate(project1));
            }

//            assert getService() != null;
//            System.out.println(getService().save(project2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


