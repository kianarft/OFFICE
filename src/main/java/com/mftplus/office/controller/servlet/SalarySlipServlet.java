package com.mftplus.office.controller.servlet;
import com.mftplus.office.controller.validation.BeanValidator;
import com.mftplus.office.model.entity.SalarySlip;
import com.mftplus.office.model.service.SalarySlipService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {"employee"}
        ),

        httpMethodConstraints =
        @HttpMethodConstraint(
                value = "GET",
                rolesAllowed = {"salarySlip"}
        )
)

@WebServlet("/SalarySlip.do")
public class SalarySlipServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            SalarySlip salarySlip1 =
                    SalarySlip
                            .builder()
                            .month("aban")
                            .totalSalary("10m")
                            .totalHours("43")
                            .bonus("0")
                            .build();

            SalarySlip salarySlip2 =
                    SalarySlip
                            .builder()
                            .month("mehr")
                            .totalSalary("8m")
                            .totalHours("30")
                            .bonus("0")
                            .build();


            BeanValidator<SalarySlip> salarySlipBeanValidator = new BeanValidator<>();
            if (salarySlipBeanValidator.validate(salarySlip1).isEmpty()) {
                System.out.println(SalarySlipService.getService().save(salarySlip1));
            } else {
                System.out.println(salarySlipBeanValidator.validate(salarySlip1));
            }

            System.out.println(SalarySlipService.getService().save(salarySlip2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
