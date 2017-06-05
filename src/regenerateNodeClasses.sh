#Quick and dirty script to generate the base structure of all Node type classes
while read p; do
  echo public class $p{ >$p.java
  echo 	>>$p.java
  echo 	Node parent\;>>$p.java
  echo 	>>$p.java
  echo 	public $p\(\)>>$p.java
  echo 	{>>$p.java
  echo 	}>>$p.java
  echo 	>>$p.java
  echo 	public String getNodeType\(\)>>$p.java
  echo 	{>>$p.java
  echo 		return \"$p\"\;>>$p.java
  echo 	}>>$p.java
  echo 	>>$p.java
  echo 	public boolean checkNodeType\(\)>>$p.java
  echo 	{>>$p.java
  echo 		return true\; //Check okay>>$p.java
  echo 	}>>$p.java
  echo 	>>$p.java
  echo 	public Node getParent\(\)>>$p.java
  echo 	{>>$p.java
  echo 		return parent\;>>$p.java
  echo 	}>>$p.java
  echo 	>>$p.java
  echo 	public void setParent\(Node newParent\)>>$p.java
  echo 	{>>$p.java
  echo 		parent = newParent\;>>$p.java
  echo 	}>>$p.java
  echo }>>$p.java
done <AstClassNames.txt