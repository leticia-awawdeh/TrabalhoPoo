
public class Equipamento {
    private static int contadorCodigo = 1; // Gerador de códigos únicos
    private int codigo; // Código único gerado automaticamente
    private String nome; // Nome do equipamento
    private String descricao; // Descrição do equipamento
    private double valorDiario; // Valor diário do aluguel
    private Status status; // Disponível ou Alugado

    public Equipamento(String nome, String descricao, double valorDiario) {
        this.codigo = contadorCodigo++; // Código gerado automaticamente
        this.nome = nome;
        this.descricao = descricao;
        this.valorDiario = valorDiario;
        this.status = Status.DISPONIVEL; // Equipamento está disponível por padrão
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValorDiario() {
        return valorDiario;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Equipamento{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valorDiario=" + valorDiario +
                ", status='" + status +
                '}';
    }
}

