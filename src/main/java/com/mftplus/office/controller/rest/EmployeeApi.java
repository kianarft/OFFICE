package com.mftplus.office.controller.rest;

import com.mftplus.office.model.entity.Employee;
import com.mftplus.office.model.service.EmployeeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Employee")
public class EmployeeApi {
    @Inject
    private EmployeeService employeeService;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editEmployee(Employee employee) {
        try {
            System.out.println("Employee Api Edit : " + employee.toString());
            employeeService.edit(employee);
            return Response.ok().entity("Employee").build();

        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEmployee(@PathParam("id") Long id) {
        try {
            System.out.println("Employee Api Delete : " + id);
            employeeService.remove(id);
            return Response.accepted().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
