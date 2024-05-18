public class Cargos {
    private String nomeCargo;
    private double salarioBase;
    private double proporcAdesao;

    public Cargos(String nomeCargo, double salarioBase, double proporcAdesao){
        this.nomeCargo = nomeCargo;
        this.salarioBase = salarioBase;
        this.proporcAdesao = proporcAdesao;
    }

    public static Cargos criarCargo(String nomeCargo, double salarioBase, double proporcAdesao) {
        return new Cargos(nomeCargo, salarioBase, proporcAdesao);
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getProporcAdesao() {
        return proporcAdesao;
    }

}