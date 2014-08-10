
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
        if (arrangement.isComplete()) {
            System.out.println(arrangement);
            return arrangement;
        }
        for (int pieceNumber = 0; pieceNumber < availablePieces.size(); pieceNumber++) {
            HasFaces piece = availablePieces.pieceAt(pieceNumber);
            for (int rotation = 0; rotation < piece.faceCount(); rotation++) {
                final HasFaces candidate = new RotatedPiece(piece, rotation);
                if (arrangement.canAdd(candidate)) {
                    solve(arrangement.withAdditionOf(candidate), availablePieces.without(pieceNumber));
                }
            }
        }
        return null;
    }

}
