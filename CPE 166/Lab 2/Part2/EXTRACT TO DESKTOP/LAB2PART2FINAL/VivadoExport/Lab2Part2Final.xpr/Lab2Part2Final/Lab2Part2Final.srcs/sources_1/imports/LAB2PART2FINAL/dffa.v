module dffa (clk, clr, load, da, qa);
input        clk, clr, load;
input [3:0]  da;
output [3:0] qa;

reg    [3:0] qa;

always@(posedge clr or  posedge clk)
begin
    if(clr) qa <= 0;
    else if (load)
       qa <= da;
end

endmodule


/*

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

*/









 