package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>WELCOME LOGIN</title>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style/login.css\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Nunito:400,600,700,800&display=swap\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"cont\">\n");
      out.write("          \n");
      out.write("            <div class=\"form sign-in\">\n");
      out.write("                <form action=\"login\" method=\"post\">\n");
      out.write("                    <h2>Sign In</h2>\n");
      out.write("                    <p class=\"text-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mess}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                    <label>\n");
      out.write("                        User Name:\n");
      out.write("                        <input name=\"name\" type=\"text\" value=\"\"><br>\n");
      out.write("                    </label>\n");
      out.write("                    <label>\n");
      out.write("                        Password:\n");
      out.write("                        <input name=\"pass\" type=\"password\" value=\"\"><br>\n");
      out.write("                    </label>\n");
      out.write("                    <!--                <button><input type=\"submit\" name=\"submit\" value=\"Log in\" /></button>-->\n");
      out.write("                    <button class=\"submit\" name=\"submit\">Sign In</button>\n");
      out.write("                  \n");
      out.write("                    <a href=\"forgotPassword.jsp\">Forgot Password ?</a>\n");
      out.write("\n");
      out.write("                    <div class=\"social-media\">\n");
      out.write("                        <ul>\n");
      out.write("                            <li><img src=\"image/facebook.png\"></li>\n");
      out.write("                            <li> <a href=\"https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/Website_Laptop/login-google&response_type=code\n");
      out.write("    &client_id=481924402277-2r527uo5cu6cb602r8t7cjspejeoc2sm.apps.googleusercontent.com&approval_prompt=force\"><img src=\"image/google.jpg\"></a> </li>\n");
      out.write("                            <li><img src=\"image/linkedin.png\"></li>\n");
      out.write("                            <li><img src=\"image/instagram.png\"></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"sub-cont\">\n");
      out.write("                <div class=\"img\">\n");
      out.write("                    <div class=\"img-text m-up\">\n");
      out.write("                        <h2>New here?</h2>\n");
      out.write("                        <p>Sign up and discover great amount of new opportunities!</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"img-text m-in\">\n");
      out.write("                        <h2>One of us?</h2>\n");
      out.write("                        <p>If you already has an account, just sign in. We've missed you!</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"img-btn\">\n");
      out.write("                        <span class=\"m-up\">Sign Up</span>\n");
      out.write("                        <span class=\"m-in\">Sign In</span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form sign-up\" >\n");
      out.write("                    <form action=\"Register\" method=\"post\">\n");
      out.write("                        <label>\n");
      out.write("                            User Name:\n");
      out.write("                            <input name=\"name\" type=\"text\" value=\"\"><br>\n");
      out.write("                        </label>\n");
      out.write("                        <label style=\"margin-top: -10px\">\n");
      out.write("                            Email:\n");
      out.write("                            <input name=\"email\" type=\"email\" value=\"\"><br>\n");
      out.write("                        </label>\n");
      out.write("                        <label style=\"margin-top: -5px\">\n");
      out.write("                            <span>Password</span>\n");
      out.write("                            <input type=\"password\" name=\"pass\">\n");
      out.write("                        </label>\n");
      out.write("                        <label >\n");
      out.write("                            <span>Confirm Password</span>\n");
      out.write("                            <input type=\"password\" name=\"repass\">\n");
      out.write("                        </label>\n");
      out.write("                        <label >\n");
      out.write("                            <span>Full name</span>\n");
      out.write("                            <input type=\"text\" name=\"fullname\">\n");
      out.write("                        </label>\n");
      out.write("                        <label>\n");
      out.write("                            <span>BirthDay</span>\n");
      out.write("                            <input type=\"date\" name=\"birthday\">\n");
      out.write("                        </label>\n");
      out.write("                        <label>\n");
      out.write("                            <span>Phone</span>\n");
      out.write("                            <input type=\"text\" name=\"phone\">\n");
      out.write("                        </label>\n");
      out.write("                        <label>\n");
      out.write("                            <span>Address</span>\n");
      out.write("                            <input type=\"text\" name=\"address\">\n");
      out.write("                        </label>\n");
      out.write("                        <button name=\"submit\" class=\"submit\">Sign Up Now</button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/login.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
