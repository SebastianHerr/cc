@ECHO OFF 
SET "parser=%1"

ECHO =================================== 

IF NOT EXIST bin\ MKDIR "bin\" 
CALL javacc "%parser%.jj" 
CALL javac -d bin *.java 

FOR %%f IN ( test\*.grm ) DO ( 
    ECHO ----------------------------------- %%f 
    CALL java -cp bin %parser% %%f 
) 
ECHO =================================== 
