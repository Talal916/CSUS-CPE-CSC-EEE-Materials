// counter for horizontal and vertical count

module counter (clk, reset, hcnt, vcnt);

input            clk, reset;
output [9:0] hcnt;
output [9:0] vcnt;

reg [9:0]      hcnt;
reg [9:0]      vcnt;

always @(posedge clk or posedge reset) 
begin

  if(reset)  
  begin
     hcnt <= 0;
     vcnt <= 0;
  end
  else begin
    if(hcnt == 799) 
    begin
       hcnt <= 0;
       if(vcnt == 521)
          vcnt <= 0;
       else
         vcnt <= vcnt + 1;
    end
    else 
    begin
        hcnt <= hcnt + 1;
    end
  end

end

endmodule




