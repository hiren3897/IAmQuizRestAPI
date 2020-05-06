package fr.epita.quiz.resources;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;

import fr.epita.dataModel.Student;
import fr.epita.quiz.ErrorManager.CommonError;
import fr.epita.quiz.dto.UserDTO;
import fr.epita.quiz.service.dao.StudentDAO;

@Path("/User")
public class UserResources {
	
	@Inject
	StudentDAO studentDao;
	
	@POST
	@Path("/Authentication")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response LogInAuthentication(@RequestBody UserDTO userDTO) {
		
		if(userDTO.getEmail() == null || userDTO.getUsername() == null) {
			return Response.ok(new CommonError("Please Enter UserName And Email")).build();
		}
		
		Student student = studentDao.getById(userDTO.getUsername());
		if(student != null) {
			if(student.getUsername().equalsIgnoreCase(userDTO.getUsername()) && student.getEmail().equalsIgnoreCase(userDTO.getEmail())) {
				userDTO.setType(student.getType());
				return Response.status(Status.OK).entity(userDTO).build();
			}else {
				return Response.ok(new CommonError("User Not Registered. Please Register First")).build();
			}
		}else {
			return Response.ok(new CommonError("NO such User Exists. Please Register.")).build();
		}
		
	}
	
	@POST
	@Path("/register")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response registerUser(@RequestBody UserDTO userDTO) {
		
		if(userDTO.getEmail() == null || userDTO.getUsername() == null) {
			return Response.ok(new CommonError("Please Enter UserName And Email")).build();
		}
		
		Student student = new Student();
		student.setUsername(userDTO.getUsername());
		student.setEmail(userDTO.getEmail());
		student.setType(userDTO.getType());
		
		if(studentDao.getById(userDTO.getUsername()) == null) {
			try {
				studentDao.create(student);
				return Response.status(Status.OK).entity(userDTO).build();
			} catch (Exception e) {
				return Response.ok(new CommonError(e.getLocalizedMessage())).build();
			}
	
		}else {
			return Response.ok(new CommonError("User Already Exists")).build();
		}
			
	}
	
	

}
