public class StrategyGA extends Strategy
{
    private String chromo;

    // Save the last two moves from the opponent
    // Based on these four bits (e.g. CDCD, CCDD, etc.), choose the next move
    // described by the GA's strategy chromosome that is evolved.
    // D is described as a 0, C is described as a 1.
    // If the last two moves were CDCD, this would be 1010, decimal 10
    // so we go to bit 10 in the GA chromosome to find what our next move is

    String lastMoves;

    public StrategyGA(String chromo)
    {
        lastMoves = "1111";

        name = "GA Evolved Strategy";
        this.chromo = chromo;

        opponentLastMove = 1;
        myLastMove = 1;
    }

    public int nextMove()
    {
        lastMoves = lastMoves.substring(2) + myLastMove + opponentLastMove;
        char myMove = chromo.charAt(binToDec(lastMoves));

        return Character.getNumericValue(myMove);
    }

    public int binToDec(String moves)
    {
        return (Character.getNumericValue(moves.charAt(0)) * 8 +
        Character.getNumericValue(moves.charAt(1)) * 4 +
        Character.getNumericValue(moves.charAt(2)) * 2 +
        Character.getNumericValue(moves.charAt(3)));
    }
}
