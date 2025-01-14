package com.mftplus.office.controller.servlet;

import java.io.IOException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import com.mftplus.office.model.entity.Phase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import com.mftplus.office.model.service.PhaseService;
import jakarta.servlet.annotation.HttpMethodConstraint;
import com.mftplus.office.controller.validation.BeanValidator;

@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {"phase"}
        ),

        httpMethodConstraints =
        @HttpMethodConstraint(
                value = "GET",
                rolesAllowed = {"phase"}
        )
)

@WebServlet("/phase.do")
public class PhaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Phase phase1 =
                    Phase
                            .builder()
                            .phaseName("ppp")
                            .build();

            Phase phase2 =
                    Phase
                            .builder()
                            .phaseName("qqq")
                            .build();

            BeanValidator<Phase> phaseBeanValidator = new BeanValidator<>();
            if (phaseBeanValidator.validate(phase1).isEmpty()) {
                assert PhaseService.getService() != null;
                System.out.println(PhaseService.getService().save(phase1));
            } else {
                System.out.println(phaseBeanValidator.validate(phase1));
            }

            assert PhaseService.getService() != null;
            System.out.println(PhaseService.getService().save(phase2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
