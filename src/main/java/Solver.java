/*
start with all pieces in array in some arrangement
work through all combinations of pieces and rotations

pick a piece [0], pick next piece which matches the piece you've got.
if none found, remove last piece and attempt with next
 */

public class Solver {

    public static final Piece[] PIECES = new Piece[] {
        new Piece(new Type[] {Type.Man, Type.WineBottle, Type.BarTender, Type.BeerGlass}),
        new Piece(new Type[] {Type.BeerGlass, Type.BarTender, Type.Man, Type.IHeartBeer}),
        new Piece(new Type[] {Type.BeerGlass, Type.Band, Type.IHeartBeer, Type.WineBottle}),
        new Piece(new Type[] {Type.IHeartBeer, Type.BeerGlass, Type.Man, Type.Band}),
        new Piece(new Type[] {Type.BarTender, Type.Band, Type.Man, Type.WineBottle}),
        new Piece(new Type[] {Type.BeerGlass, Type.BarTender, Type.Man, Type.WineBottle}),
        new Piece(new Type[] {Type.WineBottle, Type.BarTender, Type.IHeartBeer, Type.Band}),
        new Piece(new Type[] {Type.BarTender, Type.IHeartBeer, Type.BeerGlass, Type.Band}),
        new Piece(new Type[] {Type.Band, Type.Man, Type.WineBottle, Type.IHeartBeer})
    };
}
