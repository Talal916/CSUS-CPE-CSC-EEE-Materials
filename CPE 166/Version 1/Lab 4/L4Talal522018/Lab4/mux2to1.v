module mux2to1(d0, d1, s, y);

input 		 d0, d1;
input        s;

output  y;

reg     y;

always@(d1 or d0 or s)
begin
   if(s)
          y <= d1;
   else
          y <= d0;
end

endmodule
