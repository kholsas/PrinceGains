package za.co.applications.ws.ordermanager.rest;

import za.co.applications.ws.ordermanager.model.Customer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//http://localhost:8080/OrderRestFulWS/rest/test/sample
@Path("/test")
public class MessageRestService {


	@GET
	@Path("/sample")
	public Response printMessage() {

		String result = "{\"customer\":{\"@id\":\"2\",\"dateOfBirth\":\"2016-09-16T16:18:19.119+02:00\",\"firstName\":\"Lehlogonolo\",\"lastName\":\"Maloma\"}}";

		return Response.status(200).entity(result).build();

	}


    @GET
    @Produces({"application/json"})
    @Path("/customer/{id}")
    public Customer getCustomers(@PathParam("id") int id) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("Lehlogonolo");
        customer.setLastName("Maloma");
        customer.setDateOfBirth(new Date());
        return customer;
    }


    @GET
    @Produces("application/json")
    @Path("/customers")
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("Lehlogonolo");
        customer.setLastName("Maloma");
        customer.setDateOfBirth(new Date());

        customerList.add(customer);

        customer = new Customer();
        customer.setId(2);
        customer.setFirstName("Kholofelo");
        customer.setLastName("Sekgobane");
        customer.setDateOfBirth(new Date(1487222115));

        customerList.add(customer);
        return customerList;
    }

}