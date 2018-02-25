package CMA;

public class CMA {

     public Instruction[] program;
     public int PC; //Program Counter
     public int FP; //Frame Pointer
     public int SP; //Stack Pointer
     public int EP; //Extreme Pointer: Highest stack pointer in current function
     public int NP; //New Pointer: Lowest occupied memmory cell
     public int max = 1000;
     public int[] stack;
     

     CMA (Instruction[] program) {
	  this.program = program;
	  this.PC = 0;
	  this.NP = this.max;
	  this.FP = 0;
	  this.EP = 0;
	  this.SP = -1;
	  this.stack = new int[max];
     }
     CMA (Instruction[] program, int max) {
	  this.program = program;
	  this.max = max;
	  this.PC = 0;
	  this.NP = this.max;
	  this.FP = 0;
	  this.EP = 0;
	  this.SP = -1;
	  this.stack = new int[max];
     }
     
    public int exec() throws BadInstruction, StackOverflow {
	  Instruction instr;
	  while (true) {
	      this.print();
        System.out.println(program[PC]);
	      instr = program[PC];
	      PC = PC + 1;
	      if (instr.halt()) break;
	      instr.exec(this);
	  }
	  return stack[SP];
    }

    public void print() {
      String formatting = "%3d";
      
      String s = "PC: " + String.format(formatting, PC);
      s = s +   " FP: " + String.format(formatting, FP);
      s = s +   " EP: " + String.format(formatting, EP);
      s = s +   " SP: " + String.format(formatting, SP);
      s = s +   " NP: " + String.format(formatting, NP) + " Stack: [";	
      for (int i=0; i<SP; i++)
        s = s + String.format(formatting, stack[i]) +", ";
      System.out.println(s+String.format(formatting, stack[SP>=0 ? SP : 0])+"]");

    }
     
}
