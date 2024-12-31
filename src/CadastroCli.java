import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CadastroCli {
    /*Cadastro de Clientes: Registrar locações, associando equipamentos aos clientes
    * Campos Obrigatórios:
    *   Nome completo do Cliente
    *   CPF
    *   Telefone
    *   Equipamentos alugados <- estes equipamentos podem ser cadastrados via enum? ou tem que ser por array/fila/lista? (selecionados via menu dropdown)
    *   Data de início do aluguel
    *   Data prevista de devolução
    *   Quantidade de dias de locação (Subtração de dias)
    *   Multa diária por atraso
    *
    * Funcionalidades Adicionais:
    *   Validar se o equipamento está disponível antes de alugar
    *   Calcular e exibir o valor total no momento do registro*/

    private String nomeCli;
    private String cpf; //verificar qual formato de cpf é melhor
    private String telefone; //verificar qual formato de telefone é melhor (se necessita de DDD)
    private List<Equipamento> equipAlug;
    private LocalDate dataIni;
    private LocalDate dataDevol;
    private int qtdDiasAlug;
    private double multa;

    // Construtores

    public CadastroCli(String nomeCli, String cpf, String telefone, LocalDate dataIniAlug, LocalDate dataDevolAlugPrev, double multa) {
        this.nomeCli = nomeCli;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataIni = dataIni;
        this.dataDevol = dataDevol;
        this.qtdDiasAlug = calcularDiasLocacao(); // Subtração de datas
        this.multa = multa > 0 ? multa : 0.1; // Valor padrão de 10%
        this.equipAlug = new ArrayList<>(); // Inicializa a lista
    }

    // Métodos

    // Adicionar Equipamento
    public void adicionarEquipamento(Equipamento equipamento) {
        if (equipamento.getStatus() == Status.DISPONIVEL) {
            equipAlug.add(equipamento);
            equipamento.setStatus(Status.ALUGADO); // Atualiza o status do equipamento
        } else {
            throw new IllegalArgumentException("Equipamento não está disponível para locação.");
        }
    }

    // Calcular quantidade de dias de locação
    private int calcularDiasLocacao() {
        return dataDevol.compareTo(dataIni); // Número de dias entre a devolução prevista e a data inicial
    }

    // Getters e Setters
    public String getNomeCli() {
        return nomeCli;
    }

    public void setNomeCli(String nomeCli) {
        this.nomeCli = nomeCli;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataIni() {
        return dataIni;
    }

    public void setDataIni(LocalDate dataIniAlug) {
        this.dataIni = dataIni;
    }

    public LocalDate getDataDevol() {
        return dataDevol;
    }

    public void setDataDevol(LocalDate dataDevol) {
        this.dataDevol = dataDevol;
    }

    public List<Equipamento> getEquipAlug() {
        return equipAlug;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    @Override
    public String toString() {
        return "Cadastro do Cliente: " + nomeCli + ", CPF: " + cpf + ", Telefone: " + telefone +
                ", Equipamentos: " + equipAlug + ", Dias Alugados: " + qtdDiasAlug +
                ", Multa Diária: R$ " + multa;
    }
}
