
public class Solver {

    public static final PiecePool PIECES = new PiecePool(new Piece[] {
        new Piece(new FaceDesign[] {FaceDesign.Man, FaceDesign.WineBottle, FaceDesign.BarTender, FaceDesign.BeerGlass}),
        new Piece(new FaceDesign[] {FaceDesign.BeerGlass, FaceDesign.BarTender, FaceDesign.Man, FaceDesign.IHeartBeer}),
        new Piece(new FaceDesign[] {FaceDesign.BeerGlass, FaceDesign.Band, FaceDesign.IHeartBeer, FaceDesign.WineBottle}),
        new Piece(new FaceDesign[] {FaceDesign.IHeartBeer, FaceDesign.BeerGlass, FaceDesign.Man, FaceDesign.Band}),
        new Piece(new FaceDesign[] {FaceDesign.BarTender, FaceDesign.Band, FaceDesign.Man, FaceDesign.WineBottle}),
        new Piece(new FaceDesign[] {FaceDesign.BeerGlass, FaceDesign.BarTender, FaceDesign.Man, FaceDesign.WineBottle}),
        new Piece(new FaceDesign[] {FaceDesign.WineBottle, FaceDesign.BarTender, FaceDesign.IHeartBeer, FaceDesign.Band}),
        new Piece(new FaceDesign[] {FaceDesign.BarTender, FaceDesign.IHeartBeer, FaceDesign.BeerGlass, FaceDesign.Band}),
        new Piece(new FaceDesign[] {FaceDesign.Band, FaceDesign.Man, FaceDesign.WineBottle, FaceDesign.IHeartBeer})
    });

    public static void main(String[] args) {
        solve(new Arrangement(), PIECES);
    }

    private static Arrangement solve(Arrangement arrangement, PiecePool availablePieces) {
        if (availablePieces.isEmpty()) {
            System.out.println(arrangement);
            return arrangement;
        }
        for (int i = 0; i < availablePieces.size(); i++) {
            for (int rotation = 0; rotation <= 3; rotation++) {
                final HasFaces candidate = new RotatedPiece(availablePieces.pieceAt(i), rotation);
                if (arrangement.canAdd(candidate)) {
                    solve(arrangement.withAdditionOf(candidate), availablePieces.without(i));
                }
            }
        }
        return null;
    }

}
