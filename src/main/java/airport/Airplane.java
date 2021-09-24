package airport;

public abstract class Airplane {
    private String id;
    private boolean isFlying;
    private double cruiseSpeed;
    private int maximumNumberOfLoad;
    private int currentNumberOfLoad;

    protected abstract String loadPlane(int amount);

    protected abstract String unloadPlane();

    public Airplane(String id, int maximumNumberOfLoad, int currentNumberOfLoad, boolean isFlying, double cruiseSpeed) {
        this.id = id;
        this.isFlying = isFlying;
        this.cruiseSpeed = cruiseSpeed;
        this.maximumNumberOfLoad = maximumNumberOfLoad;
        this.currentNumberOfLoad = currentNumberOfLoad;
    }

    protected void setupPlane(Airplane airplane, int amount) {
        if (amount > this.getMaximumNumberOfLoad())
            this.setCurrentNumberOfLoad(this.getMaximumNumberOfLoad());
        else this.setCurrentNumberOfLoad(amount);

    }

    protected void setupCurrentLoad(int amount) {
        if (amount <= this.maximumNumberOfLoad)
            this.currentNumberOfLoad = amount;
        else System.out.println("Capacity is not enough for this amount");
    }

    public String takeOff() {
        if (isFlying) {
            return "Airplane " + this.id + " can not take off, because we are already flying.";
        } else if (!isFlying) {
            return "Airplane " + this.id + " can not land, because we are still on the ground.";
        }
        this.isFlying = true;
        return "Airplane " + this.id + " rises.";
    }

    public String land() {
        if (isFlying) {
            return "Airplane " + this.id + " can not take off, because we are already flying.";
        }
        this.isFlying = false;
        return "Airplane " + this.id + " lands.";
    }

    public String getId() {
        return id;
    }


    private void setId(String id) {
        this.id = id;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public void setFlying(boolean flying) {
        isFlying = flying;
    }

    public double getCruiseSpeed() {
        return cruiseSpeed;
    }

    public void setCruiseSpeed(double cruiseSpeed) {
        this.cruiseSpeed = cruiseSpeed;
    }

    public int getMaximumNumberOfLoad() {
        return maximumNumberOfLoad;
    }


    private void setMaximumNumberOfLoad(int maximumNumberOfLoad) {
        this.maximumNumberOfLoad = maximumNumberOfLoad;
    }

    public int getCurrentNumberOfLoad() {
        return currentNumberOfLoad;
    }

    private void setCurrentNumberOfLoad(int currentNumberOfLoad) {
        this.currentNumberOfLoad = currentNumberOfLoad;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id='" + id + '\'' +
                ", isFlying=" + isFlying +
                ", cruiseSpeed=" + cruiseSpeed +
                ", maximumNumberOfLoad=" + maximumNumberOfLoad +
                ", currentNumberOfLoad=" + currentNumberOfLoad +
                '}';
    }
}