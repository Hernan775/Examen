
package com.emergentes.controlador;

import com.emergentes.gestion.Lista;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        Lista objCalificacion = new Lista();
        int id, pos;
        
        HttpSession ses = request.getSession();
        ArrayList<Lista> lista = (ArrayList<Lista>) ses.getAttribute("listaCalificacion");
        switch(op){
            case "nuevo":
                request.setAttribute("miObjetoCalificacion", objCalificacion);
                request.setAttribute("titulo", "Nuevo Registro");
                request.setAttribute("boton", "Agregar");
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request, id);
                
                objCalificacion = lista.get(pos);
                
                request.setAttribute("miObjetoCalificacion", objCalificacion);
                request.setAttribute("titulo", "Modificar Registro");
                request.setAttribute("boton", "Modificar");
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request, id);
                if (pos >= 0) {
                    lista.remove(pos);
                }
                request.setAttribute("miObjetoCalificacion", lista);
                response.sendRedirect(request.getContextPath()+"/index.jsp");
                break;
            default:
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("txtId"));
        HttpSession ses = request.getSession();
        ArrayList<Lista> lista = (ArrayList<Lista>) ses.getAttribute("listaCalificacion");
        Lista objCalificacion = new Lista();
        objCalificacion.setId(id);
        objCalificacion.setNombre(request.getParameter("txtNombre"));
        objCalificacion.setP1(Double.parseDouble(request.getParameter("txtP1")));
        objCalificacion.setP2(Double.parseDouble(request.getParameter("txtP2")));
        objCalificacion.setEf(Double.parseDouble(request.getParameter("txtEf")));
        if(id == 0){
            int idNuevo = obtenerId(request);
            objCalificacion.setId(idNuevo);
            lista.add(objCalificacion);
        }else{
            int pos = buscarPorIndice(request, id);
            lista.set(pos, objCalificacion);
        }
        request.setAttribute("miObjetoCalificacion", lista);
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
    
    public int buscarPorIndice(HttpServletRequest request, int id){
        HttpSession ses = request.getSession();
        ArrayList<Lista> lista = (ArrayList<Lista>) ses.getAttribute("listaCalificacion");
        
        int pos = -1;
        if (lista != null) {
            for(Lista ele : lista){
                pos++;
                if(ele.getId() == id){
                    break;
                }
            }
        }
        return pos;
    }
    
    public int obtenerId(HttpServletRequest request){
        HttpSession ses = request.getSession();
        ArrayList<Lista> lista = (ArrayList<Lista>) ses.getAttribute("listaCalificacion");
        
        int idn = 0;
        for(Lista ele : lista){
            idn = ele.getId();
        }
        
        return idn+1;
    }


}