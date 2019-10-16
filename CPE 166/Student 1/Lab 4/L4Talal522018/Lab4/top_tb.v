module top_tb;

	// Inputs
	reg clk;
	reg sw1;
	reg m0;
	reg m1;
	reg m2;
	reg cin;

	// Outputs
	wire dout;

	// Instantiate the Unit Under Test (UUT)
	top uut (
		.clk(clk), 
		.sw1(sw1), 
		.m0(m0), 
		.m1(m1), 
		.m2(m2), 
		.cin(cin), 
		.dout(dout)
	);
	always #5 clk <= ~clk;
	initial begin
		// Initialize Inputs
		clk = 0;
		sw1 = 0;
		m0 = 1;
		m1 = 0;
		m2 = 0;
		cin = 1;
		
		#20;
		sw1 = 1;
		#20;
		sw1 = 0;
		#150;
		
		m0 = 1;
		m1 = 1;
		m2 = 0;
		cin = 1;
		sw1 = 1;
		
		#20;
		sw1 = 0;
		
		#150;
		
		// Wait 100 ns for global reset to finish
		#100;
        
		// Add stimulus here

	end
      
endmodule

