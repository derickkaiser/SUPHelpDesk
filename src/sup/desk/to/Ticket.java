/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sup.desk.to;

import java.util.Date;
import javax.swing.JOptionPane;
import sup.desk.util.ValidationUtils;

/**
 *
 * @author derick
 */
public class Ticket {
    private int id;
    private String titulo;
    private String descricao;
    private String suporteNome;
    private String clienteNome;
    private String prioridadeDesc;
    private String statusDesc;
    private String categoriaDesc;
    private String dataAbertura;
    private String dataConclusao;
    private String dataPrevisao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
        
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSuporteNome() {
        return suporteNome;
    }

    public void setSuporteNome(String suporteNome) {
        this.suporteNome = suporteNome;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getPrioridadeDesc() {
        return prioridadeDesc;
    }

    public void setPrioridadeDesc(String prioridadeDesc) {
        this.prioridadeDesc = prioridadeDesc;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getCategoriaDesc() {
        return categoriaDesc;
    }

    public void setCategoriaDesc(String categoriaDesc) {
        this.categoriaDesc = categoriaDesc;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getDataPrevisao() {
        return dataPrevisao;
    }

    public void setDataPrevisao(String dataPrevisao) {
        this.dataPrevisao = dataPrevisao;
    }

    public Ticket(int id, String titulo, String descricao, String suporteNome, String clienteNome, String prioridadeDesc, String statusDesc, String categoriaDesc, String dataAbertura, String dataConclusao, String dataPrevisao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.suporteNome = suporteNome;
        this.clienteNome = clienteNome;
        this.prioridadeDesc = prioridadeDesc;
        this.statusDesc = statusDesc;
        this.categoriaDesc = categoriaDesc;
        this.dataAbertura = dataAbertura;
        this.dataConclusao = dataConclusao;
        this.dataPrevisao = dataPrevisao;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", suporteNome=" + suporteNome + ", clienteNome=" + clienteNome + ", prioridadeDesc=" + prioridadeDesc + ", statusDesc=" + statusDesc + ", categoriaDesc=" + categoriaDesc + ", dataAbertura=" + dataAbertura + ", dataConclusao=" + dataConclusao + ", dataPrevisao=" + dataPrevisao + '}';
    }
    
    public Ticket(){
    
    }
  
}
