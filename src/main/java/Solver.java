
public class Solver {

    public static final Piece[] PIECES = new Piece[] {
        new Piece(new FaceDesign[] {FaceDesign.Man, FaceDesign.WineBottle, FaceDesign.BarTender, FaceDesign.BeerGlass}),
        new Piece(new FaceDesign[] {FaceDesign.BeerGlass, FaceDesign.BarTender, FaceDesign.Man, FaceDesign.IHeartBeer}),
        new Piece(new FaceDesign[] {FaceDesign.BeerGlass, FaceDesign.Band, FaceDesign.IHeartBeer, FaceDesign.WineBottle}),
        new Piece(new FaceDesign[] {FaceDesign.IHeartBeer, FaceDesign.BeerGlass, FaceDesign.Man, FaceDesign.Band}),
        new Piece(new FaceDesign[] {FaceDesign.BarTender, FaceDesign.Band, FaceDesign.Man, FaceDesign.WineBottle}),
        new Piece(new FaceDesign[] {FaceDesign.BeerGlass, FaceDesign.BarTender, FaceDesign.Man, FaceDesign.WineBottle}),
        new Piece(new FaceDesign[] {FaceDesign.WineBottle, FaceDesign.BarTender, FaceDesign.IHeartBeer, FaceDesign.Band}),
        new Piece(new FaceDesign[] {FaceDesign.BarTender, FaceDesign.IHeartBeer, FaceDesign.BeerGlass, FaceDesign.Band}),
        new Piece(new FaceDesign[] {FaceDesign.Band, FaceDesign.Man, FaceDesign.WineBottle, FaceDesign.IHeartBeer})
    };

    public static void main(String[] args) {
        solve(new Arrangement(), PIECES);
    }

    private static Arrangement solve(Arrangement arrangement, Piece[] availablePieces) {
        if (availablePieces.length == 0) {
            System.out.println(arrangement);
            return arrangement;
        }
        for (int i = 0; i < availablePieces.length; i++) {
            for (int rotation = 0; rotation <= 3; rotation++) {
                final RotatedPiece candidate = new RotatedPiece(availablePieces[i], rotation);
                if (arrangement.canAdd(candidate)) {
                    solve(arrangement.withAdditionOf(candidate), piecesMinus(availablePieces, i));
                }
            }
        }
        return null;
    }

    private static Piece[] piecesMinus(Piece[] availablePieces, int index) {
        Piece[] result = new Piece[availablePieces.length - 1];
        System.arraycopy(availablePieces, 0, result, 0, index);
        if (index != result.length) {
            System.arraycopy(availablePieces, index + 1, result, index, result.length - index);
        }
        return result;
    }
}
