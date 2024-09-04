package com.mftplus.office.controller.servlet;

import com.mftplus.office.controller.validation.BeanValidator;
import  com.mftplus.office.model.entity.Role;
import com.mftplus.office.model.service.RoleService;
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
                rolesAllowed = {"role"}
        ),

        httpMethodConstraints =
        @HttpMethodConstraint(
                value = "GET",
                rolesAllowed = {"role"}
        )
)

@WebServlet("/role.do")
public class RoleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Role role1 =
                    Role
                            .builder()
                            .nameRole("aaa")
                            .descriptionRole("bbb")
                            .build();

            Role role2 =
                    Role
                            .builder()
                            .nameRole("ccc")
                            .descriptionRole("ddd")
                            .build();

            BeanValidator<Role> roleBeanValidator = new BeanValidator<>();
            if (roleBeanValidator.validate(role1).isEmpty()) {
                assert RoleService.getService() != null;
                System.out.println(RoleService.getService().save(role1));
            } else {
                System.out.println(roleBeanValidator.validate(role1));
            }

            assert RoleService.getService() != null;
            System.out.println(RoleService.getService().save(role2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


