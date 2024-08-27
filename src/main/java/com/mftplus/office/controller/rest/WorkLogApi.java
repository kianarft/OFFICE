package com.mftplus.office.controller.rest;

import com.mftplus.office.model.entity.Employee;
import com.mftplus.office.model.entity.WorkLog;
import com.mftplus.office.model.service.WorkLogService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/WorkLog")
public class WorkLogApi {    @Inject
    private WorkLogService workLogService;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editWorkLog(WorkLog workLog) {
        try {
            System.out.println("WorkLog Api Edit : " + workLog.toString());
            workLogService.edit(workLog);
            return Response.ok().entity("WorkLog").build();

        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteWorkLog(@PathParam("id") Long id) {
        try {
            System.out.println("WorkLog Api Delete : " + id);
            workLogService.remove(id);
            return Response.accepted().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}

