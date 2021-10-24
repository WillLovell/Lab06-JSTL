/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Item;


/**
 *
 * @author awarsyle
 */
public class AccountServlet extends HttpServlet {

    ArrayList<Item> listItems = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setAttribute("username_session", session.getAttribute("username_s"));
        //ArrayList<Item> listItems = new ArrayList<>();
        if(request.getQueryString()!= null){
            if(request.getQueryString().equals("logout")){
            getServletContext().getRequestDispatcher("/WEB-INF/Register.jsp").forward(request,response);
            session.invalidate();
            session = request.getSession();
            }
        }
        if(session.getAttribute("ItemsList") != null){
            for(int i = 0; i < listItems.size(); i++){
            session.setAttribute("ItemsList", listItems);
            }
        }
        
        
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/Register.jsp").forward(request, response);
      return;
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession session = request.getSession();
        
       
        
        
        String username = request.getParameter("username_session");
        session.setAttribute("username_s", username);
        
        
        if(session.getAttribute("username_s") != null){
            session.setAttribute("username_session", session.getAttribute("username_s"));
        }
        
        

        
        
        
        if(request.getParameter("item") != null && !request.getParameter("item").equals("")){
        listItems.add(new Item((String)request.getParameter("item")));
        
            session.setAttribute("ItemsList",listItems);
  
        }
        
     
        if(request.getParameter("delete") != null){
        String checkDelete = request.getParameter("delete");
        
        
        if(checkDelete.equals("delete")){
        String deleted = request.getParameter("select");
        for(int i = 0; i <listItems.size(); i++)
        {
            if(deleted != null && deleted.equals(listItems.get(i).getItemName())){
                listItems.remove(i);
               session.setAttribute("ItemsList", listItems);
                
            }
        }
        
        
        }
        }
        
        
        //request.setAttribute("itemListFinal", listItems);
        
        //for each Item in listItems get item.getName()
        
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);
        return;
        
    }
}
