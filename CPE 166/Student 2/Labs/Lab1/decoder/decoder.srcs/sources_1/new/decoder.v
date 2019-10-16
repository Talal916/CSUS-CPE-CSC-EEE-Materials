`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 01/23/2019 05:19:32 PM
// Design Name: 
// Module Name: decoder
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


module decoder(a,d);
input [1:0]a;
output [3:0]d;

assign d[0] = ~a[0] & ~a[1];
assign d[1] = a[0] & ~a[1];
assign d[2] = ~a[0] & a[1];
assign d[3] = a[0] & a[1];

endmodule
