/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sup.desk.to;

/**
 *
 * @author derick
 */
public class Status {
    private int id;
    private String descricao;

    public Status(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Status(){
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Status{" + "id=" + id + ", descricao=" + descricao + '}';
    }
    
}
