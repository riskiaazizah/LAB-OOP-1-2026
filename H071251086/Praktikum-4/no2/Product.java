package tuprak4.no2;

class Product {
    String brand;
    int seriesNumber;
    double price;

    public Product(String brand, int seriesNumber, double price) {
        this.brand = brand;
        this.seriesNumber = seriesNumber;
        this.price = price;
    }

    void displayInfo(){
        System.out.println("Brand : " + brand);
        System.out.println("Serial Number : " + seriesNumber);
        System.out.println("Price :  " + price);
    }
}

class Smartphone extends Product{
    double screenSize;
    int strogeCapacity;

    Smartphone(String brand, int seriesNumber, double price, double screenSize, int strogeCapacity){
        super(brand, seriesNumber, price);
        this.screenSize = screenSize;
        this.strogeCapacity = strogeCapacity;
    }

    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("Screen Size : " + screenSize);
        System.out.println("Storage Capacity : " + strogeCapacity);
    }
}

class Camera extends Product{
    int resolution;
    String lensType;

    Camera(String brand, int seriesNumber, double price, int resolution, String lensType){
        super(brand, seriesNumber, price);
        this.resolution = resolution;
        this.lensType = lensType;
    }

    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("Resolution : " + resolution);
        System.out.println("Lens Type :" + lensType);
    }
}

class Laptop extends Product {
    int ramSize;
    String processorType;

    Laptop(String brand, int seriesNumber, double price, int ramSize, String processorType){
        super(brand, seriesNumber, price);
        this.ramSize = ramSize;
        this.processorType = processorType;
    }

    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("Processor Type : " + processorType);
        System.out.println("RAM Size : " + ramSize);
    }
}
