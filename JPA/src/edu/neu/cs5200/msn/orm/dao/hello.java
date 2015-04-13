package edu.neu.cs5200.msn.orm.dao;

import javax.ws.rs.*;

@Path("/hello")
public class hello {
	@GET
	@Path("/")
	public String sayHello()
	{
		return "Hello";
	}

}
