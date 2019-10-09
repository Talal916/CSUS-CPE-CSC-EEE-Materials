module fpga_proj( clk, seg, dig);
 
input        clk;
output [7:0] seg;
output [7:0] dig; 
 
parameter N = 18;
 
reg [N-1:0] count; 
reg [3:0]   dd; 
reg [7:0]   seg;
reg [7:0]   an; 

always @ (posedge clk)
 begin
  count <= count + 1;
  
  case(count[N-1:N-3])  
   3'b000 :
    begin
     dd = 4'd7;
     an = 8'b11111110;
    end
    
   3'b001:  
    begin
     dd = 4'd6;
     an = 8'b11111101;
    end
    
   3'b010:  
    begin
     dd = 4'd5; 
     an = 8'b11111011;
    end
     
   3'b011:  
    begin
     dd = 4'd4;
     an = 8'b11110111;
    end
    
    3'b100 :
        begin
         dd = 4'd3;
         an = 8'b11101111;
        end
        
       3'b101:  
        begin
         dd = 4'd2;
         an = 8'b11011111;
        end
        
       3'b110:  
        begin
         dd = 4'd1;
         an = 8'b10111111;
        end
         
       3'b111:  
        begin
         dd = 4'd0;
         an = 8'b01111111;
        end
  endcase
 end
assign dig = an;
 

 
always @ (dd)
 begin
  seg[7] = 1'b1; 
  case(dd) //			gfedcba
   4'd0 : seg[6:0] = 7'b1000110; //to display F - C
   4'd1 : seg[6:0] = 7'b0001100; //to display P - P
   4'd2 : seg[6:0] = 7'b0000110; //to display G - E
   4'd3 : seg[6:0] = 7'b1111001; //to display A - 1
   4'd4 : seg[6:0] = 7'b0000010; //to display - 6 
   4'd5 : seg[6:0] = 7'b0000010; //to display F -6 
   4'd6 : seg[6:0] = 7'b0000111; //to display u - A
   4'd7 : seg[6:0] = 7'b1100001; //to display n - S
   //S - 0010010
   default : seg[6:0] = 7'b1111111; //blank
  endcase
 end 
 
endmodule