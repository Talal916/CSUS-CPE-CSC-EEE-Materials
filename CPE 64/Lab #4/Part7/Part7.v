module Part7(clk, si, pl, sl, sr, rr, rl, Q);
	input clk, si, pl, sl, sr, rr, rl;
	output reg [7:0]Q = 8'b10101010;
	wire [7:0]P;
	
	assign P = 8'b10011001;
	
	always @(posedge clk)
	case ({pl, sl, sr, rr, rl})
	
	5'b10000: begin Q<=P; end
	5'b01000: begin Q<=Q<<1; Q[0]<=si; end
	5'b00100: begin Q<=Q>>1; Q[7]<=si; end
	5'b00010: begin Q<=Q>>1; Q[7]<=Q[0]; end
	5'b00001: begin Q<=Q<<1; Q[0]<=Q[7]; end
	
	endcase
	endmodule
	