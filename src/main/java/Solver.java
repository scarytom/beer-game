/*
start with all pieces in array in some arrangement
work through all combinations of pieces and rotations

pick a piece [0], pick next piece which matches the piece you've got.
if none found, remove last piece and attempt with next
 */

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
}
