`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 01/23/2019 05:02:12 PM
// Design Name: 
// Module Name: mux2to1_tb
// Project Name: 
// Target Devices: 
// Tool Versions: 
// Description: 
// 
// Dependencies: 
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
//////////////////////////////////////////////////////////////////////////////////


module mux2to1_tb;
   reg [1:0] d;
   reg       s;
   wire      y;
   mux2to1 u1(.d(d), .s(s), .y(y));
   initial
   begin
            //d[0]=0; d[1]; s=0;
            d=2'b10; s=0;
            #10;
            //d[0]=1; d[1]=0; s=0
            d=2'b01; s=0;
            #10;
            //d[0]=0; d[1]=1; s=1;
            d=2'b10; s=1;
            #10;
            //d[0]=1; d[1]=0; s=1;
            d=2'b01; s=1;
            #20 $stop;
     end   
endmodule
