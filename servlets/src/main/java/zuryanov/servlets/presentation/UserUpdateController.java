package zuryanov.servlets.presentation;

import zuryanov.servlets.logic.Validate;
import zuryanov.servlets.logic.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Alexei Zuryanov (zuryanovalexei@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class UserUpdateController extends HttpServlet {
    private final Validate logic = ValidateService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("id", req.getParameter("id"));
        req.setAttribute("user", logic.findById(Integer.parseInt(req.getParameter("id"))));

        HttpSession session = req.getSession();
        session.setAttribute("countriesupdate", ((ValidateService) logic).findCountry());
        session.setAttribute("citiesupdate", ((ValidateService) logic).findCity());
        session.setAttribute("countryattr", ((ValidateService) logic).findCountryById(Integer.parseInt(req.getParameter("id"))));
        session.setAttribute("cityattr", ((ValidateService) logic).findCityById(Integer.parseInt(req.getParameter("id"))));
        req.getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logic.update(Integer.parseInt(req.getParameter("id")), req.getParameter("login"), req.getParameter("countryname"), req.getParameter("cityname"));
        resp.sendRedirect(String.format("%s/list", req.getContextPath()));
    }
}
