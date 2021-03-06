
public final class RotatedPiece implements HasFaces {
    private final int rotation;
    private final HasFaces piece;

    public RotatedPiece(HasFaces piece, int rotation) {
        this.piece = piece;
        this.rotation = rotation;
    }

    @Override
    public FaceDesign face(int face) {
        return piece.face(face + rotation);
    }

    @Override
    public int faceCount() {
        return piece.faceCount();
    }
}
