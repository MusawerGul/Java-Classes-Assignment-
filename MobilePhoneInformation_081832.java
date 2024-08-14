class MobilePhone {
    String brand;
    String model;
    double price;
    int storageCapacity;

    public MobilePhone(String brand, String model, double price, int storageCapacity) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.storageCapacity = storageCapacity;
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: $" + price);
        System.out.println("Storage Capacity: " + storageCapacity + "GB");
    }

    public static void comparePrices(MobilePhone phone1, MobilePhone phone2) {
        if (phone1.price < phone2.price) {
            System.out.println(phone1.brand + " " + phone1.model + " is cheaper.");
        } else if (phone1.price > phone2.price) {
            System.out.println(phone2.brand + " " + phone2.model + " is cheaper.");
        } else {
            System.out.println("Both phones have the same price.");
        }
    }

    public boolean meetsRequirements(int minStorage) {
        return storageCapacity >= minStorage;
    }
}

public class MobilePhoneInformation {
    public static void main(String[] args) {
        MobilePhone[] phones = new MobilePhone[3];

        phones[0] = new MobilePhone("Apple", "iPhone 14", 999.99, 128);
        phones[1] = new MobilePhone("Samsung", "Galaxy S22", 799.99, 256);
        phones[2] = new MobilePhone("Google", "Pixel 7", 699.99, 512);

        for (MobilePhone phone : phones) {
            phone.displayDetails();
            System.out.println();
        }

        MobilePhone.comparePrices(phones[0], phones[1]);

        if (phones[0].meetsRequirements(128)) {
            System.out.println(phones[0].brand + " " + phones[0].model + " meets the storage requirement.");
        } else {
            System.out.println(phones[0].brand + " " + phones[0].model + " does not meet the storage requirement.");
        }

        int maxStorage = 0;
        MobilePhone phoneWithMaxStorage = null;
        for (MobilePhone phone : phones) {
            if (phone.storageCapacity > maxStorage) {
                maxStorage = phone.storageCapacity;
                phoneWithMaxStorage = phone;
            }
        }

        System.out.println("\nPhone with the highest storage capacity:");
        if (phoneWithMaxStorage != null) {
            phoneWithMaxStorage.displayDetails();
        }
    }
}