import java.util.List;
public class CalculadoraFuncionarios {



    // (1) - Valor total pago (salário + beneficio)
    public static double calcularTotalPago(List<Funcionarios> funcionarios, int mes, int ano) {
        double totalPago = 0;
        for (Funcionarios funcionario : funcionarios) {
            totalPago += funcionario.getSalario();
        }
        return totalPago;
    }


    // (2) - Valor pago (salário)
    public static double calcularTotalSalarios(List<Funcionarios> funcionarios, int mes, int ano) {
        double totalSalarios = 0;
        for (Funcionarios funcionario : funcionarios) {
            totalSalarios += funcionario.getSalario();
        }
        return totalSalarios;
    }


    // (3) - Valor pago (beneficio)
    public static double calcularTotalBeneficios(List<Funcionarios> funcionarios, int mes, int ano) {
        double totalBeneficios = 0;
        for (Funcionarios funcionario : funcionarios) {
            totalBeneficios += funcionario.getBeneficio();
        }
        return totalBeneficios;
    }

    // (4) - Valor MAIS ALTO pago
    public static Funcionarios calcularFuncionarioMaiorValor(List<Funcionarios> funcionarios, int mes, int ano) {
        Funcionarios funcionarioMaiorValor = null;
        double maiorValor = 0;
        for (Funcionarios funcionario : funcionarios) {
            double valorRecebido = funcionario.getSalario();
            if (valorRecebido > maiorValor) {
                maiorValor = valorRecebido;
                funcionarioMaiorValor = funcionario;
            }
        }
        return funcionarioMaiorValor;
    }

    // (5) - Funcionario que recebeu o valor mais alto
    public static String calcularFuncionarioMaiorBeneficio(List<Funcionarios> funcionarios, int mes, int ano) {
        String funcionarioMaiorBeneficio = "";
        double maiorBeneficio = 0;
        for (Funcionarios funcionario : funcionarios) {
            double beneficio = funcionario.getBeneficio();
            if (beneficio > maiorBeneficio) {
                maiorBeneficio = beneficio;
                funcionarioMaiorBeneficio = funcionario.getNomeFuncionario();
            }
        }
        return funcionarioMaiorBeneficio;
    }

    // (6) - Funcionario que recebeu o valor mais alto
    public static Funcionarios calcularVendedorMaiorVenda(List<Funcionarios> funcionarios, int mes, int ano) {
        Funcionarios vendedorMaiorVenda = null;
        double maiorVenda = 0;
        for (Funcionarios funcionario : funcionarios) {
            if (funcionario.getCargo().getNomeCargo().equals("Vendedor")) {
                double vendaMes = calcularTotalVendas(funcionario, mes, ano);
                if (vendaMes > maiorVenda || (vendaMes == maiorVenda && vendedorMaiorVenda == null)) {
                    maiorVenda = vendaMes;
                    vendedorMaiorVenda = funcionario;
                }
            }
        }
        return vendedorMaiorVenda;
    }

    public static double calcularTotalVendas(Funcionarios funcionario, int mes, int ano) {
        double totalVendas = 0;

            List<ComissaoVendedor> comissoes = funcionario.getComissoes();
            for (ComissaoVendedor comissao : comissoes) {
                if (isComissaoDoMes(comissao, mes, ano)) {
                    totalVendas += comissao.getValorVendido();
                }
            }
        return totalVendas;
    }

    private static boolean isComissaoDoMes(ComissaoVendedor comissao, int mes, int ano) {
        String[] competencia = comissao.getCompetenciaFechada().split("-");
        int mesComissao = Integer.parseInt(competencia[1]);
        int anoComissao = Integer.parseInt(competencia[0]);
        return mesComissao == mes && anoComissao == ano;
    }

}