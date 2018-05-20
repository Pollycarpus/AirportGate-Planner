import java.util.*;

class Flight{
    private int id;
    private Time arr;
    private Time dep;
    private int gate;

    public Flight() {
        id = -1;
        arr = null;
        dep = null;
        gate = -1;
    }

    public Flight(int id, Time arr, Time dep) {
        this.id = id;
        this.arr = arr;
        this.dep = dep;
        this.gate = 0;
    }

    public int getId(){
        return id;
    }

    public Time getArr(){
        return arr;
    }

    public Time getDep(){
        return dep;
    }

    public int getGate(){
        return gate;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setArr(Time arr){
        this.arr = arr;
    }

    public void setDep(Time dep){
        this.dep = dep;
    }

    public void setGate(int gate){
        this.gate = gate;
    }

    public Flight tow(){
        Time t1 = new Time(1, 0);
        Flight flt = new Flight(this.id, this.dep.minus(t1), this.dep);
        this.dep = this.arr.add(t1);
        
        return flt;
    } 
}