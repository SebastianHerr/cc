package CMA;

public class Alloc extends Instruction {
    public int k;

    Alloc(int k) { this.k = k; }
    
    public void exec(CMA state) throws StackOverflow {
	state.SP = state.SP + k;
    }

    public String toString()
    {
      return super.toString() + " k=" + k;
    }

    
}
