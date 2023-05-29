class Sneaker {
    private int id;
    String name;
    String description;
    double price;
    private final String creator;

    public Sneaker(int id, String name, String description, double price, String creator) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getCreator() {
        return creator;
    }

}
