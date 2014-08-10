
public final class PiecePool {
    final HasFaces[] pieces;

    public PiecePool(HasFaces[] pieces) {
        this.pieces = pieces;
    }

    public int size() {
        return pieces.length;
    }

    public HasFaces pieceAt(int index) {
        return pieces[index];
    }

    public PiecePool without(int index) {
        HasFaces[] result = new HasFaces[pieces.length - 1];
        System.arraycopy(pieces, 0, result, 0, index);
        if (index != result.length) {
            System.arraycopy(pieces, index + 1, result, index, result.length - index);
        }
        return new PiecePool(result);
    }

    public boolean isEmpty() {
        return pieces.length == 0;
    }
}
