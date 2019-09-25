module adder( a, b, cout, s );
input [3:0]  a, b; //inputs for adder
output       cout; //cout shift
output [3:0] s;//output of adder

assign  { cout, s } = a + b;

endmodule



