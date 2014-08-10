public class Piece {
    private FaceDesign[] faces = new FaceDesign[4];

    public Piece(FaceDesign[] faces) {
        this.faces = faces;
    }

    public FaceDesign[] faces() {
        return this.faces;
    }
}
