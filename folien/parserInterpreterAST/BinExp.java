public class BinExp extends Exp {
    String op;
    Exp left, right;
    BinExp (String o, Exp l, Exp r) {
	op=o;
	left=l;
	right=r;
    }
}
