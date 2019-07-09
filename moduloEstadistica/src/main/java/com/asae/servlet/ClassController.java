package com.asae.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*import com.asae.ejbinterface.IEjbUsuario;
import com.asae.jb.JbUsuario;*/

public class ClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String EJBGestionUsuarios_SESSION_KEY = "EJBSesionUsuarios";  
	
	private IEjbUsuario iEjbUsuario;
	
    public usuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		consultarReferenciaEJB(request);
		
		String tipoOperacion = request.getParameter("tipoOperacion");
	
		if(tipoOperacion.equals("editar"))
		{
			
			String email = request.getParameter("email");
			System.out.println("email "+email);
			iEjbUsuario.getByCorreoElectronico(email);
			JbUsuario jbUsuario=new JbUsuario();
			jbUsuario.setIdUsuario(iEjbUsuario.getUsuario().getIdUsuario());
			jbUsuario.setNombre(iEjbUsuario.getUsuario().getNombre());
			jbUsuario.setApellido(iEjbUsuario.getUsuario().getApellido());
			jbUsuario.setFechaNacimiento(iEjbUsuario.getUsuario().getFechaNacimiento());
			jbUsuario.setCorreoElectronico(iEjbUsuario.getUsuario().getCorreoElectronico());
			jbUsuario.setContrasenia(iEjbUsuario.getUsuario().getContrasenia());
			jbUsuario.setFechaRegistro(iEjbUsuario.getUsuario().getFechaRegistro());
			jbUsuario.setFechaModificacion(iEjbUsuario.getUsuario().getFechaModificacion());
			
			request.setAttribute("usuario", jbUsuario);
			
			request.getRequestDispatcher("usuario/editar.jsp").forward(request, response);
			System.out.println("ServletUsuarioEditar:Saliendo de doGet()...");
		}		
		else if(tipoOperacion.equals("listar")){
			System.out.println("ServletUsuarioListar: Entrando de doGet()...");
			
			
			
			
			System.out.println("paso l2...");
			List<JbUsuario> listaJbUsuario=new ArrayList<JbUsuario>();
			System.out.println("paso l3...");
			
			List<JbUsuario> listaUsuarios= iEjbUsuario.getListaUsuarios();		
			
			
			request.setAttribute("listaUsuario", listaJbUsuario);
			
			request.getRequestDispatcher("usuario/listar.jsp").forward(request, response);
	    	
	    	
	    	System.out.println("ServletUsuarioListar:Saliendo de doGet()...");
		}else if(tipoOperacion.equals("eliminar")){
			System.out.println("ServletUsuarioEliminar: En doPost()...");
			
			iEjbUsuario.getByCorreoElectronico(request.getParameter("email"));
			
			iEjbUsuario.remove();
			
			List<JbUsuario> listaUsuarios= iEjbUsuario.getListaUsuarios();			

			request.setAttribute("listaUsuario", listaUsuarios);

			request.getRequestDispatcher("usuario/listar.jsp").forward(request, response);

		}else
		{
			if(request.getParameter("session")!=null && request.getParameter("session").compareTo("finalizar")==0)
			{
				this.iEjbUsuario.finalizarEJB();
				System.out.println("finalizando session");
				
			}
			else
			{
				response.getWriter().append("Served at: ").append(request.getContextPath());
				request.getRequestDispatcher("usuario/insertar.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		consultarReferenciaEJB(request);
		String tipoOperacion = request.getParameter("tipoOperacion");
		
		switch(tipoOperacion)
		{
			case "Registrarme":
				try
				{				
					iEjbUsuario.insert(request.getParameter("txtNombre"), request.getParameter("txtApellido"), request.getParameter("passContrasenia"), request.getParameter("dateFechaNacimiento"), request.getParameter("txtCorreoElectronico"));
					
					request.getRequestDispatcher("usuario/insertar.jsp").forward(request, response);
				}
				catch(Exception ex)
				{
					System.out.println("Error en insertar: "+ex.getMessage());
				}
			break;
			case "Actualizar":
				
				iEjbUsuario.getByCorreoElectronico(request.getParameter("txtCorreoElectronico"));				
				iEjbUsuario.getUsuario().setNombre(request.getParameter("txtNombre"));
				iEjbUsuario.getUsuario().setApellido(request.getParameter("txtApellido"));
				iEjbUsuario.getUsuario().setFechaNacimiento(request.getParameter("dateFechaNacimiento"));
				iEjbUsuario.getUsuario().setCorreoElectronico(request.getParameter("txtCorreoElectronico"));
				
				iEjbUsuario.update();
				
				request.getRequestDispatcher("usuario/listar.jsp").forward(request, response);
			break;
		}
		
	}
	
	public void consultarReferenciaEJB(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
    	this.iEjbUsuario = (IEjbUsuario) session.getAttribute(EJBGestionUsuarios_SESSION_KEY);
    	 
         if(this.iEjbUsuario == null){
	                         
	        	
				try {
					InitialContext ic = new InitialContext();
					this.iEjbUsuario = (IEjbUsuario) ic.lookup("java:global/webappagenda-1.0-SNAPSHOT/EjbUsuario!com.asae.ejbinterface.IEjbUsuario");
			        	 
					
					 session.setAttribute(EJBGestionUsuarios_SESSION_KEY, this.iEjbUsuario);
								        
			        System.out.println("ejb para la gestión de usuarios creado");
			        
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
         }
	}
}
