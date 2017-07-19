
public class CodeExecutionException extends Exception{
  public CodeExecutionException()
  {
    super();
  }
  
  public CodeExecutionException(String message)
  {
    super(message);
  }
  
  public CodeExecutionException(Exception ex)
  {
    this(ex.getMessage());
  }
}
  