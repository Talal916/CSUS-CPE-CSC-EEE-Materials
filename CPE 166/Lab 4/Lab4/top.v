module top (clk, sw1, m0, m1, m2, cin, dout);
input  clk, sw1, m0, m1, m2, cin;
output dout;

wire clr;
wire [1:0] sel;
wire [2:0] w, s;
wire [3:0] ce;

topdata g1(clk, clr, ce, sel, m0, m1, m2, w, s, cin, dout);
fsm     f1(clk, sw1, clr, w, ce, sel, s);

endmodule
