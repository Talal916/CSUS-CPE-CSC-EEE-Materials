module vga(clk, reset, hcnt, vcnt, hs, vs, vga);
input          clk, reset;
input [9:0] hcnt, vcnt;
output        vs, hs, vga;

assign hs = (hcnt < 704) ? 1 : 0;
assign vs = (vcnt < 519) ? 1 : 0;
assign vga = (hs && vs) ? 1 : 0;

endmodule



