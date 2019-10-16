
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use WORK.ALL;

entity top_sram is
 Port ( clk, reset: in std_logic;
       data:  inout std_logic_vector(7 downto 0)
 );
end top_sram;

architecture Behavioral of top_sram is

signal cs, we, oe: std_logic;
signal  wdata:     std_logic_vector(7 downto 0);
signal address:    std_logic_vector(3 downto 0);

attribute mark_debug: string;
attribute keep: string ;
attribute mark_debug of address: signal is "true";
attribute mark_debug of wdata: signal is "true";
 
begin

 data <= "11000011" when ( we='1' and oe='0' )  else "ZZZZZZZZ";
 wdata <= data;
 
  
g1:  entity sram ( beh_sram ) 
     port map ( address => address, din => data, dout => data, 
               cs => cs, we => we,  oe => oe );

g2:  entity sram_fsm ( fsm_beh ) 
     port map ( clk=>clk, reset=>reset,   
         address=> address, 		 	 
	     cs => cs, we => we, oe => oe ); 


end Behavioral;
