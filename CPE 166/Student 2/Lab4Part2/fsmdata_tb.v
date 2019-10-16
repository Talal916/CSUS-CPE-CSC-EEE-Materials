`timescale 1ns / 1ps
module fsmdata_tb;
    reg sw1, clk, cin;
    reg[3:0] m0, m1, m2;
    wire en;
    wire[3:0] r0, r1, r2;

fsmdata u1(sw1, clk, m0, m1, m2, cin, en, r0, r1, r2);

initial clk = 0;
always #1 clk = ~clk;

initial begin
    sw1 = 1; m0 = 4; m1 = 1; m2 = 0; cin = 1;
    #10 sw1 = 0;
    #10 sw1 = 1; m0 = 5; m1 = 3; cin = 0;
    #10 sw1 = 0;
    #10 $stop;
end
endmodule
