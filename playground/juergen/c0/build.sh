#!/bin/sh

PARSER='C0'
javacc=/home/png/programme/javacc-5.0/bin/javacc
javac=/usr/lib/jvm/java-8-openjdk/bin/javac
java=/usr/lib/jvm/java-8-openjdk/jre/bin/java


$javacc $PARSER.jj
$javac *.java

echo -e "\n\e[1mBuilding completed. \e[0m \n"

for grammar in grammars/*.grm
do
  echo -e "\e[1m$grammar:\e[0m"
  $java $PARSER $grammar
done
