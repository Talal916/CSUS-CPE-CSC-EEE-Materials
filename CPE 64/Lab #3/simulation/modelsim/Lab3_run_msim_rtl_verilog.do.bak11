transcript on
if {[file exists rtl_work]} {
	vdel -lib rtl_work -all
}
vlib rtl_work
vmap work rtl_work

vlog -vlog01compat -work work +incdir+//gaia/leesam/CPE\ 64/Lab\ #3 {//gaia/leesam/CPE 64/Lab #3/adder.v}

vlog -vlog01compat -work work +incdir+C:/intelFPGA_lite/17.0 {C:/intelFPGA_lite/17.0/ComparatorTestBench.v}

vsim -t 1ps -L altera_ver -L lpm_ver -L sgate_ver -L altera_mf_ver -L altera_lnsim_ver -L cycloneive_ver -L rtl_work -L work -voptargs="+acc"  ComparatorTestBench

add wave *
view structure
view signals
run -all
