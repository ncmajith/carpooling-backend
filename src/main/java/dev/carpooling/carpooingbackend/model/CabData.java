package dev.carpooling.carpooingbackend.model;

import java.util.List;

public class CabData {
    private List<CabService> cabs;

    public List<CabService> getCabs() {
        return cabs;
    }

    public void setCabs(List<CabService> cabs) {
        this.cabs = cabs;
    }

    public static class CabService {
        private String service;
        private List<Car> cars;

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }

        public List<Car> getCars() {
            return cars;
        }

        public void setCars(List<Car> cars) {
            this.cars = cars;
        }
    }

    public static class Car {
        private String car_type;
        private String brand; // Only present in "Other" service
        private String price;

        public String getCar_type() {
            return car_type;
        }

        public void setCar_type(String car_type) {
            this.car_type = car_type;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
