/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.46
 * Generated at: 2017-10-23 01:19:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import edu.tecnopotify.entidades.Artista;
import edu.tecnopotify.entidades.Usuario;
import edu.tecnopotify.fabrica.Fabrica;
import edu.tecnopotify.interfaces.IControlador;

public final class mostrarArtista_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.util.Iterator");
    _jspx_imports_classes.add("edu.tecnopotify.entidades.Artista");
    _jspx_imports_classes.add("edu.tecnopotify.entidades.Usuario");
    _jspx_imports_classes.add("edu.tecnopotify.fabrica.Fabrica");
    _jspx_imports_classes.add("edu.tecnopotify.interfaces.IControlador");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Datos Artista</title>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/templates/csss.jsp", out, false);
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/templates/header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("        <h1>Datos Artista</h1>\n");
      out.write("        \n");
      out.write("        ");

            List<String> listAl = (ArrayList) request.getAttribute("albumArt");
            Iterator<String> itAl = listAl.iterator();
        
        
        
      out.write("\n");
      out.write("\n");
      out.write("        <form   method = \"post\" >\n");
      out.write("            <input type=\"hidden\"  name=\"comando\" value=\"mostrarArtista\" />\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <h6>NickName: </h6>\n");
      out.write("                <input type=\"text\"  value =");
      out.print( request.getAttribute("nickName"));
      out.write(" /> <br/>\n");
      out.write("                <h6>Nombre: </h6>\n");
      out.write("                <input type=\"text\"  value =");
      out.print( request.getAttribute("nombre"));
      out.write(" /> <br/>\n");
      out.write("                <h6>Apellido </h6>\n");
      out.write("                <input type=\"text\"  value =");
      out.print( request.getAttribute("apellido"));
      out.write(" /> <br/>\n");
      out.write("                <h6>Mail: </h6>\n");
      out.write("                <input type=\"text\"  value =");
      out.print( request.getAttribute("mail"));
      out.write(" /> <br/>\n");
      out.write("                <h6>Fecha de Nacimiento: </h6>\n");
      out.write("                <input type=\"text\"  value =");
      out.print( request.getAttribute("dia"));
      out.write(" /> / \n");
      out.write("                <input type=\"text\"  value =");
      out.print( request.getAttribute("mes"));
      out.write(" />\n");
      out.write("                <input type=\"text\"  value =");
      out.print( request.getAttribute("anio"));
      out.write(" />\n");
      out.write("                <br/>\n");
      out.write("                <h6>Biografia: </h6>\n");
      out.write("                <input type=\"text\"  value =");
      out.print( request.getAttribute("biografia"));
      out.write(" /> <br/>\n");
      out.write("                <h6>Link: </h6>\n");
      out.write("                <input type=\"text\"  value =");
      out.print( request.getAttribute("link"));
      out.write(" /> <br/>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <h6>Imagen: </h6>\n");
      out.write("                <img type=\"text\"  src=\"");
      out.print( request.getAttribute("imagen"));
      out.write("\" /> <br/>\n");
      out.write("                \n");
      out.write("                <h6>Lista de Album Favoritos: </h6>\n");
      out.write("                ");
 while (itAl.hasNext()) {
      out.write(" \n");
      out.write("                <ol>\n");
      out.write("                    <li> <a href=\"");
      out.print( request.getContextPath());
      out.write("/mostrarAlbum.jsp\"> ");
out.print(itAl.next()); 
      out.write("</a></li> </li>\n");
      out.write("                </ol>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </form> \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/templates/scripts.jsp", out, false);
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
