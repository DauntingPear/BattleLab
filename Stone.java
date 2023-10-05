public class Stone extends Entity {

    public Stone() {
        setName("regular stone");
    }

    public Stone(double width, double height, double depth) {
        double dimensions[] = {width, height, depth};
        this.setDimensions(dimensions);
        setName("regular stone");
    }
}
