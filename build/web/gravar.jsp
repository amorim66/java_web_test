<%@page import="classes.Aluno"%>
<%@page import="dao.AlunoDAO"%>
<%
    //Captura os dados do formulário do index
    String rgm = request.getParameter("rgm");
    String nome = request.getParameter("nome");
    String n1 = request.getParameter("nota1");
    String n2 = request.getParameter("nota2");
    
    
    
%>



<%@page contentType="text/
     
        
        html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
