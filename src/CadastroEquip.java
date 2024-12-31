import java.util.Random;

public class CadastroEquip {
    /*Cadastro de equipamentos: permitir que o operador cadastre os equipamentos
    * que estarão disponíveis para locação
    *
    * Campos obrigatórios:
    *       Nome do equipamento,
    *       Código único do equipamento(gerado automaticamente)
    *       Descrição
    *       Valor diário de locação
    *       Status(disponível ou alugado)*/

    private String nomeEquip;
    private String descricao;
    private int codigoEquip;
    private double valorDiario;
    private CadastroEquip.Status Status;

    enum Status {ALUGADO, DISPONIVEL};



    //construtor
    public void cadastrarEquipamento(String nomeEquip, String descricao, double valorDiario, int codigoEquip){
        this.nomeEquip = nomeEquip;
        this.codigoEquip = gerarCodigo();
        this.descricao = descricao;
        this.valorDiario = valorDiario;
        this.Status = Status.DISPONIVEL;
    }

    //Função para gerar código aleatório e único para cada equipamento
    public int gerarCodigo(){
        Random random = new Random();
        int numero = 100000 + random.nextInt(900000);
        return numero;
    }

    //Getters and Setters

    public void setNomeEquip(String nomeEquip) {
        this.nomeEquip = nomeEquip;
    }

    public String getNomeEquip() {
        return nomeEquip;
    }


    public void setCodigoEquip(int codigoEquip) {
        this.codigoEquip = codigoEquip;
    }

    public int getCodigoEquip() {
        return codigoEquip;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }


    public void setValorDiario(double valorDiario) {
        this.valorDiario = valorDiario;
    }

    public double getValorDiario() {
        return valorDiario;
    }

}
