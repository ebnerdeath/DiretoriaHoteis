/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

/**
 *
 * @author Ebner
 */
public class Hospedagem {
    private int id_hospedagem,id_cliente,id_quarto,id_status_hospedagem,quarto_andar;
    private String periodo_ini,periodo_fim,quarto_descricao;
    private Double quarto_val_diaria;

    /**
     * @return the id_hospedagem
     */
    public int getId_hospedagem() {
        return id_hospedagem;
    }

    /**
     * @param id_hospedagem the id_hospedagem to set
     */
    public void setId_hospedagem(int id_hospedagem) {
        this.id_hospedagem = id_hospedagem;
    }
    /**
     * @return the id_cliente
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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
     * @return the id_status_hospedagem
     */
    public int getId_status_hospedagem() {
        return id_status_hospedagem;
    }

    /**
     * @param id_status_hospedagem the id_status_hospedagem to set
     */
    public void setId_status_hospedagem(int id_status_hospedagem) {
        this.id_status_hospedagem = id_status_hospedagem;
    }

    /**
     * @return the quarto_andar
     */
    public int getQuarto_andar() {
        return quarto_andar;
    }

    /**
     * @param quarto_andar the quarto_andar to set
     */
    public void setQuarto_andar(int quarto_andar) {
        this.quarto_andar = quarto_andar;
    }

    /**
     * @return the periodo_ini
     */
    public String getPeriodo_ini() {
        return periodo_ini;
    }

    /**
     * @param periodo_ini the periodo_ini to set
     */
    public void setPeriodo_ini(String periodo_ini) {
        this.periodo_ini = periodo_ini;
    }

    /**
     * @return the periodo_fim
     */
    public String getPeriodo_fim() {
        return periodo_fim;
    }

    /**
     * @param periodo_fim the periodo_fim to set
     */
    public void setPeriodo_fim(String periodo_fim) {
        this.periodo_fim = periodo_fim;
    }

    /**
     * @return the quarto_descricao
     */
    public String getQuarto_descricao() {
        return quarto_descricao;
    }

    /**
     * @param quarto_descricao the quarto_descricao to set
     */
    public void setQuarto_descricao(String quarto_descricao) {
        this.quarto_descricao = quarto_descricao;
    }

    /**
     * @return the quarto_val_diaria
     */
    public Double getQuarto_val_diaria() {
        return quarto_val_diaria;
    }

    /**
     * @param quarto_val_diaria the quarto_val_diaria to set
     */
    public void setQuarto_val_diaria(Double quarto_val_diaria) {
        this.quarto_val_diaria = quarto_val_diaria;
    }
    

    
}
