package org.apache.jsp.Views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login</title>\n");
      out.write("    </head>\n");
      out.write("    <!--<link rel=\"stylesheet\" href=\"css/logins.css\">-->\n");
      out.write("    <style>\n");
      out.write("        .login{\n");
      out.write("            width: 350px;\n");
      out.write("            height: 615px;\n");
      out.write("            background-color: white;\n");
      out.write("            box-shadow: 0px 0px 10px #0082bb;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            padding: 50px;\n");
      out.write("            margin: 0 auto;\n");
      out.write("            margin-top: 15px;\n");
      out.write("            color: black;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .logo img{\n");
      out.write("            width: 70px;\n");
      out.write("            height: 70px;\n");
      out.write("            margin-left: 120px;\n");
      out.write("            margin-top: -10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .form-input{\n");
      out.write("            padding: 20px;\n");
      out.write("            border: 1px solid blue;\n");
      out.write("            margin: 10px 20px;\n");
      out.write("            border-radius: 20px;\n");
      out.write("            width: 300px;\n");
      out.write("            height: 50px;\n");
      out.write("            padding: 0 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .form-input:focus{\n");
      out.write("            border-color: #0082bb;\n");
      out.write("            box-shadow: 0px 0px 5px #0082bb;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .form-field{\n");
      out.write("            position: relative;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("        .btn{\n");
      out.write("            position: relative;\n");
      out.write("            top: 0px;\n");
      out.write("            left: 73px;\n");
      out.write("            width: 100px;\n");
      out.write("            height: 40px;\n");
      out.write("            border-radius: 20px;\n");
      out.write("            background-color: #0082bb;\n");
      out.write("            color: white;\n");
      out.write("        }\n");
      out.write("        .btnHome{\n");
      out.write("            position: relative;\n");
      out.write("            right: 30px;\n");
      out.write("            padding: 10px 10px;\n");
      out.write("            border-radius: 20px;\n");
      out.write("            margin: 70px 30px;\n");
      out.write("            border: 2px solid black;\n");
      out.write("            background-color: #0082bb;\n");
      out.write("            color: white;\n");
      out.write("        }\n");
      out.write("        .btnHome:hover{\n");
      out.write("            box-shadow: 0px 0px 10px #0082bb;\n");
      out.write("        }\n");
      out.write("        .btnLoginwithGG{\n");
      out.write("            position: relative;\n");
      out.write("            right: -15px;\n");
      out.write("            margin: 10px 78px;\n");
      out.write("            border: 2px solid black;\n");
      out.write("        }\n");
      out.write("        .btnLoginwithGG:hover{\n");
      out.write("            box-shadow: 0px 0px 10px #0082bb;\n");
      out.write("        }\n");
      out.write("        .signup{\n");
      out.write("            margin-left: 80px;\n");
      out.write("            margin-top: 20px;\n");
      out.write("        }\n");
      out.write("        .forget{\n");
      out.write("            text-align: justify;\n");
      out.write("            margin: 10px 118px;\n");
      out.write("        }\n");
      out.write("        .action{\n");
      out.write("            margin-bottom: 30px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"login\">\n");
      out.write("            <h1 style=\"text-align: center;\">Login</h1>\n");
      out.write("\n");
      out.write("            <form class=\"action\" action=\"/Technology_Shop/login\" method=\"post\">\n");
      out.write("                <div class=\"form-field\">\n");
      out.write("                    <h3>Username<h3>\n");
      out.write("                            <input type=\"text\" class=\"form-input\" name=\"username\" placeholder=\"username\"/>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-field\">\n");
      out.write("                                <h3>Password</h3>\n");
      out.write("                                <input type=\"password\" class=\"form-input\" name=\"password\" placeholder=\"password\"/>\n");
      out.write("                            </div>\n");
      out.write("                            <p style=\"color: black;\"><input style=\" display: inline-block\" type=\"checkbox\" name=\"remember\" value=\"on\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cookie.crem != null ?'checked':''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" />Remember me</p>\n");
      out.write("                            <div>\n");
      out.write("                                <h3 class=\"text-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mess}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div style=\"background: green; text-decoration: none; text-align: center;\" class=\"btnLoginwithGG\">\n");
      out.write("                                <a href=\"https://accounts.google.com/o/oauth2/auth/oauthchooseaccount?scope=email profile&redirect_uri=http%3A%2F%2Flocalhost%3A9999%2FTechnology_Shop%2FLoginGoogleHandler&response_type=code&client_id=782277117461-lg10v0nkrua8sc4eucjk872de74b7de4.apps.googleusercontent.com&approval_prompt=force&service=lso&o2v=1&theme=glif&flowName=GeneralOAuthFlow\" \n");
      out.write("                                   ><i class=\"display-flex-center zmdi zmdi-google\"></i><h2 \n");
      out.write("                                        style=\"color: white;\">Login with Google</h2></a>\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                            <p style=\"color: red;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                            <a class=\"btnHome\" href=\"/Technology_Shop/home\" style=\"text-decoration: none; text-align: center;\">Return to home</a>\n");
      out.write("                            <button class=\"btn\" type=\"submit\">Login</button> \n");
      out.write("                            </form>\n");
      out.write("\n");
      out.write("                            <a class=\"forget\" href=\"/Technology_Shop/GetPassword\">Forget password?</a>\n");
      out.write("                            <div class=\"signup\">\n");
      out.write("                                Do you have an account? <a href=\"/Technology_Shop/signUp\">Sign up</a>\n");
      out.write("                            </div>\n");
      out.write("                            </div>\n");
      out.write("                            </body>\n");
      out.write("                            </html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
