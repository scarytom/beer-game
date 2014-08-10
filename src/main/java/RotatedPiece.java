
public class RotatedPiece {
    private final Type[] unrotatedFaces;
    private final int rotation;
    private final int faceCount;

    public RotatedPiece(Piece piece, int rotation) {
        this.unrotatedFaces = piece.types();
        this.rotation = rotation;
        this.faceCount = piece.types().length;
    }

    public Type face(int face) {
        return unrotatedFaces[(face + rotation) % faceCount];
    }
}
