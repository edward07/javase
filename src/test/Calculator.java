package test;

public class Calculator {

    private static int result;

    public void add(int n) {
        result = result + n;
    }

    public void subtract(int n) {
        result = result - n;
    }

    public void multiply(int n) {
        result = result * n;
    }

    public void divide(int n) {
        result = result / n;
    }

    public void square(int n) {
        result = n * n;
    }

    public void squareRoot(int n) {
        result = (int) Math.sqrt(n);
        //for (;;);
    }

    public void clear() {
        result = 0;
    }

    public int getResult() {
        return result;
    }

    public void cubic(int n) {
    }

}
