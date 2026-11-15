public class Complex {

    public double ReZ;
    private double IeZ;

    public Complex(double ReZ, double IeZ){
        this.ReZ = ReZ;
        this.IeZ = IeZ;
    }

    public void printComplex (){
        if (IeZ > 0) {
            System.out.println(this.ReZ + " + " + this.IeZ + "i");
        }
        else System.out.println(this.ReZ + " + (" + this.IeZ + "i)" );
    }

    public Complex sum (Complex other){
        return new Complex(this.ReZ + other.ReZ, this.IeZ + other.IeZ);
    }

    public Complex sub (Complex other){
        return new Complex(this.ReZ - other.ReZ, this.IeZ - other.IeZ);
    }

    public Complex multi (Complex other){
        return new Complex(this.ReZ * other.ReZ, this.IeZ * other.IeZ);
    }

    public Complex div (Complex other){
        return new Complex(this.ReZ / other.ReZ, this.IeZ / other.IeZ);
    }


    public double rSum (double ReZ){
        return this.ReZ + ReZ;
    }

    public double rSub (Complex other){
        return this.ReZ - other.ReZ;
    }

    public Complex rMulti (Complex other){
        return new Complex(this.ReZ * other.ReZ, this.IeZ * other.IeZ);

    }

}
