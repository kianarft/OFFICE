package com.mftplus.office.controller.servlet;

import java.io.IOException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import com.mftplus.office.model.entity.Task;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import com.mftplus.office.model.service.TaskService;
import jakarta.servlet.annotation.HttpMethodConstraint;
import com.mftplus.office.controller.validation.BeanValidator;

@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {"task"}
        ),

        httpMethodConstraints =
        @HttpMethodConstraint(
                value = "GET",
                rolesAllowed = {"task"}
        )
)

@WebServlet("/task.do")
public class TaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Task task1 =
                    Task
                            .builder()
                            .taskName("aaa")
                            .build();

            Task task2 =
                    Task
                            .builder()
                            .taskName("ccc")
                            .build();


            BeanValidator<Task> taskBeanValidator = new BeanValidator<>();
            if (taskBeanValidator.validate(task1).isEmpty()) {
                assert TaskService.getService() != null;
                System.out.println(TaskService.getService().save(task1));
            } else {
                System.out.println(taskBeanValidator.validate(task1));
            }

            assert TaskService.getService() != null;
            System.out.println(TaskService.getService().save(task2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
