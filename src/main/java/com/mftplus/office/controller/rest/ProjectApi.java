package com.mftplus.office.controller.rest;

import com.mftplus.office.model.entity.Project;
import com.mftplus.office.model.service.ProjectService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Project")
public class ProjectApi {
    @Inject
    private ProjectService ProjectService;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editProject(Project project) {
        try {
            System.out.println("Project Api Edit : " + project.toString());
            ProjectService.edit(project);
            return Response.ok().entity("Project").build();

        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProject(@PathParam("id") Long id) {
        try {
            System.out.println("Project Api Delete : " + id);
            ProjectService.remove(id);
            return Response.accepted().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
