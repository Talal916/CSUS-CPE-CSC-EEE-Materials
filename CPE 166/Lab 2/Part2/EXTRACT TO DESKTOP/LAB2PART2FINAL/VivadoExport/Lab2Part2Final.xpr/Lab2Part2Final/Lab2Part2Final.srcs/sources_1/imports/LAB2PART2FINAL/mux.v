module mux ( s, d1, d0, y );
input [3:0]  d1, d0; // a,b
input  [3:0]       s;// select bit 
output [3:0] y; // output of multiplexer

reg    [3:0] y;

always@( s or d1 or d0 )
begin
   if (s[0]) //if lsb of input is 1
          y = d1; // = B
   else
          y = d0; // y = 0000
end

endmodule



