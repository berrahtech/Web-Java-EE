package filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

// Filtre pour journaliser les requêtes
public class LoggingFilter implements Filter {

    // Initialisation du filtre
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoggingFilter initialisé");
    }

    // Interception des requêtes
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Récupération du chemin de la requête
        String path = request.getServletContext().getContextPath() + ((HttpServletRequest) request).getServletPath();
        // Affichage dans la console
        System.out.println("Requête interceptée : " + path);
        // Poursuite de la chaîne de traitement
        chain.doFilter(request, response);
    }

    // Destruction du filtre
    @Override
    public void destroy() {
        System.out.println("LoggingFilter détruit");
    }
}