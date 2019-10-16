


`timescale 1ns/1ps

module dffa_tb;

reg       clk, clr, load;
reg [3:0] da;

wire [3:0] qa;

dffa   uut ( .clk(clk), .clr(clr), .load(load), .da(da), .qa(qa));

//  dffa uut ( clk, clr, load, da, qa );

initial  clk = 0;

always   #10 clk = ~ clk;

initial
begin
    clr = 1; load = 0;
    da  = 4'b1011;
   
    #24  clr = 0; load = 1;
    #20  load = 0;

    #60 $stop;
end

endmodule






