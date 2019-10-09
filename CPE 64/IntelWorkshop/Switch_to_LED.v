/*This lab will step you through the process of a simple design from generating your first Verilog file
to synthesize and compile. Synthesis converts your Verilog language file to an FPGA specific
“netlist” that programs the programmable FPGA lookup tables into your desired function.
Compilation figures out the location of the lookup table cells used in the FPGA and generates a
programming image that is downloaded to your Intel FPGA Development kit. At the end of this
lab, you will be able to test the functionality of the example digital electronic circuits by toggling
the switches and observing the LEDs for proper circuit operation.*/

module Switch_to_LED(SW, LEDR); //create module Switch_to_LED
	input [9:0] SW; // input declarations: 10 switches
	output [9:0] LEDR; // output declarations: 10 red LEDs
	assign LEDR = SW; // connect switches to LEDs
endmodule 