package com.rain.rest;

import com.google.gson.Gson;
import com.rain.pojo.MessageCode;
import com.rain.pojo.Student;
import com.rain.util.TimeComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rain
 * created on 2018/4/22
 */
@Component
@Path("/student")
public class StudentResource {
    private TimeComponent timeComponent;

    @Autowired
    public StudentResource(TimeComponent timeComponent) {
        this.timeComponent = timeComponent;
    }

    private static Gson gson = new Gson();
    private static List<Student> students = new ArrayList<>(12);
    private static MessageCode messageCode = new MessageCode("500", "Server Internal Error");

    static {
        Student student = new Student("汪润", 25, "湖北省武汉市新洲区", "REST资源测试");
        students.add(student);
    }

    @GET
    @Path("/{studentId}")
    @Produces({"application/json"})
    public String get(@PathParam("studentId") Integer studentId) {
        return students.size() > studentId ? gson.toJson(students.get(studentId)) : gson.toJson(messageCode);
    }

    @POST
    @Produces({"application/json"})
    public String post(@FormParam("name") String name, @FormParam("age") Integer age, @FormParam("address")
            String address, @FormParam("comment") String comment) {
        students.add(new Student(name, age, address, comment));
        return gson.toJson(new MessageCode("200", "ok"));
    }

    @GET
    @Path("/time")
    @Produces({"text/plain"})
    public String time() {
        return gson.toJson(timeComponent.getTime());
    }
}