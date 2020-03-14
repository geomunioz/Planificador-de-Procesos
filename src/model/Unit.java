package model;

public class Unit {
    
    private String L;
    private String U;
    private String E;

    public Unit(String L, String U, String E) {
        this.L = L;
        this.U = U;
        this.E = E;
    }

    public Unit() {
        this.L = "";
        this.U = "";
        this.E = "";
    }

    public String getL() {
        return L;
    }

    public void setL(String L) {
        this.L = L;
    }

    public String getU() {
        return U;
    }

    public void setU(String U) {
        this.U = U;
    }

    public String getE() {
        return E;
    }

    public void setE(String E) {
        this.E = E;
    }   

    @Override
    public String toString() {
        return "**** LUE{ \n\tL={"+L+"} \n\tU="+U+" \n\tE="+E+"\n}\n";
    }
    
    
    
}
