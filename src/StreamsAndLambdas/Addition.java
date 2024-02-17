package StreamsAndLambdas;

public class Addition implements MathematicalOperation{
    @Override
    public int operate(int x, int y) {
        return x + y;
    }
}
