package com.mftplus.office.controller.rest;

import com.mftplus.office.model.entity.Role;
import com.mftplus.office.model.service.RoleService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/role")
public class RoleApi {
    @Inject
    private RoleService roleService;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editRole(Role role) {
        try {
            System.out.println("Role Api Edit : " + role.toString());
            roleService.edit(role);
            return Response.ok().entity("Role").build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
