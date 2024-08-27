package com.mftplus.office.controller.rest;
import com.mftplus.office.model.entity.SalarySlip;
import com.mftplus.office.model.service.SalarySlipService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/SalarySlip")
public class SalarySlipApi {    @Inject
    private SalarySlipService salarySlipService;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editSalarySlip(SalarySlip salarySlip) {
        try {
            System.out.println("SalarySlip Api Edit : " + salarySlip.toString());
            salarySlipService.edit(salarySlip);
            return Response.ok().entity("SalarySlip").build();

        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSalarySlip(@PathParam("id") Long id) {
        try {
            System.out.println("SalarySlip Api Delete : " + id);
            salarySlipService.remove(id);
            return Response.accepted().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}

