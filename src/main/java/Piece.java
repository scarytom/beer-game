public final class Piece implements HasFaces {
    private final FaceDesign[] faces;

    public Piece(FaceDesign[] faces) {
        this.faces = faces;
    }

    public FaceDesign[] faces() {
        return this.faces;
    }

    @Override
    public FaceDesign face(int face) {
        return faces[face % faces.length];
    }
}
