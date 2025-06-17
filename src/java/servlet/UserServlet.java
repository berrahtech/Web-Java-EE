package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Annotation pour mapper le servlet à l'URL /userServlet
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    // Liste statique pour stocker tous les utilisateurs en mémoire
    private static List<User> users = new ArrayList<>();

    // Méthode doGet : Affiche le formulaire initial
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirige vers userForm.jsp
       // request.getRequestDispatcher("/jsp/userForm.jsp").forward(request, response);
        // Récupération des paramètres du formulaire
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");

        // Validation côté serveur
        if (nom == null || nom.trim().isEmpty() || email == null || email.trim().isEmpty()) {
            // Message d'erreur si les champs sont vides
            request.setAttribute("errorMessage", "Veuillez remplir tous les champs !");
            request.getRequestDispatcher("/jsp/userForm.jsp").forward(request, response);
            return;
        }

        // Création d'un nouvel utilisateur
        User user = new User(nom, email);

        // Ajout à la liste des utilisateurs
        users.add(user);

        // Récupération de la session
        HttpSession session = request.getSession();
        // Stockage de l'utilisateur courant dans la session
        session.setAttribute("currentUser", user);
        // Stockage de la liste des utilisateurs dans la session
        session.setAttribute("users", users);

        // Redirection vers userDetails.jsp
        response.sendRedirect("jsp/userDetails.jsp");
    }

    // Méthode doPost : Traite les données du formulaire
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupération des paramètres du formulaire
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");

        // Validation côté serveur
        if (nom == null || nom.trim().isEmpty() || email == null || email.trim().isEmpty()) {
            // Message d'erreur si les champs sont vides
            request.setAttribute("errorMessage", "Veuillez remplir tous les champs !");
            request.getRequestDispatcher("jsp/userForm.jsp").forward(request, response);
            return;
        }

        // Création d'un nouvel utilisateur
        User user = new User(nom, email);

        // Ajout à la liste des utilisateurs
        users.add(user);

        // Récupération de la session
        HttpSession session = request.getSession();
        // Stockage de l'utilisateur courant dans la session
        session.setAttribute("currentUser", user);
        // Stockage de la liste des utilisateurs dans la session
        session.setAttribute("users", users);

        // Redirection vers userDetails.jsp
        response.sendRedirect("jsp/userDetails.jsp");
    }
}