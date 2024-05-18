import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        // Criação dos objetos Cargos
        Cargos secretario = Cargos.criarCargo("Secretário", 7000.00, 1000.00);
        Cargos vendedor = Cargos.criarCargo("Vendedor", 12000.00, 1800.00);
        Cargos gerente = Cargos.criarCargo("Gerente", 20000.00, 3000.00);

        // Criação dos objetos Funcionarios
        List<Funcionarios> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionarios("Jorge Carvalho", secretario, LocalDate.of(2018, 1, 1), new ArrayList<>()));
        funcionarios.add(new Funcionarios("Maria Souza", secretario, LocalDate.of(2015, 12, 1), new ArrayList<>()));
        funcionarios.add(new Funcionarios("Ana Silva", vendedor, LocalDate.of(2021, 12, 1), criarComissoesAna()));
        funcionarios.add(new Funcionarios("João Mendes", vendedor, LocalDate.of(2021, 12, 1), criarComissoesJoao()));
        funcionarios.add(new Funcionarios("Juliana Alves", gerente, LocalDate.of(2017, 7, 1), new ArrayList<>()));
        funcionarios.add(new Funcionarios("Bento Albino", gerente, LocalDate.of(2014, 3, 1), new ArrayList<>()));

        // Teste do método calcularTotalPago
        double totalPago = CalculadoraFuncionarios.calcularTotalPago(funcionarios, 4, 2021);
        System.out.println("Total Pago (Salário e Benefício): " + totalPago);

        // Teste do método calcularTotalSalarios
        double totalSalarios = CalculadoraFuncionarios.calcularTotalSalarios(funcionarios, 4, 2021);
          System.out.println("Total Pago Somente em Salários: " + totalSalarios);

        // Teste do método calcularTotalBeneficios
        double totalBeneficios = CalculadoraFuncionarios.calcularTotalBeneficios(funcionarios, 4, 2021);
            System.out.println("Total Pago em Benefícios: " + totalBeneficios);

        // Teste do método calcularFuncionarioMaiorValor
        Funcionarios funcionarioMaiorValor = CalculadoraFuncionarios.calcularFuncionarioMaiorValor(funcionarios, 4, 2021);
         System.out.println("Funcionário que Recebeu o Valor Mais Alto: " + funcionarioMaiorValor.getNomeFuncionario());

        // Teste do método calcularFuncionarioMaiorBeneficio
        String funcionarioMaiorBeneficio = CalculadoraFuncionarios.calcularFuncionarioMaiorBeneficio(funcionarios, 4, 2021);
         System.out.println("Funcionário que Recebeu o Maior Benefício: " + funcionarioMaiorBeneficio);

        // Teste do método calcularVendedorMaiorVenda
        Funcionarios vendedorMaiorVenda = CalculadoraFuncionarios.calcularVendedorMaiorVenda(funcionarios, 4, 2021);
        System.out.println("Vendedor que Mais Vendeu: " + vendedorMaiorVenda.getNomeFuncionario());


        for (Funcionarios funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNomeFuncionario());
            System.out.println("Cargo: " + funcionario.getCargo().getNomeCargo());
            System.out.println("Data de Admissão: " + funcionario.getDataAdmissao());
            System.out.println("Salário: " + funcionario.getSalario());
            System.out.println("Benefício: " + funcionario.getBeneficio());
            System.out.println("--------------------------------------");
        }
    }



    public static List<ComissaoVendedor> criarComissoesAna() {
        List<ComissaoVendedor> comissoes = new ArrayList<>();
        comissoes.add(new ComissaoVendedor("Ana Silva", "2021-12", 5200.00));
        comissoes.add(new ComissaoVendedor("Ana Silva", "2022-01", 4000.00));
        comissoes.add(new ComissaoVendedor("Ana Silva", "2022-02", 4200.00));
        comissoes.add(new ComissaoVendedor("Ana Silva", "2022-03", 5850.00));
        comissoes.add(new ComissaoVendedor("Ana Silva", "2022-04", 7000.00));
        return comissoes;
    }

    public static List<ComissaoVendedor> criarComissoesJoao() {
        List<ComissaoVendedor> comissoes = new ArrayList<>();
        comissoes.add(new ComissaoVendedor("João Mendes", "2021-12", 3400.00));
        comissoes.add(new ComissaoVendedor("João Mendes", "2022-01", 7700.00));
        comissoes.add(new ComissaoVendedor("João Mendes", "2022-02", 5000.00));
        comissoes.add(new ComissaoVendedor("João Mendes", "2022-03", 5900.00));
        comissoes.add(new ComissaoVendedor("João Mendes", "2022-04", 6500.00));
        return comissoes;
    }
}
