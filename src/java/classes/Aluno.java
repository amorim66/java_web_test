package classes;

public class Aluno {
    private String rgm;
    private String nome;
    private float n1;
    private float n2;

    public Aluno() {
        this.rgm = "";
        this.nome = "";
        this.n1 = 0;
        this.n2 = 0;
    }

    public String getRgm() {
        return rgm;
    }

    public void setRgm(String rgm) {
        this.rgm = rgm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getN1() {
        return n1;
    }

    public void setN1(float n1) {
        this.n1 = n1;
    }

    public float getN2() {
        return n2;
    }

    public void setN2(float n2) {
        this.n2 = n2;
    }

    
}
