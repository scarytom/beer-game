
public class Arrangement {
    private final RotatedPiece piece;
    private final Arrangement parent;
    private final int length;
    private FaceDesign faceLeftOfNext;
    private FaceDesign faceAboveNext;

    public Arrangement() {
        this(null, null);
    }

    private Arrangement(Arrangement parent, RotatedPiece piece) {
        super();
        this.piece = piece;
        this.parent = parent;
        this.length = (parent == null) ? 0 : (parent.length + 1);
        this.faceLeftOfNext = (length % 3 != 0) ? piece.face(1) : null;
        this.faceAboveNext = (length >= 3) ? pieceAt(length - 3).face(2) : null;
    }

    public static final Arrangement arrangementOf(RotatedPiece[] pieces) {
        Arrangement result = new Arrangement();
        for (RotatedPiece piece : pieces) {
            result = result.withAdditionOf(piece);
        }
        return result;
    }

    public int score() {
        int score = 0;
        for (int row = 0; row < 3; row++) {
            if (length() > row * 3 + 1 && canFitHorizontally(0 + row * 3)) {
                score += 1;
            }
            if (length() > row * 3 + 2 && canFitHorizontally(1 + row * 3)) {
                score += 1;
            }
        }
        for (int piece = 0; piece < 6; piece++) {
            if (length() > piece + 3 && canFitVertically(piece)) {
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
        return (pieceAt(piece1Idx).face(face1) == pieceAt(piece2Idx).face(face2));
    }

    private int length() {
        return length;
    }

    private RotatedPiece pieceAt(int index) {
        return (index == length - 1) ? piece : parent.pieceAt(index);
    }

    public RotatedPiece[] getPieces() {
        RotatedPiece[] result = new RotatedPiece[length];
        for(int i = 0; i < length; i++) {
            result[i] = pieceAt(i);
        }
        return result;
    }

    public Arrangement withAdditionOf(RotatedPiece pieceAdded) {
        return new Arrangement(this, pieceAdded);
    }

    public boolean canAdd(RotatedPiece candidate) {
        if (faceLeftOfNext != null && faceLeftOfNext != candidate.face(3)) {
            return false;
        }
        if (faceAboveNext != null && faceAboveNext != candidate.face(0)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        RotatedPiece[] pieces = getPieces();
        for (int i = 0; i < pieces.length; i++) {
            result.append('[');
            for (int j = 0; j < 4; j++) {
                result.append(pieces[i].face(j));
                result.append(',');
            }
            result.setCharAt(result.length() - 1, ']');
            if (i % 3 == 2) {
                result.append('\n');
            }
        }
        return result.toString();
    }
}