package heranca_e_polimorfismo.exercicios.exercicio1.entities;

public class OutsourcedEmplotyee extends Employee{

    private Double additionalCharge;

    public OutsourcedEmplotyee() {
    }

    public OutsourcedEmplotyee(String name, Integer hours, Double valuePerHour, Double additionalCharge) {
        super(name, hours, valuePerHour);
        this.additionalCharge = additionalCharge;
    }

    @Override
    public double payment() {
        return super.payment() + additionalCharge * 1.1;
    }

    public Double getAdditionalCharge() {
        return additionalCharge;
    }

    public void setAdditionalCharge(Double additionalCharge) {
        this.additionalCharge = additionalCharge;
    }
}
