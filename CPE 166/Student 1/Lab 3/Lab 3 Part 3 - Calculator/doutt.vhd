library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.std_logic_unsigned.all;
use ieee.std_logic_arith.all;

entity doutt is
port( 
	q 				: in std_logic_vector ( 4 downto 1);
	dout3, dout4	: out std_logic_vector(1 downto 0));
end doutt;

architecture Behavioral of doutt is
begin
	process(q)
	begin
		dout3 <= q(2)&q(1);
		dout4 <= q(4)&q(3);
	end process;

end Behavioral;