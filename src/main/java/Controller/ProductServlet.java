package Controller;

import Models.Product;
import Services.CategoryService;
import Services.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/sanpham"})
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductService();
    CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher requestDispatcher;

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                req.setAttribute("listCategory", categoryService.listCategory);
                requestDispatcher = req.getRequestDispatcher("views/create.jsp");
                requestDispatcher.forward(req, resp);
                break;
            case "edit":
                int indexEdit = Integer.parseInt(req.getParameter("index"));
                req.setAttribute("listCategory", categoryService.listCategory);
                req.setAttribute("product", productService.listSP.get(indexEdit));
                requestDispatcher = req.getRequestDispatcher("views/edit.jsp");
                requestDispatcher.forward(req, resp);
                break;
            case "delete":
                int indexDelete = Integer.parseInt(req.getParameter("index"));
                try {
                    productService.delete(indexDelete);
                    resp.sendRedirect("/sanpham");
                } catch (Exception e) {
                    resp.sendRedirect("views/404.jsp");
                }
                break;
            case "findName":
                String name = req.getParameter("findName");
                try {
                    req.setAttribute("listSP", productService.findByName(name));
                    requestDispatcher = req.getRequestDispatcher("views/home.jsp");
                    requestDispatcher.forward(req, resp);
                } catch (Exception e) {
                    resp.sendRedirect("views/404.jsp");
                }
                break;
            case "thongbao" :
                requestDispatcher = req.getRequestDispatcher("views/thongbao.jsp");
                requestDispatcher.forward(req, resp);
            default:
                req.setAttribute("listSP", productService.listSP);
                requestDispatcher = req.getRequestDispatcher("views/home.jsp");
                requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher requestDispatcher;
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    String name = req.getParameter("name");
                    Double price = Double.valueOf(req.getParameter("price"));
                    int amount = Integer.parseInt(req.getParameter("amount"));
                    String color = req.getParameter("color");
                    String description = req.getParameter("description");
                    int idCategory = Integer.parseInt(req.getParameter("idCategory"));

                    Product product = new Product(name, price, amount, color, description, idCategory);
                    productService.save(product);
                    resp.sendRedirect("/sanpham");
                } catch (Exception e) {
                    resp.sendRedirect("views/404.jsp");
                }
                break;
            case "edit":
                try {
                    String name = req.getParameter("name");
                    Double price = Double.valueOf(req.getParameter("price"));
                    int amount = Integer.parseInt(req.getParameter("amount"));
                    String color = req.getParameter("color");
                    String description = req.getParameter("description");
                    int idCategory = Integer.parseInt(req.getParameter("idCategory"));

                    int index = Integer.parseInt(req.getParameter("index"));
                    Product productEidt = new Product(1,name, price, amount, color, description, idCategory);
                    productService.edit(productEidt,index);

                    req.setAttribute("listSP", productService.listSP);
                    requestDispatcher = req.getRequestDispatcher("views/home.jsp");
                    requestDispatcher.forward(req, resp);
                } catch (Exception e) {
                    resp.sendRedirect("views/404.jsp");
                }
        }
    }
}
