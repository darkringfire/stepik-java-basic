public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }
    
    @Override
    public int hashCode() {
    	return Double.hashCode(re) + Double.hashCode(im);
    }
    
    @Override
    public boolean equals(Object obj) {
    	if (obj == this) {
    		return true;
    	} else if (obj instanceof ComplexNumber) {
			return (re == ((ComplexNumber)obj).getRe() && im == ((ComplexNumber)obj).getIm());
		}
    	return false;
    }
}