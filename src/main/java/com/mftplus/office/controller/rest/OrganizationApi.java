package com.mftplus.office.controller.rest;

import jakarta.ws.rs.*;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import com.mftplus.office.model.entity.Organization;
import com.mftplus.office.model.service.OrganizationService;

@Path("/Organization")
public class OrganizationApi {
    @Inject
    private OrganizationService organizationService;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editOrganization(Organization organization) {
        try {
            System.out.println("Orgnization Api Edit : " + organization.toString());
            organizationService.edit(organization);
            return Response.ok().entity("Organization").build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletePrganization(@PathParam("id") Long id) {
        try {
            System.out.println("Organization Api Delete : " + id);
            return Response.accepted().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
