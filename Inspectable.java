package sample;

abstract public class Inspectable {

    private String description;

    public Inspectable(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void inspect() {
        System.out.println(description);
    }

}
