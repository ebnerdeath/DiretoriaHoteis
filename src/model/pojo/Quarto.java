/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

/**
 *
 * @author Usuario
 */
public class Quarto {
    private int id_quarto;
    private String descricao;
    private int andar;
    private Double val_diaria;
    private int quarto_status;
    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the andar
     */
    public int getAndar() {
        return andar;
    }

    /**
     * @param andar the andar to set
     */
    public void setAndar(int andar) {
        this.andar = andar;
    }

    /**
     * @return the val_diaria
     */
    public Double getVal_diaria() {
        return val_diaria;
    }

    /**
     * @param val_diaria the val_diaria to set
     */
    public void setVal_diaria(Double val_diaria) {
        this.val_diaria = val_diaria;
    }

    /**
     * @return the id_quarto
     */
    public int getId_quarto() {
        return id_quarto;
    }

    /**
     * @param id_quarto the id_quarto to set
     */
    public void setId_quarto(int id_quarto) {
        this.id_quarto = id_quarto;
    }

    /**
     * @return the quarto_status
     */
    public int getQuarto_status() {
        return quarto_status;
    }

    /**
     * @param quarto_status the quarto_status to set
     */
    public void setQuarto_status(int quarto_status) {
        this.quarto_status = quarto_status;
    }
    
    
    
    
}
