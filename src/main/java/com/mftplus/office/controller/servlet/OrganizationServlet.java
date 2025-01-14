package com.mftplus.office.controller.servlet;

import java.io.IOException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import com.mftplus.office.model.entity.Organization;
import jakarta.servlet.annotation.HttpMethodConstraint;
import com.mftplus.office.model.service.OrganizationService;
import com.mftplus.office.controller.validation.BeanValidator;

@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {"organization"}
        ),

        httpMethodConstraints =
        @HttpMethodConstraint(
                value = "GET",
                rolesAllowed = {"organization"}
        )
)

@WebServlet("/organization.do")
public class OrganizationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Organization organization1 =
                    Organization
                            .builder()
                            .organizationName("fff")
                            .build();

            Organization organization2 =
                    Organization
                            .builder()
                            .organizationName("ddd")
                            .build();

            BeanValidator<Organization> organizationBeanValidator = new BeanValidator<>();
            if (organizationBeanValidator.validate(organization1).isEmpty()) {
                assert OrganizationService.getService() != null;
                System.out.println(OrganizationService.getService().save(organization1));
            } else {
                System.out.println(organizationBeanValidator.validate(organization1));
            }

            assert OrganizationService.getService() != null;
            System.out.println(OrganizationService.getService().save(organization2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
