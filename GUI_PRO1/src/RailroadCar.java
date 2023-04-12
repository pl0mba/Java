import java.util.concurrent.atomic.AtomicStampedReference;

class RailroadCar implements Carriage {

    private Type type;
    int weight=30_000;
    public RailroadCar(Type type){
        this.type=type;
    }
    public RailroadCar(){}
    public boolean isElectrified(){return this.type.isElectrified();}
    public Type getType(){return type;}
}




