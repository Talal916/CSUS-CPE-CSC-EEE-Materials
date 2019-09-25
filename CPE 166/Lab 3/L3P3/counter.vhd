library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_unsigned.all;
use ieee.std_logic_arith.all;

entity counter is
port(
	osc	: in std_logic;
	b1	: in std_logic;
	clk	: out std_logic
);
end counter;

architecture beh of counter is

signal clkref	: std_logic;
signal cnt10 	: std_logic_vector(26 downto 0);

begin
	clk <= clkref;

	process(osc,b1)
	begin
		if(b1 = '1') then
			cnt10 <= (others=>'0');
			clkref <='0';
		elsif( rising_edge(osc) ) then
			if (cnt10 = 49999999 ) then
				cnt10 <= ( others => '0' );
				clkref <= '1';
			elsif (cnt10 < 24999999) then
				cnt10 <= cnt10 + 1;
				clkref <= '1';
			else
				cnt10 <= cnt10 + 1;
				clkref <= '0';
			end if;
		end if;
	end process;

end beh;