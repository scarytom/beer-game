import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class PuzzleTest {
    Piece piece1 = new Piece(new FaceDesign[] {FaceDesign.BarTender, FaceDesign.WineBottle, FaceDesign.Man, FaceDesign.Band});
    Piece piece2 = new Piece(new FaceDesign[] {FaceDesign.BarTender, FaceDesign.Band, FaceDesign.Man, FaceDesign.WineBottle});
    Piece piece3 = new Piece(new FaceDesign[] {FaceDesign.BarTender, FaceDesign.IHeartBeer, FaceDesign.Man, FaceDesign.Band});
    Piece piece4 = new Piece(new FaceDesign[] {FaceDesign.Man, FaceDesign.IHeartBeer, FaceDesign.BarTender, FaceDesign.Band});

    Piece awesomePiece = new Piece(new FaceDesign[] {FaceDesign.Man, FaceDesign.Man, FaceDesign.Man, FaceDesign.Man});

    @Test public void
    twoMatchedPiecesScoreOne() {
        Arrangement a = Arrangement.arrangementOf(new HasFaces[]{piece1, piece2});
        Assert.assertEquals(1, a.score());
    }

    @Test public void
    twoUnmatchedPiecesScoreTwo() {
        Arrangement a = Arrangement.arrangementOf(new HasFaces[]{piece1, piece1});
        Assert.assertEquals(0, a.score());
    }

    @Test public void
    threeMatchedPiecesScoreTwo() {
        Arrangement a = Arrangement.arrangementOf(new HasFaces[]{piece1, piece2, piece3});
        Assert.assertEquals(2, a.score());
    }

    @Test public void
    fourMatchedPiecesScoreThree() {
        Arrangement a = Arrangement.arrangementOf(new HasFaces[]{piece1, piece2, piece3, piece4});
        Assert.assertEquals(3, a.score());
    }

    @Test public void
    nineMatchedPiecesScoreTwelve() {
        RotatedPiece[] arrangement = new RotatedPiece[9];
        Arrays.fill(arrangement, new RotatedPiece(awesomePiece, 0));

        Arrangement a = Arrangement.arrangementOf(arrangement);
        Assert.assertEquals(12, a.score());
    }

    @Test public void
    rotatingRockzYo() {
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