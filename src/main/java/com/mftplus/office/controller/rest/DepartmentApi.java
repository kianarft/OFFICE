package com.mftplus.office.controller.rest;

import com.mftplus.office.model.entity.Department;
import com.mftplus.office.model.service.DepartmentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


    @Path("/Department")
    public class DepartmentApi {
        @Inject
        private DepartmentService departmentService;

        @PUT
        @Consumes(MediaType.APPLICATION_JSON)
        public Response editDepartment(Department department) {
            try {
                System.out.println("Department Api Edit : " + department.toString());
                departmentService.edit(department);
                return Response.ok().entity("Department").build();

            } catch (Exception e) {
                return Response.serverError().build();
            }
        }

        @DELETE
        @Path("/{id}")
        public Response deleteDepartment(@PathParam("id") Long id) {
            try {
                System.out.println("Department Api Delete : " + id);
                departmentService.remove(id);
                return Response.accepted().build();
            } catch (Exception e) {
                return Response.serverError().build();
            }
        }
    }
