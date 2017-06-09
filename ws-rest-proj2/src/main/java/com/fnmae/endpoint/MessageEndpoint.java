package com.fnmae.endpoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fnmae.beans.Message;
import com.fnmae.endpoint.impl.MessageEndpointImpl;

@Path("/message")
public class MessageEndpoint {

	private static MessageEndpointImpl impl = new MessageEndpointImpl();

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessages() {
		return impl.getAllMessages();
	}

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessageById(@PathParam("id") int id) {
		return impl.getMessageById(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message saveMessage(Message message) {
		return impl.saveMessage(message);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(Message message) {
		return impl.updateMessage(message);
	}

	@Path("/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message deleteMessage(@PathParam("id") int id) {
		Message deleted = impl.deleteMessage(id);
		if (!deleted.equals(null)) {
			deleted.setText(deleted.getText() + " - Deleted");
			return deleted;
		} else {
			deleted.setText(deleted.getText() + " - DID NOT Delete");
			return deleted;
		}
	}
}
