import java.time.LocalDate;
import java.time.Period;
import java.util.List;

class Funcionarios {

    private String nomeFuncionario;
    private Cargos cargo;
    private LocalDate dataAdmissao;
    private double beneficio;
    private List<ComissaoVendedor> comissoesVendedor;
    private double totalComissao;

    public Funcionarios(String nomeFuncionario, Cargos cargo, LocalDate dataAdmissao, List<ComissaoVendedor> comissoesVendedor) {
        this.nomeFuncionario = nomeFuncionario;
        this.cargo = cargo;
        this.dataAdmissao = dataAdmissao;
        this.comissoesVendedor = comissoesVendedor;
        this.beneficio = calcularBeneficio(); // Calcula o benefício
    }

    public List<ComissaoVendedor> getComissoes() {
        return comissoesVendedor;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public Cargos getCargo() {
        return cargo;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public double getBeneficio() {
        return beneficio;
    }

    public double getSalario() {
        return cargo.getSalarioBase() + (calcularTempoServico() * cargo.getProporcAdesao()) + beneficio;
    }

     protected double calcularBeneficio() {
        switch (cargo.getNomeCargo()) {
            case "Secretário":
                return cargo.getSalarioBase() * 0.20;
            case "Vendedor":
                double totalComissao = (
                        comissoesVendedor.stream()
                            .mapToDouble(ComissaoVendedor::getValorVendido).sum()
                            ) * 0.30;
                return totalComissao;
            default:
                return 0;
        }
    }

    private int calcularTempoServico() {
        Period period = Period.between(dataAdmissao, LocalDate.now());
        return period.getYears();
    }
}



class ComissaoVendedor {
    private String nomeFuncionario;
    private String competenciaFechada;
    private double valorVendido;

    public ComissaoVendedor(String nomeFuncionario, String competenciaFechada, double valorVendido) {
        this.nomeFuncionario = nomeFuncionario;
        this.competenciaFechada = competenciaFechada;
        this.valorVendido = valorVendido;
    }


    public String getCompetenciaFechada() {
        return competenciaFechada;
    }

    public double getValorVendido() {
        return valorVendido;
    }

}
