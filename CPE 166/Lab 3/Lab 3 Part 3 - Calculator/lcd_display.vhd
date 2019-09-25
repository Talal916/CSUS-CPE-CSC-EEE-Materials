library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_unsigned.all;
use ieee.std_logic_arith.all;

entity lcd_display is
port( 
	clk															: in std_logic;
	f 															: in std_logic_vector(3 downto 1);
	lcd_e, lcd_rs, lcd_rw, lcd_7, lcd_6, lcd_5, lcd_4, sf_ce0	: out std_logic);
end lcd_display;

architecture beh of lcd_display is
signal lcd_busy, lcd_stb	: std_logic;
signal lcd_code				: std_logic_vector (5 downto 0);
signal lcd_stuff			: std_logic_vector (6 downto 0);
signal count				: std_logic_vector (24 downto 0);
signal lcd_rw_1				: std_logic;
begin
	process(clk)
	begin
		if (rising_edge (clk)) then
			lcd_busy <= '1';
			sf_ce0 <= '1';
			count <= count + 1;
			case count (24 downto 20) is
				when "00000" =>
					lcd_code <= "000011";
				when "00001" =>
					lcd_code <= "000011";
				when "00010" =>
					lcd_code <= "000011";
				when "00011" =>
					lcd_code <= "000010";
				when "00100" =>
					lcd_code <= "000010";
				when "00101" =>
					lcd_code <= "001000";
				when "00110" =>
					lcd_code <= "000000";
				when "00111" =>
					lcd_code <= "000110";
				when "01000" =>
					lcd_code <= "000000";
				when "01001" =>
					lcd_code <= "001100";
				when "01010" =>
					lcd_code <= "000000";
				when "01011" =>
					lcd_code <= "000001";
				when "01100" =>
					lcd_code <= "100011";
				when "01101" =>
					lcd_code <= "10000"&f(3); --f3
				when "01110" =>
					lcd_code <= "100011";
				when "01111" =>
					lcd_code <= "10000"&f(2); --f2
				when "10000" =>
					lcd_code <= "100011";
				when "10001" =>
					lcd_code <= "10000"&f(1); --f1
				when others =>
					lcd_code <= "010000";
			end case;
			lcd_rw <= lcd_rw_1;
			lcd_stb <= (count(19) xor count(18)) and (not lcd_rw_1) and lcd_busy;
			lcd_stuff <= (lcd_stb) & lcd_code;
			(lcd_e, lcd_rs, lcd_rw_1, lcd_7, lcd_6, lcd_5, lcd_4) <= lcd_stuff;
		end if;
	end process;
	
end beh;