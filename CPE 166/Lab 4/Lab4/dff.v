module dff(clk, reset, enable, da, qa);
input       clk, reset, enable;
input da;
output qa;

reg qa;

always@(posedge reset or posedge clk)
	begin
		if(reset == 1)
			qa <= 0;
		else
		if(enable)
			qa <= da;
	end
endmodule
