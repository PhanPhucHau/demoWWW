package com.example.demo2.resource;

import com.example.demo2.business.NhanVienBL;
import com.example.demo2.resource.model.Nhanvien;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.util.List;

@Path("/nhanvien")
public class NhanVienResource {
    @Inject
    private NhanVienBL nhanVienBL;


    @GET
    @Produces(MediaType.TEXT_HTML)
    public void getAllNhanVien(@Context HttpServletRequest request, @Context HttpServletResponse response) throws ServletException, IOException {
        List<Nhanvien> nhanviens = nhanVienBL.getNhanVien();
        request.setAttribute("nhanvien", nhanviens);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    @POST
    @Path("/delete")
    public Response deleteNhanVien(@FormParam("id") int id){
        boolean b = nhanVienBL.deleteById(id);
        if (b) {
            return Response.ok("xoa thanh cong").build();
        }
        return Response.status(404).build();
    }
}
