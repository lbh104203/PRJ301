package org.apache.jsp.Views;

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
      out.write("    <body >\n");
      out.write("        <div class=\"cont\" >\n");
      out.write("\n");
      out.write("            <div class=\"form sign-in\">\n");
      out.write("                <form class=\"action\" action=\"/Technology_Shop/login\" method=\"post\">\n");
      out.write("                    <h2>Sign In</h2>\n");
      out.write("                    <p class=\"text-danger\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mess}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                    <label>\n");
      out.write("                        User Name:\n");
      out.write("                        <input type=\"text\" name=\"username\" placeholder=\"username\"/>\n");
      out.write("                    </label>\n");
      out.write("                    <label>\n");
      out.write("                        Password:\n");
      out.write("                        <input type=\"password\" class=\"form-input\" name=\"password\" placeholder=\"password\"/>\n");
      out.write("                    </label>\n");
      out.write("                    <button class=\"submit\" name=\"submit\" type=\"submit\">Login</button> \n");
      out.write("                    <a class=\"forget\" href=\"/Technology_Shop/GetPassword\">Forget password?</a>\n");
      out.write("\n");
      out.write("                    <div class=\"social-media\">\n");
      out.write("                        <ul>\n");
      out.write("                            <li> <a href=\"https://accounts.google.com/o/oauth2/auth/oauthchooseaccount?scope=email profile&redirect_uri=http%3A%2F%2Flocalhost%3A9999%2FTechnology_Shop%2Flogin&response_type=code&client_id=782277117461-lg10v0nkrua8sc4eucjk872de74b7de4.apps.googleusercontent.com&approval_prompt=force&service=lso&o2v=1&theme=glif&flowName=GeneralOAuthFlow\" \n");
      out.write("                                    ><img src=\"image/google.jpg\"></a> </li>\n");
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
      out.write("                        <label style=\"display: block;    width: 250px;    margin: -20px auto 0;    text-align: center;\">\n");
      out.write("                            User Name:\n");
      out.write("                            <input type=\"text\"  required=\"\" name=\"username\"/>\n");
      out.write("                        </label>\n");
      out.write("                        <label style=\"display: block;    width: 250px;    margin: -20px auto 0;    text-align: center;\"\">\n");
      out.write("                            Email:\n");
      out.write("                            <input type=\"email\"  name=\"email\" required=\"\" />\n");
      out.write("                        </label>\n");
      out.write("                        <label style=\"display: block;    width: 250px;    margin: -20px auto 0;    text-align: center;\"\">\n");
      out.write("                            <span>Password</span>\n");
      out.write("                            <input type=\"password\"  required=\"\" name=\"password\" />\n");
      out.write("                        </label>\n");
      out.write("                        <label style=\"display: block;    width: 250px;    margin: -20px auto 0;    text-align: center;\" >\n");
      out.write("                            <span>Confirm Password</span>\n");
      out.write("                            <input type=\"password\"  name=\"RePassword\" required=\"\" />\n");
      out.write("                        </label>\n");
      out.write("                        <label style=\"display: block;    width: 250px;    margin: -20px auto 0;    text-align: center;\" >\n");
      out.write("                            <span>Full name</span>\n");
      out.write("                            <input type=\"text\"  required=\"\" name=\"fullname\" />\n");
      out.write("                        </label>\n");
      out.write("                        <label style=\"display: block;    width: 250px;    margin: -20px auto 0;    text-align: center;\">\n");
      out.write("                            <span>Phone</span>\n");
      out.write("                            <input type=\"text\" minlength=\"10\" maxlength=\"10\" name=\"phone\" required=\"\" />\n");
      out.write("                        </label>\n");
      out.write("                        <label style=\"display: block;    width: 250px;    margin: -20px auto 0;    text-align: center;\">\n");
      out.write("\n");
      out.write("                            <select  name=\"city\" required=\"\">\n");
      out.write("                                <option class=\"hidden\"  selected disabled>Please select your city</option>\n");
      out.write("                                <c:forEach items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${city}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" var=\"c\">\n");
      out.write("                                    <option value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.cityId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.cityName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</option>\n");
      out.write("                                </c:forEach> \n");
      out.write("                            </select>\n");
      out.write("                        </label>\n");
      out.write("                        <label style=\"display: block;    width: 250px;    margin: -20px auto 0;    text-align: center;\">\n");
      out.write("                            <select name=\"question\">\n");
      out.write("                                <option class=\"hidden\" required=\"\" selected disabled>Please select your Security Question</option>\n");
      out.write("                                <c:forEach items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${question}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" var=\"q\">\n");
      out.write("                                    <option value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${q.questionId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${q.content}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</option>\n");
      out.write("                                </c:forEach>   \n");
      out.write("                            </select>\n");
      out.write("                        </label>\n");
      out.write("                        <label>\n");
      out.write("                            <span>Answer</span>\n");
      out.write("                            <input type=\"text\"  name=\"answer\" required=\"\"  />\n");
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
