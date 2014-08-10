public class Piece {
    private Type[] types = new Type[4];

    public Piece(Type[] types) {
        this.types = types;
    }

    public Type[] faces() {
        return this.types;
    }
}
