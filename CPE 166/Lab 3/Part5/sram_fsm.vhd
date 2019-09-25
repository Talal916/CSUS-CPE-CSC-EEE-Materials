library IEEE;  
use IEEE.std_logic_1164.all; 
use IEEE.std_logic_unsigned.all;
use IEEE.std_logic_arith.all;
 
entity sram_fsm is  
  port ( clk, reset : IN   std_logic;  
         address : OUT     std_logic_vector(3 downto 0);		 
	    cs, we, oe: OUT    std_logic ); 
end sram_fsm;

architecture fsm_beh of sram_fsm is 
  type state_type is (idle, s1,s2,s3,s4);  
  signal state: state_type ;
  signal cnt: std_logic_vector(3 downto 0); 
begin  
 
  cs <= '1';
  address <= cnt;
 
  process (clk,reset)  
  begin  
    if (reset ='1') then  
      state   <= idle;  
      cnt     <= "0000";
 
    elsif (clk='1' and clk'event) then  
      case state is  
	when idle => 
		state <= s1;
        cnt   <= "0000";

        when s1 => 
		state <= s2;
        cnt   <= "0000";
                      
        when s2 => 
		cnt   <=   cnt + 1;
		if (cnt  < 15) then
		   state <= s2;
		else
		   state <= s3;   
		end if;

        when s3 =>   state <= s4;
           cnt  <= "0000";

	when s4 => 
		cnt  <= cnt + 1;		
		state <= s4;
		
                      
    when others => 
		cnt     <= "0000";
		state   <= s1;       
	
      end case;  
    end if;  
  end process;

  process(state)
  begin
 	case state is  
		when idle => we <= '0'; oe <= '0';  
        when s1 => we <= '1'; oe <= '0';                     
        when s2 => we <= '1'; oe <= '0';   
        when s3 => we <= '0'; oe <= '1';  
        when s4 => we <= '0'; oe <= '1';  
	    when others => we <= '0'; oe <= '0';   
	end case;  
  end process;  

end fsm_beh; 