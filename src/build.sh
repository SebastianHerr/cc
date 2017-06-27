#!/bin/sh

PARSER='C0'

unset COMPILE
unset TESTP
unset FILTER

#Set default filter
FILTER="*"

while getopts "crf:" opt; do
  case "$opt" in
    c)  COMPILE=" "
        echo "Will recompile the parser"
    ;;
    f)  FILTER=$OPTARG
        echo "Will use the filder $FILTER"
    ;;
    r)  TESTP=" "
        echo "Will run the parser"
    ;;
 esac
done

if test "$COMPILE" ; then
  echo Compiling Program
  rm bin/*.class
  rm bin/*.java

  if [ ! -d "bin/" ]
  then
    mkdir bin
  fi

  javacc -OUTPUT_DIRECTORY=bin/ $PARSER.jj
  javac -d bin bin/*.java

  echo -e "\n\e[1mBuilding completed. \e[0m \n"
else
  echo Parser not recompiled
fi

if test "$TESTP" ; then
  echo Parser will be tested with the filter "$FILTER"
  for testfile in `find test -type f -name "$FILTER"`
  do
    echo -e "\e[1m$testfile:\e[0m"
    java -cp bin $PARSER $testfile
  done
else 
  echo Parser not tested
fi