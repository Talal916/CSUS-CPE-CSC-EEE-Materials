module lab5(r, x, y);
input [31:0] x, y;
output reg [31:0] r;

wire [47:0] mult_reg;

assign mult_reg = ({1'b1,x[22:0]})*({1'b1,y[22:0]});

always@(x or y)
begin
	if(x == 0 | y == 0)
		r[31:0] = 0;
	else
	begin
		r[31] = x[31] ^ y[31];
		r[30:23] = x[30:23] + y[30:23] - 8'b0111_1111;		
		r[22:0] = mult_reg[45:23];
	end
end

endmodule