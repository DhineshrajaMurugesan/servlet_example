<html>
    <head>
        <title>My First JSP Page</title>
    </head>
   <%
       int count = 0;
   %>
  <body>
        Page Count is:  
        <%
           
            out.println(++count);
         %>   
  </body>
</html>