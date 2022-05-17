package dao;

import java.sql.*;
import classes.Aluno;
import java.util.ArrayList;

public class AlunoDAO {
    public String insertAluno(Aluno aluno){
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            String sql = "INSERT INTO dados (rgm, nome, nota1, nota2) VALUES (?,?,?,?)";
            // os ? são os parâmetros para realizar a inserção
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, aluno.getRgm());
            pst.setString(2, aluno.getNome());
            pst.setFloat(3, aluno.getN1());
            pst.setFloat(4, aluno.getN2());
            pst.execute();
            con.close();
            resp = "OK";
        } catch (Exception e) {
            resp = "Erro: " + e.toString(); // Tratamento de Erro
        }
        return resp;
    }
    
    public ArrayList<Aluno> getAlunos(){
        ArrayList<Aluno> lista = new ArrayList<Aluno>();
        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql ="SELECT * FROM dados ORDER BY nome";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Aluno aluno = new Aluno();
                aluno.setRgm(rs.getString("rgm"));
                aluno.setNome(rs.getString("nome"));
                aluno.setN1(rs.getFloat("nota1"));
                aluno.setN2(rs.getFloat("nota2"));
                
                lista.add(aluno);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public Aluno consultarAluno (String rgm){
        Aluno aluno = new Aluno();
        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql ="SELECT * FROM dados WHERE rgm = '"+ rgm + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                aluno.setRgm(rs.getString("rgm"));
                aluno.setNome(rs.getString("nome"));
                aluno.setN1(rs.getFloat("nota1"));
                aluno.setN2(rs.getFloat("nota2"));

            } else {
                aluno.setRgm("");
                aluno.setNome("");
                aluno.setN1(0);
                aluno.setN2(0);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aluno;
    }
    
    public String alterarAluno(Aluno aluno){
        
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            String sql = "UPDATE dados SET nome=?, nota1=?, nota2=? WHERE rgm=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, aluno.getNome());
            pst.setFloat(2, aluno.getN1());
            pst.setFloat(3, aluno.getN2());
            pst.setString(4, aluno.getRgm());
            
            pst.execute();
            
            pst.close();
            con.close();
            
            resp = "OK";
        } catch (Exception e) {
            resp = "ERRO: " + e.toString();
        }
        return resp;
    }
    
    public String excluirAluno(Aluno aluno){
        String resp = "";
        
        try {
            Connection con = Conecta.getConexao();
            String sql = "DELETE FROM WHERE rgm=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, aluno.getRgm());
            
            pst.execute();
            
            pst.close();
            con.close();
        
            resp = "OK";
        } catch (Exception e) {
            resp = "ERRO: " + e.toString();
        }
        
        return resp;
    }
}

