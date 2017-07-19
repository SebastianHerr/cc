# Compilerbau - SS 2017

## Overview
* [Documentation](/doc) (doc/)
* [Source code](/src) (src/)

```
./
|- src/ ................................... Project source code
|  |- test/ ............................... Test programs
|  |  |- 01parsing/ ....................... Test programs for parsing
|  |  |- 02symbolTable/ ................... Test programs for the symbol table
|  |  |- 03typeChecking/ .................. Test programs for type checking
|  |  '- 04codeGeneration/ ................ Test programs for code generation
|  |- C0.jj ............................... C0 parser
|  |- Node*.java .......................... Nodes used for the AST
|  |- *Exception.java ..................... Custom Exceptions for the different stages
|  |- build.sh ............................ Build script for C0 (Linux/Unix)
|  '- bld.ps1 ............................. Build script for C0 (Windows) (No longer maintained)
'- README.md .............................. General hints
```

## How To
### Compiling
```
src> build.sh -c
```

### Testing
```
src> build.sh -r
```
In case of succesful tests it will end with following line:
```
  #####################################################
  Passed all tests.
```
and if some of the tests failed outside of their test scope then it will end with:
```
  #####################################################
  One or more tests failed
```

It's possible to only test a subset of the tests with filters. 
To select a filter you need to have the parameter -f with the paramter `filter`
To only run test which should pass you can run the following command:
```
src> build.sh -r -f *pass*
```
If `-f` is ommited, the default filter `*` will apply.

The parser can be run manually with following commands
```
src> java -cp bin C0 yourProgram.c0
```
