# Specifications
Grammar rules for the [C0-language 2015](c0-reference.pdf).

## Keywords [15]
* int 
* bool 
* string 
* char 
* void 
* struct 
* typedef 
* if 
* else 
* while 
* for 
* continue 
* break 
* return 
* assert 
* true 
* false 
* NULL 
* alloc 
* alloc_array

## Types
| Type      | Description
| -         | -
| int       | 2^31 − 1 = 2147483647
| bool      |
| char      |
| string    |
| *t [ ]*   | *∀ t ∃ t [ ]*
| *t* *     | *∀ t ∃ t* *
| struct    |

## Functions [4]
Functions are not ﬁrst-class in C0, but can only be declared or deﬁned at the top-level of a ﬁle. A function deﬁnition has the form `t g (t1 x1, ..., tn xn) { body }`
where `t` is the result type of the function called `g` which takes `n` arguments of type `t1,...,tn`.

Functions may be declared without giving a deﬁnition in the form
`t g (t1 x1, ..., tn xn);`

Function calls have the form `g(e1,...,en)`

## Commands [5]
Commands occur in the bodies of functions. There are
* assignments
* conditionals
* loops 
* blocks
* returns

### Assignments [5]
Basic assignments `x = e;`

### Expressions as Statements

### Conditionals

### Loops

### Blocks

### Returns

### Assertions

### Errors

## Structs [10]

## Compiler directives [15]
Compiler directives are always on a single line and have the form `#use` followed by white space and then either a library literal `<liblit>` or a string literal `<strlit>`. Other top-level directives starting with `#` are ignored, but may produce a warning. 

## Contracts

### Function Contracts

### Loop Invariants

### Assertions

### Purity

## Grammar

### Non-printing characters [14]
Whitespace separates tokens, but is otherwise ignored. Other control (non-printing) characters in the input constitute an error.

### Tokens [15]
```
<id>        ::= [A-Za-z_][A-Za-z0-9_]*
<num>       ::= <decnum> | <hexnum>
<decnum>    ::= 0 | [1-9][0-9]*
<hexnum>    ::= 0[xX][0-9a-fA-F]+
<strlit>    ::= "<schar>*" 
<chrlit>    ::= '<cchar>'
<liblit>    ::= <<lchar>*>
<schar>     ::= <nchar> | <esc>
<cchar>     ::= <nchar> | <esc> | " | \0 
<nchar>     ::= (normal printing character except ") 
<lchar>     ::= (normal printing character except >) 
<esc>       ::= \n | \t | \v | \b | \r | \f | \a | \\ | \’ | \"
<sep>       ::= ( | ) | [ | ] | { | } | , | ; 
<unop>      ::= ! | ~ | - | * 
<binop>     ::= . | -> | * | / | % | + | - | << | >> | < | <= | >= | > | == | !=
                | & | ^ | | | && | || | ? | : 
<asnop>     ::= = | += | -= | *= | /= | %= | <<= | >>= | &= | ^= | |= 
<postop>    ::= -- | ++
```

### Productions
```
<prog>      ::= (<gdecl> | <gdefn>)*
<gdecl>     ::= struct <sid> ; 
                | <tp> <vid> ( [<tp> <vid> (, <tp> <vid>)*] ) ; 
                | #use <liblit> \n 
                | #use <strlit> \n
<gdefn>     ::= struct <sid> { (<tp> <fid> ;)* } ; 
                | <tp> <vid> ( [<tp> <vid> (, <tp> <vid>)*] ) { <stmt>* } 
                | typedef <tp> <aid> ;
<stmt>      ::= <simple> ; 
                | if ( <exp> ) <stmt> [ else <stmt> ] 
                | while ( <exp> ) <stmt> 
                | for ( [<simple>] ; <exp> ; [<simple>] ) <stmt> 
                | return [<exp>] ; 
                | { <stmt>* } 
                | assert ( <exp> ) ; 
                | error ( <exp> ) ;
<simple>    ::= <lv> <asnop> <exp> 
                | <lv> ++ 
                | <lv> --
                | <exp> 
                | <tp> <vid> [= <exp>]
<lv>        ::= <vid> 
                | <lv> . <fid> 
                | <lv> -> <fid> 
                | * <lv> 
                | <lv> [ <exp> ] 
                | ( <lv> )
<tp>        ::= int 
                | bool 
                | string 
                | char 
                | void 
                | <tp> * 
                | <tp> [ ] 
                | struct <sid> 
                | <aid>
<exp>       ::= ( <exp> ) 
                | <num> 
                | <strlit> 
                | <chrlit> 
                | true 
                | false 
                | NULL 
                | <vid> 
                | <exp> <binop> <exp> 
                | <unop> <exp> 
                | <exp> ? <exp> : <exp> 
                | <vid> ( [<exp> (, <exp>)*] ) 
                | <exp> . <fid> 
                | <exp> -> <fid> 
                | <exp> [ <exp> ] 
                | alloc ( <tp> ) 
                | alloc_array ( <tp> , <exp> )
```