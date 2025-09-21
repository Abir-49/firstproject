public class adapter {
    interface Railroad {
    void vehicleMoving();
}
    interface Roadway {
    void vehicleMoving();
}
    static class Train implements Railroad {
    @Override
    public void vehicleMoving() {
        System.out.println("Train is moving on railroad tracks.");
    }
}
    static class Car implements Roadway {
    @Override
    public void vehicleMoving() {
        System.out.println("Car is moving on the road.");
    }
}
    static class TrainAdapter implements Roadway {
    private Railroad train;

    public TrainAdapter(Railroad train) {
        this.train = train;
    }

    @Override
    public void vehicleMoving() {
        train.vehicleMoving();
    }
}
    public static void main(String[] args) {
        Railroad train = new Train();
        Roadway car = new Car();

        // Using the adapter to make the train compatible with roadway interface
        Roadway trainAdapter = new TrainAdapter(train);

        car.vehicleMoving(); // Output: Car is moving on the road.
        trainAdapter.vehicleMoving(); // Output: Train is moving on railroad tracks.
    }
}
