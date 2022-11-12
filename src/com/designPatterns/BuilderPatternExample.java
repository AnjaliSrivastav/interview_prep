package com.designPatterns;

public class BuilderPatternExample {
    public static void main(String[] args) {
      Vehicle car = new Vehicle.VehicleBuilder("1500cc",4).setAirbags(4).build();
      Vehicle bike = new Vehicle.VehicleBuilder("2500cc",2).build();
    }
}

/*This class only has getters and private constructor(so we can't call it from outside.)*/
class Vehicle {
    //required parameter
    private String engine;
    private int wheel;

    //optional parameter
    private int airbags;

    public String getEngine() {
        return this.engine;
    }

    public int getWheel() {
        return this.wheel;
    }

    public int getAirbags() {
        return this.airbags;
    }

    private Vehicle(VehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbags = builder.airbags;
    }

    /*static nested class*/
    public static class VehicleBuilder {
        private String engine;
        private int wheel;

        private int airbags;

        /*here, I am seeting the required parameters using the constructor*/
        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        /*here, I am setting the optional parameters using the setter method*/
        public VehicleBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}


