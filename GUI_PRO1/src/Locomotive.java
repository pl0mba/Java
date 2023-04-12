import java.util.InputMismatchException;
import java.util.Scanner;

class Locomotive implements Carriage{

    int maxNumOfCars;
    int carsCarried=0;
    int weightCarried;
    int maxWeightCarried;
    int carsInElecGrid;
    int maxcarstoEleGrid;
    int selfWeight;

    String name;String homeStation;
    public Locomotive(String name, String homeStation) throws TooManyPropsException {
        ID newID = new ID();
        this.name = name;
        this.homeStation = homeStation;

        Scanner setProps = new Scanner(System.in);

        boolean validInput = false;
        do {
            try {
                System.out.println("Please input the maximum num of cars to carry: ");
                this.maxNumOfCars = setProps.nextInt();

                System.out.println("Please input the maximum cars which can be connected to electrical grid: ");
                maxcarstoEleGrid = setProps.nextInt();

                if (maxcarstoEleGrid + maxNumOfCars > 10 || maxcarstoEleGrid > maxNumOfCars) {
                    throw new TooManyPropsException();
                }

                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter integers for the properties:");
                setProps.nextLine();
            } catch (TooManyPropsException e) {
                System.out.println("Too many properties. Please input the values again.");
                setProps.nextLine();
            }
        } while (!validInput);
        setMaxWeightCarried();
        setSelfWeight();
    }

    @Override
    public String toString() {
        return name + " homestation: "+homeStation+" ID: "+ID;
    }

    public boolean canAddElec() {
        if (this.maxcarstoEleGrid >= ++carsInElecGrid)
            return true;
        carsInElecGrid--;
        return false;
    }

    private boolean checkWeight(RailroadCar car){
        if(weightCarried+car.weight<=maxWeightCarried)
            return true;
        weightCarried -= car.weight;
        return false;
    }

    private boolean checkNumOfCars(){
        if(carsCarried<=maxNumOfCars)
            return true;
        return false;
    }

    public static boolean canAddCar(RailroadCar car, Locomotive locomotive){
        if (car.isElectrified()&&!locomotive.canAddElec()||!locomotive.checkWeight(car)||!locomotive.checkNumOfCars())
            return false;
        else return true;
    }
    public void setMaxNumOfCars(int maxNumOfCars) {
        this.maxNumOfCars = maxNumOfCars;
    }
    public void setMaxWeightCarried() {
        this.maxWeightCarried = maxNumOfCars*50000;
    }
    public void setMaxcarstoEleGrid(int maxcarstoEleGrid) {
        this.maxcarstoEleGrid = maxcarstoEleGrid;
    }
    private void setSelfWeight(){
        this.selfWeight = 30000 + 5000 * maxNumOfCars;
    }
}
