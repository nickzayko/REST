package dao;

import dto.CarDTO;
import entity.Car;

import java.util.*;


public class CarDAO {

    private int indexAutoIncrement = carHashMap.size();

    private static Map<String, Car> carHashMap = new HashMap<String, Car>();

    static {
        initCars();
    }

    private static void initCars() {
        Car car0 = new Car(0, "Audi", "Red", 35000);
        Car car1 = new Car(1, "VW", "Black", 18000);
        Car car2 = new Car(2, "Audi", "White", 21000);
        Car car3 = new Car(3, "Ford", "Yellow", 5000);
        Car car4 = new Car(4, "Lada", "Red", 5500);
        Car car5 = new Car(5, "Lada", "Black", 1600);
        Car car6 = new Car(6, "Renault", "Green", 7900);

        carHashMap.put(String.valueOf(car0.getId()), car0);
        carHashMap.put(String.valueOf(car1.getId()), car1);
        carHashMap.put(String.valueOf(car2.getId()), car2);
        carHashMap.put(String.valueOf(car3.getId()), car3);
        carHashMap.put(String.valueOf(car4.getId()), car4);
        carHashMap.put(String.valueOf(car5.getId()), car5);
        carHashMap.put(String.valueOf(car6.getId()), car6);
    }

    public static Car getCar(String id){
        return carHashMap.get(id);
    }

    public static List<Car> getAllCars(){
        Collection<Car> carCollection = carHashMap.values();
        List<Car> carList = new ArrayList<Car>();
        carList.addAll(carCollection);
        return carList;
    }

    public static Car addCar(Car newCar){
        carHashMap.put(String.valueOf(newCar.getId()), newCar);
        return newCar;
    }

    public static Car deleteCar(String id){
        Car car = carHashMap.get(id);
        carHashMap.remove(id);
        return car;
    }

    public static Car updateCar(Integer id, CarDTO newCar) {
        Car car = carHashMap.get(String.valueOf(id));
        car.setModel(newCar.getModel());
        car.setColor(newCar.getColor());
        car.setPrice(newCar.getPrice());
        return car;
    }
}
