
SET "parser=C0"
CALL javacc "%parser%.jj"
CALL javac *.java
ECHO ------------------- TESTING GRAMMARS -------------------
FOR %%f IN (grammars\*.grm) DO java %parser% %%f
PAUSE