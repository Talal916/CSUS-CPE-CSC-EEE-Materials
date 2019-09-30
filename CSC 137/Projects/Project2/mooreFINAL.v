`timescale 1ns/1ps
module mooredetector(digit, rst, clk, y);

input digit;
input clk;
input rst;

output reg y;

reg [2:0] cs, ns;

parameter S0 = 3'b000, S1 = 3'b001, S2 = 3'b010, S3 = 3'b100, S4 = 3'b101;

always @(cs or digit)
 begin
 case (cs)
   S0: if (digit == 1'b1)
          begin
             ns = S1;
              y=1'b0;
          end
      else ns = cs;
   S1: if (digit == 1'b0)
          begin
            ns = S2;
             y=1'b0;
          end
       else
          begin
              ns = cs;
              y=1'b0;
          end
   S2: if (digit == 1'b1)
          begin
             ns = S3;
              y=1'b0;
          end    
            else
          begin
              ns = S0;
              y=1'b0;
          end
   S3: if (digit == 1'b0)
          begin
             ns = S4;
              y=1'b0;
          end
       else
          begin
              ns = S1;
              y=1'b0;
          end
S4: if (digit == 1'b0)
          begin
             ns = S0;
              y=1'b1;
          end
          else
          begin
              ns = S3;
              y=1'b1;
          end
   default: ns = S0;
  endcase
end
always@(posedge clk)
begin
          if (rst)
          cs <= S0;
          else
            cs <= ns;
end
endmodule

module mooredetector_tb;
reg digit,clk,rst;
wire y;


mooredetector uut(digit, rst, clk, y);


initial begin
rst=0; 
clk=0;
digit=0;

$display("Sequence to be detected: 1010");
$display("Input given: 01010101011010110110111100010101");
$monitor($time, , ,"CLK: %b",clk,,"Y: %b",y,,"RST: %b ",rst,,"Digit: %b",digit);

#5 digit=1;
#5 digit=0;
#5 digit=1;
#5 digit=0;
#5 digit=1;
#5 digit=0;
#5 digit=1;
#5 digit=0;
#5 digit=1;
#5 digit=1;
#5 digit=0;
#5 digit=1;
#5 digit=0;
#5 digit=1;
#5 digit=1;
#5 digit=0;
#5 digit=1;
#5 digit=1;
#5 digit=0;
#5 digit=1;
#5 digit=1;
#5 digit=1;
#5 digit=1;
#5 digit=0;
#5 digit=0;
#5 digit=0;
#5 digit=1;
#5 digit=0;
#5 digit=1;
#5 digit=0;
#5 digit=1;


end

always
#5 clk=~clk;
initial
#100 $finish;


endmodule