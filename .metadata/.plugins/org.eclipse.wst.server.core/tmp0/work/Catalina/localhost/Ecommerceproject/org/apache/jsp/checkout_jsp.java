/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.39
 * Generated at: 2020-10-26 15:23:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.ecommerce.entities.*;
import com.ecommerce.Dao.CategoryDao;
import com.ecommerce.helper.FactoryProvider;
import java.util.*;
import com.ecommerce.entities.User;
import com.ecommerce.Dao.UserDao;
import com.ecommerce.helper.FactoryProvider;
import com.ecommerce.entities.User;

public final class checkout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/Components/common_modals.jsp", Long.valueOf(1603476212700L));
    _jspx_dependants.put("/Components/navbar.jsp", Long.valueOf(1603645374952L));
    _jspx_dependants.put("/Components/common_css_js.jsp", Long.valueOf(1603474869995L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("com.ecommerce.entities");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.ecommerce.entities.User");
    _jspx_imports_classes.add("com.ecommerce.helper.FactoryProvider");
    _jspx_imports_classes.add("com.ecommerce.Dao.CategoryDao");
    _jspx_imports_classes.add("com.ecommerce.Dao.UserDao");
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	User user = (User) session.getAttribute("current-user");
	if (user == null) {
		session.setAttribute("error", "You are not Logged in !! Login First.");
		response.sendRedirect("loginForm.jsp");
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>CheckOut</title>\r\n");
      out.write("<!-- css -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n");
      out.write(" <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" integrity=\"sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN\" crossorigin=\"anonymous\">\r\n");
      out.write(" <link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write(" \r\n");
      out.write(" <!-- js -->\r\n");
      out.write("<script\r\n");
      out.write("  src=\"https://code.jquery.com/jquery-3.5.1.min.js\"\r\n");
      out.write("  integrity=\"sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=\"\r\n");
      out.write("  crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"js/script.js\"></script>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("</body>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
User NavbarUser = null;
try{
Object NavbarUserId = session.getAttribute("userId");
UserDao Navbarud = new UserDao(FactoryProvider.getfactory());
 NavbarUser = Navbarud.getUserByUserId((int)(NavbarUserId));
}catch(Exception e){
	e.printStackTrace();
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Home Page</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-dark bg-light custom-bg fixed-top sticky-top\">\r\n");
      out.write("  <a class=\"navbar-brand\" href=\"index.jsp\">ShopStop</a>\r\n");
      out.write("  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("    <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("  </button>\r\n");
      out.write("\r\n");
      out.write("  <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("    <ul class=\"navbar-nav mr-auto\">\r\n");
      out.write("      <li class=\"nav-item active\">\r\n");
      out.write("        <a class=\"nav-link\" href=\"#\">Home <span class=\"sr-only\">(current)</span></a>\r\n");
      out.write("      </li>\r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link\" href=\"#\">About Us</a>\r\n");
      out.write("      </li>\r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link\" href=\"#\">Contact Us</a>\r\n");
      out.write("      </li>\r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link\" href=\"#\">Return Policy</a>\r\n");
      out.write("      </li>\r\n");
      out.write("      \r\n");
      out.write("    </ul>\r\n");
      out.write("    <ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("    <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link\" href=\"#\"><i class=\"fa fa-cart-plus\" style=\"font-size: 28px\" data-toggle=\"modal\" data-target=\"#cart\"></i><span class=\"cart-items\">(3)</span></a>\r\n");
      out.write("      </li>\r\n");
      out.write("    ");
if(NavbarUser==null){ 
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("     <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link\" href=\"loginForm.jsp\">Login</a>\r\n");
      out.write("      </li>\r\n");
      out.write("       <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link\" href=\"registrationForm.jsp\">Register</a>\r\n");
      out.write("      </li>\r\n");
      out.write("    ");
} 
      out.write("\r\n");
      out.write("    ");
if(NavbarUser!=null){ 
      out.write("\r\n");
      out.write("    \r\n");
      out.write("     <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link\" href=\"#\" data-toggle=\"modal\" data-target=\"#userProfile\"><i class=\"fad fa-user\"></i>");
      out.print(NavbarUser.getUserName() );
      out.write("</a>\r\n");
      out.write("      </li>\r\n");
      out.write("       <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link\" href=\"LogoutServlet\">LogOut</a>\r\n");
      out.write("      </li>\r\n");
      out.write("    ");
} 
      out.write("\r\n");
      out.write("    </ul>\r\n");
      out.write("  </div>\r\n");
      out.write("</nav>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t<div class=\"container text-center\">\r\n");
      out.write("\t<div class=\"row\">\r\n");
      out.write("\t<div class=\"col\">\r\n");
      out.write("\t<!-- Cart details -->\r\n");
      out.write("\t<div class=\"card m-3 p-2\">\r\n");
      out.write("\t<h3 class=\"text-center\">Your selected Items</h3>\r\n");
      out.write("\t<div class=\"cartText m-3\">\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\t</script>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("  <button class=\"btn btn-primary btn-lg \">Order Now</button>\r\n");
      out.write("    <a class=\"btn btn-dark btn-lg \" href=\"index.jsp\">Continue Shopping</a>\r\n");
      out.write("  \r\n");
      out.write("  </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t");
      out.write('\r');
      out.write('\n');

User userProfile = (User)session.getAttribute("current-user");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--Start of CheckOut  Modal -->\r\n");
      out.write("<div class=\"modal fade \" id=\"cart\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("  <div class=\"modal-dialog modal-lg\">\r\n");
      out.write("    <div class=\"modal-content\">\r\n");
      out.write("      <div class=\"modal-header\">\r\n");
      out.write("        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Your Cart</h5>\r\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("          <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("        </button>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"modal-body\">\r\n");
      out.write("        <div class=\"cartText\">\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"modal-footer\">\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-success btn-checkout\" onclick=\"checkoutPage()\">CheckOut</button>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--End of CheckOut  Modal -->\r\n");
      out.write("\r\n");
      out.write("<!--Start of UserProfile Modal -->\r\n");
      out.write("<div class=\"modal fade \" id=\"userProfile\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("  <div class=\"modal-dialog card \">\r\n");
      out.write("    <div class=\"modal-content\">\r\n");
      out.write("      <div class=\"modal-header card-header text-center\">\r\n");
      out.write("        <h5 class=\"modal-title \"  id=\"exampleModalLabel\">Your Profile</h5>\r\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("          <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("        </button>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"modal-body\">\r\n");
      out.write("      <div class=\"container text-center\">\r\n");
      out.write("             <img alt=\"pic\" style=\"width: 20%\" src=\"img/unnamed.png\"> \r\n");
      out.write("      </div>\r\n");
      out.write("      <ul class=\"list-group list-group-flush\">\r\n");
      out.write("\r\n");
      out.write("     ");
if(userProfile!=null){ 
      out.write(" \r\n");
      out.write("  <li class=\"list-group-item\"><b>Name :</b>");
      out.print(userProfile.getUserName() );
      out.write(" </li>\r\n");
      out.write("    <li class=\"list-group-item\"><b>Email :</b>");
      out.print(userProfile.getUserEmail() );
      out.write(" </li>\r\n");
      out.write("    <li class=\"list-group-item\"><b>Phone :</b>");
      out.print(userProfile.getUserPhone() );
      out.write(" </li>\r\n");
      out.write("    <li class=\"list-group-item\"><b>Address :</b>");
      out.print(userProfile.getUserAddress() );
      out.write(" </li>\r\n");
      out.write("  ");
} 
      out.write("\r\n");
      out.write(" \r\n");
      out.write("</ul>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"modal-footer card-footer\">\r\n");
      out.write("      <a  class=\"btn btn-dark\" href=\"updateProfile.jsp\">Edit profile</a>\r\n");
      out.write("      \r\n");
      out.write("        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--End of UserProfile Modal -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</html>");
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
