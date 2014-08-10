import org.junit.Assert;
import org.junit.Test;

public class PuzzleTest {
    final Piece piece1 = new Piece(new FaceDesign[] {FaceDesign.BarTender, FaceDesign.WineBottle, FaceDesign.Man, FaceDesign.Band});
    final Piece piece2 = new Piece(new FaceDesign[] {FaceDesign.BarTender, FaceDesign.Band, FaceDesign.Man, FaceDesign.WineBottle});
    final Piece piece3 = new Piece(new FaceDesign[] {FaceDesign.BarTender, FaceDesign.IHeartBeer, FaceDesign.Man, FaceDesign.Band});
    final Piece piece4 = new Piece(new FaceDesign[] {FaceDesign.Man, FaceDesign.IHeartBeer, FaceDesign.BarTender, FaceDesign.Band});
    final Piece awesomePiece = new Piece(new FaceDesign[] {FaceDesign.Man, FaceDesign.Man, FaceDesign.Man, FaceDesign.Man});

    @Test public void
    canRotateAPiece() {
        RotatedPiece rotatedPiece = new RotatedPiece(piece1, 1);
        Assert.assertEquals(FaceDesign.WineBottle, rotatedPiece.face(0));
        Assert.assertEquals(FaceDesign.Man, rotatedPiece.face(1));
        Assert.assertEquals(FaceDesign.Band, rotatedPiece.face(2));
        Assert.assertEquals(FaceDesign.BarTender, rotatedPiece.face(3));
    }

    @Test public void
    arrangementsCanSpawnNewArrangementsByPieceAddition() {
        final HasFaces originalPiece = piece1;
        final Arrangement original = Arrangement.arrangementOf(new HasFaces[]{originalPiece});
        final HasFaces pieceAdded = piece2;
        final Arrangement spawn = original.withAdditionOf(pieceAdded);
        
        Assert.assertArrayEquals(new HasFaces[] {originalPiece}, original.getPieces());
        Assert.assertArrayEquals(new HasFaces[] {originalPiece, pieceAdded}, spawn.getPieces());
    }

    @Test public void
    verifiesAPieceCanBeAddedToAnEmptyArrangement() {
        Arrangement a = new Arrangement();
        Assert.assertTrue(a.canAdd(piece1));
    }

    @Test public void
    verifiesASecondPieceCanOnlyBeAddedIfItMatchesTheFirst() {
        Arrangement a = Arrangement.arrangementOf(new HasFaces[]{piece1});

        Assert.assertTrue(a.canAdd(piece2));
        Assert.assertFalse(a.canAdd(piece3));
    }

    @Test public void
    verifiesAThirdPieceCanOnlyBeAddedIfItMatchesTheSecond() {
        Arrangement a = Arrangement.arrangementOf(new HasFaces[]{piece4, piece1});

        Assert.assertTrue(a.canAdd(piece2));
        Assert.assertFalse(a.canAdd(piece3));
    }

    @Test public void
    verifiesAFourthPieceCanOnlyBeAddedIfItMatchesTheFirstPieceAbove() {
        Arrangement a = Arrangement.arrangementOf(new HasFaces[]{piece1, piece2, piece3});

        Assert.assertTrue(a.canAdd(piece4));
        Assert.assertFalse(a.canAdd(new RotatedPiece(piece4, 1)));
    }
}