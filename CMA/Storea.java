package CMA;

public class Storea extends Instruction {

    public int q;

    Storea(int q) { this.q = q; }
    
    public void exec(CMA state) {
	state.stack[q] = state.stack[state.SP];
    }

    public String toString()
    {
      return super.toString() + " q=" + q;
    }

    
}
