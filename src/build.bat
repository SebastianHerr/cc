@ECHO OFF
SET "parser=%1"
IF /I "%2"=="-r" GOTO run:

ECHO ===================================
IF NOT EXIST bin\ MKDIR "bin\"
CALL javacc "%parser%.jj"
CALL javac -d bin *.java

IF /I "%2"=="-c" GOTO end:

:run
FOR %%f IN ( test\*.grm ) DO (
    ECHO ----------------------------------- %%f
    CALL java -cp bin %parser% %%f
)
ECHO ===================================

:end