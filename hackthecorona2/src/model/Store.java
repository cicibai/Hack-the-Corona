package model;

public class Store {
    private String name;
    private boolean containsTP;
    private boolean Masks;
    private boolean containsHS;

    public Store(String name, boolean containsTP, boolean Masks, boolean containsHS) {
        this.name = name;
        this.containsTP = containsTP;
        this.Masks = Masks;
        this.containsHS = containsHS;
    }

    public String getName() {
        return name;
    }

    public boolean getcontainsToiletPaper() {
        return containsTP;
    }

    public boolean getcontainsMasks() {
        return Masks;
    }

    public boolean getHandSanitizer() {
        return containsHS;
    }

}
