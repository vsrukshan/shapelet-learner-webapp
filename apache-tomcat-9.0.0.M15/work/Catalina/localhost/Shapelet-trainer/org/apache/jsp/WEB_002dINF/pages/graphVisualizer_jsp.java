/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M15
 * Generated at: 2016-12-29 12:43:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class graphVisualizer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        google.charts.load('current', {'packages':['line']});\n");
      out.write("        google.charts.setOnLoadCallback(drawChart);\n");
      out.write("\n");
      out.write("        function drawChart() {\n");
      out.write("\n");
      out.write("            var data = new google.visualization.DataTable();\n");
      out.write("            data.addColumn('number', 'Day');\n");
      out.write("            data.addColumn('number', 'Guardians of the Galaxy');\n");
      out.write("            data.addColumn('number', 'The Avengers');\n");
      out.write("            data.addColumn('number', 'Transformers: Age of Extinction');\n");
      out.write("//            var dataVal = [\n");
      out.write("//                [1,  37.8, 80.8, 41.8],\n");
      out.write("//                [2,  30.9, 69.5, 32.4],\n");
      out.write("//                [3,  25.4,   57, 25.7],\n");
      out.write("//                [4,  11.7, 18.8, 10.5],\n");
      out.write("//                [5,  11.9, 17.6, 10.4],\n");
      out.write("//                [6,   8.8, 13.6,  7.7],\n");
      out.write("//                [7,   7.6, 12.3,  9.6],\n");
      out.write("//                [8,  12.3, 29.2, 10.6],\n");
      out.write("//                [9,  16.9, 42.9, 14.8],\n");
      out.write("//                [10, 12.8, 30.9, 11.6],\n");
      out.write("//                [11,  5.3,  7.9,  4.7],\n");
      out.write("//                [12,  6.6,  8.4,  5.2],\n");
      out.write("//                [13,  4.8,  6.3,  3.6],\n");
      out.write("//                [14,  4.2,  6.2,  3.4]\n");
      out.write("//            ];\n");
      out.write("\n");
      out.write("            var rawFile = new XMLHttpRequest();\n");
      out.write("            rawFile.open(\"GET\", dataset/importantShapelets/event1.json, false);\n");
      out.write("            rawFile.onreadystatechange = function ()\n");
      out.write("            {\n");
      out.write("                if(rawFile.readyState === 4)\n");
      out.write("                {\n");
      out.write("                    if(rawFile.status === 200 || rawFile.status == 0)\n");
      out.write("                    {\n");
      out.write("                        var dataVal = rawFile.responseText;\n");
      out.write("                        alert(allText);\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            rawFile.send(null);\n");
      out.write("            data.addRows(dataVal);\n");
      out.write("\n");
      out.write("            var options = {\n");
      out.write("                chart: {\n");
      out.write("                    title: 'Box Office Earnings in First Two Weeks of Opening',\n");
      out.write("                    subtitle: 'in millions of dollars (USD)'\n");
      out.write("                },\n");
      out.write("                width: 900,\n");
      out.write("                height: 500,\n");
      out.write("                axes: {\n");
      out.write("                    x: {\n");
      out.write("                        0: {side: 'top'}\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            var chart = new google.charts.Line(document.getElementById('line_top_x'));\n");
      out.write("\n");
      out.write("            chart.draw(data, options);\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div id=\"line_top_x\"></div>\n");
      out.write("</body>\n");
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
