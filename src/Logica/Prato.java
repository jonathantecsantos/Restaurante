package Logica;

/**
 *
 * @author Abimael e Jonathan Classe responsavel pelos pratos do restaurante
 */
public class Prato {

    private static int geradorId = 0;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer codigo;

    /**
     * Metodo construtor para classe Prato
     *
     * @param nome
     * @param descricao
     * @param preco
     */
    public Prato(String nome, String descricao, Double preco) {
        geradorId++;
        this.codigo = geradorId;
        if (nome.isEmpty()) {

        } else {
            this.nome = nome;
        }
        this.descricao = descricao;
        if (preco == null || preco < 0) {
            throw new NumberFormatException();
        } else {
            this.preco = preco;
        }

    }

    public Prato() {
        
    }

    /**
     * Metodo get para identificador do Prato
     *
     * @return id do prato
     */
    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Metodo get para nome do prato
     *
     * @return nome do prato
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo set para nome do prato
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo get para descricao do prato
     *
     * @return descricao do prato
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Metodo set para descricao do prato
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Metodo get para preco do prato
     *
     * @return preco do prato
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * Metodo set para Preco do prato
     *
     * @param preco
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

}
