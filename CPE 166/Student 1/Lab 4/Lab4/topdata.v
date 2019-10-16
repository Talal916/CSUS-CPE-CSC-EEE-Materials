module topdata(clk, reset, ce, sel, m0, m1, m2, w, s, cin, dout);

input [3:0] ce;
input [2:0] w, s;
input [1:0] sel;
input clk, reset, cin, m0, m1, m2;

output dout;

wire [3:0] r;
wire [3:0] y;
wire j;

assign dout = r[2];
dff d1(clk, reset, ce[0], y[0], r[0]);
dff d2(clk, reset, ce[1], y[1], r[1]);
dff d3(clk, reset, ce[2], y[2], r[2]);
dff d4(clk, reset, ce[3], y[3], r[3]);

mux2to1 m55(m0, r[3], w[0], y[0]);
mux2to1 m69(m1, r[3], w[1], y[1]);
mux2to1 m96(m2, r[3], w[2], y[2]);

mux4to1 m4(r[0], r[1], r[2], 0, sel, j);

alu a1(s, cin, r[3], j, y[3]);
	
	
endmodule
