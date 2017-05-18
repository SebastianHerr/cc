SET "parser=C0"
CALL javacc "%parser%.jj"
CALL javac *.java
FOR %%f IN (grammars\*.grm) DO ECHO ------------------- Test %%f && java %parser% %%f
PAUSE