package it.ITSincom.WebDev.rest;

import it.ITSincom.WebDev.persistance.model.Partner;
import it.ITSincom.WebDev.service.PartnerService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/partners")
public class PartnerResource {
    private final PartnerService partnerService;

    public PartnerResource(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPartners() {
        List<Partner> partners = partnerService.getAllPartners();
        return Response.ok(partners).build();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPartnersByName(@PathParam("name") String name) {
        List<Partner> partners = partnerService.getPartnersByName(name);
        return Response.ok(partners).build();
    }

}