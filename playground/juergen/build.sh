#!/bin/sh

PARSER='C0'
javacc=/home/png/programme/javacc-5.0/bin/javacc
javac=/usr/lib/jvm/java-8-openjdk/bin/javac
java=/usr/lib/jvm/java-8-openjdk/jre/bin/java


$javacc $PARSER.jj
$javac *.java

for grammar in grammars/*.grm
do
  $java $PARSER $grammar
done
