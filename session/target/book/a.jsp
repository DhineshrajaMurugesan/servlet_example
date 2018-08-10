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
            for(count=0;count>=10;count++) 
            out.println(++count);
         %>   
  </body>
</html>