# Compilerbau - SS 2017

## Overview
* [Documentation](/doc) (doc/)
* [Source code](/src) (src/)

```
./
|- CMA/ ................................... CMA virtual machine
|                                           (original provided by Prof. Dr. Jörg Kreiker but heavily modified)
|- src/ ................................... Project source code
|  |- bin/ ................................ Place for the generated javacc file
|  |- C0.jj ............................... C0 parser
|  |- Node*.java .......................... Nodes used for the AST
|  |- *Exception.java ..................... Custom Exceptions for the different stages
|  '- TestMain.java ....................... Main entry point for running the tets
|- testfiles/ ............................. Test programs
|  |- 01parsing/ .......................... Test programs for parsing
|  |- 02symbolTable/ ...................... Test programs for the symbol table
|  |- 03typeChecking/ ..................... Test programs for type checking
|  '- 04codeGeneration/ ................... Test programs for code generation
'- README.md .............................. General hints
```

## How To
### Testing
To run the tests you need to call the main method in the class TestMain with following parameters:
```
parameters: * [print] [cma]
```
The `*` is the filter about which tests are being run

In case of successful tests it will end with following line:
```
  #####################################################
  All tests passed
```
and if some of the tests failed outside of their test scope then it will end with:
```
  #####################################################
  Following tests failed:
  [List of failed tests]
```
The optional parameter `print` enables expanded debug output.
The optional parameter `cma` enables the output of each step of the cma execution (Warning can be very long output)

It's possible to only test a subset of the tests with filters.
The wildcard is the standard way to select which tests to run. The matching is run against [name of the testfolder eg. "01parsing"]/[name of the test]
To only run test which should pass you can run the following first parameter:
```
parameters: *_pass*
```
To only run test which should are in the type checking you can run the following first parameter:
```
parameters: 03*
```

### Naming of the tests
All names for the tests are following this naming convention. 
With that naming convention the building script can check if a test should pass and 
with the proper placement inside the test folders it can also correctly check where it failed and if the test was going good enough
```
[3 digit test ID]_[pass/fail]_[testname without any underscores].c0
```
If a test should also test the return value of the output of the CMA machine then there is another field put after the pass/fail looking like this:
```
[3 digit test ID]_[pass/fail]_[return value of CMA]_[testname without any underscores].c0
```
