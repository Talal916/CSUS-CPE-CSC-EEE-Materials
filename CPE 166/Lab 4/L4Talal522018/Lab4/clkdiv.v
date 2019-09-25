//clk divider from 50 MHz to 25 Mhz

module clkdiv (clk, reset, div_clk);
input clk, reset;
output div_clk;
reg div_clk;

always @ (posedge clk or posedge reset)
begin
if(reset)
div_clk <= 0;
else
div_clk <= ~div_clk;
end

endmodule

