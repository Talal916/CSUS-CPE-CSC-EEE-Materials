library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use ieee.std_logic_unsigned.all;
use ieee.std_logic_arith.all;

entity calculator is
port ( 
	b1,b2,b3,b4,osc 	: in std_logic;
	q					: inout std_logic_vector(4 downto 1);
	lcd_e, lcd_rs, lcd_rw, lcd_7, lcd_6, lcd_5, lcd_4, sf_ce0: out STD_LOGIC
);
end calculator;

architecture Behavioral of calculator is
signal dout3,dout4 	: std_logic_vector(1 downto 0);
signal clk,res 		: std_logic;
signal lfsgen 		: std_logic;
signal lfshold 		: std_logic;
signal f3_l 		: STD_LOGIC_VECTOR (5 downto 0);
signal f3_u 		: STD_LOGIC_VECTOR (5 downto 0);
signal f2_l 		: STD_LOGIC_VECTOR (5 downto 0);
signal f2_u 		: STD_LOGIC_VECTOR (5 downto 0);
signal f1_l 		: STD_LOGIC_VECTOR (5 downto 0);
signal f1_u 		: STD_LOGIC_VECTOR (5 downto 0);
signal f 			: std_logic_vector (3 downto 1);

component counter is
port(
	osc	: in std_logic;
	b1	: in std_logic;
	clk	: out std_logic );
end component;

component fsm is
port( 
	b1,b2,clk 			: in std_logic;
	res,lfsgen,lfshold 	: out std_logic);
end component;

component lfsr is
port(
	b2,clk,res,lfsgen,lfshold	: in std_logic;
	q							: out std_logic_vector(4 downto 1));
end component;

component doutt is
port( 
	q			: in std_logic_vector (4 downto 1);
	dout3,dout4	: out std_logic_vector (1 downto 0));
end component;

component cal is
port( 
	dout3, dout4	: in std_logic_vector(1 downto 0);
	b1,b2,b3, b4	: in std_logic;
	f				: out std_logic_vector(3 downto 1));
end component cal;

component lcdvalue
port( 
	f 		: in std_logic_vector(3 downto 1);
	clk		: in std_logic;
	f3_l 	: out STD_LOGIC_VECTOR (5 downto 0);
	f3_u 	: out STD_LOGIC_VECTOR (5 downto 0);
	f2_l 	: out STD_LOGIC_VECTOR (5 downto 0);
	f2_u 	: out STD_LOGIC_VECTOR (5 downto 0);
	f1_l 	: out STD_LOGIC_VECTOR (5 downto 0);
	f1_u 	: out STD_LOGIC_VECTOR (5 downto 0) );
end component;

component lcd_display
port( 
	clk															: in std_logic;
	f															: in std_logic_vector(3 downto 1);
	lcd_e, lcd_rs, lcd_rw, lcd_7, lcd_6, lcd_5, lcd_4, sf_ce0	: out std_logic);
end component;

begin
	q0	: counter port map(osc,b1,clk);
	q1	: fsm port map( b1,b2,clk,res,lfsgen,lfshold);
	q2	: lfsr port map(b2,clk,res,lfsgen,lfshold,q);
	q3	: doutt port map(q,dout3,dout4);
	q4	: cal port map(dout3, dout4, b1,b2,b3, b4,f);	
	q6	: lcd_display port map(osc,f,lcd_e, lcd_rs, lcd_rw, lcd_7, lcd_6, lcd_5, lcd_4, sf_ce0);
end Behavioral;