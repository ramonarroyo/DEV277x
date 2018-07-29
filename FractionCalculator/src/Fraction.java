
public class Fraction {
    // fields
    private int numerator;
    private int denominator;

    // constructors
    public Fraction(int num, int den){
        if (den == 0){
            throw new IllegalArgumentException("Error: Division by zero.");
        }
        if (den < 0){
            num *= -1;
            den *= -1;
        }
        this.numerator = num;
        this.denominator = den;
    }
    public Fraction(int num){
        this(num, 1);
    }
    public Fraction(){
        this(0, 1);
    }

    // methods
    public int getNumerator(){
        return numerator;
    }
    public int getDenominator(){
        return denominator;
    }
    public String toString(){
        if (numerator == 0) return "0";
        else if (numerator == denominator) return "1";
        else if ((-1) * numerator == denominator) return "-1";
        else return numerator + "/" + denominator;
    }
    public double toDouble(){
        return ((double) numerator) / denominator;
    }
    public Fraction add(Fraction other){
        int newNum = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDen = this.denominator * other.denominator;
        Fraction result = new Fraction(newNum, newDen);
        result.toLowestTerms();
        return result;
    }
    public Fraction subtract(Fraction other){
        int newNum = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDen = this.denominator * other.denominator;
        Fraction result = new Fraction(newNum, newDen);
        result.toLowestTerms();
        return result;
    }
    public Fraction multiply(Fraction other){
        int newNum = this.numerator * other.numerator;
        int newDen = this.denominator * other.denominator;
        Fraction result = new Fraction(newNum, newDen);
        result.toLowestTerms();
        return result;
    }
    public Fraction divide(Fraction other){
        if (other.numerator == 0){
            throw new IllegalArgumentException("Error: Division by zero.");
        }
        int newNum = this.numerator * other.denominator;
        int newDen = this.denominator * other.numerator;
        Fraction result = new Fraction(newNum, newDen);
        result.toLowestTerms();
        return result;
    }
    public boolean equals(Object other){
        if (other instanceof Fraction){
            return this.numerator == ((Fraction) other).numerator && this.denominator == ((Fraction) other).denominator;
        }
        return false;
    }
    public void toLowestTerms(){
        int gcd = gcd(numerator, denominator);
        if (gcd != 0){
            numerator /= gcd;
            denominator /= gcd;
        }
    }
    public static int gcd(int num, int den){
        if (den == 0) return num;
        return gcd(den, num % den);
    }
}

