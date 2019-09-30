// bitcell.v
// How to use registers to latch data into one bitcell (reg)

module BitcellMod(clk, in, out);
   input clk, in;
   output out;

   reg bitcell;

   assign out = bitcell;

   always @(posedge clk) begin
      bitcell = in;
   end
endmodule

module TestMod;
   reg clk, data_in;
   wire data_out;

   BitcellMod my_memory1(clk, data_in, data_out);

   always begin // this is clock wave
      #1;
      clk = 0;  // 0 for half cycle (#1)
      #1;
      clk = 1;  // 1 for half cycle (#1)
   end
   
   initial begin
      $display("Time clk    in out");

      data_in = 0;
      #1;
      $display("%4d   %b    %b  %b", $time, clk, data_in, data_out);
      #1;
      $display("%4d   %b    %b  %b", $time, clk, data_in, data_out);

      data_in = 1;
      #1;
      $display("%4d   %b    %b  %b", $time, clk, data_in, data_out);
      #1;
      $display("%4d   %b    %b  %b", $time, clk, data_in, data_out);

      data_in = 0;
      #1;
      $display("%4d   %b    %b  %b", $time, clk, data_in, data_out);
      #1;
      $display("%4d   %b    %b  %b", $time, clk, data_in, data_out);

      data_in = 1;
      #1;
      $display("%4d   %b    %b  %b", $time, clk, data_in, data_out);
      #1;
      $display("%4d   %b    %b  %b", $time, clk, data_in, data_out);

      $finish;
   end
endmodule
