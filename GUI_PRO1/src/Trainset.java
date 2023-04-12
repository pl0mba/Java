import java.util.*;

import static java.lang.reflect.Type.*;

public class Trainset {
    Locomotive locomotive;
    List<RailroadCar> forLoco = new ArrayList<>();
    Map<Locomotive, List<RailroadCar>> trainSet = new HashMap<>();
    public Trainset(Locomotive locomotive) {
        System.out.println("please add carriages. If you're finished type -1");
        this.locomotive=locomotive;
        createTail(locomotive);
        trainSet.put(locomotive, forLoco);
    }
    public Trainset(){
        Locomotive forTrain;
        System.out.println("you will now create locomotive and add carriages to it." +
                " If you're finished type -1"+"Choose the name and homestation for locomotive");
        Scanner nameandHome= new Scanner(System.in);
        String name = nameandHome.nextLine();
        String home = nameandHome.nextLine();
        try {
            forTrain = new Locomotive(name,home);
        } catch (TooManyPropsException e) {
            throw new RuntimeException(e);
        }
        this.locomotive=forTrain;
        createTail(locomotive);
        trainSet.put(locomotive, forLoco);
    }
    private void createTail(Locomotive locomotive){
        String types="";
        System.out.println("Enter the type of carriage you want, choose from those:");
        for(Type type: Type.values())
            System.out.print(type.name()+" ");
        RailroadCar toAdd;
        do{
            System.out.println("Add next carriage");
            Scanner forCars = new Scanner(System.in);
            Type typForCar = Type.valueOf(forCars.nextLine());
            toAdd = new RailroadCar(typForCar);
            forLoco.add(toAdd);
            locomotive.carsCarried++;
        }while(locomotive.canAddCar(toAdd, locomotive));
    }
    public void loadPassengers(){

    }

    public String stringOfCarrs(){
        String allCars = " ";
        for(RailroadCar good: forLoco){
            allCars+=(good.getType().name()).toUpperCase()+" ";
        }
        return allCars;
    }
    @Override
    public String toString(){
        return "locomotive: "+locomotive.name+" RailroadCars: "+ stringOfCarrs();
    }
}
