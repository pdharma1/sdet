package com.fnmae.endpoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fnmae.beans.Message;
import com.fnmae.endpoint.impl.RestStringImpl;

@Path("/delete")
public class RestStringEndpoint {
	private static RestStringImpl impl = new RestStringImpl();

	// TODO: Returns a 500
	@Path("/{author}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	// public List<Message> deleteMessageByAuthor(@PathParam("author") String
	// author) {
	public List<Message> deleteMessagesByAuthor(@PathParam("author") String author) {
		System.out.println("Delete endpoint hit.");
		return impl.deleteMessagesByAuthor(author);
	}

	// TODO: Returns a 500
	@Path("/{author}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessagesByAuthor(@PathParam("author") String author) {
		return impl.getMessagesByAuthor(author);
	}
}
