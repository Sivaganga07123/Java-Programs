import java.time.Year;
class Vehicle {
    String brand;
    String model;
    int year;
    double basePrice;

    Vehicle(String brand, String model, int year, double basePrice) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.basePrice = basePrice;
    }

    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Base Price: " + basePrice);
    }

    double calculateResaleValue() {
        int currentYear = Year.now().getValue();
        int age = currentYear - year;
        double resale = basePrice;
        double depreciation = 0.85;
        for (int i = 0; i < age; i++) {
            resale = resale * depreciation;
        }
        return resale;
    }
}

class Car extends Vehicle {
    int numberOfDoors;

    Car(String brand, String model, int year, double basePrice, int numberOfDoors) {
        super(brand, model, year, basePrice);
        this.numberOfDoors = numberOfDoors;
    }

    double calculateInsurance() {
        return 5000 + 1000 * numberOfDoors;
    }

    double calculateMaintenanceCost() {
        return 3000 + 500 * numberOfDoors;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Insurance: " + calculateInsurance());
        System.out.println("Maintenance Cost: " + calculateMaintenanceCost());
        System.out.printf("Resale Value: %.2f\n", calculateResaleValue());
    }
}

class Motorcycle extends Vehicle {
    boolean hasSidecar;

    Motorcycle(String brand, String model, int year, double basePrice, boolean hasSidecar) {
        super(brand, model, year, basePrice);
        this.hasSidecar = hasSidecar;
    }

    double calculateInsurance() {
        return hasSidecar ? 2500 + 1500 : 2500;
    }

    double calculateMaintenanceCost() {
        return hasSidecar ? 2000 + 1000 : 2000;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
        System.out.println("Insurance: " + calculateInsurance());
        System.out.println("Maintenance Cost: " + calculateMaintenanceCost());
        System.out.printf("Resale Value: %.2f\n", calculateResaleValue());
    }
}

class Vehicledetails {
    public static void main(String[] args) {
        Car car = new Car("Hyundai", "Verna", 2020, 1100000, 4);
        Motorcycle bike = new Motorcycle("Royal Enfield", "Classic 350", 2021, 180000, true);

        System.out.println("Car Details:");
        car.displayInfo();
        System.out.println(); 

        System.out.println("Motorcycle Details:");
        bike.displayInfo();
    }
}
