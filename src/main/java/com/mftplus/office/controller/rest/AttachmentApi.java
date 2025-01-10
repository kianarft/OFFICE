package com.mftplus.office.controller.rest;

import com.mftplus.office.model.service.EmployeeService;
import jakarta.ws.rs.*;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import com.mftplus.office.model.entity.Attachment;
import com.mftplus.office.model.service.AttachmentService;

@Path("/Attachment")
public class AttachmentApi {
    @Inject
    private AttachmentService attachmentService;
    @Inject
    private EmployeeService employeeService;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAttachment(Attachment attachment) {
        try {
            System.out.println("Attachment Api Edit : " + attachment.toString());
            attachmentService.edit(attachment);
            return Response.ok().entity("Attachment").build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAttachment(@PathParam("id") String id) {
        try {
            System.out.println("Attachment Api Delete : " + id);
            return Response.accepted().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
