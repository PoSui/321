package circle;

public class CreditApply {
        int Serialno;
        String Name;
        String VouchType;
        Double sum;

    public CreditApply(int serialno, String name, String vouchType, Double sum) {
        Serialno = serialno;
        Name = name;
        VouchType = vouchType;
        this.sum = sum;
    }

    public int getSerialno() {
        return Serialno;
    }

    public String getName() {
        return Name;
    }

    public String getVouchType() {
        return VouchType;
    }

    public Double getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "CreditApply{" +
                "Serialno=" + Serialno +
                ", Name='" + Name + '\'' +
                ", VouchType='" + VouchType + '\'' +
                ", sum=" + sum +
                '}';
    }
}
