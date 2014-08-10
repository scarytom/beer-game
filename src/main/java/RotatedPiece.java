
public class RotatedPiece {
    private Type[] faces = new Type[4];

    public RotatedPiece(Piece piece, int rotation) {
        System.arraycopy(piece.types(), rotation, faces, 0, piece.types().length - rotation);
        System.arraycopy(piece.types(), 0, faces, piece.types().length - rotation, rotation);
        System.arraycopy(faces, 0, piece.types(), 0, piece.types().length);
    }

    public Type face(int face) {
        return faces[face];
    }
}
