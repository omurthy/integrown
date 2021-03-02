package org.omuralcin;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.tempuri.CalculatorSoap;
import org.omuralcin.FruitWebService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@Tag(name = "default")
public class NumberConversionResource {

    @Inject CalculatorSoap service;
    @Inject FruitWebService fruitWebService;

    @POST
    @Path("{number1}/{number2}")
    @Produces(MediaType.TEXT_PLAIN)
    public int get(@PathParam("number1") int number1, @PathParam("number2") int number2) {
        return service.add(number1, number2);
    }

    @GET
    @Path("/fruit")
    @Produces(MediaType.TEXT_XML)
    public List<Fruit> getFruitList() {
        return fruitWebService.list();
    }
}
