//Talal Jawaid
//Professor Weide Chang
//CSC 137

module TestMod;                     // the "main" thing
   
   parameter STDIN = 32'h8000_0000; // I/O address of keyboard input channel

   reg C0;            
   reg [7:0] str [1:3]; 
   reg [4:0] X, Y;      
   wire [4:0] S;        
   wire C4, C5, E;      

   AddSubMod  my_addsub(X, Y, S, C0, C4, C5, E);

   initial begin

      $display("Enter X (range 0 ~ 15):");
      str[1] = $fgetc( STDIN );        
      str[2] = $fgetc( STDIN );      
      str[3] = $fgetc( STDIN );      
      str[1] = str[1] - 48;          
      str[2] = str[2] - 48;          
      str[1] = str[1] * 10;          
      X = str[1] + str[2];           

      $display("Enter Y (range 0 ~ 15):");
      str[1] = $fgetc( STDIN );      
      str[2] = $fgetc( STDIN );      
      str[3] = $fgetc( STDIN );      
      str[1] = str[1] - 48;          
      str[2] = str[2] - 48;          
      str[1] = str[1] * 10;          
      Y = str[1] + str[2];           

      $display("Enter either '+' or '-':");
      str[1] = $fgetc( STDIN );     

      if( str[1] == 45 ) // Subtract numbers
          C0 = 1;
      else // Add Numbers
          C0 = 0; 
      
      #1; // wait until Adder gets them processed

      $display("X=%b (%d) Y=%b (%d) C0=%d", X, X, Y, Y, C0);
      $display("Result=%b (as unsigned %d) ", S, S);
      $display("C4=%d C5=%d E=%d", C4, C5, E);
      if(E==0)
        $display("Since E is %d, C5 is not needed.", E);      
      else 
        $display("Since E is %d, correct with C5 in front: %d%b", E, C5, S);
   end

endmodule


module AddSubMod(X, Y, S, C0, C4, C5, E); // 5-Bit Adder/Subtractor

   input C0;           
   input [4:0] X, Y ;  
   output [4:0] S;     
   output E, C4, C5;   
   wire [0:5] c;       
   wire [0:4] xw;      

   assign c[0] = C0;   
   assign C4 = c[4];   
   assign C5 = c[5];   

   xor(xw[0], c[0], Y[0]); 
   xor(xw[1], c[0], Y[1]); 
   xor(xw[2], c[0], Y[2]); 
   xor(xw[3], c[0], Y[3]); 
   xor(xw[4], c[0], Y[4]); 

   FullAdder fa1(X[0], xw[0], c[0], c[1], S[0]);  
   FullAdder fa2(X[1], xw[1], c[1] ,c[2] ,S[1]);
   FullAdder fa3(X[2], xw[2], c[2] ,c[3] ,S[2]); 
   FullAdder fa4(X[3], xw[3], c[3], c[4] ,S[3]); 
   FullAdder fa5(X[4], xw[4], c[4], c[5] ,S[4]); 

   xor(E, c[4], c[5]); 

endmodule

module majorityMod(x, y, c_in, c_out); 

   input x, y, c_in; 
   output c_out; 

   wire [0:2] a_wire; // array of extra wires

   and(a_wire[0], x, y);
   and(a_wire[1], x, c_in); 
   and(a_wire[2], y, c_in);  

   or(c_out, a_wire[0], a_wire[1], a_wire[2]);

endmodule



module parityMod(x, y, c_in, sum);

   input x, y, c_in; 
   output sum; 

   wire x_y; 
   xor(x_y, x, y);

   xor(sum, x_y, c_in);

endmodule


module FullAdder(x, y, c_in, c_out, sum);

   input x, y, c_in; 
   output c_out, sum;

   majorityMod my_mm (x, y, c_in, c_out); 
   parityMod my_pm (x, y, c_in, sum); 

endmodule

