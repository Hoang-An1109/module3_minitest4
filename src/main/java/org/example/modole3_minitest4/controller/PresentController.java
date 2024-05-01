package org.example.modole3_minitest4.controller;

import org.example.modole3_minitest4.model.Present;
import org.example.modole3_minitest4.service.IPresentService;
import org.example.modole3_minitest4.service.PresentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "presentcontroller", urlPatterns = "/present")
public class PresentController extends HttpServlet {
    private final IPresentService presentService = new PresentService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                createPresent(req, resp);
                break;
            }
            case "edit": {
                updatePresent(req, resp);
                break;
            }
            case "delete": {
                deletePresent(req, resp);
                break;
            }
            default: {
                break;
            }
        }
    }

    private void deletePresent(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));

        Present present = this.presentService.findById(id);
        RequestDispatcher dispatcher;

        if (present == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            this.presentService.remove(id);

            try {
                resp.sendRedirect("/present");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void updatePresent(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String ship = req.getParameter("ship");
        String img = req.getParameter("img");

        Present present = this.presentService.findById(id);
        RequestDispatcher dispatcher;

        if (present == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            present.setCode(code);
            present.setName(name);
            present.setPrice(price);
            present.setShip(ship);
            present.setImg(img);
            this.presentService.update(id, present);
            req.setAttribute("present", present);
            req.setAttribute("message", "Present information was updated");
            dispatcher = req.getRequestDispatcher("present/edit.jsp");
        }

        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createPresent(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String ship = req.getParameter("ship");
        String img = req.getParameter("img");

        Present present=new Present(id,code,name,price,ship,img);
        this.presentService.save(present);
        RequestDispatcher dispatcher= req.getRequestDispatcher("present/create.jsp");
        req.setAttribute("message", "New present was created");

        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                showDeleteForm(req, resp);
                break;
            case "view":
                viewPresents(req, resp);
                break;
            default:
                listPresents(req, resp);
                break;
        }
    }

    private void listPresents(HttpServletRequest req, HttpServletResponse resp) {
        List<Present> presents=this.presentService.findAll();
        req.setAttribute("present", presents);

        RequestDispatcher dispatcher= req.getRequestDispatcher("present/list.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void viewPresents(HttpServletRequest req, HttpServletResponse resp) {
        int id=Integer.parseInt(req.getParameter("id"));

        Present present=this.presentService.findById(id);
        RequestDispatcher dispatcher;
        if (present==null){
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        }else {
            req.setAttribute("present",present);
            dispatcher=req.getRequestDispatcher("present/view.jsp");
        }

        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) {
        int id=Integer.parseInt(req.getParameter("id"));

        Present present=this.presentService.findById(id);
        RequestDispatcher dispatcher;
        if (present==null){
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        }else {
            req.setAttribute("present",present);
            dispatcher=req.getRequestDispatcher("present/delete.jsp");
        }

        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        int id=Integer.parseInt(req.getParameter("id"));

        Present present=this.presentService.findById(id);
        RequestDispatcher dispatcher;
        if (present==null){
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        }else {
            req.setAttribute("present",present);
            dispatcher=req.getRequestDispatcher("present/edit.jsp");
        }

        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("present/create.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
