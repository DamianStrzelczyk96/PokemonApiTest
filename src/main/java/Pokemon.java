import java.util.ArrayList;
import java.util.List;

public class Pokemon {

    public List<String> doubleDamageTo = new ArrayList<>();
    public List<String> halfDamageTo =new ArrayList<>();
    public List<String> noDamageTo =new ArrayList<>();


    public Pokemon(){
    }

    public List<String> getDoubleDamageTo() {
        return doubleDamageTo;
    }

    public void setDoubleDamageTo(String doubleDamageTo) {
        this.doubleDamageTo.add(doubleDamageTo);
    }

    public List<String> getHalfDamageTo() {
        return halfDamageTo;
    }

    public void setHalfDamageTo(String halfDamageTo) {
        this.halfDamageTo.add(halfDamageTo);
    }

    public List<String> getNoDamageTo() {
        return noDamageTo;
    }

    public void setNoDamageTo(String noDamageTo) {
        this.noDamageTo.add(noDamageTo);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "doubleDamageTo=" + doubleDamageTo +
                ", halfDamageTo=" + halfDamageTo +
                ", noDamageTo=" + noDamageTo +
                '}';
    }

}
