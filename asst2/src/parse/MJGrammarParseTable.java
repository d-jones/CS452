package
parse
;
import
java
.
util
.
ArrayList
;
import
java
.
util
.
List
;
import
errorMsg
.
*
;
import
syntaxtree
.
*
;
public class MJGrammarParseTable implements wrangLR.runtime.ParseTable {
public int getEofSym() { return 137; }
public int getNttSym() { return 138; }
private String[] symNameTable = {
"$$start",
"<start>",
"ws*",
"<program>",
"<class decl>+",
"<class decl>",
"`class",
"ID",
"`{",
"<decl in class>*",
"`}",
"<decl in class>",
"<method decl>",
"<inst var decl>",
"`public",
"`void",
"`(",
"`)",
"<stmt>*",
"<type>",
"`;",
"`int",
"`boolean",
"<empty bracket pair>",
"`[",
"`]",
"<stmt>",
"<assign>",
"`break",
"<local var decl>",
"<exp>",
"`=",
"`++",
"`--",
"<exp1>",
"`||",
"<exp2>",
"`&&",
"<exp3>",
"`!=",
"<exp4>",
"`==",
"`<",
"<exp5>",
"`>",
"`<=",
"`>=",
"`instanceof",
"`+",
"<exp6>",
"`-",
"`*",
"<exp7>",
"`/",
"`%",
"<cast exp>",
"<unary exp>",
"<exp8>",
"`!",
"INTLIT",
"STRINGLIT",
"CHARLIT",
"`this",
"`true",
"`false",
"`.",
"`new",
"<empty bracket pair>*",
"letter",
"\"a\"",
"\"p\"",
"\"v\"",
"\"c\"",
"\"f\"",
"\"i\"",
"\"l\"",
"\"o\"",
"\"r\"",
"\"u\"",
"\"b\"",
"\"e\"",
"\"h\"",
"{\"A\"..\"Z\" \"d\" \"g\" \"j\"..\"k\" \"m\" \"q\" \"s\" \"w\"..\"z\"}",
"\"n\"",
"\"t\"",
"letter128",
"{199..218 231..250}",
"{193..198 225..230}",
"digit",
"{\"1\"..\"9\"}",
"\"0\"",
"digit128",
"{176..185}",
"any",
"\"[\"",
"\"-\"",
"\"<\"",
"\"|\"",
"\" \"",
"\"#\"",
"\"&\"",
"\")\"",
"\"]\"",
"\"/\"",
"\";\"",
"{0..9 11..31 \"$\" \",\" \":\" \"?\" \"\\\" \"^\" \"`\" \"~\"..127}",
"\">\"",
"\"{\"",
"\"%\"",
"\"(\"",
"\"+\"",
"\".\"",
"\"_\"",
"\"=\"",
"\"@\"",
"10",
"\"}\"",
"\"!\"",
"\"\'\"",
"\'\"\'",
"\"*\"",
"any128",
"{223}",
"{128..175 186..192 219..222 224 251..255}",
"ws",
"idChar*",
"$$0",
"digit*",
"$$1",
"hexDigit*",
"$$2",
"any*",
"$$3",
"idChar",
"idChar128",
"hexDigit",
"hexDigit128",
"$",
"$NT",
};
public String symName(int n) {
 return n >= 0 && n < symNameTable.length ? symNameTable[n] : "??";
}
private MJGrammar actionObject;
public int[][] getParseTable() { return parseTable; }
public int numSymbols() { return 139;}
private static final int MIN_REDUCTION = 416;
public int minReduction() { return MIN_REDUCTION;}
private static final int MAX_ACCEPT_REDUCTION = MIN_REDUCTION+0;
public int maxAcceptReduction() { return MAX_ACCEPT_REDUCTION; }
private final int[][] parseTable;
public void error(int pos, String msg){
 if (((Object)actionObject) instanceof wrangLR.runtime.MessageObject)
 ((wrangLR.runtime.MessageObject)(Object)actionObject).error(pos,msg);
 else System.err.println("file position "+pos+": "+msg);}
public void warning(int pos, String msg){
 if (((Object)actionObject) instanceof wrangLR.runtime.MessageObject)
 ((wrangLR.runtime.MessageObject)(Object)actionObject).warning(pos,msg);
 else System.err.println("file position "+pos+"(warning): "+msg);}
public String filePosString(int pos){
 if (((Object)actionObject) instanceof wrangLR.runtime.FilePosObject)
 return ((wrangLR.runtime.FilePosObject)(Object)actionObject).filePosString(pos);
 else return ""+pos;}
public boolean parse(java.io.InputStream is) {
	return new wrangLR.runtime.BaseParser(this).parse(is);
}
public boolean parse(java.io.InputStream is, int verboseLevel, boolean verboseReductions) {
	return new wrangLR.runtime.BaseParser(this,verboseLevel,verboseReductions).parse(is);
}
private class Initter1{
public int doInit(int startIdx) {
  for (int i = 0; i < myParseTable.length; i++) {
    parseTable[i+startIdx] = myParseTable[i];
  }
  return myParseTable.length;
}
private final int[][] myParseTable = {
{ // state 0
1,336, // <start>
2,402, // ws*
3,387, // <program>
4,147, // <class decl>+
5,414, // <class decl>
6,83, // `class
98,101, // " "
99,37, // "#"
115,75, // {10}
124,222, // ws
  }
,
{ // state 1
0x80000000|161, // match move
0x80000000|88, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 2
  }
,
{ // state 3
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 4
48,70, // `+
50,230, // `-
95,173, // "-"
110,144, // "+"
MIN_REDUCTION+36, // (default reduction)
  }
,
{ // state 5
2,394, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+99, // (default reduction)
  }
,
{ // state 6
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+102, // (default reduction)
  }
,
{ // state 7
2,6, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+103, // (default reduction)
  }
,
{ // state 8
24,MIN_REDUCTION+182, // `[
94,MIN_REDUCTION+182, // "["
MIN_REDUCTION+182, // (default reduction)
  }
,
{ // state 9
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 10
0x80000000|2, // match move
0x80000000|372, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 11
35,355, // `||
114,236, // "@"
MIN_REDUCTION+27, // (default reduction)
  }
,
{ // state 12
2,253, // ws*
24,MIN_REDUCTION+127, // `[
98,334, // " "
115,71, // {10}
124,46, // ws
MIN_REDUCTION+127, // (default reduction)
  }
,
{ // state 13
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+110, // (default reduction)
  }
,
{ // state 14
MIN_REDUCTION+178, // (default reduction)
  }
,
{ // state 15
2,330, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+83, // (default reduction)
  }
,
{ // state 16
MIN_REDUCTION+165, // (default reduction)
  }
,
{ // state 17
138,MIN_REDUCTION+15, // $NT
MIN_REDUCTION+15, // (default reduction)
  }
,
{ // state 18
76,370, // "o"
  }
,
{ // state 19
2,289, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+123, // (default reduction)
  }
,
{ // state 20
2,293, // ws*
  }
,
{ // state 21
MIN_REDUCTION+71, // (default reduction)
  }
,
{ // state 22
MIN_REDUCTION+10, // (default reduction)
  }
,
{ // state 23
20,406, // `;
104,204, // ";"
  }
,
{ // state 24
MIN_REDUCTION+12, // (default reduction)
  }
,
{ // state 25
69,227, // "a"
70,227, // "p"
71,227, // "v"
72,227, // "c"
73,227, // "f"
74,227, // "i"
75,227, // "l"
76,227, // "o"
77,227, // "r"
78,227, // "u"
79,227, // "b"
80,227, // "e"
81,227, // "h"
82,227, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,227, // "n"
84,227, // "t"
86,305, // {199..218 231..250}
87,305, // {193..198 225..230}
89,227, // {"1".."9"}
90,227, // "0"
92,305, // {176..185}
93,340, // any
94,227, // "["
95,227, // "-"
96,227, // "<"
97,227, // "|"
98,227, // " "
99,227, // "#"
100,227, // "&"
101,227, // ")"
102,227, // "]"
103,227, // "/"
104,227, // ";"
105,227, // {0..9 11..31 "$" "," ":" "?" "\" "^" "`" "~"..127}
106,227, // ">"
107,227, // "{"
108,227, // "%"
109,227, // "("
110,227, // "+"
111,227, // "."
112,227, // "_"
113,227, // "="
114,227, // "@"
115,227, // {10}
116,227, // "}"
117,227, // "!"
118,227, // "'"
119,227, // '"'
120,227, // "*"
121,356, // any128
122,305, // {223}
123,305, // {128..175 186..192 219..222 224 251..255}
131,390, // any*
132,121, // $$3
  }
,
{ // state 26
20,338, // `;
104,204, // ";"
  }
,
{ // state 27
0x80000000|2, // match move
0x80000000|91, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 28
68,109, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,352, // letter128
86,209, // {199..218 231..250}
87,209, // {193..198 225..230}
88,16, // digit
89,245, // {"1".."9"}
90,245, // "0"
91,57, // digit128
92,21, // {176..185}
112,354, // "_"
122,208, // {223}
125,332, // idChar*
126,142, // $$0
133,152, // idChar
134,43, // idChar128
  }
,
{ // state 29
2,410, // ws*
24,MIN_REDUCTION+159, // `[
94,MIN_REDUCTION+159, // "["
98,334, // " "
115,71, // {10}
124,46, // ws
MIN_REDUCTION+159, // (default reduction)
  }
,
{ // state 30
2,249, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+95, // (default reduction)
  }
,
{ // state 31
51,33, // `*
53,399, // `/
54,53, // `%
103,214, // "/"
108,7, // "%"
120,116, // "*"
MIN_REDUCTION+42, // (default reduction)
  }
,
{ // state 32
24,MIN_REDUCTION+171, // `[
94,MIN_REDUCTION+171, // "["
MIN_REDUCTION+171, // (default reduction)
  }
,
{ // state 33
7,229, // ID
16,106, // `(
48,303, // `+
50,39, // `-
52,67, // <exp7>
55,44, // <cast exp>
56,247, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,349, // "#"
109,168, // "("
110,144, // "+"
114,233, // "@"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 34
MIN_REDUCTION+170, // (default reduction)
  }
,
{ // state 35
0x80000000|149, // match move
0x80000000|115, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 36
0x80000000|207, // match move
0x80000000|12, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 37
72,63, // "c"
  }
,
{ // state 38
MIN_REDUCTION+53, // (default reduction)
  }
,
{ // state 39
7,229, // ID
48,303, // `+
50,39, // `-
56,240, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,349, // "#"
110,144, // "+"
114,233, // "@"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 40
MIN_REDUCTION+183, // (default reduction)
  }
,
{ // state 41
24,MIN_REDUCTION+148, // `[
94,MIN_REDUCTION+148, // "["
98,334, // " "
115,71, // {10}
124,401, // ws
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 42
24,MIN_REDUCTION+69, // `[
94,MIN_REDUCTION+69, // "["
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 43
2,89, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+191, // (default reduction)
  }
,
{ // state 44
MIN_REDUCTION+48, // (default reduction)
  }
,
{ // state 45
7,229, // ID
16,106, // `(
43,235, // <exp5>
48,303, // `+
49,223, // <exp6>
50,39, // `-
52,140, // <exp7>
55,44, // <cast exp>
56,247, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,349, // "#"
109,168, // "("
110,144, // "+"
114,233, // "@"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 46
0x80000000|132, // match move
0x80000000|191, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 47
0x80000000|2, // match move
0x80000000|64, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 48
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+114, // (default reduction)
  }
,
{ // state 49
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+100, // (default reduction)
  }
,
{ // state 50
24,MIN_REDUCTION+90, // `[
94,MIN_REDUCTION+90, // "["
98,334, // " "
115,71, // {10}
124,401, // ws
MIN_REDUCTION+90, // (default reduction)
  }
,
{ // state 51
24,MIN_REDUCTION+178, // `[
94,MIN_REDUCTION+178, // "["
MIN_REDUCTION+178, // (default reduction)
  }
,
{ // state 52
24,MIN_REDUCTION+150, // `[
94,MIN_REDUCTION+150, // "["
MIN_REDUCTION+150, // (default reduction)
  }
,
{ // state 53
7,229, // ID
16,106, // `(
48,303, // `+
50,39, // `-
52,180, // <exp7>
55,44, // <cast exp>
56,247, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,349, // "#"
109,168, // "("
110,144, // "+"
114,233, // "@"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 54
24,MIN_REDUCTION+169, // `[
94,MIN_REDUCTION+169, // "["
MIN_REDUCTION+169, // (default reduction)
  }
,
{ // state 55
39,367, // `!=
41,186, // `==
114,167, // "@"
MIN_REDUCTION+31, // (default reduction)
  }
,
{ // state 56
MIN_REDUCTION+15, // (default reduction)
  }
,
{ // state 57
MIN_REDUCTION+168, // (default reduction)
  }
,
{ // state 58
31,361, // `=
113,68, // "="
  }
,
{ // state 59
69,333, // "a"
70,333, // "p"
71,333, // "v"
72,333, // "c"
73,333, // "f"
74,333, // "i"
75,333, // "l"
76,333, // "o"
77,333, // "r"
78,333, // "u"
79,333, // "b"
80,333, // "e"
81,333, // "h"
82,333, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,333, // "n"
84,333, // "t"
89,333, // {"1".."9"}
90,333, // "0"
93,119, // any
94,333, // "["
95,333, // "-"
96,333, // "<"
97,333, // "|"
98,333, // " "
99,333, // "#"
100,333, // "&"
101,333, // ")"
102,333, // "]"
103,333, // "/"
104,333, // ";"
105,333, // {0..9 11..31 "$" "," ":" "?" "\" "^" "`" "~"..127}
106,333, // ">"
107,333, // "{"
108,333, // "%"
109,333, // "("
110,333, // "+"
111,333, // "."
112,333, // "_"
113,333, // "="
114,333, // "@"
115,333, // {10}
116,333, // "}"
117,333, // "!"
118,333, // "'"
119,333, // '"'
120,333, // "*"
  }
,
{ // state 60
7,229, // ID
16,106, // `(
43,4, // <exp5>
48,303, // `+
49,223, // <exp6>
50,39, // `-
52,140, // <exp7>
55,44, // <cast exp>
56,247, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,349, // "#"
109,168, // "("
110,144, // "+"
114,233, // "@"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 61
24,MIN_REDUCTION+63, // `[
94,MIN_REDUCTION+63, // "["
MIN_REDUCTION+63, // (default reduction)
  }
,
{ // state 62
69,34, // "a"
70,34, // "p"
71,34, // "v"
72,34, // "c"
73,34, // "f"
74,34, // "i"
75,34, // "l"
76,34, // "o"
77,34, // "r"
78,34, // "u"
79,34, // "b"
80,34, // "e"
81,34, // "h"
82,34, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,34, // "n"
84,34, // "t"
87,66, // {193..198 225..230}
89,34, // {"1".."9"}
90,34, // "0"
92,66, // {176..185}
130,27, // $$2
135,268, // hexDigit
136,100, // hexDigit128
  }
,
{ // state 63
75,360, // "l"
  }
,
{ // state 64
24,MIN_REDUCTION+153, // `[
94,MIN_REDUCTION+153, // "["
MIN_REDUCTION+153, // (default reduction)
  }
,
{ // state 65
MIN_REDUCTION+182, // (default reduction)
  }
,
{ // state 66
0x80000000|371, // match move
0x80000000|32, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 67
MIN_REDUCTION+44, // (default reduction)
  }
,
{ // state 68
2,131, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+121, // (default reduction)
  }
,
{ // state 69
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+134, // (default reduction)
  }
,
{ // state 70
7,229, // ID
16,106, // `(
48,303, // `+
49,213, // <exp6>
50,39, // `-
52,140, // <exp7>
55,44, // <cast exp>
56,247, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,349, // "#"
109,168, // "("
110,144, // "+"
114,233, // "@"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 71
0x80000000|244, // match move
0x80000000|128, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 72
2,145, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+97, // (default reduction)
  }
,
{ // state 73
24,MIN_REDUCTION+62, // `[
94,MIN_REDUCTION+62, // "["
MIN_REDUCTION+62, // (default reduction)
  }
,
{ // state 74
MIN_REDUCTION+167, // (default reduction)
  }
,
{ // state 75
138,MIN_REDUCTION+75, // $NT
MIN_REDUCTION+75, // (default reduction)
  }
,
{ // state 76
7,MIN_REDUCTION+13, // ID
24,MIN_REDUCTION+56, // `[
32,86, // `++
33,404, // `--
69,MIN_REDUCTION+13, // "a"
70,MIN_REDUCTION+13, // "p"
71,MIN_REDUCTION+13, // "v"
72,MIN_REDUCTION+13, // "c"
73,MIN_REDUCTION+13, // "f"
74,MIN_REDUCTION+13, // "i"
75,MIN_REDUCTION+13, // "l"
76,MIN_REDUCTION+13, // "o"
77,MIN_REDUCTION+13, // "r"
78,MIN_REDUCTION+13, // "u"
79,MIN_REDUCTION+13, // "b"
80,MIN_REDUCTION+13, // "e"
81,MIN_REDUCTION+13, // "h"
82,MIN_REDUCTION+13, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,MIN_REDUCTION+13, // "n"
84,MIN_REDUCTION+13, // "t"
86,MIN_REDUCTION+13, // {199..218 231..250}
87,MIN_REDUCTION+13, // {193..198 225..230}
94,MIN_REDUCTION+56, // "["
114,211, // "@"
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 77
0x80000000|129, // match move
0x80000000|226, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 78
MIN_REDUCTION+150, // (default reduction)
  }
,
{ // state 79
2,366, // ws*
24,MIN_REDUCTION+111, // `[
94,MIN_REDUCTION+111, // "["
98,334, // " "
115,71, // {10}
124,46, // ws
MIN_REDUCTION+111, // (default reduction)
  }
,
{ // state 80
7,219, // ID
8,386, // `{
10,159, // `}
16,106, // `(
19,335, // <type>
21,311, // `int
22,24, // `boolean
26,300, // <stmt>
27,26, // <assign>
28,120, // `break
29,23, // <local var decl>
30,58, // <exp>
32,395, // `++
33,200, // `--
34,11, // <exp1>
36,407, // <exp2>
38,55, // <exp3>
40,126, // <exp4>
43,125, // <exp5>
48,303, // `+
49,223, // <exp6>
50,39, // `-
52,140, // <exp7>
55,44, // <cast exp>
56,247, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,256, // "#"
107,280, // "{"
109,168, // "("
110,144, // "+"
114,267, // "@"
116,307, // "}"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 81
0x80000000|2, // match move
0x80000000|228, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 82
MIN_REDUCTION+151, // (default reduction)
  }
,
{ // state 83
7,400, // ID
68,28, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,176, // letter128
86,209, // {199..218 231..250}
87,209, // {193..198 225..230}
  }
,
{ // state 84
MIN_REDUCTION+181, // (default reduction)
  }
,
{ // state 85
17,246, // `)
101,327, // ")"
  }
,
{ // state 86
MIN_REDUCTION+22, // (default reduction)
  }
,
{ // state 87
7,229, // ID
16,106, // `(
43,205, // <exp5>
48,303, // `+
49,223, // <exp6>
50,39, // `-
52,140, // <exp7>
55,44, // <cast exp>
56,247, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,349, // "#"
109,168, // "("
110,144, // "+"
114,233, // "@"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 88
24,MIN_REDUCTION+71, // `[
94,MIN_REDUCTION+71, // "["
MIN_REDUCTION+71, // (default reduction)
  }
,
{ // state 89
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+190, // (default reduction)
  }
,
{ // state 90
MIN_REDUCTION+4, // (default reduction)
  }
,
{ // state 91
24,MIN_REDUCTION+156, // `[
94,MIN_REDUCTION+156, // "["
MIN_REDUCTION+156, // (default reduction)
  }
,
{ // state 92
0x80000000|2, // match move
0x80000000|73, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 93
16,316, // `(
109,168, // "("
MIN_REDUCTION+13, // (default reduction)
  }
,
{ // state 94
24,MIN_REDUCTION+192, // `[
94,MIN_REDUCTION+192, // "["
98,334, // " "
115,71, // {10}
124,401, // ws
MIN_REDUCTION+192, // (default reduction)
  }
,
{ // state 95
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+132, // (default reduction)
  }
,
{ // state 96
2,309, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+77, // (default reduction)
  }
,
{ // state 97
24,MIN_REDUCTION+61, // `[
94,MIN_REDUCTION+61, // "["
MIN_REDUCTION+61, // (default reduction)
  }
,
{ // state 98
24,MIN_REDUCTION+194, // `[
94,MIN_REDUCTION+194, // "["
98,334, // " "
115,71, // {10}
124,401, // ws
MIN_REDUCTION+194, // (default reduction)
  }
,
{ // state 99
0x80000000|2, // match move
0x80000000|138, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 100
0x80000000|411, // match move
0x80000000|181, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 101
138,MIN_REDUCTION+74, // $NT
MIN_REDUCTION+74, // (default reduction)
  }
,
{ // state 102
2,410, // ws*
  }
,
{ // state 103
0x80000000|2, // match move
0x80000000|382, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 104
24,MIN_REDUCTION+154, // `[
94,MIN_REDUCTION+154, // "["
98,334, // " "
115,71, // {10}
124,401, // ws
MIN_REDUCTION+154, // (default reduction)
  }
,
{ // state 105
MIN_REDUCTION+150, // (default reduction)
  }
,
{ // state 106
7,392, // ID
19,396, // <type>
21,311, // `int
22,24, // `boolean
68,28, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,176, // letter128
86,209, // {199..218 231..250}
87,209, // {193..198 225..230}
99,348, // "#"
  }
,
{ // state 107
2,69, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+135, // (default reduction)
  }
,
{ // state 108
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+106, // (default reduction)
  }
,
{ // state 109
MIN_REDUCTION+164, // (default reduction)
  }
,
{ // state 110
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 111
MIN_REDUCTION+19, // (default reduction)
  }
,
{ // state 112
0x80000000|260, // match move
0x80000000|54, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 113
MIN_REDUCTION+6, // (default reduction)
  }
,
{ // state 114
0x80000000|405, // match move
0x80000000|243, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 115
24,MIN_REDUCTION+65, // `[
94,MIN_REDUCTION+65, // "["
MIN_REDUCTION+65, // (default reduction)
  }
,
{ // state 116
2,108, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+107, // (default reduction)
  }
,
{ // state 117
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 118
2,325, // ws*
24,MIN_REDUCTION+87, // `[
94,MIN_REDUCTION+87, // "["
98,334, // " "
115,71, // {10}
124,46, // ws
MIN_REDUCTION+87, // (default reduction)
  }
,
{ // state 119
0x80000000|20, // match move
0x80000000|188, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 120
MIN_REDUCTION+17, // (default reduction)
  }
,
{ // state 121
0x80000000|2, // match move
0x80000000|384, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 122
2,255, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+105, // (default reduction)
  }
,
{ // state 123
MIN_REDUCTION+180, // (default reduction)
  }
,
{ // state 124
48,70, // `+
50,230, // `-
95,173, // "-"
110,144, // "+"
MIN_REDUCTION+38, // (default reduction)
  }
,
{ // state 125
48,70, // `+
50,230, // `-
95,173, // "-"
110,144, // "+"
MIN_REDUCTION+40, // (default reduction)
  }
,
{ // state 126
42,45, // `<
44,60, // `>
45,87, // `<=
46,170, // `>=
47,331, // `instanceof
96,376, // "<"
99,239, // "#"
106,158, // ">"
114,285, // "@"
MIN_REDUCTION+34, // (default reduction)
  }
,
{ // state 127
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+84, // (default reduction)
  }
,
{ // state 128
24,MIN_REDUCTION+75, // `[
94,MIN_REDUCTION+75, // "["
MIN_REDUCTION+75, // (default reduction)
  }
,
{ // state 129
MIN_REDUCTION+190, // (default reduction)
  }
,
{ // state 130
71,18, // "v"
  }
,
{ // state 131
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+120, // (default reduction)
  }
,
{ // state 132
MIN_REDUCTION+179, // (default reduction)
  }
,
{ // state 133
MIN_REDUCTION+21, // (default reduction)
  }
,
{ // state 134
MIN_REDUCTION+13, // (default reduction)
  }
,
{ // state 135
2,366, // ws*
  }
,
{ // state 136
37,383, // `&&
114,287, // "@"
MIN_REDUCTION+28, // (default reduction)
  }
,
{ // state 137
24,270, // `[
65,271, // `.
94,397, // "["
111,242, // "."
MIN_REDUCTION+51, // (default reduction)
  }
,
{ // state 138
24,MIN_REDUCTION+58, // `[
94,MIN_REDUCTION+58, // "["
MIN_REDUCTION+58, // (default reduction)
  }
,
{ // state 139
0x80000000|82, // match move
0x80000000|326, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 140
MIN_REDUCTION+47, // (default reduction)
  }
,
{ // state 141
24,MIN_REDUCTION+126, // `[
98,334, // " "
115,71, // {10}
124,401, // ws
MIN_REDUCTION+126, // (default reduction)
  }
,
{ // state 142
MIN_REDUCTION+151, // (default reduction)
  }
,
{ // state 143
31,350, // `=
113,68, // "="
  }
,
{ // state 144
2,408, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+119, // (default reduction)
  }
,
{ // state 145
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+96, // (default reduction)
  }
,
{ // state 146
24,MIN_REDUCTION+158, // `[
94,MIN_REDUCTION+158, // "["
98,334, // " "
115,71, // {10}
124,401, // ws
MIN_REDUCTION+158, // (default reduction)
  }
,
{ // state 147
5,347, // <class decl>
6,83, // `class
99,37, // "#"
MIN_REDUCTION+3, // (default reduction)
  }
,
{ // state 148
24,MIN_REDUCTION+183, // `[
94,MIN_REDUCTION+183, // "["
MIN_REDUCTION+183, // (default reduction)
  }
,
{ // state 149
23,363, // <empty bracket pair>
24,198, // `[
94,397, // "["
  }
,
{ // state 150
2,237, // ws*
MIN_REDUCTION+149, // (default reduction)
  }
,
{ // state 151
7,93, // ID
19,169, // <type>
21,311, // `int
22,24, // `boolean
68,28, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,176, // letter128
86,209, // {199..218 231..250}
87,209, // {193..198 225..230}
99,348, // "#"
  }
,
{ // state 152
MIN_REDUCTION+187, // (default reduction)
  }
,
{ // state 153
24,MIN_REDUCTION+168, // `[
94,MIN_REDUCTION+168, // "["
MIN_REDUCTION+168, // (default reduction)
  }
,
{ // state 154
42,45, // `<
44,60, // `>
45,87, // `<=
46,170, // `>=
47,331, // `instanceof
96,376, // "<"
99,239, // "#"
106,158, // ">"
114,285, // "@"
MIN_REDUCTION+33, // (default reduction)
  }
,
{ // state 155
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 156
2,193, // ws*
24,MIN_REDUCTION+193, // `[
94,MIN_REDUCTION+193, // "["
98,334, // " "
115,71, // {10}
124,46, // ws
MIN_REDUCTION+193, // (default reduction)
  }
,
{ // state 157
77,319, // "r"
81,194, // "h"
  }
,
{ // state 158
0x80000000|2, // match move
0x80000000|107, // no-match move
// T-test match for "=":
113,
  }
,
{ // state 159
MIN_REDUCTION+18, // (default reduction)
  }
,
{ // state 160
2,281, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+143, // (default reduction)
  }
,
{ // state 161
MIN_REDUCTION+71, // (default reduction)
  }
,
{ // state 162
15,377, // `void
99,130, // "#"
  }
,
{ // state 163
25,17, // `]
102,313, // "]"
  }
,
{ // state 164
7,392, // ID
9,210, // <decl in class>*
10,279, // `}
11,315, // <decl in class>
12,113, // <method decl>
13,317, // <inst var decl>
14,162, // `public
19,259, // <type>
21,311, // `int
22,24, // `boolean
68,28, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,176, // letter128
86,209, // {199..218 231..250}
87,209, // {193..198 225..230}
99,337, // "#"
116,307, // "}"
  }
,
{ // state 165
76,96, // "o"
77,171, // "r"
  }
,
{ // state 166
20,22, // `;
104,204, // ";"
  }
,
{ // state 167
97,274, // "|"
100,122, // "&"
113,19, // "="
117,224, // "!"
  }
,
{ // state 168
2,344, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+109, // (default reduction)
  }
,
{ // state 169
23,369, // <empty bracket pair>
24,199, // `[
94,397, // "["
  }
,
{ // state 170
7,229, // ID
16,106, // `(
43,124, // <exp5>
48,303, // `+
49,223, // <exp6>
50,39, // `-
52,140, // <exp7>
55,44, // <cast exp>
56,247, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,349, // "#"
109,168, // "("
110,144, // "+"
114,233, // "@"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 171
2,127, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+85, // (default reduction)
  }
,
{ // state 172
24,MIN_REDUCTION+196, // `[
94,MIN_REDUCTION+196, // "["
98,334, // " "
115,71, // {10}
124,401, // ws
MIN_REDUCTION+196, // (default reduction)
  }
,
{ // state 173
2,196, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+117, // (default reduction)
  }
,
{ // state 174
0x80000000|2, // match move
0x80000000|272, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 175
0x80000000|2, // match move
0x80000000|104, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 176
2,9, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+149, // (default reduction)
  }
,
{ // state 177
MIN_REDUCTION+50, // (default reduction)
  }
,
{ // state 178
7,229, // ID
48,303, // `+
50,39, // `-
56,225, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,349, // "#"
110,144, // "+"
114,233, // "@"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 179
MIN_REDUCTION+1, // (default reduction)
  }
,
{ // state 180
MIN_REDUCTION+46, // (default reduction)
  }
,
{ // state 181
2,220, // ws*
24,MIN_REDUCTION+195, // `[
94,MIN_REDUCTION+195, // "["
98,334, // " "
115,71, // {10}
124,46, // ws
MIN_REDUCTION+195, // (default reduction)
  }
,
{ // state 182
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+138, // (default reduction)
  }
,
{ // state 183
MIN_REDUCTION+23, // (default reduction)
  }
,
{ // state 184
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+140, // (default reduction)
  }
,
{ // state 185
MIN_REDUCTION+9, // (default reduction)
  }
,
{ // state 186
7,229, // ID
16,106, // `(
40,154, // <exp4>
43,125, // <exp5>
48,303, // `+
49,223, // <exp6>
50,39, // `-
52,140, // <exp7>
55,44, // <cast exp>
56,247, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,349, // "#"
109,168, // "("
110,144, // "+"
114,233, // "@"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 187
2,81, // ws*
  }
,
{ // state 188
2,293, // ws*
24,MIN_REDUCTION+163, // `[
94,MIN_REDUCTION+163, // "["
98,334, // " "
115,71, // {10}
124,46, // ws
MIN_REDUCTION+163, // (default reduction)
  }
,
{ // state 189
7,219, // ID
8,386, // `{
10,269, // `}
16,106, // `(
19,335, // <type>
21,311, // `int
22,24, // `boolean
26,300, // <stmt>
27,26, // <assign>
28,120, // `break
29,23, // <local var decl>
30,58, // <exp>
32,395, // `++
33,200, // `--
34,11, // <exp1>
36,407, // <exp2>
38,55, // <exp3>
40,126, // <exp4>
43,125, // <exp5>
48,303, // `+
49,223, // <exp6>
50,39, // `-
52,140, // <exp7>
55,44, // <cast exp>
56,247, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,256, // "#"
107,280, // "{"
109,168, // "("
110,144, // "+"
114,267, // "@"
116,307, // "}"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 190
0x80000000|117, // match move
0x80000000|42, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 191
24,MIN_REDUCTION+179, // `[
94,MIN_REDUCTION+179, // "["
MIN_REDUCTION+179, // (default reduction)
  }
,
{ // state 192
2,175, // ws*
  }
,
{ // state 193
0x80000000|2, // match move
0x80000000|94, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 194
0x80000000|380, // match move
0x80000000|118, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 195
0x80000000|2, // match move
0x80000000|409, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 196
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+116, // (default reduction)
  }
,
{ // state 197
98,101, // " "
115,75, // {10}
124,264, // ws
138,MIN_REDUCTION+126, // $NT
MIN_REDUCTION+126, // (default reduction)
  }
,
{ // state 198
25,299, // `]
102,36, // "]"
  }
,
{ // state 199
7,229, // ID
16,106, // `(
25,17, // `]
30,306, // <exp>
34,11, // <exp1>
36,407, // <exp2>
38,55, // <exp3>
40,126, // <exp4>
43,125, // <exp5>
48,303, // `+
49,223, // <exp6>
50,39, // `-
52,140, // <exp7>
55,44, // <cast exp>
56,247, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,349, // "#"
102,313, // "]"
109,168, // "("
110,144, // "+"
114,233, // "@"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 200
7,342, // ID
68,28, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,176, // letter128
86,209, // {199..218 231..250}
87,209, // {193..198 225..230}
  }
,
{ // state 201
MIN_REDUCTION+168, // (default reduction)
  }
,
{ // state 202
24,MIN_REDUCTION+66, // `[
67,35, // <empty bracket pair>*
94,MIN_REDUCTION+66, // "["
MIN_REDUCTION+66, // (default reduction)
  }
,
{ // state 203
2,373, // ws*
24,MIN_REDUCTION+91, // `[
94,MIN_REDUCTION+91, // "["
98,334, // " "
115,71, // {10}
124,46, // ws
MIN_REDUCTION+91, // (default reduction)
  }
,
{ // state 204
2,184, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 205
48,70, // `+
50,230, // `-
95,173, // "-"
110,144, // "+"
MIN_REDUCTION+37, // (default reduction)
  }
,
{ // state 206
MIN_REDUCTION+74, // (default reduction)
  }
,
{ // state 207
2,253, // ws*
MIN_REDUCTION+127, // (default reduction)
  }
,
{ // state 208
MIN_REDUCTION+169, // (default reduction)
  }
,
{ // state 209
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 210
7,392, // ID
10,90, // `}
11,393, // <decl in class>
12,113, // <method decl>
13,317, // <inst var decl>
14,162, // `public
19,259, // <type>
21,311, // `int
22,24, // `boolean
68,28, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,176, // letter128
86,209, // {199..218 231..250}
87,209, // {193..198 225..230}
99,337, // "#"
116,307, // "}"
  }
,
{ // state 211
95,273, // "-"
96,413, // "<"
97,274, // "|"
100,122, // "&"
106,275, // ">"
110,160, // "+"
113,19, // "="
117,224, // "!"
  }
,
{ // state 212
2,373, // ws*
  }
,
{ // state 213
51,33, // `*
53,399, // `/
54,53, // `%
103,214, // "/"
108,7, // "%"
120,116, // "*"
MIN_REDUCTION+41, // (default reduction)
  }
,
{ // state 214
2,283, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 215
0x80000000|2, // match move
0x80000000|265, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 216
2,81, // ws*
24,MIN_REDUCTION+89, // `[
94,MIN_REDUCTION+89, // "["
98,334, // " "
115,71, // {10}
124,46, // ws
MIN_REDUCTION+89, // (default reduction)
  }
,
{ // state 217
MIN_REDUCTION+126, // (default reduction)
  }
,
{ // state 218
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+112, // (default reduction)
  }
,
{ // state 219
0x80000000|134, // match move
0x80000000|76, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 220
0x80000000|2, // match move
0x80000000|98, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 221
0x80000000|2, // match move
0x80000000|137, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 222
138,MIN_REDUCTION+179, // $NT
MIN_REDUCTION+179, // (default reduction)
  }
,
{ // state 223
51,33, // `*
53,399, // `/
54,53, // `%
103,214, // "/"
108,7, // "%"
120,116, // "*"
MIN_REDUCTION+43, // (default reduction)
  }
,
{ // state 224
2,49, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+101, // (default reduction)
  }
,
{ // state 225
MIN_REDUCTION+54, // (default reduction)
  }
,
{ // state 226
24,MIN_REDUCTION+190, // `[
94,MIN_REDUCTION+190, // "["
98,334, // " "
115,71, // {10}
124,401, // ws
MIN_REDUCTION+190, // (default reduction)
  }
,
{ // state 227
MIN_REDUCTION+72, // (default reduction)
  }
,
{ // state 228
24,MIN_REDUCTION+88, // `[
94,MIN_REDUCTION+88, // "["
98,334, // " "
115,71, // {10}
124,401, // ws
MIN_REDUCTION+88, // (default reduction)
  }
,
{ // state 229
0x80000000|2, // match move
0x80000000|238, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 230
7,229, // ID
16,106, // `(
48,303, // `+
49,31, // <exp6>
50,39, // `-
52,140, // <exp7>
55,44, // <cast exp>
56,247, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,349, // "#"
109,168, // "("
110,144, // "+"
114,233, // "@"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 231
2,323, // ws*
24,MIN_REDUCTION+197, // `[
94,MIN_REDUCTION+197, // "["
98,334, // " "
115,71, // {10}
124,46, // ws
MIN_REDUCTION+197, // (default reduction)
  }
,
{ // state 232
84,15, // "t"
  }
,
{ // state 233
119,252, // '"'
  }
,
{ // state 234
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+78, // (default reduction)
  }
,
{ // state 235
48,70, // `+
50,230, // `-
95,173, // "-"
110,144, // "+"
MIN_REDUCTION+35, // (default reduction)
  }
,
{ // state 236
97,274, // "|"
  }
,
{ // state 237
0x80000000|3, // match move
0x80000000|41, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 238
24,MIN_REDUCTION+56, // `[
94,MIN_REDUCTION+56, // "["
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 239
74,379, // "i"
  }
,
{ // state 240
MIN_REDUCTION+52, // (default reduction)
  }
,
{ // state 241
0x80000000|2, // match move
0x80000000|277, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 242
2,182, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+139, // (default reduction)
  }
,
{ // state 243
2,77, // ws*
24,MIN_REDUCTION+191, // `[
94,MIN_REDUCTION+191, // "["
98,334, // " "
115,71, // {10}
124,46, // ws
MIN_REDUCTION+191, // (default reduction)
  }
,
{ // state 244
MIN_REDUCTION+75, // (default reduction)
  }
,
{ // state 245
MIN_REDUCTION+70, // (default reduction)
  }
,
{ // state 246
8,296, // `{
107,280, // "{"
  }
,
{ // state 247
MIN_REDUCTION+49, // (default reduction)
  }
,
{ // state 248
0x80000000|74, // match move
0x80000000|353, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 249
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+94, // (default reduction)
  }
,
{ // state 250
0x80000000|2, // match move
0x80000000|61, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 251
0x80000000|2, // match move
0x80000000|297, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 252
0x80000000|102, // match move
0x80000000|29, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 253
0x80000000|217, // match move
0x80000000|141, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 254
0x80000000|2, // match move
0x80000000|266, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 255
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+104, // (default reduction)
  }
,
{ // state 256
73,381, // "f"
74,232, // "i"
79,165, // "b"
83,282, // "n"
84,157, // "t"
  }
,
{ // state 257
MIN_REDUCTION+72, // (default reduction)
  }
,
{ // state 258
24,MIN_REDUCTION+110, // `[
94,MIN_REDUCTION+110, // "["
98,334, // " "
115,71, // {10}
124,401, // ws
MIN_REDUCTION+110, // (default reduction)
  }
,
{ // state 259
7,166, // ID
23,369, // <empty bracket pair>
24,163, // `[
68,28, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,176, // letter128
86,209, // {199..218 231..250}
87,209, // {193..198 225..230}
94,397, // "["
  }
,
{ // state 260
MIN_REDUCTION+169, // (default reduction)
  }
,
{ // state 261
88,123, // digit
89,245, // {"1".."9"}
90,245, // "0"
91,292, // digit128
92,1, // {176..185}
128,174, // $$1
  }
,
{ // state 262
0x80000000|40, // match move
0x80000000|148, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 263
24,MIN_REDUCTION+74, // `[
94,MIN_REDUCTION+74, // "["
MIN_REDUCTION+74, // (default reduction)
  }
,
{ // state 264
138,MIN_REDUCTION+178, // $NT
MIN_REDUCTION+178, // (default reduction)
  }
,
{ // state 265
24,270, // `[
65,271, // `.
94,397, // "["
111,242, // "."
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 266
24,MIN_REDUCTION+64, // `[
94,MIN_REDUCTION+64, // "["
MIN_REDUCTION+64, // (default reduction)
  }
,
{ // state 267
95,273, // "-"
110,160, // "+"
119,252, // '"'
  }
,
{ // state 268
MIN_REDUCTION+184, // (default reduction)
  }
,
{ // state 269
MIN_REDUCTION+8, // (default reduction)
  }
,
{ // state 270
7,229, // ID
16,106, // `(
30,284, // <exp>
34,11, // <exp1>
36,407, // <exp2>
38,55, // <exp3>
40,126, // <exp4>
43,125, // <exp5>
48,303, // `+
49,223, // <exp6>
50,39, // `-
52,140, // <exp7>
55,44, // <cast exp>
56,247, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,349, // "#"
109,168, // "("
110,144, // "+"
114,233, // "@"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 271
7,254, // ID
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
  }
,
{ // state 272
24,MIN_REDUCTION+152, // `[
94,MIN_REDUCTION+152, // "["
MIN_REDUCTION+152, // (default reduction)
  }
,
{ // state 273
2,310, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+145, // (default reduction)
  }
,
{ // state 274
2,339, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+129, // (default reduction)
  }
,
{ // state 275
2,288, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+137, // (default reduction)
  }
,
{ // state 276
2,323, // ws*
  }
,
{ // state 277
24,MIN_REDUCTION+57, // `[
94,MIN_REDUCTION+57, // "["
MIN_REDUCTION+57, // (default reduction)
  }
,
{ // state 278
76,96, // "o"
  }
,
{ // state 279
MIN_REDUCTION+5, // (default reduction)
  }
,
{ // state 280
2,218, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+113, // (default reduction)
  }
,
{ // state 281
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 282
80,30, // "e"
  }
,
{ // state 283
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+146, // (default reduction)
  }
,
{ // state 284
25,241, // `]
102,36, // "]"
  }
,
{ // state 285
96,413, // "<"
97,274, // "|"
100,122, // "&"
106,275, // ">"
113,19, // "="
117,224, // "!"
  }
,
{ // state 286
MIN_REDUCTION+185, // (default reduction)
  }
,
{ // state 287
97,274, // "|"
100,122, // "&"
  }
,
{ // state 288
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+136, // (default reduction)
  }
,
{ // state 289
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+122, // (default reduction)
  }
,
{ // state 290
24,MIN_REDUCTION+73, // `[
94,MIN_REDUCTION+73, // "["
MIN_REDUCTION+73, // (default reduction)
  }
,
{ // state 291
MIN_REDUCTION+39, // (default reduction)
  }
,
{ // state 292
0x80000000|412, // match move
0x80000000|156, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 293
0x80000000|2, // match move
0x80000000|388, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 294
69,34, // "a"
70,34, // "p"
71,34, // "v"
72,34, // "c"
73,34, // "f"
74,34, // "i"
75,34, // "l"
76,34, // "o"
77,34, // "r"
78,34, // "u"
79,34, // "b"
80,34, // "e"
81,34, // "h"
82,34, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,34, // "n"
84,34, // "t"
87,66, // {193..198 225..230}
89,34, // {"1".."9"}
90,34, // "0"
92,66, // {176..185}
129,62, // hexDigit*
130,103, // $$2
135,286, // hexDigit
136,100, // hexDigit128
  }
,
{ // state 295
0x80000000|105, // match move
0x80000000|52, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 296
7,219, // ID
8,386, // `{
10,185, // `}
16,106, // `(
18,189, // <stmt>*
19,335, // <type>
21,311, // `int
22,24, // `boolean
26,308, // <stmt>
27,26, // <assign>
28,120, // `break
29,23, // <local var decl>
30,58, // <exp>
32,395, // `++
33,200, // `--
34,11, // <exp1>
36,407, // <exp2>
38,55, // <exp3>
40,126, // <exp4>
43,125, // <exp5>
48,303, // `+
49,223, // <exp6>
50,39, // `-
52,140, // <exp7>
55,44, // <cast exp>
56,247, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,256, // "#"
107,280, // "{"
109,168, // "("
110,144, // "+"
114,267, // "@"
116,307, // "}"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 297
24,MIN_REDUCTION+59, // `[
94,MIN_REDUCTION+59, // "["
MIN_REDUCTION+59, // (default reduction)
  }
,
{ // state 298
24,MIN_REDUCTION+86, // `[
94,MIN_REDUCTION+86, // "["
98,334, // " "
115,71, // {10}
124,401, // ws
MIN_REDUCTION+86, // (default reduction)
  }
,
{ // state 299
0x80000000|56, // match move
0x80000000|329, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 300
MIN_REDUCTION+172, // (default reduction)
  }
,
{ // state 301
23,262, // <empty bracket pair>
24,198, // `[
67,35, // <empty bracket pair>*
94,397, // "["
  }
,
{ // state 302
0x80000000|2, // match move
0x80000000|359, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 303
7,229, // ID
48,303, // `+
50,39, // `-
56,38, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,349, // "#"
110,144, // "+"
114,233, // "@"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 304
42,45, // `<
44,60, // `>
45,87, // `<=
46,170, // `>=
47,331, // `instanceof
96,376, // "<"
99,239, // "#"
106,158, // ">"
114,285, // "@"
MIN_REDUCTION+32, // (default reduction)
  }
,
{ // state 305
0x80000000|328, // match move
0x80000000|290, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 306
25,364, // `]
102,36, // "]"
  }
,
{ // state 307
2,48, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+115, // (default reduction)
  }
,
{ // state 308
MIN_REDUCTION+173, // (default reduction)
  }
,
{ // state 309
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+76, // (default reduction)
  }
,
{ // state 310
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+144, // (default reduction)
  }
,
{ // state 311
MIN_REDUCTION+11, // (default reduction)
  }
,
{ // state 312
7,229, // ID
16,106, // `(
55,177, // <cast exp>
57,221, // <exp8>
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
99,349, // "#"
109,168, // "("
114,233, // "@"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 313
2,197, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
138,MIN_REDUCTION+127, // $NT
MIN_REDUCTION+127, // (default reduction)
  }
,
{ // state 314
39,367, // `!=
41,186, // `==
114,167, // "@"
MIN_REDUCTION+30, // (default reduction)
  }
,
{ // state 315
MIN_REDUCTION+175, // (default reduction)
  }
,
{ // state 316
17,195, // `)
101,389, // ")"
  }
,
{ // state 317
MIN_REDUCTION+7, // (default reduction)
  }
,
{ // state 318
24,163, // `[
94,397, // "["
  }
,
{ // state 319
0x80000000|212, // match move
0x80000000|203, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 320
2,237, // ws*
24,MIN_REDUCTION+149, // `[
94,MIN_REDUCTION+149, // "["
98,334, // " "
115,71, // {10}
124,46, // ws
MIN_REDUCTION+149, // (default reduction)
  }
,
{ // state 321
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+80, // (default reduction)
  }
,
{ // state 322
68,109, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,248, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
88,16, // digit
89,245, // {"1".."9"}
90,245, // "0"
91,368, // digit128
92,1, // {176..185}
112,354, // "_"
122,112, // {223}
125,385, // idChar*
126,139, // $$0
133,152, // idChar
134,114, // idChar128
  }
,
{ // state 323
0x80000000|2, // match move
0x80000000|172, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 324
0x80000000|192, // match move
0x80000000|374, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 325
0x80000000|2, // match move
0x80000000|298, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 326
24,MIN_REDUCTION+151, // `[
94,MIN_REDUCTION+151, // "["
MIN_REDUCTION+151, // (default reduction)
  }
,
{ // state 327
2,13, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+111, // (default reduction)
  }
,
{ // state 328
MIN_REDUCTION+73, // (default reduction)
  }
,
{ // state 329
24,MIN_REDUCTION+15, // `[
94,MIN_REDUCTION+15, // "["
MIN_REDUCTION+15, // (default reduction)
  }
,
{ // state 330
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+82, // (default reduction)
  }
,
{ // state 331
7,291, // ID
68,28, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,176, // letter128
86,209, // {199..218 231..250}
87,209, // {193..198 225..230}
  }
,
{ // state 332
68,109, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,352, // letter128
86,209, // {199..218 231..250}
87,209, // {193..198 225..230}
88,16, // digit
89,245, // {"1".."9"}
90,245, // "0"
91,57, // digit128
92,21, // {176..185}
112,354, // "_"
122,208, // {223}
126,78, // $$0
133,341, // idChar
134,43, // idChar128
  }
,
{ // state 333
0x80000000|257, // match move
0x80000000|358, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 334
0x80000000|206, // match move
0x80000000|263, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 335
7,143, // ID
23,369, // <empty bracket pair>
24,163, // `[
68,28, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,176, // letter128
86,209, // {199..218 231..250}
87,209, // {193..198 225..230}
94,397, // "["
  }
,
{ // state 336
137,MIN_REDUCTION+0, // $
  }
,
{ // state 337
70,343, // "p"
74,232, // "i"
79,278, // "b"
  }
,
{ // state 338
MIN_REDUCTION+16, // (default reduction)
  }
,
{ // state 339
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+128, // (default reduction)
  }
,
{ // state 340
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 341
MIN_REDUCTION+186, // (default reduction)
  }
,
{ // state 342
MIN_REDUCTION+25, // (default reduction)
  }
,
{ // state 343
78,72, // "u"
  }
,
{ // state 344
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+108, // (default reduction)
  }
,
{ // state 345
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+130, // (default reduction)
  }
,
{ // state 346
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 347
MIN_REDUCTION+189, // (default reduction)
  }
,
{ // state 348
74,232, // "i"
79,278, // "b"
  }
,
{ // state 349
73,381, // "f"
83,282, // "n"
84,157, // "t"
  }
,
{ // state 350
7,229, // ID
16,106, // `(
30,403, // <exp>
34,11, // <exp1>
36,407, // <exp2>
38,55, // <exp3>
40,126, // <exp4>
43,125, // <exp5>
48,303, // `+
49,223, // <exp6>
50,39, // `-
52,140, // <exp7>
55,44, // <cast exp>
56,247, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,349, // "#"
109,168, // "("
110,144, // "+"
114,233, // "@"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 351
0x80000000|2, // match move
0x80000000|97, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 352
MIN_REDUCTION+167, // (default reduction)
  }
,
{ // state 353
24,MIN_REDUCTION+167, // `[
94,MIN_REDUCTION+167, // "["
MIN_REDUCTION+167, // (default reduction)
  }
,
{ // state 354
MIN_REDUCTION+166, // (default reduction)
  }
,
{ // state 355
7,229, // ID
16,106, // `(
36,136, // <exp2>
38,55, // <exp3>
40,126, // <exp4>
43,125, // <exp5>
48,303, // `+
49,223, // <exp6>
50,39, // `-
52,140, // <exp7>
55,44, // <cast exp>
56,247, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,349, // "#"
109,168, // "("
110,144, // "+"
114,233, // "@"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 356
0x80000000|276, // match move
0x80000000|231, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 357
2,398, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+93, // (default reduction)
  }
,
{ // state 358
24,MIN_REDUCTION+72, // `[
94,MIN_REDUCTION+72, // "["
MIN_REDUCTION+72, // (default reduction)
  }
,
{ // state 359
24,MIN_REDUCTION+160, // `[
94,MIN_REDUCTION+160, // "["
MIN_REDUCTION+160, // (default reduction)
  }
,
{ // state 360
2,234, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+79, // (default reduction)
  }
,
{ // state 361
7,229, // ID
16,106, // `(
30,133, // <exp>
34,11, // <exp1>
36,407, // <exp2>
38,55, // <exp3>
40,126, // <exp4>
43,125, // <exp5>
48,303, // `+
49,223, // <exp6>
50,39, // `-
52,140, // <exp7>
55,44, // <cast exp>
56,247, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,349, // "#"
109,168, // "("
110,144, // "+"
114,233, // "@"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 362
MIN_REDUCTION+45, // (default reduction)
  }
,
{ // state 363
0x80000000|65, // match move
0x80000000|8, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 364
0x80000000|301, // match move
0x80000000|202, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 365
88,84, // digit
89,245, // {"1".."9"}
90,245, // "0"
91,292, // digit128
92,1, // {176..185}
127,261, // digit*
128,47, // $$1
  }
,
{ // state 366
0x80000000|2, // match move
0x80000000|258, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 367
7,229, // ID
16,106, // `(
40,304, // <exp4>
43,125, // <exp5>
48,303, // `+
49,223, // <exp6>
50,39, // `-
52,140, // <exp7>
55,44, // <cast exp>
56,247, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,349, // "#"
109,168, // "("
110,144, // "+"
114,233, // "@"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 368
0x80000000|201, // match move
0x80000000|153, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 369
MIN_REDUCTION+14, // (default reduction)
  }
,
{ // state 370
2,321, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+81, // (default reduction)
  }
,
{ // state 371
MIN_REDUCTION+171, // (default reduction)
  }
,
{ // state 372
24,MIN_REDUCTION+60, // `[
94,MIN_REDUCTION+60, // "["
MIN_REDUCTION+60, // (default reduction)
  }
,
{ // state 373
0x80000000|2, // match move
0x80000000|50, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 374
2,175, // ws*
24,MIN_REDUCTION+155, // `[
94,MIN_REDUCTION+155, // "["
98,334, // " "
115,71, // {10}
124,46, // ws
MIN_REDUCTION+155, // (default reduction)
  }
};
}
private class Initter2{
public int doInit(int startIdx) {
  for (int i = 0; i < myParseTable.length; i++) {
    parseTable[i+startIdx] = myParseTable[i];
  }
  return myParseTable.length;
}
private final int[][] myParseTable = {
{ // state 375
0x80000000|187, // match move
0x80000000|216, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 376
2,345, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+131, // (default reduction)
  }
,
{ // state 377
7,378, // ID
68,28, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,176, // letter128
86,209, // {199..218 231..250}
87,209, // {193..198 225..230}
  }
,
{ // state 378
16,85, // `(
109,168, // "("
  }
,
{ // state 379
83,357, // "n"
  }
,
{ // state 380
2,325, // ws*
  }
,
{ // state 381
69,375, // "a"
  }
,
{ // state 382
24,MIN_REDUCTION+157, // `[
94,MIN_REDUCTION+157, // "["
MIN_REDUCTION+157, // (default reduction)
  }
,
{ // state 383
7,229, // ID
16,106, // `(
38,314, // <exp3>
40,126, // <exp4>
43,125, // <exp5>
48,303, // `+
49,223, // <exp6>
50,39, // `-
52,140, // <exp7>
55,44, // <cast exp>
56,247, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,349, // "#"
109,168, // "("
110,144, // "+"
114,233, // "@"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 384
24,MIN_REDUCTION+161, // `[
94,MIN_REDUCTION+161, // "["
MIN_REDUCTION+161, // (default reduction)
  }
,
{ // state 385
68,109, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,248, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
88,16, // digit
89,245, // {"1".."9"}
90,245, // "0"
91,368, // digit128
92,1, // {176..185}
112,354, // "_"
122,112, // {223}
126,295, // $$0
133,341, // idChar
134,114, // idChar128
  }
,
{ // state 386
7,219, // ID
8,386, // `{
10,111, // `}
16,106, // `(
18,80, // <stmt>*
19,335, // <type>
21,311, // `int
22,24, // `boolean
26,308, // <stmt>
27,26, // <assign>
28,120, // `break
29,23, // <local var decl>
30,58, // <exp>
32,395, // `++
33,200, // `--
34,11, // <exp1>
36,407, // <exp2>
38,55, // <exp3>
40,126, // <exp4>
43,125, // <exp5>
48,303, // `+
49,223, // <exp6>
50,39, // `-
52,140, // <exp7>
55,44, // <cast exp>
56,247, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,256, // "#"
107,280, // "{"
109,168, // "("
110,144, // "+"
114,267, // "@"
116,307, // "}"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 387
MIN_REDUCTION+2, // (default reduction)
  }
,
{ // state 388
24,MIN_REDUCTION+162, // `[
94,MIN_REDUCTION+162, // "["
98,334, // " "
115,71, // {10}
124,401, // ws
MIN_REDUCTION+162, // (default reduction)
  }
,
{ // state 389
0x80000000|135, // match move
0x80000000|79, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 390
69,227, // "a"
70,227, // "p"
71,227, // "v"
72,227, // "c"
73,227, // "f"
74,227, // "i"
75,227, // "l"
76,227, // "o"
77,227, // "r"
78,227, // "u"
79,227, // "b"
80,227, // "e"
81,227, // "h"
82,227, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,227, // "n"
84,227, // "t"
86,305, // {199..218 231..250}
87,305, // {193..198 225..230}
89,227, // {"1".."9"}
90,227, // "0"
92,305, // {176..185}
93,346, // any
94,227, // "["
95,227, // "-"
96,227, // "<"
97,227, // "|"
98,227, // " "
99,227, // "#"
100,227, // "&"
101,227, // ")"
102,227, // "]"
103,227, // "/"
104,227, // ";"
105,227, // {0..9 11..31 "$" "," ":" "?" "\" "^" "`" "~"..127}
106,227, // ">"
107,227, // "{"
108,227, // "%"
109,227, // "("
110,227, // "+"
111,227, // "."
112,227, // "_"
113,227, // "="
114,227, // "@"
115,227, // {10}
116,227, // "}"
117,227, // "!"
118,227, // "'"
119,227, // '"'
120,227, // "*"
121,356, // any128
122,305, // {223}
123,305, // {128..175 186..192 219..222 224 251..255}
132,302, // $$3
  }
,
{ // state 391
0x80000000|150, // match move
0x80000000|320, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 392
MIN_REDUCTION+13, // (default reduction)
  }
,
{ // state 393
MIN_REDUCTION+174, // (default reduction)
  }
,
{ // state 394
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+98, // (default reduction)
  }
,
{ // state 395
7,183, // ID
68,28, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,176, // letter128
86,209, // {199..218 231..250}
87,209, // {193..198 225..230}
  }
,
{ // state 396
17,312, // `)
23,369, // <empty bracket pair>
24,163, // `[
94,397, // "["
101,327, // ")"
  }
,
{ // state 397
2,155, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 398
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+92, // (default reduction)
  }
,
{ // state 399
7,229, // ID
16,106, // `(
48,303, // `+
50,39, // `-
52,362, // <exp7>
55,44, // <cast exp>
56,247, // <unary exp>
57,215, // <exp8>
58,178, // `!
59,99, // INTLIT
60,251, // STRINGLIT
61,10, // CHARLIT
62,351, // `this
63,92, // `true
64,250, // `false
66,151, // `new
68,322, // letter
69,110, // "a"
70,110, // "p"
71,110, // "v"
72,110, // "c"
73,110, // "f"
74,110, // "i"
75,110, // "l"
76,110, // "o"
77,110, // "r"
78,110, // "u"
79,110, // "b"
80,110, // "e"
81,110, // "h"
82,110, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
83,110, // "n"
84,110, // "t"
85,391, // letter128
86,190, // {199..218 231..250}
87,190, // {193..198 225..230}
89,365, // {"1".."9"}
90,294, // "0"
91,324, // digit128
92,1, // {176..185}
95,173, // "-"
99,349, // "#"
109,168, // "("
110,144, // "+"
114,233, // "@"
117,5, // "!"
118,59, // "'"
119,25, // '"'
  }
,
{ // state 400
8,164, // `{
107,280, // "{"
  }
,
{ // state 401
0x80000000|14, // match move
0x80000000|51, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 402
3,179, // <program>
4,147, // <class decl>+
5,414, // <class decl>
6,83, // `class
98,101, // " "
99,37, // "#"
115,75, // {10}
124,264, // ws
  }
,
{ // state 403
MIN_REDUCTION+26, // (default reduction)
  }
,
{ // state 404
MIN_REDUCTION+24, // (default reduction)
  }
,
{ // state 405
2,77, // ws*
MIN_REDUCTION+191, // (default reduction)
  }
,
{ // state 406
MIN_REDUCTION+20, // (default reduction)
  }
,
{ // state 407
37,383, // `&&
114,287, // "@"
MIN_REDUCTION+29, // (default reduction)
  }
,
{ // state 408
98,101, // " "
115,75, // {10}
124,264, // ws
MIN_REDUCTION+118, // (default reduction)
  }
,
{ // state 409
24,MIN_REDUCTION+67, // `[
94,MIN_REDUCTION+67, // "["
MIN_REDUCTION+67, // (default reduction)
  }
,
{ // state 410
0x80000000|2, // match move
0x80000000|146, // no-match move
0x80000000|318, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 411
2,220, // ws*
  }
,
{ // state 412
2,193, // ws*
  }
,
{ // state 413
2,95, // ws*
98,101, // " "
115,75, // {10}
124,222, // ws
MIN_REDUCTION+133, // (default reduction)
  }
,
{ // state 414
MIN_REDUCTION+188, // (default reduction)
  }
,
};
}
public MJGrammarParseTable(MJGrammar actionObj) {
  actionObject = actionObj;
  parseTable = new int[415][];
  int doneSoFar = 0;
  doneSoFar += new Initter1().doInit(doneSoFar);
  doneSoFar += new Initter2().doInit(doneSoFar);
}
public int[] getProdTable() { return prodTable; }
private static int[] prodTable = {
// $$start ::= <start>
(0<<16)+1,
// <start> ::= ws* <program>
(1<<16)+2,
// <start> ::= <program>
(1<<16)+1,
// <program> ::= <class decl>+
(3<<16)+1,
// <class decl> ::= `class ID `{ <decl in class>* `}
(5<<16)+5,
// <class decl> ::= `class ID `{ `}
(5<<16)+4,
// <decl in class> ::= <method decl>
(11<<16)+1,
// <decl in class> ::= <inst var decl>
(11<<16)+1,
// <method decl> ::= `public `void ID `( `) `{ <stmt>* `}
(12<<16)+8,
// <method decl> ::= `public `void ID `( `) `{ `}
(12<<16)+7,
// <inst var decl> ::= <type> ID `;
(13<<16)+3,
// <type> ::= `int
(19<<16)+1,
// <type> ::= `boolean
(19<<16)+1,
// <type> ::= ID
(19<<16)+1,
// <type> ::= <type> <empty bracket pair>
(19<<16)+2,
// <empty bracket pair> ::= `[ `]
(23<<16)+2,
// <stmt> ::= <assign> `;
(26<<16)+2,
// <stmt> ::= `break
(26<<16)+1,
// <stmt> ::= `{ <stmt>* `}
(26<<16)+3,
// <stmt> ::= `{ `}
(26<<16)+2,
// <stmt> ::= <local var decl> `;
(26<<16)+2,
// <assign> ::= <exp> `= <exp>
(27<<16)+3,
// <assign> ::= ID `++
(27<<16)+2,
// <assign> ::= `++ ID
(27<<16)+2,
// <assign> ::= ID `--
(27<<16)+2,
// <assign> ::= `-- ID
(27<<16)+2,
// <local var decl> ::= <type> ID `= <exp>
(29<<16)+4,
// <exp> ::= <exp1>
(30<<16)+1,
// <exp1> ::= <exp1> `|| <exp2>
(34<<16)+3,
// <exp1> ::= <exp2>
(34<<16)+1,
// <exp2> ::= <exp2> `&& <exp3>
(36<<16)+3,
// <exp2> ::= <exp3>
(36<<16)+1,
// <exp3> ::= <exp3> `!= <exp4>
(38<<16)+3,
// <exp3> ::= <exp3> `== <exp4>
(38<<16)+3,
// <exp3> ::= <exp4>
(38<<16)+1,
// <exp4> ::= <exp4> `< <exp5>
(40<<16)+3,
// <exp4> ::= <exp4> `> <exp5>
(40<<16)+3,
// <exp4> ::= <exp4> `<= <exp5>
(40<<16)+3,
// <exp4> ::= <exp4> `>= <exp5>
(40<<16)+3,
// <exp4> ::= <exp4> `instanceof ID
(40<<16)+3,
// <exp4> ::= <exp5>
(40<<16)+1,
// <exp5> ::= <exp5> `+ <exp6>
(43<<16)+3,
// <exp5> ::= <exp5> `- <exp6>
(43<<16)+3,
// <exp5> ::= <exp6>
(43<<16)+1,
// <exp6> ::= <exp6> `* <exp7>
(49<<16)+3,
// <exp6> ::= <exp6> `/ <exp7>
(49<<16)+3,
// <exp6> ::= <exp6> `% <exp7>
(49<<16)+3,
// <exp6> ::= <exp7>
(49<<16)+1,
// <exp7> ::= <cast exp>
(52<<16)+1,
// <exp7> ::= <unary exp>
(52<<16)+1,
// <cast exp> ::= `( <type> `) <cast exp>
(55<<16)+4,
// <cast exp> ::= `( <type> `) <exp8>
(55<<16)+4,
// <unary exp> ::= `- <unary exp>
(56<<16)+2,
// <unary exp> ::= `+ <unary exp>
(56<<16)+2,
// <unary exp> ::= `! <unary exp>
(56<<16)+2,
// <unary exp> ::= <exp8>
(56<<16)+1,
// <exp8> ::= ID
(57<<16)+1,
// <exp8> ::= <exp8> !<empty bracket pair> `[ <exp> `]
(57<<16)+4,
// <exp8> ::= INTLIT
(57<<16)+1,
// <exp8> ::= STRINGLIT
(57<<16)+1,
// <exp8> ::= CHARLIT
(57<<16)+1,
// <exp8> ::= `this
(57<<16)+1,
// <exp8> ::= `true
(57<<16)+1,
// <exp8> ::= `false
(57<<16)+1,
// <exp8> ::= <exp8> `. ID
(57<<16)+3,
// <exp8> ::= `new <type> `[ <exp> `] <empty bracket pair>*
(57<<16)+6,
// <exp8> ::= `new <type> `[ <exp> `]
(57<<16)+5,
// <exp8> ::= `new ID `( `)
(57<<16)+4,
// letter ::= {"A".."Z" "a".."z"}
(68<<16)+1,
// letter128 ::= {193..218 225..250}
(85<<16)+1,
// digit ::= {"0".."9"}
(88<<16)+1,
// digit128 ::= {176..185}
(91<<16)+1,
// any ::= {0..127}
(93<<16)+1,
// any128 ::= {128..255}
(121<<16)+1,
// ws ::= " "
(124<<16)+1,
// ws ::= {10}
(124<<16)+1,
// `boolean ::= "#" "b" "o" ws*
(22<<16)+4,
// `boolean ::= "#" "b" "o"
(22<<16)+3,
// `class ::= "#" "c" "l" ws*
(6<<16)+4,
// `class ::= "#" "c" "l"
(6<<16)+3,
// `void ::= "#" "v" "o" ws*
(15<<16)+4,
// `void ::= "#" "v" "o"
(15<<16)+3,
// `int ::= "#" "i" "t" ws*
(21<<16)+4,
// `int ::= "#" "i" "t"
(21<<16)+3,
// `break ::= "#" "b" "r" ws*
(28<<16)+4,
// `break ::= "#" "b" "r"
(28<<16)+3,
// `this ::= "#" "t" "h" ws*
(62<<16)+4,
// `this ::= "#" "t" "h"
(62<<16)+3,
// `false ::= "#" "f" "a" ws*
(64<<16)+4,
// `false ::= "#" "f" "a"
(64<<16)+3,
// `true ::= "#" "t" "r" ws*
(63<<16)+4,
// `true ::= "#" "t" "r"
(63<<16)+3,
// `instanceof ::= "#" "i" "n" ws*
(47<<16)+4,
// `instanceof ::= "#" "i" "n"
(47<<16)+3,
// `new ::= "#" "n" "e" ws*
(66<<16)+4,
// `new ::= "#" "n" "e"
(66<<16)+3,
// `public ::= "#" "p" "u" ws*
(14<<16)+4,
// `public ::= "#" "p" "u"
(14<<16)+3,
// `! ::= "!" ws*
(58<<16)+2,
// `! ::= "!"
(58<<16)+1,
// `!= ::= "@" "!" ws*
(39<<16)+3,
// `!= ::= "@" "!"
(39<<16)+2,
// `% ::= "%" ws*
(54<<16)+2,
// `% ::= "%"
(54<<16)+1,
// `&& ::= "@" "&" ws*
(37<<16)+3,
// `&& ::= "@" "&"
(37<<16)+2,
// `* ::= "*" ws*
(51<<16)+2,
// `* ::= "*"
(51<<16)+1,
// `( ::= "(" ws*
(16<<16)+2,
// `( ::= "("
(16<<16)+1,
// `) ::= ")" ws*
(17<<16)+2,
// `) ::= ")"
(17<<16)+1,
// `{ ::= "{" ws*
(8<<16)+2,
// `{ ::= "{"
(8<<16)+1,
// `} ::= "}" ws*
(10<<16)+2,
// `} ::= "}"
(10<<16)+1,
// `- ::= "-" ws*
(50<<16)+2,
// `- ::= "-"
(50<<16)+1,
// `+ ::= "+" ws*
(48<<16)+2,
// `+ ::= "+"
(48<<16)+1,
// `= ::= "=" ws*
(31<<16)+2,
// `= ::= "="
(31<<16)+1,
// `== ::= "@" "=" ws*
(41<<16)+3,
// `== ::= "@" "="
(41<<16)+2,
// `[ ::= "[" ws*
(24<<16)+2,
// `[ ::= "["
(24<<16)+1,
// `] ::= "]" ws*
(25<<16)+2,
// `] ::= "]"
(25<<16)+1,
// `|| ::= "@" "|" ws*
(35<<16)+3,
// `|| ::= "@" "|"
(35<<16)+2,
// `< ::= "<" ws*
(42<<16)+2,
// `< ::= "<"
(42<<16)+1,
// `<= ::= "@" "<" ws*
(45<<16)+3,
// `<= ::= "@" "<"
(45<<16)+2,
// `> ::= ">" !"=" ws*
(44<<16)+2,
// `> ::= ">" !"="
(44<<16)+1,
// `>= ::= "@" ">" ws*
(46<<16)+3,
// `>= ::= "@" ">"
(46<<16)+2,
// `. ::= "." ws*
(65<<16)+2,
// `. ::= "."
(65<<16)+1,
// `; ::= ";" ws*
(20<<16)+2,
// `; ::= ";"
(20<<16)+1,
// `++ ::= "@" "+" ws*
(32<<16)+3,
// `++ ::= "@" "+"
(32<<16)+2,
// `-- ::= "@" "-" ws*
(33<<16)+3,
// `-- ::= "@" "-"
(33<<16)+2,
// `/ ::= "/" ws*
(53<<16)+2,
// `/ ::= "/"
(53<<16)+1,
// ID ::= letter128 ws*
(7<<16)+2,
// ID ::= letter128
(7<<16)+1,
// ID ::= letter idChar* $$0
(7<<16)+3,
// ID ::= letter $$0
(7<<16)+2,
// INTLIT ::= {"1".."9"} digit* $$1
(59<<16)+3,
// INTLIT ::= {"1".."9"} $$1
(59<<16)+2,
// INTLIT ::= digit128 ws*
(59<<16)+2,
// INTLIT ::= digit128
(59<<16)+1,
// INTLIT ::= "0" hexDigit* $$2
(59<<16)+3,
// INTLIT ::= "0" $$2
(59<<16)+2,
// STRINGLIT ::= "@" '"' ws*
(60<<16)+3,
// STRINGLIT ::= "@" '"'
(60<<16)+2,
// STRINGLIT ::= '"' any* $$3
(60<<16)+3,
// STRINGLIT ::= '"' $$3
(60<<16)+2,
// CHARLIT ::= "'" any ws*
(61<<16)+3,
// CHARLIT ::= "'" any
(61<<16)+2,
// idChar ::= letter
(133<<16)+1,
// idChar ::= digit
(133<<16)+1,
// idChar ::= "_"
(133<<16)+1,
// idChar128 ::= letter128
(134<<16)+1,
// idChar128 ::= digit128
(134<<16)+1,
// idChar128 ::= {223}
(134<<16)+1,
// hexDigit ::= {"0".."9" "A".."Z" "a".."z"}
(135<<16)+1,
// hexDigit128 ::= {176..185 193..198 225..230}
(136<<16)+1,
// <stmt>* ::= <stmt>* <stmt>
(18<<16)+2,
// <stmt>* ::= <stmt>
(18<<16)+1,
// <decl in class>* ::= <decl in class>* <decl in class>
(9<<16)+2,
// <decl in class>* ::= <decl in class>
(9<<16)+1,
// any* ::= any* any
(131<<16)+2,
// any* ::= any
(131<<16)+1,
// ws* ::= ws* ws
(2<<16)+2,
// ws* ::= ws
(2<<16)+1,
// digit* ::= digit* digit
(127<<16)+2,
// digit* ::= digit
(127<<16)+1,
// <empty bracket pair>* ::= <empty bracket pair>* <empty bracket pair>
(67<<16)+2,
// <empty bracket pair>* ::= <empty bracket pair>
(67<<16)+1,
// hexDigit* ::= hexDigit* hexDigit
(129<<16)+2,
// hexDigit* ::= hexDigit
(129<<16)+1,
// idChar* ::= idChar* idChar
(125<<16)+2,
// idChar* ::= idChar
(125<<16)+1,
// <class decl>+ ::= <class decl>
(4<<16)+1,
// <class decl>+ ::= <class decl>+ <class decl>
(4<<16)+2,
// $$0 ::= idChar128 ws*
(126<<16)+2,
// $$0 ::= idChar128
(126<<16)+1,
// $$1 ::= digit128 ws*
(128<<16)+2,
// $$1 ::= digit128
(128<<16)+1,
// $$2 ::= hexDigit128 ws*
(130<<16)+2,
// $$2 ::= hexDigit128
(130<<16)+1,
// $$3 ::= any128 ws*
(132<<16)+2,
// $$3 ::= any128
(132<<16)+1,
};
public int[] getCharMapTable() { return charMapTable; }
private static int[] charMapTable = {
105, // 0
105, // 1
105, // 2
105, // 3
105, // 4
105, // 5
105, // 6
105, // 7
105, // 8
105, // 9
115, // 10
105, // 11
105, // 12
105, // 13
105, // 14
105, // 15
105, // 16
105, // 17
105, // 18
105, // 19
105, // 20
105, // 21
105, // 22
105, // 23
105, // 24
105, // 25
105, // 26
105, // 27
105, // 28
105, // 29
105, // 30
105, // 31
98, // " "
117, // "!"
119, // '"'
99, // "#"
105, // "$"
108, // "%"
100, // "&"
118, // "'"
109, // "("
101, // ")"
120, // "*"
110, // "+"
105, // ","
95, // "-"
111, // "."
103, // "/"
90, // "0"
89, // "1"
89, // "2"
89, // "3"
89, // "4"
89, // "5"
89, // "6"
89, // "7"
89, // "8"
89, // "9"
105, // ":"
104, // ";"
96, // "<"
113, // "="
106, // ">"
105, // "?"
114, // "@"
82, // "A"
82, // "B"
82, // "C"
82, // "D"
82, // "E"
82, // "F"
82, // "G"
82, // "H"
82, // "I"
82, // "J"
82, // "K"
82, // "L"
82, // "M"
82, // "N"
82, // "O"
82, // "P"
82, // "Q"
82, // "R"
82, // "S"
82, // "T"
82, // "U"
82, // "V"
82, // "W"
82, // "X"
82, // "Y"
82, // "Z"
94, // "["
105, // "\"
102, // "]"
105, // "^"
112, // "_"
105, // "`"
69, // "a"
79, // "b"
72, // "c"
82, // "d"
80, // "e"
73, // "f"
82, // "g"
81, // "h"
74, // "i"
82, // "j"
82, // "k"
75, // "l"
82, // "m"
83, // "n"
76, // "o"
70, // "p"
82, // "q"
77, // "r"
82, // "s"
84, // "t"
78, // "u"
71, // "v"
82, // "w"
82, // "x"
82, // "y"
82, // "z"
107, // "{"
97, // "|"
116, // "}"
105, // "~"
105, // 127
123, // 128
123, // 129
123, // 130
123, // 131
123, // 132
123, // 133
123, // 134
123, // 135
123, // 136
123, // 137
123, // 138
123, // 139
123, // 140
123, // 141
123, // 142
123, // 143
123, // 144
123, // 145
123, // 146
123, // 147
123, // 148
123, // 149
123, // 150
123, // 151
123, // 152
123, // 153
123, // 154
123, // 155
123, // 156
123, // 157
123, // 158
123, // 159
123, // 160
123, // 161
123, // 162
123, // 163
123, // 164
123, // 165
123, // 166
123, // 167
123, // 168
123, // 169
123, // 170
123, // 171
123, // 172
123, // 173
123, // 174
123, // 175
92, // 176
92, // 177
92, // 178
92, // 179
92, // 180
92, // 181
92, // 182
92, // 183
92, // 184
92, // 185
123, // 186
123, // 187
123, // 188
123, // 189
123, // 190
123, // 191
123, // 192
87, // 193
87, // 194
87, // 195
87, // 196
87, // 197
87, // 198
86, // 199
86, // 200
86, // 201
86, // 202
86, // 203
86, // 204
86, // 205
86, // 206
86, // 207
86, // 208
86, // 209
86, // 210
86, // 211
86, // 212
86, // 213
86, // 214
86, // 215
86, // 216
86, // 217
86, // 218
123, // 219
123, // 220
123, // 221
123, // 222
122, // 223
123, // 224
87, // 225
87, // 226
87, // 227
87, // 228
87, // 229
87, // 230
86, // 231
86, // 232
86, // 233
86, // 234
86, // 235
86, // 236
86, // 237
86, // 238
86, // 239
86, // 240
86, // 241
86, // 242
86, // 243
86, // 244
86, // 245
86, // 246
86, // 247
86, // 248
86, // 249
86, // 250
123, // 251
123, // 252
123, // 253
123, // 254
123, // 255
};
public String[] getActionProdNameTable() { return actionProdNameTable; }
private String[] actionProdNameTable = {
"", // 0
"<start> ::= ws* <program>", // 1
"<start> ::= ws* <program>", // 2
"<program> ::= # <class decl>+", // 3
"<class decl> ::= `class # ID `{ <decl in class>* `}", // 4
"<class decl> ::= `class # ID `{ <decl in class>* `}", // 5
"<decl in class> ::= <method decl>", // 6
"<decl in class> ::= <inst var decl>", // 7
"<method decl> ::= `public `void # ID `( `) `{ <stmt>* `}", // 8
"<method decl> ::= `public `void # ID `( `) `{ <stmt>* `}", // 9
"<inst var decl> ::= # <type> ID `;", // 10
"<type> ::= # `int", // 11
"<type> ::= # `boolean", // 12
"<type> ::= # ID", // 13
"<type> ::= # <type> <empty bracket pair>", // 14
"<empty bracket pair> ::= `[ `]", // 15
"<stmt> ::= <assign> `;", // 16
"<stmt> ::= # `break", // 17
"<stmt> ::= # `{ <stmt>* `}", // 18
"<stmt> ::= # `{ <stmt>* `}", // 19
"<stmt> ::= <local var decl> `;", // 20
"<assign> ::= <exp> # `= <exp>", // 21
"<assign> ::= ID # `++", // 22
"<assign> ::= # `++ ID", // 23
"<assign> ::= ID # `--", // 24
"<assign> ::= # `-- ID", // 25
"<local var decl> ::= <type> # ID `= <exp>", // 26
"<exp> ::= <exp1>", // 27
"<exp1> ::= <exp1> # `|| <exp2>", // 28
"<exp1> ::= <exp2>", // 29
"<exp2> ::= <exp2> # `&& <exp3>", // 30
"<exp2> ::= <exp3>", // 31
"<exp3> ::= <exp3> # `!= <exp4>", // 32
"<exp3> ::= <exp3> # `== <exp4>", // 33
"<exp3> ::= <exp4>", // 34
"<exp4> ::= <exp4> # `< <exp5>", // 35
"<exp4> ::= <exp4> # `> <exp5>", // 36
"<exp4> ::= <exp4> # `<= <exp5>", // 37
"<exp4> ::= <exp4> # `>= <exp5>", // 38
"<exp4> ::= <exp4> # `instanceof ID", // 39
"<exp4> ::= <exp5>", // 40
"<exp5> ::= <exp5> # `+ <exp6>", // 41
"<exp5> ::= <exp5> # `- <exp6>", // 42
"<exp5> ::= <exp6>", // 43
"<exp6> ::= <exp6> # `* <exp7>", // 44
"<exp6> ::= <exp6> # `/ <exp7>", // 45
"<exp6> ::= <exp6> # `% <exp7>", // 46
"<exp6> ::= <exp7>", // 47
"<exp7> ::= <cast exp>", // 48
"<exp7> ::= <unary exp>", // 49
"<cast exp> ::= # `( <type> `) <cast exp>", // 50
"<cast exp> ::= # `( <type> `) <exp8>", // 51
"<unary exp> ::= # `- <unary exp>", // 52
"<unary exp> ::= # `+ <unary exp>", // 53
"<unary exp> ::= # `! <unary exp>", // 54
"<unary exp> ::= <exp8>", // 55
"<exp8> ::= # ID", // 56
"<exp8> ::= <exp8> !<empty bracket pair> # `[ <exp> `]", // 57
"<exp8> ::= # INTLIT", // 58
"<exp8> ::= # STRINGLIT", // 59
"<exp8> ::= # CHARLIT", // 60
"<exp8> ::= # `this", // 61
"<exp8> ::= # `true", // 62
"<exp8> ::= # `false", // 63
"<exp8> ::= # <exp8> `. ID", // 64
"<exp8> ::= # `new <type> `[ <exp> `] <empty bracket pair>*", // 65
"<exp8> ::= # `new <type> `[ <exp> `] <empty bracket pair>*", // 66
"<exp8> ::= # `new ID `( `)", // 67
"letter ::= {\"A\"..\"Z\" \"a\"..\"z\"}", // 68
"letter128 ::= {193..218 225..250}", // 69
"digit ::= {\"0\"..\"9\"}", // 70
"digit128 ::= {176..185}", // 71
"any ::= {0..127}", // 72
"any128 ::= {128..255}", // 73
"ws ::= \" \"", // 74
"ws ::= {10} registerNewline", // 75
"`boolean ::= \"#\" \"b\" \"o\" ws*", // 76
"`boolean ::= \"#\" \"b\" \"o\" ws*", // 77
"`class ::= \"#\" \"c\" \"l\" ws*", // 78
"`class ::= \"#\" \"c\" \"l\" ws*", // 79
"`void ::= \"#\" \"v\" \"o\" ws*", // 80
"`void ::= \"#\" \"v\" \"o\" ws*", // 81
"`int ::= \"#\" \"i\" \"t\" ws*", // 82
"`int ::= \"#\" \"i\" \"t\" ws*", // 83
"`break ::= \"#\" \"b\" \"r\" ws*", // 84
"`break ::= \"#\" \"b\" \"r\" ws*", // 85
"`this ::= \"#\" \"t\" \"h\" ws*", // 86
"`this ::= \"#\" \"t\" \"h\" ws*", // 87
"`false ::= \"#\" \"f\" \"a\" ws*", // 88
"`false ::= \"#\" \"f\" \"a\" ws*", // 89
"`true ::= \"#\" \"t\" \"r\" ws*", // 90
"`true ::= \"#\" \"t\" \"r\" ws*", // 91
"`instanceof ::= \"#\" \"i\" \"n\" ws*", // 92
"`instanceof ::= \"#\" \"i\" \"n\" ws*", // 93
"`new ::= \"#\" \"n\" \"e\" ws*", // 94
"`new ::= \"#\" \"n\" \"e\" ws*", // 95
"`public ::= \"#\" \"p\" \"u\" ws*", // 96
"`public ::= \"#\" \"p\" \"u\" ws*", // 97
"`! ::= \"!\" ws*", // 98
"`! ::= \"!\" ws*", // 99
"`!= ::= \"@\" \"!\" ws*", // 100
"`!= ::= \"@\" \"!\" ws*", // 101
"`% ::= \"%\" ws*", // 102
"`% ::= \"%\" ws*", // 103
"`&& ::= \"@\" \"&\" ws*", // 104
"`&& ::= \"@\" \"&\" ws*", // 105
"`* ::= \"*\" ws*", // 106
"`* ::= \"*\" ws*", // 107
"`( ::= \"(\" ws*", // 108
"`( ::= \"(\" ws*", // 109
"`) ::= \")\" ws*", // 110
"`) ::= \")\" ws*", // 111
"`{ ::= \"{\" ws*", // 112
"`{ ::= \"{\" ws*", // 113
"`} ::= \"}\" ws*", // 114
"`} ::= \"}\" ws*", // 115
"`- ::= \"-\" ws*", // 116
"`- ::= \"-\" ws*", // 117
"`+ ::= \"+\" ws*", // 118
"`+ ::= \"+\" ws*", // 119
"`= ::= \"=\" ws*", // 120
"`= ::= \"=\" ws*", // 121
"`== ::= \"@\" \"=\" ws*", // 122
"`== ::= \"@\" \"=\" ws*", // 123
"`[ ::= \"[\" ws*", // 124
"`[ ::= \"[\" ws*", // 125
"`] ::= \"]\" ws*", // 126
"`] ::= \"]\" ws*", // 127
"`|| ::= \"@\" \"|\" ws*", // 128
"`|| ::= \"@\" \"|\" ws*", // 129
"`< ::= \"<\" ws*", // 130
"`< ::= \"<\" ws*", // 131
"`<= ::= \"@\" \"<\" ws*", // 132
"`<= ::= \"@\" \"<\" ws*", // 133
"`> ::= \">\" !\"=\" ws*", // 134
"`> ::= \">\" !\"=\" ws*", // 135
"`>= ::= \"@\" \">\" ws*", // 136
"`>= ::= \"@\" \">\" ws*", // 137
"`. ::= \".\" ws*", // 138
"`. ::= \".\" ws*", // 139
"`; ::= \";\" ws*", // 140
"`; ::= \";\" ws*", // 141
"`++ ::= \"@\" \"+\" ws*", // 142
"`++ ::= \"@\" \"+\" ws*", // 143
"`-- ::= \"@\" \"-\" ws*", // 144
"`-- ::= \"@\" \"-\" ws*", // 145
"`/ ::= \"/\" ws*", // 146
"`/ ::= \"/\" ws*", // 147
"ID ::= letter128 ws*", // 148
"ID ::= letter128 ws*", // 149
"ID ::= letter idChar* idChar128 ws*", // 150
"ID ::= letter idChar* idChar128 ws*", // 151
"INTLIT ::= {\"1\"..\"9\"} digit* digit128 ws*", // 152
"INTLIT ::= {\"1\"..\"9\"} digit* digit128 ws*", // 153
"INTLIT ::= digit128 ws*", // 154
"INTLIT ::= digit128 ws*", // 155
"INTLIT ::= \"0\" hexDigit* hexDigit128 ws*", // 156
"INTLIT ::= \"0\" hexDigit* hexDigit128 ws*", // 157
"STRINGLIT ::= \"@\" \'\"\' ws*", // 158
"STRINGLIT ::= \"@\" \'\"\' ws*", // 159
"STRINGLIT ::= \'\"\' any* any128 ws*", // 160
"STRINGLIT ::= \'\"\' any* any128 ws*", // 161
"CHARLIT ::= \"\'\" any ws*", // 162
"CHARLIT ::= \"\'\" any ws*", // 163
"idChar ::= letter", // 164
"idChar ::= digit", // 165
"idChar ::= \"_\"", // 166
"idChar128 ::= letter128", // 167
"idChar128 ::= digit128", // 168
"idChar128 ::= {223}", // 169
"hexDigit ::= {\"0\"..\"9\" \"A\"..\"Z\" \"a\"..\"z\"}", // 170
"hexDigit128 ::= {176..185 193..198 225..230}", // 171
"<stmt>* ::= <stmt>* <stmt>", // 172
"<stmt>* ::= <stmt>* <stmt>", // 173
"<decl in class>* ::= <decl in class>* <decl in class>", // 174
"<decl in class>* ::= <decl in class>* <decl in class>", // 175
"any* ::= any* any", // 176
"any* ::= any* any", // 177
"ws* ::= ws* ws", // 178
"ws* ::= ws* ws", // 179
"digit* ::= digit* digit", // 180
"digit* ::= digit* digit", // 181
"<empty bracket pair>* ::= <empty bracket pair>* <empty bracket pair>", // 182
"<empty bracket pair>* ::= <empty bracket pair>* <empty bracket pair>", // 183
"hexDigit* ::= hexDigit* hexDigit", // 184
"hexDigit* ::= hexDigit* hexDigit", // 185
"idChar* ::= idChar* idChar", // 186
"idChar* ::= idChar* idChar", // 187
"<class decl>+ ::= <class decl>", // 188
"<class decl>+ ::= <class decl>+ <class decl>", // 189
"", // 190
"", // 191
"", // 192
"", // 193
"", // 194
"", // 195
"", // 196
"", // 197
};
public int[][] getActionTable() { return actionTable; }
private int[][] actionTable = {
    { // 0: $$start ::= <start> @pass
      ((1<<5)|0xe)/*popPos:1*/,
    },
    { // 1: <start> ::= ws* <program> @topLevel(Program)=>
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((0<<5)|0x5)/*methodCall:0*/,
    },
    { // 2: <start> ::= [ws*] <program> @topLevel(Program)=>
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((0<<5)|0x5)/*methodCall:0*/,
    },
    { // 3: <program> ::= [#] <class decl>+ @createProgram(int,List<ClassDecl>)=>Program
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0x5)/*methodCall:1*/,
    },
    { // 4: <class decl> ::= `class [#] ID `{ <decl in class>* `} @createClassDecl(int,String,List<Decl>)=>ClassDecl
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((2<<5)|0x5)/*methodCall:2*/,
    },
    { // 5: <class decl> ::= `class [#] ID `{ [<decl in class>*] `} @createClassDecl(int,String,List<Decl>)=>ClassDecl
      ((1<<5)|0xe)/*popPos:1*/,
      ((4<<5)|0x6)/*nullProductionAction:4*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((2<<5)|0x5)/*methodCall:2*/,
    },
    { // 6: <decl in class> ::= <method decl> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 7: <decl in class> ::= <inst var decl> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 8: <method decl> ::= `public `void [#] ID `( `) `{ <stmt>* `} @createMethodDeclVoid(int,String,List<Statement>)=>Decl
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((3<<5)|0x5)/*methodCall:3*/,
    },
    { // 9: <method decl> ::= `public `void [#] ID `( `) `{ [<stmt>*] `} @createMethodDeclVoid(int,String,List<Statement>)=>Decl
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x6)/*nullProductionAction:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((3<<5)|0x5)/*methodCall:3*/,
    },
    { // 10: <inst var decl> ::= [#] <type> ID `; @createInstVarDecl(int,Type,String)=>Decl
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((4<<5)|0x5)/*methodCall:4*/,
    },
    { // 11: <type> ::= [#] `int @intType(int)=>Type
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((5<<5)|0x5)/*methodCall:5*/,
    },
    { // 12: <type> ::= [#] `boolean @booleanType(int)=>Type
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((6<<5)|0x5)/*methodCall:6*/,
    },
    { // 13: <type> ::= [#] ID @identifierType(int,String)=>Type
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((7<<5)|0x5)/*methodCall:7*/,
    },
    { // 14: <type> ::= [#] <type> <empty bracket pair> @newArrayType(int,Type,Object)=>Type
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((8<<5)|0x5)/*methodCall:8*/,
    },
    { // 15: <empty bracket pair> ::= `[ `] @null
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x8)/*nullPointer:1*/,
    },
    { // 16: <stmt> ::= <assign> `; @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 17: <stmt> ::= [#] `break @newBreak(int)=>Statement
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((9<<5)|0x5)/*methodCall:9*/,
    },
    { // 18: <stmt> ::= [#] `{ <stmt>* `} @newBlock(int,List<Statement>)=>Statement
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((10<<5)|0x5)/*methodCall:10*/,
    },
    { // 19: <stmt> ::= [#] `{ [<stmt>*] `} @newBlock(int,List<Statement>)=>Statement
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x6)/*nullProductionAction:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((10<<5)|0x5)/*methodCall:10*/,
    },
    { // 20: <stmt> ::= <local var decl> `; @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 21: <assign> ::= <exp> [#] `= <exp> @assign(Exp,int,Exp)=>Statement
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((11<<5)|0x5)/*methodCall:11*/,
    },
    { // 22: <assign> ::= ID [#] `++ @incrBack(String,int)=>Statement
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((12<<5)|0x5)/*methodCall:12*/,
    },
    { // 23: <assign> ::= [#] `++ ID @incrFront(int,String)=>Statement
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((13<<5)|0x5)/*methodCall:13*/,
    },
    { // 24: <assign> ::= ID [#] `-- @subBack(String,int)=>Statement
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((14<<5)|0x5)/*methodCall:14*/,
    },
    { // 25: <assign> ::= [#] `-- ID @subBack(int,String)=>Statement
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((15<<5)|0x5)/*methodCall:15*/,
    },
    { // 26: <local var decl> ::= <type> [#] ID `= <exp> @localVarDecl(Type,int,String,Exp)=>Statement
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((16<<5)|0x5)/*methodCall:16*/,
    },
    { // 27: <exp> ::= <exp1> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 28: <exp1> ::= <exp1> [#] `|| <exp2> @newOr(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((17<<5)|0x5)/*methodCall:17*/,
    },
    { // 29: <exp1> ::= <exp2> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 30: <exp2> ::= <exp2> [#] `&& <exp3> @newAnd(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((18<<5)|0x5)/*methodCall:18*/,
    },
    { // 31: <exp2> ::= <exp3> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 32: <exp3> ::= <exp3> [#] `!= <exp4> @newNotEquals(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((19<<5)|0x5)/*methodCall:19*/,
    },
    { // 33: <exp3> ::= <exp3> [#] `== <exp4> @newEquals(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((20<<5)|0x5)/*methodCall:20*/,
    },
    { // 34: <exp3> ::= <exp4> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 35: <exp4> ::= <exp4> [#] `< <exp5> @newLessThan(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((21<<5)|0x5)/*methodCall:21*/,
    },
    { // 36: <exp4> ::= <exp4> [#] `> <exp5> @newGreaterThan(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((22<<5)|0x5)/*methodCall:22*/,
    },
    { // 37: <exp4> ::= <exp4> [#] `<= <exp5> @newLessThanEquals(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((23<<5)|0x5)/*methodCall:23*/,
    },
    { // 38: <exp4> ::= <exp4> [#] `>= <exp5> @newGreaterEquals(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((24<<5)|0x5)/*methodCall:24*/,
    },
    { // 39: <exp4> ::= <exp4> [#] `instanceof ID @newInstanceOf(Exp,int,String)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((25<<5)|0x5)/*methodCall:25*/,
    },
    { // 40: <exp4> ::= <exp5> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 41: <exp5> ::= <exp5> [#] `+ <exp6> @newPlus(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((26<<5)|0x5)/*methodCall:26*/,
    },
    { // 42: <exp5> ::= <exp5> [#] `- <exp6> @newMinus(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((27<<5)|0x5)/*methodCall:27*/,
    },
    { // 43: <exp5> ::= <exp6> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 44: <exp6> ::= <exp6> [#] `* <exp7> @newTimes(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((28<<5)|0x5)/*methodCall:28*/,
    },
    { // 45: <exp6> ::= <exp6> [#] `/ <exp7> @newDivide(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((29<<5)|0x5)/*methodCall:29*/,
    },
    { // 46: <exp6> ::= <exp6> [#] `% <exp7> @newRemainder(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((30<<5)|0x5)/*methodCall:30*/,
    },
    { // 47: <exp6> ::= <exp7> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 48: <exp7> ::= <cast exp> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 49: <exp7> ::= <unary exp> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 50: <cast exp> ::= [#] `( <type> `) <cast exp> @newCast(int,Type,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((31<<5)|0x5)/*methodCall:31*/,
    },
    { // 51: <cast exp> ::= [#] `( <type> `) <exp8> @newCast(int,Type,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((31<<5)|0x5)/*methodCall:31*/,
    },
    { // 52: <unary exp> ::= [#] `- <unary exp> @newUnaryMinus(int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((32<<5)|0x5)/*methodCall:32*/,
    },
    { // 53: <unary exp> ::= [#] `+ <unary exp> @newUnaryPlus(int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((33<<5)|0x5)/*methodCall:33*/,
    },
    { // 54: <unary exp> ::= [#] `! <unary exp> @newUnaryNot(int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((34<<5)|0x5)/*methodCall:34*/,
    },
    { // 55: <unary exp> ::= <exp8> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 56: <exp8> ::= [#] ID @newIdentfierExp(int,String)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((35<<5)|0x5)/*methodCall:35*/,
    },
    { // 57: <exp8> ::= <exp8> !<empty bracket pair> [#] `[ <exp> `] @newArrayLookup(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((36<<5)|0x5)/*methodCall:36*/,
    },
    { // 58: <exp8> ::= [#] INTLIT @newIntegerLiteral(int,int)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((37<<5)|0x5)/*methodCall:37*/,
    },
    { // 59: <exp8> ::= [#] STRINGLIT @newStringLiteral(int,String)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((38<<5)|0x5)/*methodCall:38*/,
    },
    { // 60: <exp8> ::= [#] CHARLIT @newCharLiteral(int,int)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((39<<5)|0x5)/*methodCall:39*/,
    },
    { // 61: <exp8> ::= [#] `this @newThis(int)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((40<<5)|0x5)/*methodCall:40*/,
    },
    { // 62: <exp8> ::= [#] `true @newTrue(int)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((41<<5)|0x5)/*methodCall:41*/,
    },
    { // 63: <exp8> ::= [#] `false @newFalse(int)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((42<<5)|0x5)/*methodCall:42*/,
    },
    { // 64: <exp8> ::= [#] <exp8> `. ID @newInstVarAccess(int,Exp,String)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((43<<5)|0x5)/*methodCall:43*/,
    },
    { // 65: <exp8> ::= [#] `new <type> `[ <exp> `] <empty bracket pair>* @newMultiArray(int,Type,Exp,List<Object>)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((44<<5)|0x5)/*methodCall:44*/,
    },
    { // 66: <exp8> ::= [#] `new <type> `[ <exp> `] [<empty bracket pair>*] @newMultiArray(int,Type,Exp,List<Object>)=>Exp
      ((2<<5)|0x6)/*nullProductionAction:2*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((44<<5)|0x5)/*methodCall:44*/,
    },
    { // 67: <exp8> ::= [#] `new ID `( `) @newObject(int,String)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((45<<5)|0x5)/*methodCall:45*/,
    },
    { // 68: letter ::= {"A".."Z" "a".."z"} @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 69: letter128 ::= {193..218 225..250} @sub128(char)=>char
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((46<<5)|0x5)/*methodCall:46*/,
    },
    { // 70: digit ::= {"0".."9"} @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 71: digit128 ::= {176..185} @sub128(char)=>char
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((46<<5)|0x5)/*methodCall:46*/,
    },
    { // 72: any ::= {0..127} @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 73: any128 ::= {128..255} @sub128(char)=>char
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((46<<5)|0x5)/*methodCall:46*/,
    },
    { // 74: ws ::= " " @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 75: ws ::= {10} [registerNewline] @void
      ((9<<5)|0x6)/*nullProductionAction:9*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 76: `boolean ::= "#" "b" "o" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 77: `boolean ::= "#" "b" "o" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 78: `class ::= "#" "c" "l" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 79: `class ::= "#" "c" "l" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 80: `void ::= "#" "v" "o" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 81: `void ::= "#" "v" "o" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 82: `int ::= "#" "i" "t" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 83: `int ::= "#" "i" "t" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 84: `break ::= "#" "b" "r" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 85: `break ::= "#" "b" "r" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 86: `this ::= "#" "t" "h" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 87: `this ::= "#" "t" "h" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 88: `false ::= "#" "f" "a" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 89: `false ::= "#" "f" "a" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 90: `true ::= "#" "t" "r" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 91: `true ::= "#" "t" "r" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 92: `instanceof ::= "#" "i" "n" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 93: `instanceof ::= "#" "i" "n" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 94: `new ::= "#" "n" "e" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 95: `new ::= "#" "n" "e" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 96: `public ::= "#" "p" "u" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 97: `public ::= "#" "p" "u" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 98: `! ::= "!" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 99: `! ::= "!" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 100: `!= ::= "@" "!" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 101: `!= ::= "@" "!" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 102: `% ::= "%" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 103: `% ::= "%" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 104: `&& ::= "@" "&" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 105: `&& ::= "@" "&" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 106: `* ::= "*" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 107: `* ::= "*" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 108: `( ::= "(" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 109: `( ::= "(" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 110: `) ::= ")" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 111: `) ::= ")" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 112: `{ ::= "{" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 113: `{ ::= "{" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 114: `} ::= "}" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 115: `} ::= "}" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 116: `- ::= "-" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 117: `- ::= "-" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 118: `+ ::= "+" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 119: `+ ::= "+" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 120: `= ::= "=" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 121: `= ::= "=" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 122: `== ::= "@" "=" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 123: `== ::= "@" "=" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 124: `[ ::= "[" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 125: `[ ::= "[" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 126: `] ::= "]" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 127: `] ::= "]" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 128: `|| ::= "@" "|" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 129: `|| ::= "@" "|" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 130: `< ::= "<" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 131: `< ::= "<" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 132: `<= ::= "@" "<" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 133: `<= ::= "@" "<" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 134: `> ::= ">" !"=" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 135: `> ::= ">" !"=" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 136: `>= ::= "@" ">" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 137: `>= ::= "@" ">" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 138: `. ::= "." ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 139: `. ::= "." [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 140: `; ::= ";" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 141: `; ::= ";" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 142: `++ ::= "@" "+" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 143: `++ ::= "@" "+" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 144: `-- ::= "@" "-" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 145: `-- ::= "@" "-" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 146: `/ ::= "/" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 147: `/ ::= "/" [ws*] @void
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 148: ID ::= letter128 ws* @text
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x4)/*stringConcat:1*/,
    },
    { // 149: ID ::= letter128 [ws*] @text
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x4)/*stringConcat:1*/,
    },
    { // 150: ID ::= letter idChar* $$0 @text
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x4)/*stringConcat:3*/,
    },
    { // 151: ID ::= letter [idChar*] $$0 @text
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x4)/*stringConcat:3*/,
    },
    { // 152: INTLIT ::= {"1".."9"} digit* $$1 @convertToInt(char,List<Character>,char)=>int
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((47<<5)|0x5)/*methodCall:47*/,
    },
    { // 153: INTLIT ::= {"1".."9"} [digit*] $$1 @convertToInt(char,List<Character>,char)=>int
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((7<<5)|0x6)/*nullProductionAction:7*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((47<<5)|0x5)/*methodCall:47*/,
    },
    { // 154: INTLIT ::= digit128 ws* @convertToInt(char)=>int
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((48<<5)|0x5)/*methodCall:48*/,
    },
    { // 155: INTLIT ::= digit128 [ws*] @convertToInt(char)=>int
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((48<<5)|0x5)/*methodCall:48*/,
    },
    { // 156: INTLIT ::= "0" hexDigit* $$2 @convert16ToInt(char,List<Character>,char)=>int
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((49<<5)|0x5)/*methodCall:49*/,
    },
    { // 157: INTLIT ::= "0" [hexDigit*] $$2 @convert16ToInt(char,List<Character>,char)=>int
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((0<<5)|0x6)/*nullProductionAction:0*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((49<<5)|0x5)/*methodCall:49*/,
    },
    { // 158: STRINGLIT ::= "@" '"' ws* @emptyString(char,char)=>String
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((50<<5)|0x5)/*methodCall:50*/,
    },
    { // 159: STRINGLIT ::= "@" '"' [ws*] @emptyString(char,char)=>String
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((50<<5)|0x5)/*methodCall:50*/,
    },
    { // 160: STRINGLIT ::= '"' any* $$3 @string(char,List<Character>,char)=>String
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((51<<5)|0x5)/*methodCall:51*/,
    },
    { // 161: STRINGLIT ::= '"' [any*] $$3 @string(char,List<Character>,char)=>String
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((51<<5)|0x5)/*methodCall:51*/,
    },
    { // 162: CHARLIT ::= "'" any ws* @charVal(char,char)=>int
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((52<<5)|0x5)/*methodCall:52*/,
    },
    { // 163: CHARLIT ::= "'" any [ws*] @charVal(char,char)=>int
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((52<<5)|0x5)/*methodCall:52*/,
    },
    { // 164: idChar ::= letter @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 165: idChar ::= digit @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 166: idChar ::= "_" @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 167: idChar128 ::= letter128 @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 168: idChar128 ::= digit128 @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 169: idChar128 ::= {223} @underscore(char)=>char
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((53<<5)|0x5)/*methodCall:53*/,
    },
    { // 170: hexDigit ::= {"0".."9" "A".."Z" "a".."z"} @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 171: hexDigit128 ::= {176..185 193..198 225..230} @sub128(char)=>char
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((46<<5)|0x5)/*methodCall:46*/,
    },
    { // 172: <stmt>* ::= <stmt>* <stmt> @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 173: <stmt>* ::= [<stmt>*] <stmt> @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x6)/*nullProductionAction:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 174: <decl in class>* ::= <decl in class>* <decl in class> @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 175: <decl in class>* ::= [<decl in class>*] <decl in class> @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((4<<5)|0x6)/*nullProductionAction:4*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 176: any* ::= any* any @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 177: any* ::= [any*] any @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 178: ws* ::= ws* ws @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
    },
    { // 179: ws* ::= [ws*] ws @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((5<<5)|0x6)/*nullProductionAction:5*/,
    },
    { // 180: digit* ::= digit* digit @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 181: digit* ::= [digit*] digit @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((7<<5)|0x6)/*nullProductionAction:7*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 182: <empty bracket pair>* ::= <empty bracket pair>* <empty bracket pair> @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 183: <empty bracket pair>* ::= [<empty bracket pair>*] <empty bracket pair> @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x6)/*nullProductionAction:2*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 184: hexDigit* ::= hexDigit* hexDigit @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 185: hexDigit* ::= [hexDigit*] hexDigit @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((0<<5)|0x6)/*nullProductionAction:0*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 186: idChar* ::= idChar* idChar @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 187: idChar* ::= [idChar*] idChar @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 188: <class decl>+ ::= <class decl> @singleList
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xa)/*singleList:1*/,
    },
    { // 189: <class decl>+ ::= <class decl>+ <class decl> @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 190: $$0 ::= idChar128 ws* @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 191: $$0 ::= idChar128 [ws*] @pass
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 192: $$1 ::= digit128 ws* @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 193: $$1 ::= digit128 [ws*] @pass
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 194: $$2 ::= hexDigit128 ws* @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 195: $$2 ::= hexDigit128 [ws*] @pass
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 196: $$3 ::= any128 ws* @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 197: $$3 ::= any128 [ws*] @pass
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
};
public String[] getNullProdNameTable() { return nullProdNameTable; }
private String[] nullProdNameTable = {
    "hexDigit* ::=", // hexDigit*
    "<stmt>* ::=", // <stmt>*
    "<empty bracket pair>* ::=", // <empty bracket pair>*
    "any* ::=", // any*
    "<decl in class>* ::=", // <decl in class>*
    "ws* ::=", // ws*
    "idChar* ::=", // idChar*
    "digit* ::=", // digit*
    "# ::=", // #
    "registerNewline ::= #", // registerNewline
};
public int[][] getNullProductionActionTable() { return nullActionTable; }
private int[][] nullActionTable = {
    { // hexDigit*
      ((1<<5)|0x9)/*emptyList:1*/,
    },
    { // <stmt>*
      ((1<<5)|0x9)/*emptyList:1*/,
    },
    { // <empty bracket pair>*
      ((1<<5)|0x9)/*emptyList:1*/,
    },
    { // any*
      ((1<<5)|0x9)/*emptyList:1*/,
    },
    { // <decl in class>*
      ((1<<5)|0x9)/*emptyList:1*/,
    },
    { // ws*
    },
    { // idChar*
      ((1<<5)|0x9)/*emptyList:1*/,
    },
    { // digit*
      ((1<<5)|0x9)/*emptyList:1*/,
    },
    { // #
      7/*duplicateTop*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // registerNewline
      ((8<<5)|0x6)/*nullProductionAction:8*/,
      ((54<<5)|0x5)/*methodCall:54*/,
    },
};
public void actionCall(int idx, wrangLR.runtime.SemanticInfo si) {
  switch(idx) {
    default: System.err.println("Internal error--illegal action number: "+idx);break;
    case 0: {
      Program parm0 = (Program)si.popPb();
      actionObject.topLevel(parm0);
    }
    break;
    case 1: {
      int parm0 = (Integer)si.popPb();
      List<ClassDecl> parm1 = (List<ClassDecl>)si.popPb();
      Program result = actionObject.createProgram(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 2: {
      int parm0 = (Integer)si.popPb();
      String parm1 = (String)si.popPb();
      List<Decl> parm2 = (List<Decl>)si.popPb();
      ClassDecl result = actionObject.createClassDecl(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 3: {
      int parm0 = (Integer)si.popPb();
      String parm1 = (String)si.popPb();
      List<Statement> parm2 = (List<Statement>)si.popPb();
      Decl result = actionObject.createMethodDeclVoid(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 4: {
      int parm0 = (Integer)si.popPb();
      Type parm1 = (Type)si.popPb();
      String parm2 = (String)si.popPb();
      Decl result = actionObject.createInstVarDecl(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 5: {
      int parm0 = (Integer)si.popPb();
      Type result = actionObject.intType(parm0);
      si.pushPb(result);
    }
    break;
    case 6: {
      int parm0 = (Integer)si.popPb();
      Type result = actionObject.booleanType(parm0);
      si.pushPb(result);
    }
    break;
    case 7: {
      int parm0 = (Integer)si.popPb();
      String parm1 = (String)si.popPb();
      Type result = actionObject.identifierType(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 8: {
      int parm0 = (Integer)si.popPb();
      Type parm1 = (Type)si.popPb();
      Object parm2 = (Object)si.popPb();
      Type result = actionObject.newArrayType(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 9: {
      int parm0 = (Integer)si.popPb();
      Statement result = actionObject.newBreak(parm0);
      si.pushPb(result);
    }
    break;
    case 10: {
      int parm0 = (Integer)si.popPb();
      List<Statement> parm1 = (List<Statement>)si.popPb();
      Statement result = actionObject.newBlock(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 11: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Statement result = actionObject.assign(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 12: {
      String parm0 = (String)si.popPb();
      int parm1 = (Integer)si.popPb();
      Statement result = actionObject.incrBack(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 13: {
      int parm0 = (Integer)si.popPb();
      String parm1 = (String)si.popPb();
      Statement result = actionObject.incrFront(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 14: {
      String parm0 = (String)si.popPb();
      int parm1 = (Integer)si.popPb();
      Statement result = actionObject.subBack(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 15: {
      int parm0 = (Integer)si.popPb();
      String parm1 = (String)si.popPb();
      Statement result = actionObject.subBack(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 16: {
      Type parm0 = (Type)si.popPb();
      int parm1 = (Integer)si.popPb();
      String parm2 = (String)si.popPb();
      Exp parm3 = (Exp)si.popPb();
      Statement result = actionObject.localVarDecl(parm0,parm1,parm2,parm3);
      si.pushPb(result);
    }
    break;
    case 17: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newOr(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 18: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newAnd(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 19: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newNotEquals(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 20: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newEquals(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 21: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newLessThan(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 22: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newGreaterThan(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 23: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newLessThanEquals(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 24: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newGreaterEquals(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 25: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      String parm2 = (String)si.popPb();
      Exp result = actionObject.newInstanceOf(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 26: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newPlus(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 27: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newMinus(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 28: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newTimes(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 29: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newDivide(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 30: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newRemainder(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 31: {
      int parm0 = (Integer)si.popPb();
      Type parm1 = (Type)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newCast(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 32: {
      int parm0 = (Integer)si.popPb();
      Exp parm1 = (Exp)si.popPb();
      Exp result = actionObject.newUnaryMinus(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 33: {
      int parm0 = (Integer)si.popPb();
      Exp parm1 = (Exp)si.popPb();
      Exp result = actionObject.newUnaryPlus(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 34: {
      int parm0 = (Integer)si.popPb();
      Exp parm1 = (Exp)si.popPb();
      Exp result = actionObject.newUnaryNot(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 35: {
      int parm0 = (Integer)si.popPb();
      String parm1 = (String)si.popPb();
      Exp result = actionObject.newIdentfierExp(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 36: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newArrayLookup(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 37: {
      int parm0 = (Integer)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp result = actionObject.newIntegerLiteral(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 38: {
      int parm0 = (Integer)si.popPb();
      String parm1 = (String)si.popPb();
      Exp result = actionObject.newStringLiteral(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 39: {
      int parm0 = (Integer)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp result = actionObject.newCharLiteral(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 40: {
      int parm0 = (Integer)si.popPb();
      Exp result = actionObject.newThis(parm0);
      si.pushPb(result);
    }
    break;
    case 41: {
      int parm0 = (Integer)si.popPb();
      Exp result = actionObject.newTrue(parm0);
      si.pushPb(result);
    }
    break;
    case 42: {
      int parm0 = (Integer)si.popPb();
      Exp result = actionObject.newFalse(parm0);
      si.pushPb(result);
    }
    break;
    case 43: {
      int parm0 = (Integer)si.popPb();
      Exp parm1 = (Exp)si.popPb();
      String parm2 = (String)si.popPb();
      Exp result = actionObject.newInstVarAccess(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 44: {
      int parm0 = (Integer)si.popPb();
      Type parm1 = (Type)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      List<Object> parm3 = (List<Object>)si.popPb();
      Exp result = actionObject.newMultiArray(parm0,parm1,parm2,parm3);
      si.pushPb(result);
    }
    break;
    case 45: {
      int parm0 = (Integer)si.popPb();
      String parm1 = (String)si.popPb();
      Exp result = actionObject.newObject(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 46: {
      char parm0 = (Character)si.popPb();
      char result = actionObject.sub128(parm0);
      si.pushPb(result);
    }
    break;
    case 47: {
      char parm0 = (Character)si.popPb();
      List<Character> parm1 = (List<Character>)si.popPb();
      char parm2 = (Character)si.popPb();
      int result = actionObject.convertToInt(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 48: {
      char parm0 = (Character)si.popPb();
      int result = actionObject.convertToInt(parm0);
      si.pushPb(result);
    }
    break;
    case 49: {
      char parm0 = (Character)si.popPb();
      List<Character> parm1 = (List<Character>)si.popPb();
      char parm2 = (Character)si.popPb();
      int result = actionObject.convert16ToInt(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 50: {
      char parm0 = (Character)si.popPb();
      char parm1 = (Character)si.popPb();
      String result = actionObject.emptyString(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 51: {
      char parm0 = (Character)si.popPb();
      List<Character> parm1 = (List<Character>)si.popPb();
      char parm2 = (Character)si.popPb();
      String result = actionObject.string(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 52: {
      char parm0 = (Character)si.popPb();
      char parm1 = (Character)si.popPb();
      int result = actionObject.charVal(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 53: {
      char parm0 = (Character)si.popPb();
      char result = actionObject.underscore(parm0);
      si.pushPb(result);
    }
    break;
    case 54: {
      int parm0 = (Integer)si.popPb();
      actionObject.registerNewline(parm0);
    }
    break;
  }
}
private String[] saNameSigTable = {
"void topLevel(Program)",
"Program createProgram(int,List<ClassDecl>)",
"ClassDecl createClassDecl(int,String,List<Decl>)",
"Decl createMethodDeclVoid(int,String,List<Statement>)",
"Decl createInstVarDecl(int,Type,String)",
"Type intType(int)",
"Type booleanType(int)",
"Type identifierType(int,String)",
"Type newArrayType(int,Type,Object)",
"Statement newBreak(int)",
"Statement newBlock(int,List<Statement>)",
"Statement assign(Exp,int,Exp)",
"Statement incrBack(String,int)",
"Statement incrFront(int,String)",
"Statement subBack(String,int)",
"Statement subBack(int,String)",
"Statement localVarDecl(Type,int,String,Exp)",
"Exp newOr(Exp,int,Exp)",
"Exp newAnd(Exp,int,Exp)",
"Exp newNotEquals(Exp,int,Exp)",
"Exp newEquals(Exp,int,Exp)",
"Exp newLessThan(Exp,int,Exp)",
"Exp newGreaterThan(Exp,int,Exp)",
"Exp newLessThanEquals(Exp,int,Exp)",
"Exp newGreaterEquals(Exp,int,Exp)",
"Exp newInstanceOf(Exp,int,String)",
"Exp newPlus(Exp,int,Exp)",
"Exp newMinus(Exp,int,Exp)",
"Exp newTimes(Exp,int,Exp)",
"Exp newDivide(Exp,int,Exp)",
"Exp newRemainder(Exp,int,Exp)",
"Exp newCast(int,Type,Exp)",
"Exp newUnaryMinus(int,Exp)",
"Exp newUnaryPlus(int,Exp)",
"Exp newUnaryNot(int,Exp)",
"Exp newIdentfierExp(int,String)",
"Exp newArrayLookup(Exp,int,Exp)",
"Exp newIntegerLiteral(int,int)",
"Exp newStringLiteral(int,String)",
"Exp newCharLiteral(int,int)",
"Exp newThis(int)",
"Exp newTrue(int)",
"Exp newFalse(int)",
"Exp newInstVarAccess(int,Exp,String)",
"Exp newMultiArray(int,Type,Exp,List<Object>)",
"Exp newObject(int,String)",
"char sub128(char)",
"int convertToInt(char,List<Character>,char)",
"int convertToInt(char)",
"int convert16ToInt(char,List<Character>,char)",
"String emptyString(char,char)",
"String string(char,List<Character>,char)",
"int charVal(char,char)",
"char underscore(char)",
"void registerNewline(int)",
};
public String[] getSaNameSigTable() {
  return saNameSigTable;
}
private int[] sigCountTable = {
1,0,
2,1,
3,1,
3,1,
3,1,
1,1,
1,1,
2,1,
3,1,
1,1,
2,1,
3,1,
2,1,
2,1,
2,1,
2,1,
4,1,
3,1,
3,1,
3,1,
3,1,
3,1,
3,1,
3,1,
3,1,
3,1,
3,1,
3,1,
3,1,
3,1,
3,1,
3,1,
2,1,
2,1,
2,1,
2,1,
3,1,
2,1,
2,1,
2,1,
1,1,
1,1,
1,1,
3,1,
4,1,
2,1,
1,1,
3,1,
1,1,
3,1,
2,1,
3,1,
2,1,
1,1,
1,0,
};
public int[] getSigCountTable() {
  return sigCountTable;
}
public int[] getSymbolSizeTable() { return symbolSizeTable; }
private int[] symbolSizeTable = {
    0,
    0,
    0,
    1,
    1,
    1,
    0,
    1,
    0,
    1,
    0,
    1,
    1,
    1,
    0,
    0,
    0,
    0,
    1,
    1,
    0,
    0,
    0,
    1,
    0,
    0,
    1,
    1,
    0,
    1,
    1,
    0,
    0,
    0,
    1,
    0,
    1,
    0,
    1,
    0,
    1,
    0,
    0,
    1,
    0,
    0,
    0,
    0,
    0,
    1,
    0,
    0,
    1,
    0,
    0,
    1,
    1,
    1,
    0,
    1,
    1,
    1,
    0,
    0,
    0,
    0,
    0,
    1,
    1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    1,
    -1,
    -1,
    1,
    -1,
    -1,
    1,
    -1,
    1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    1,
    -1,
    -1,
    0,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    -1,
    -1,
};
public Object vectorToTuple(java.util.Vector<Object> vec) {
  switch (vec.size()) {
  }
  System.err.println("Internal error--illegal Tuple size: "+vec.size());
  return null;
}
}
