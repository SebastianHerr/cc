#!/bin/bash

PARSER='C0'

unset COMPILE
unset TESTP
unset FILTER

#Set default filter
FILTER="*"

while getopts "crf:" opt; do
  case "$opt" in
    c)  COMPILE=" "
        echo -e "\e[1mWill recompile the parser\e[0m"
    ;;
    f)  FILTER=$OPTARG
        echo -e "\e[1mWill use the filder $FILTER\e[0m"
    ;;
    r)  TESTP=" "
        echo -e "\e[1mWill run the parser\e[0m"
    ;;
 esac
done

if test "$COMPILE" ; then
  echo -e "\e[1mCompiling Program\e[0m"
  rm bin/*.class
  rm bin/*.java

  if [ ! -d "bin/" ]
  then
    mkdir bin
  fi

  javacc -OUTPUT_DIRECTORY=bin/ $PARSER.jj
  javac -d bin bin/*.java

  echo -e "\e[1mBuilding completed. \e[0m"
else
  echo -e "\e[1mParser not recompiled\e[0m"
fi

if test "$TESTP" ; then
  rm bin/*.cma
  rm test/**/*.cma
  
  echo -e "\n\e[1mParser will be tested with the filter $FILTER\e[0m \n"
  PASSEDALLTEST=0
  for testfile in `find test -type f -name "$FILTER"`
  do
    echo -e "\e[1m$testfile:\e[0m"
    java -cp bin $PARSER $testfile print
    
    #Checking of the return value to further automate the tests
    RETURNVALUE=$?
    if [ "$RETURNVALUE" -ne "0" ] 
    then
      if [[ $testfile == *"_pass_"* ]];
      then
        if [ "$RETURNVALUE" -eq "666" ]; then
          echo  -e "\e[31m Test failed for an unknown reason\e[39m"
          PASSEDALLTEST=1
        else
          echo -e "\e[31m failed this test checking if good enough\e[39m"
          #at this point the return value is != 0 but the test is called pass, some error occured.
          #Now it needs to be tested that enough of the parser has done it's job
          if [[ $testfile == *"01parsing"* ]]  && [ "$RETURNVALUE" -lt "2" ]; 
          then
            #Failed in the parsing stage
            echo  -e "\e[31m Test failed in the parsing stage\e[39m"
            PASSEDALLTEST=1
          else
            if [[ $testfile == *"02symbolTable"* ]]  && [ "$RETURNVALUE" -lt "3" ]; 
            then
              #failed in the symbol table stage
              echo  -e "\e[31mTets failed in the symbol table stage\e[39m"
              PASSEDALLTEST=1
            else 
              if [[ $testfile == *"03typeChecking"* ]]  && [ "$RETURNVALUE" -lt "4" ]; 
              then
                #failed in the symbol table stage
                echo  -e "\e[31mTets failed in the type checking stage\e[39m"
                PASSEDALLTEST=1
              else 
                if [[ $testfile == *"04codeGeneration"* ]]  && [ "$RETURNVALUE" -lt "5" ]; 
                then
                  #failed in the symbol table stage
                  echo  -e "\e[31mTets failed in the type checking stage\e[39m"
                  PASSEDALLTEST=1
                else 
                  echo  -e "\e[32m This test failed, but outside of the scope of the test.\e[39m"
                fi
              fi
            fi
          fi
        fi
      else
        echo  -e "\e[32m Test failed as planned, not checking where it failed.\e[39m"
      fi
    else
      if [[ $testfile == *"_fail_"* ]];
      then
        echo  -e "\e[31m This test which should have failed but did not!\e[39m"
        PASSEDALLTEST=1
      fi
    fi
    
  done
  echo "#####################################################"
  if [ "$PASSEDALLTEST" -eq "0" ]
  then
    echo -e "\e[32mPassed all tests.\e[39m"
  else
    echo -e "\e[31mOne or more tests failed\e[39m"
  fi
else 
  echo -e "\e[1mParser not tested\e[0m"
fi