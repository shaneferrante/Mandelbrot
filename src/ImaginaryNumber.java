public class ImaginaryNumber {

  double realPart;
  double complexPart;

  public ImaginaryNumber(double real, double complex) {
    this.realPart = real;
    this.complexPart = complex;
  }

  ImaginaryNumber add(ImaginaryNumber other) {
    return new ImaginaryNumber(other.realPart+realPart, other.complexPart+complexPart);
  }

  ImaginaryNumber square() {
    return new ImaginaryNumber(realPart*realPart-complexPart*complexPart,
            2*realPart*complexPart);
  }

  double norm() {
    return realPart*realPart+complexPart*complexPart;
  }

}
