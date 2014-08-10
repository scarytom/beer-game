
public class Arrangement {
    private final RotatedPiece[] arrangement;

    public Arrangement(RotatedPiece[] arrangement) {
        this.arrangement = arrangement;
    }

    public int score() {
        int score = 0;
        for (int row = 0; row < 3; row++) {
            if (arrangement.length > row * 3 + 1 && canFitHorizontally(0 + row * 3)) {
                score += 1;
            }
            if (arrangement.length > row * 3 + 2 && canFitHorizontally(1 + row * 3)) {
                score += 1;
            }
        }
        for (int piece = 0; piece < 6; piece++) {
            if (arrangement.length > piece + 3 && canFitVertically(piece)) {
                score += 1;
            }
        }
        return score;
    }

    private boolean canFitHorizontally(int left) {
        return canFit(left, left + 1, 1, 3);
    }

    private boolean canFitVertically(int top) {
        return canFit(top, top + 3, 2, 0);
    }

    private boolean canFit(int piece1Idx, int piece2Idx, int face1, int face2) {
        return (arrangement[piece1Idx].face(face1) == arrangement[piece2Idx].face(face2));
    }

}