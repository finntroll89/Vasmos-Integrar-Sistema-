/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroee.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Entity
@Table(name = "Movimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimento.findAll", query = "SELECT m FROM Movimento m"),
    @NamedQuery(name = "Movimento.findByIdMovimento", query = "SELECT m FROM Movimento m WHERE m.idMovimento = :idMovimento"),
    @NamedQuery(name = "Movimento.findByQuantidade", query = "SELECT m FROM Movimento m WHERE m.quantidade = :quantidade"),
    @NamedQuery(name = "Movimento.findByTipo", query = "SELECT m FROM Movimento m WHERE m.tipo = :tipo"),
    @NamedQuery(name = "Movimento.findByPrecoUnitario", query = "SELECT m FROM Movimento m WHERE m.precoUnitario = :precoUnitario")})
public class Movimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMovimento")
    private Integer idMovimento;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "tipo")
    private Character tipo;
    @Column(name = "precoUnitario")
    private Long precoUnitario;
    @JoinColumn(name = "FK_Pessoa_idPessoa", referencedColumnName = "idPessoa")
    @ManyToOne(optional = false)
    private Pessoa fKPessoaidPessoa;
    @JoinColumn(name = "FK_Produto_idProduto", referencedColumnName = "idProduto")
    @ManyToOne(optional = false)
    private Produto fKProdutoidProduto;
    @JoinColumn(name = "FK_Usuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario fKUsuarioidUsuario;

    public Movimento() {
    }

    public Movimento(Integer idMovimento) {
        this.idMovimento = idMovimento;
    }

    public Integer getIdMovimento() {
        return idMovimento;
    }

    public void setIdMovimento(Integer idMovimento) {
        this.idMovimento = idMovimento;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public Long getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Long precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Pessoa getFKPessoaidPessoa() {
        return fKPessoaidPessoa;
    }

    public void setFKPessoaidPessoa(Pessoa fKPessoaidPessoa) {
        this.fKPessoaidPessoa = fKPessoaidPessoa;
    }

    public Produto getFKProdutoidProduto() {
        return fKProdutoidProduto;
    }

    public void setFKProdutoidProduto(Produto fKProdutoidProduto) {
        this.fKProdutoidProduto = fKProdutoidProduto;
    }

    public Usuario getFKUsuarioidUsuario() {
        return fKUsuarioidUsuario;
    }

    public void setFKUsuarioidUsuario(Usuario fKUsuarioidUsuario) {
        this.fKUsuarioidUsuario = fKUsuarioidUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimento != null ? idMovimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimento)) {
            return false;
        }
        Movimento other = (Movimento) object;
        if ((this.idMovimento == null && other.idMovimento != null) || (this.idMovimento != null && !this.idMovimento.equals(other.idMovimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cadastroee.model.Movimento[ idMovimento=" + idMovimento + " ]";
    }
    
}
