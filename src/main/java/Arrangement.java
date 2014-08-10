
public final class Arrangement {
    private static final int MAX_ROW_INDEX = 3;

    private static final int TOP_FACE = 0;
    private static final int RIGHT_FACE = 1;
    private static final int BOTTOM_FACE = 2;
    private static final int LEFT_FACE = 3;

    private final HasFaces piece;
    private final Arrangement parent;
    private final int pieceCount;
    private FaceDesign faceLeftOfNext;
    private FaceDesign faceAboveNext;

    public Arrangement() {
        this(null, null);
    }

    private Arrangement(Arrangement parent, HasFaces piece) {
        super();
        this.piece = piece;
        this.parent = parent;
        this.pieceCount = (parent == null) ? 0 : (parent.pieceCount + RIGHT_FACE);
        this.faceLeftOfNext = (pieceCount % MAX_ROW_INDEX != 0) ? piece.face(RIGHT_FACE) : null;
        this.faceAboveNext = (pieceCount >= MAX_ROW_INDEX) ? pieceAt(pieceCount - MAX_ROW_INDEX).face(BOTTOM_FACE) : null;
    }

    public static final Arrangement arrangementOf(HasFaces[] pieces) {
        Arrangement result = new Arrangement();
        for (HasFaces piece : pieces) {
            result = result.withAdditionOf(piece);
        }
        return result;
    }

    private HasFaces pieceAt(int index) {
        return (index == pieceCount - 1) ? piece : parent.pieceAt(index);
    }

    public HasFaces[] getPieces() {
        HasFaces[] result = new HasFaces[pieceCount];
        for(int i = 0; i < pieceCount; i++) {
            result[i] = pieceAt(i);
        }
        return result;
    }

    public Arrangement withAdditionOf(HasFaces pieceAdded) {
        return new Arrangement(this, pieceAdded);
    }

    public boolean canAdd(HasFaces candidate) {
        if (faceLeftOfNext != null && faceLeftOfNext != candidate.face(LEFT_FACE)) {
            return false;
        }
        if (faceAboveNext != null && faceAboveNext != candidate.face(TOP_FACE)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        HasFaces[] pieces = getPieces();
        for (int i = 0; i < pieces.length; i++) {
            result.append('[');
            HasFaces p = pieces[i];
            for (int j = 0; j < p.faceCount(); j++) {
                result.append(p.face(j));
                result.append(',');
            }
            result.setCharAt(result.length() - 1, ']');
            if (i % MAX_ROW_INDEX == (MAX_ROW_INDEX - 1)) {
                result.append('\n');
            }
        }
        return result.toString();
    }
}