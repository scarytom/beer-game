import java.util.Arrays;

public class Arrangement {
    public Arrangement(RotatedPiece[] arrangement) {
        this.arrangement = arrangement;
    }

    private RotatedPiece[] arrangement = new RotatedPiece[9];

    public int score() {
        int score = 0;
        for (int row = 0; row < 3; row++) {
            score += (arrangement.length > row * 3 + 1) ? canFitHorizontally(0 + row * 3) : 0;
            score += (arrangement.length > row * 3 + 2) ? canFitHorizontally(1 + row * 3) : 0;
        }
        for (int piece = 0; piece < 6; piece++) {
            if (arrangement.length > piece + 3) {
                score += canFitVertically(piece);
            }
        }
        return score;
    }

    private int canFitHorizontally(int left) {
        return canFit(left, left + 1, 1, 3);
    }

    private int canFitVertically(int top) {
        return canFit(top, top + 3, 2, 0);
    }

    private int canFit(int piece1Idx, int piece2Idx, int face1, int face2) {
        FaceDesign face1Design = arrangement[piece1Idx].face(face1);
        FaceDesign face2Design = arrangement[piece2Idx].face(face2);
        if (face1Design == face2Design) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Arrangement{" +
                "arrangement=" + Arrays.toString(arrangement) +
                "\n}";
    }
}