/**********************************************************************/
/*   ____  ____                                                       */
/*  /   /\/   /                                                       */
/* /___/  \  /                                                        */
/* \   \   \/                                                       */
/*  \   \        Copyright (c) 2003-2009 Xilinx, Inc.                */
/*  /   /          All Right Reserved.                                 */
/* /---/   /\                                                         */
/* \   \  /  \                                                      */
/*  \___\/\___\                                                    */
/***********************************************************************/

/* This file is designed for use with ISim build 0x7708f090 */

#define XSI_HIDE_SYMBOL_SPEC true
#include "xsi.h"
#include <memory.h>
#ifdef __GNUC__
#include <stdlib.h>
#else
#include <malloc.h>
#define alloca _alloca
#endif
static const char *ng0 = "T:/lab5part1/alu.v";
static int ng1[] = {0, 0};
static int ng2[] = {1, 0};
static int ng3[] = {2, 0};
static int ng4[] = {3, 0};
static int ng5[] = {4, 0};
static int ng6[] = {5, 0};
static int ng7[] = {6, 0};
static int ng8[] = {7, 0};



static void Cont_10_0(char *t0)
{
    char t5[8];
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t6;
    char *t7;
    unsigned int t8;
    unsigned int t9;
    unsigned int t10;
    unsigned int t11;
    unsigned int t12;
    unsigned int t13;
    char *t14;
    char *t15;
    char *t16;
    char *t17;
    char *t18;
    unsigned int t19;
    unsigned int t20;
    char *t21;
    unsigned int t22;
    unsigned int t23;
    char *t24;
    unsigned int t25;
    unsigned int t26;
    char *t27;

LAB0:    t1 = (t0 + 3008U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    xsi_set_current_line(10, ng0);
    t2 = (t0 + 2088);
    t3 = (t2 + 56U);
    t4 = *((char **)t3);
    memset(t5, 0, 8);
    t6 = (t5 + 4);
    t7 = (t4 + 4);
    t8 = *((unsigned int *)t4);
    t9 = (t8 >> 0);
    t10 = (t9 & 1);
    *((unsigned int *)t5) = t10;
    t11 = *((unsigned int *)t7);
    t12 = (t11 >> 0);
    t13 = (t12 & 1);
    *((unsigned int *)t6) = t13;
    t14 = (t0 + 3672);
    t15 = (t14 + 56U);
    t16 = *((char **)t15);
    t17 = (t16 + 56U);
    t18 = *((char **)t17);
    memset(t18, 0, 8);
    t19 = 1U;
    t20 = t19;
    t21 = (t5 + 4);
    t22 = *((unsigned int *)t5);
    t19 = (t19 & t22);
    t23 = *((unsigned int *)t21);
    t20 = (t20 & t23);
    t24 = (t18 + 4);
    t25 = *((unsigned int *)t18);
    *((unsigned int *)t18) = (t25 | t19);
    t26 = *((unsigned int *)t24);
    *((unsigned int *)t24) = (t26 | t20);
    xsi_driver_vfirst_trans(t14, 0, 0);
    t27 = (t0 + 3576);
    *((int *)t27) = 1;

LAB1:    return;
}

static void Always_12_1(char *t0)
{
    char t10[8];
    char t12[8];
    char t28[8];
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;
    int t6;
    char *t7;
    char *t8;
    char *t9;
    char *t11;
    unsigned int t13;
    unsigned int t14;
    unsigned int t15;
    unsigned int t16;
    unsigned int t17;
    unsigned int t18;
    unsigned int t19;
    unsigned int t20;
    unsigned int t21;
    unsigned int t22;
    unsigned int t23;
    unsigned int t24;
    unsigned int t25;
    char *t26;
    char *t27;
    unsigned int t29;
    unsigned int t30;
    unsigned int t31;
    unsigned int t32;
    unsigned int t33;
    int t34;
    int t35;
    unsigned int t36;
    unsigned int t37;
    unsigned int t38;
    unsigned int t39;
    unsigned int t40;
    unsigned int t41;
    char *t42;
    unsigned int t43;
    unsigned int t44;
    unsigned int t45;
    unsigned int t46;
    unsigned int t47;
    unsigned int t48;
    unsigned int t49;
    unsigned int t50;
    char *t51;

LAB0:    t1 = (t0 + 3256U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    xsi_set_current_line(12, ng0);
    t2 = (t0 + 3592);
    *((int *)t2) = 1;
    t3 = (t0 + 3288);
    *((char **)t3) = t2;
    *((char **)t1) = &&LAB4;

LAB1:    return;
LAB4:    xsi_set_current_line(13, ng0);

LAB5:    xsi_set_current_line(14, ng0);
    t4 = (t0 + 1048U);
    t5 = *((char **)t4);

LAB6:    t4 = ((char*)((ng1)));
    t6 = xsi_vlog_unsigned_case_compare(t5, 3, t4, 32);
    if (t6 == 1)
        goto LAB7;

LAB8:    t2 = ((char*)((ng2)));
    t6 = xsi_vlog_unsigned_case_compare(t5, 3, t2, 32);
    if (t6 == 1)
        goto LAB9;

LAB10:    t2 = ((char*)((ng3)));
    t6 = xsi_vlog_unsigned_case_compare(t5, 3, t2, 32);
    if (t6 == 1)
        goto LAB11;

LAB12:    t2 = ((char*)((ng4)));
    t6 = xsi_vlog_unsigned_case_compare(t5, 3, t2, 32);
    if (t6 == 1)
        goto LAB13;

LAB14:    t2 = ((char*)((ng5)));
    t6 = xsi_vlog_unsigned_case_compare(t5, 3, t2, 32);
    if (t6 == 1)
        goto LAB15;

LAB16:    t2 = ((char*)((ng6)));
    t6 = xsi_vlog_unsigned_case_compare(t5, 3, t2, 32);
    if (t6 == 1)
        goto LAB17;

LAB18:    t2 = ((char*)((ng7)));
    t6 = xsi_vlog_unsigned_case_compare(t5, 3, t2, 32);
    if (t6 == 1)
        goto LAB19;

LAB20:    t2 = ((char*)((ng8)));
    t6 = xsi_vlog_unsigned_case_compare(t5, 3, t2, 32);
    if (t6 == 1)
        goto LAB21;

LAB22:
LAB23:    goto LAB2;

LAB7:    xsi_set_current_line(15, ng0);
    t7 = (t0 + 1368U);
    t8 = *((char **)t7);
    t7 = (t0 + 1528U);
    t9 = *((char **)t7);
    memset(t10, 0, 8);
    xsi_vlog_unsigned_add(t10, 2, t8, 1, t9, 1);
    t7 = (t0 + 1208U);
    t11 = *((char **)t7);
    memset(t12, 0, 8);
    xsi_vlog_unsigned_add(t12, 2, t10, 2, t11, 1);
    t7 = (t0 + 2088);
    xsi_vlogvar_wait_assign_value(t7, t12, 0, 0, 2, 0LL);
    goto LAB23;

LAB9:    xsi_set_current_line(16, ng0);
    t3 = (t0 + 1368U);
    t4 = *((char **)t3);
    t3 = (t0 + 1528U);
    t7 = *((char **)t3);
    memset(t10, 0, 8);
    t3 = (t7 + 4);
    t13 = *((unsigned int *)t3);
    t14 = (~(t13));
    t15 = *((unsigned int *)t7);
    t16 = (t15 & t14);
    t17 = (t16 & 1U);
    if (t17 != 0)
        goto LAB27;

LAB25:    if (*((unsigned int *)t3) == 0)
        goto LAB24;

LAB26:    t8 = (t10 + 4);
    *((unsigned int *)t10) = 1;
    *((unsigned int *)t8) = 1;

LAB27:    t9 = (t10 + 4);
    t11 = (t7 + 4);
    t18 = *((unsigned int *)t7);
    t19 = (~(t18));
    *((unsigned int *)t10) = t19;
    *((unsigned int *)t9) = 0;
    if (*((unsigned int *)t11) != 0)
        goto LAB29;

LAB28:    t24 = *((unsigned int *)t10);
    *((unsigned int *)t10) = (t24 & 3U);
    t25 = *((unsigned int *)t9);
    *((unsigned int *)t9) = (t25 & 3U);
    memset(t12, 0, 8);
    xsi_vlog_unsigned_add(t12, 2, t4, 1, t10, 2);
    t26 = (t0 + 1208U);
    t27 = *((char **)t26);
    memset(t28, 0, 8);
    xsi_vlog_unsigned_add(t28, 2, t12, 2, t27, 1);
    t26 = (t0 + 2088);
    xsi_vlogvar_wait_assign_value(t26, t28, 0, 0, 2, 0LL);
    goto LAB23;

LAB11:    xsi_set_current_line(17, ng0);
    t3 = (t0 + 1528U);
    t4 = *((char **)t3);
    memcpy(t10, t4, 8);
    t3 = (t0 + 2088);
    xsi_vlogvar_wait_assign_value(t3, t10, 0, 0, 2, 0LL);
    goto LAB23;

LAB13:    xsi_set_current_line(18, ng0);
    t3 = (t0 + 1368U);
    t4 = *((char **)t3);
    t3 = (t0 + 1528U);
    t7 = *((char **)t3);
    t13 = *((unsigned int *)t4);
    t14 = *((unsigned int *)t7);
    t15 = (t13 & t14);
    *((unsigned int *)t12) = t15;
    t3 = (t4 + 4);
    t8 = (t7 + 4);
    t9 = (t12 + 4);
    t16 = *((unsigned int *)t3);
    t17 = *((unsigned int *)t8);
    t18 = (t16 | t17);
    *((unsigned int *)t9) = t18;
    t19 = *((unsigned int *)t9);
    t20 = (t19 != 0);
    if (t20 == 1)
        goto LAB30;

LAB31:
LAB32:    memset(t10, 0, 8);
    t27 = (t10 + 4);
    t42 = (t12 + 4);
    t43 = *((unsigned int *)t12);
    t44 = (~(t43));
    *((unsigned int *)t10) = t44;
    *((unsigned int *)t27) = 0;
    if (*((unsigned int *)t42) != 0)
        goto LAB34;

LAB33:    t49 = *((unsigned int *)t10);
    *((unsigned int *)t10) = (t49 & 3U);
    t50 = *((unsigned int *)t27);
    *((unsigned int *)t27) = (t50 & 3U);
    t51 = (t0 + 2088);
    xsi_vlogvar_wait_assign_value(t51, t10, 0, 0, 2, 0LL);
    goto LAB23;

LAB15:    xsi_set_current_line(19, ng0);
    t3 = (t0 + 1368U);
    t4 = *((char **)t3);
    t3 = (t0 + 1528U);
    t7 = *((char **)t3);
    t13 = *((unsigned int *)t4);
    t14 = *((unsigned int *)t7);
    t15 = (t13 & t14);
    *((unsigned int *)t10) = t15;
    t3 = (t4 + 4);
    t8 = (t7 + 4);
    t9 = (t10 + 4);
    t16 = *((unsigned int *)t3);
    t17 = *((unsigned int *)t8);
    t18 = (t16 | t17);
    *((unsigned int *)t9) = t18;
    t19 = *((unsigned int *)t9);
    t20 = (t19 != 0);
    if (t20 == 1)
        goto LAB35;

LAB36:
LAB37:    t27 = (t0 + 2088);
    xsi_vlogvar_wait_assign_value(t27, t10, 0, 0, 2, 0LL);
    goto LAB23;

LAB17:    xsi_set_current_line(20, ng0);
    t3 = (t0 + 1368U);
    t4 = *((char **)t3);
    t3 = (t0 + 1528U);
    t7 = *((char **)t3);
    t13 = *((unsigned int *)t4);
    t14 = *((unsigned int *)t7);
    t15 = (t13 | t14);
    *((unsigned int *)t10) = t15;
    t3 = (t4 + 4);
    t8 = (t7 + 4);
    t9 = (t10 + 4);
    t16 = *((unsigned int *)t3);
    t17 = *((unsigned int *)t8);
    t18 = (t16 | t17);
    *((unsigned int *)t9) = t18;
    t19 = *((unsigned int *)t9);
    t20 = (t19 != 0);
    if (t20 == 1)
        goto LAB38;

LAB39:
LAB40:    t27 = (t0 + 2088);
    xsi_vlogvar_wait_assign_value(t27, t10, 0, 0, 2, 0LL);
    goto LAB23;

LAB19:    xsi_set_current_line(21, ng0);
    t3 = (t0 + 1368U);
    t4 = *((char **)t3);
    memset(t10, 0, 8);
    t3 = (t4 + 4);
    t13 = *((unsigned int *)t3);
    t14 = (~(t13));
    t15 = *((unsigned int *)t4);
    t16 = (t15 & t14);
    t17 = (t16 & 1U);
    if (t17 != 0)
        goto LAB44;

LAB42:    if (*((unsigned int *)t3) == 0)
        goto LAB41;

LAB43:    t7 = (t10 + 4);
    *((unsigned int *)t10) = 1;
    *((unsigned int *)t7) = 1;

LAB44:    t8 = (t10 + 4);
    t9 = (t4 + 4);
    t18 = *((unsigned int *)t4);
    t19 = (~(t18));
    *((unsigned int *)t10) = t19;
    *((unsigned int *)t8) = 0;
    if (*((unsigned int *)t9) != 0)
        goto LAB46;

LAB45:    t24 = *((unsigned int *)t10);
    *((unsigned int *)t10) = (t24 & 3U);
    t25 = *((unsigned int *)t8);
    *((unsigned int *)t8) = (t25 & 3U);
    t11 = (t0 + 2088);
    xsi_vlogvar_wait_assign_value(t11, t10, 0, 0, 2, 0LL);
    goto LAB23;

LAB21:    xsi_set_current_line(22, ng0);
    t3 = (t0 + 1368U);
    t4 = *((char **)t3);
    t3 = (t0 + 1528U);
    t7 = *((char **)t3);
    t13 = *((unsigned int *)t4);
    t14 = *((unsigned int *)t7);
    t15 = (t13 ^ t14);
    *((unsigned int *)t10) = t15;
    t3 = (t4 + 4);
    t8 = (t7 + 4);
    t9 = (t10 + 4);
    t16 = *((unsigned int *)t3);
    t17 = *((unsigned int *)t8);
    t18 = (t16 | t17);
    *((unsigned int *)t9) = t18;
    t19 = *((unsigned int *)t9);
    t20 = (t19 != 0);
    if (t20 == 1)
        goto LAB47;

LAB48:
LAB49:    t11 = (t0 + 2088);
    xsi_vlogvar_wait_assign_value(t11, t10, 0, 0, 2, 0LL);
    goto LAB23;

LAB24:    *((unsigned int *)t10) = 1;
    goto LAB27;

LAB29:    t20 = *((unsigned int *)t10);
    t21 = *((unsigned int *)t11);
    *((unsigned int *)t10) = (t20 | t21);
    t22 = *((unsigned int *)t9);
    t23 = *((unsigned int *)t11);
    *((unsigned int *)t9) = (t22 | t23);
    goto LAB28;

LAB30:    t21 = *((unsigned int *)t12);
    t22 = *((unsigned int *)t9);
    *((unsigned int *)t12) = (t21 | t22);
    t11 = (t4 + 4);
    t26 = (t7 + 4);
    t23 = *((unsigned int *)t4);
    t24 = (~(t23));
    t25 = *((unsigned int *)t11);
    t29 = (~(t25));
    t30 = *((unsigned int *)t7);
    t31 = (~(t30));
    t32 = *((unsigned int *)t26);
    t33 = (~(t32));
    t34 = (t24 & t29);
    t35 = (t31 & t33);
    t36 = (~(t34));
    t37 = (~(t35));
    t38 = *((unsigned int *)t9);
    *((unsigned int *)t9) = (t38 & t36);
    t39 = *((unsigned int *)t9);
    *((unsigned int *)t9) = (t39 & t37);
    t40 = *((unsigned int *)t12);
    *((unsigned int *)t12) = (t40 & t36);
    t41 = *((unsigned int *)t12);
    *((unsigned int *)t12) = (t41 & t37);
    goto LAB32;

LAB34:    t45 = *((unsigned int *)t10);
    t46 = *((unsigned int *)t42);
    *((unsigned int *)t10) = (t45 | t46);
    t47 = *((unsigned int *)t27);
    t48 = *((unsigned int *)t42);
    *((unsigned int *)t27) = (t47 | t48);
    goto LAB33;

LAB35:    t21 = *((unsigned int *)t10);
    t22 = *((unsigned int *)t9);
    *((unsigned int *)t10) = (t21 | t22);
    t11 = (t4 + 4);
    t26 = (t7 + 4);
    t23 = *((unsigned int *)t4);
    t24 = (~(t23));
    t25 = *((unsigned int *)t11);
    t29 = (~(t25));
    t30 = *((unsigned int *)t7);
    t31 = (~(t30));
    t32 = *((unsigned int *)t26);
    t33 = (~(t32));
    t34 = (t24 & t29);
    t35 = (t31 & t33);
    t36 = (~(t34));
    t37 = (~(t35));
    t38 = *((unsigned int *)t9);
    *((unsigned int *)t9) = (t38 & t36);
    t39 = *((unsigned int *)t9);
    *((unsigned int *)t9) = (t39 & t37);
    t40 = *((unsigned int *)t10);
    *((unsigned int *)t10) = (t40 & t36);
    t41 = *((unsigned int *)t10);
    *((unsigned int *)t10) = (t41 & t37);
    goto LAB37;

LAB38:    t21 = *((unsigned int *)t10);
    t22 = *((unsigned int *)t9);
    *((unsigned int *)t10) = (t21 | t22);
    t11 = (t4 + 4);
    t26 = (t7 + 4);
    t23 = *((unsigned int *)t11);
    t24 = (~(t23));
    t25 = *((unsigned int *)t4);
    t34 = (t25 & t24);
    t29 = *((unsigned int *)t26);
    t30 = (~(t29));
    t31 = *((unsigned int *)t7);
    t35 = (t31 & t30);
    t32 = (~(t34));
    t33 = (~(t35));
    t36 = *((unsigned int *)t9);
    *((unsigned int *)t9) = (t36 & t32);
    t37 = *((unsigned int *)t9);
    *((unsigned int *)t9) = (t37 & t33);
    goto LAB40;

LAB41:    *((unsigned int *)t10) = 1;
    goto LAB44;

LAB46:    t20 = *((unsigned int *)t10);
    t21 = *((unsigned int *)t9);
    *((unsigned int *)t10) = (t20 | t21);
    t22 = *((unsigned int *)t8);
    t23 = *((unsigned int *)t9);
    *((unsigned int *)t8) = (t22 | t23);
    goto LAB45;

LAB47:    t21 = *((unsigned int *)t10);
    t22 = *((unsigned int *)t9);
    *((unsigned int *)t10) = (t21 | t22);
    goto LAB49;

}


extern void work_m_00000000001778201859_2725559894_init()
{
	static char *pe[] = {(void *)Cont_10_0,(void *)Always_12_1};
	xsi_register_didat("work_m_00000000001778201859_2725559894", "isim/top_tb_isim_beh.exe.sim/work/m_00000000001778201859_2725559894.didat");
	xsi_register_executes(pe);
}
