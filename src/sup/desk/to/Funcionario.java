package sup.desk.to;

import java.util.Date;

public class Funcionario {
	int id;
	String nome;
        String email;
        String telefone;
        String ramal;
        String dataMatricula;
        String cargoNome;
        String login;
	String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public String getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(String dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getCargoNome() {
        return cargoNome;
    }

    public void setCargoNome(String cargoNome) {
        this.cargoNome = cargoNome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario(int id, String nome, String email, String telefone, String ramal, String dataMatricula, String cargoNome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.ramal = ramal;
        this.dataMatricula = dataMatricula;
        this.cargoNome = cargoNome;
        this.login = login;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", ramal=" + ramal + ", dataMatricula=" + dataMatricula + ", cargoNome=" + cargoNome + ", login=" + login + ", senha=" + senha + '}';
    }   
           
    public Funcionario(){
        
    }
	
}
