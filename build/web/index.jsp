<%@page import="java.util.ArrayList"%>
<%@page import="classes.Aluno"%>
<%@page import="dao.AlunoDAO"%>
<%@page import="dao.Conecta"%>

<%
    String status = request.getParameter("status");
    
    if (status != null) {
            if(status.equals("ok")){
                out.println("Registro Inserido com sucesso");
            }
             else {
                out.println("ERRO: " + status);
            }
    }
    
    String rgm = request.getParameter("rgm");
    Aluno aluno = new Aluno();
    if (rgm != null) {
        aluno = new AlunoDAO().consultarAluno(rgm);
    }

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Banco de dados</title>
    </head>
    <body>
        <form name="form1" action="gravar.jsp" method="post">
            <table border="1">
                <tr>
                    <td>RGM:</td>
                    <td><input type="text" name="rgm" value="<%= aluno.getRgm() %>"></td>
                </tr>
                <tr>
                    <td>Nome:</td>
                    <td><input type="text" name="rgm" value="<%= aluno.getNome() %>"></td>
                </tr>
                <tr>
                    <td>Nota 1:</td>
                    <td><input type="text" name="rgm" value="<%= aluno.getN1() %>"></td>
                </tr>
                <tr>
                    <td>Nota 2:</td>
                    <td><input type="text" name="rgm" value="<%= aluno.getN2() %>"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Gravar"></td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <tr>
                <td>Nome</td>
                <td>RGM</td>
                <td>Nota 1</td>
                <td>Nota 2</td>
            </tr>
            <%
                ArrayList<Aluno> lista = new AlunoDAO().getAlunos();
                for (int i = 0; i < lista.size(); i++) {
                        out.println("<tr>");
                        out.println("<td><a href='index.jsp?rgm=" + lista.get(i).getRgm() + "'>" + lista.get(i).getRgm()+"</a></td>");
                        out.println("<td>" + lista.get(i).getNome() + "</td>");
                        out.println("<td>" + lista.get(i).getN1() + "</td>");
                        out.println("<td>" + lista.get(i).getN2() + "</td>");
                        out.println("</tr>");
                    }
            %>
        </table>    
    </body>
</html>
