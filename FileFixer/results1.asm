 .data 

CLASS_Object: 
 .word 0 

CLASS_Lib: 
 .word CLASS_Object 
 .word readLine 
 .word readInt 
 .word readChar 
 .word printStr 
 .word printBool 
 .word printInt 
 .word intToString 
 .word intToChar 
CLASS_END_Lib: 

CLASS_String: 
 .word CLASS_Object 
 .word concat 
 .word substring 
 .word length 
 .word charAt 
 .word compareTo 
CLASS_END_String: 

CLASS_RunMain: 
 .word CLASS_Object 
CLASS_END_RunMain: 

CLASS_Main: 
 .word CLASS_Object 
 .word fcn_35_main 
 .word fcn_70_add100Elements 
 .word fcn_102_removeAlternateElements 
CLASS_END_Main: 

CLASS_IntList: 
 .word CLASS_Object 
 .word fcn_120_init 
 .word fcn_195_print 
CLASS_END_IntList: 
CLASS_END_Object: 
 .data 
 .word CLASS_String 
 .word 1 
 .word 0 
strLit_129: 
 .byte 10 
 .byte 0 
 .byte 0 
 .byte 0 
 .word CLASS_String 
 .word 2 
 .word -1 
strLit_156: 
 .word CLASS_String 
 .word 1 
 .word 0 
strLit_160: 
 .byte 32 
 .byte 0 
 .byte 0 
 .byte 0 
 .word CLASS_String 
 .word 2 
 .word -1 
strLit_172: 
 .byte 10 
 .byte 0 
 .byte 0 
 .byte 0 
 .word CLASS_String 
 .word 2 
 .word -1 
strLit_189: 
 .text 
 
 .globl main 
 main: 
 jal vm_init 
 
 
 
 li $s6,2 
 li $s7,1 
 jal newObject 
 la $t0,CLASS_Main 
 sw $t0,-12($s7) 
 
 lw $zero,($sp)
 lw $t0,0($sp) 
 beq $t0,$zero,nullPtrException 
 lw $t0,-12($t0) 
 lw $t0,4($t0) 
 jalr $t0 
 
 
 li $v0,10 
 syscall 
 
 
 
 
 .globl fcn_35_main 
 fcn_35_main: 
 subu $sp,$sp,8 
 sw $ra,4($sp) 
 sw $s2,($sp) 
 lw $s2,8($sp) 
 
 
 subu $sp,$sp,4 
 sw $zero,($sp)
 
 lw $zero,($sp)
 
 
 
 
 subu $sp,$sp,8 
 sw $s5,4($sp)
 li $t0,0 
 sw $t0,($sp) 
 
 lw $zero,($sp)
 
 
 j while_enter_30 
 while_top_30: 
 
 
 
 
 
 subu $sp,$sp,4 
 sw $s2,($sp)
 
 lw $zero,($sp)
 
 lw $t0,12($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $zero,($sp)
 lw $t0,4($sp) 
 beq $t0,$zero,nullPtrException 
 lw $t0,-12($t0) 
 lw $t0,8($t0) 
 jalr $t0 
 
 lw $t0,($sp) 
 sw $t0,12($sp) 
 addu $sp,$sp,4 
 
 
 
 
 subu $sp,$sp,4 
 sw $s2,($sp)
 
 lw $zero,($sp)
 
 lw $t0,12($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $zero,($sp)
 lw $t0,4($sp) 
 beq $t0,$zero,nullPtrException 
 lw $t0,-12($t0) 
 lw $t0,12($t0) 
 jalr $t0 
 
 lw $t0,($sp) 
 sw $t0,12($sp) 
 addu $sp,$sp,4 
 
 
 
 
 
 lw $t0,0($sp) 
 subu $sp,$sp,8 
 sw $s5,4($sp)
 sw $t0,($sp)
 
 
 subu $sp,$sp,8 
 sw $s5,4($sp)
 li $t0,1 
 sw $t0,($sp) 
 
 lw $t0,($sp) 
 lw $t1,8($sp) 
 addu $t0,$t0,$t1 
 addu $sp,$sp,8 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 sw $t0,8($sp) 
 addu $sp,$sp,8 
 
 
 while_enter_30: 
 
 
 lw $t0,0($sp) 
 subu $sp,$sp,8 
 sw $s5,4($sp)
 sw $t0,($sp)
 
 
 subu $sp,$sp,8 
 sw $s5,4($sp)
 li $t0,1000 
 sw $t0,($sp) 
 
 lw $t0,($sp) 
 lw $t1,8($sp) 
 slt $t0,$t1,$t0 
 addu $sp,$sp,12 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 addu $sp,$sp,4 
 bne $t0,$zero,while_top_30 
 while_exit_30: 
 
 addu $sp,8 
 
 
 
 
 lw $t0,0($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $zero,($sp)
 lw $t0,0($sp) 
 beq $t0,$zero,nullPtrException 
 lw $t0,-12($t0) 
 lw $t0,8($t0) 
 jalr $t0 
 
 
 
 lw $ra,8($sp) 
 lw $s2,4($sp) 
 addu $sp,$sp,16 
 jr $ra 
 
 
 .globl fcn_70_add100Elements 
 fcn_70_add100Elements: 
 subu $sp,$sp,8 
 sw $ra,4($sp) 
 sw $s2,($sp) 
 lw $s2,12($sp) 
 
 
 lw $t0,8($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $zero,($sp)
 
 
 
 
 subu $sp,$sp,8 
 sw $s5,4($sp)
 li $t0,0 
 sw $t0,($sp) 
 
 lw $zero,($sp)
 
 
 j while_enter_67 
 while_top_67: 
 
 
 
 
 
 li $s6,2 
 li $s7,1 
 jal newObject 
 la $t0,CLASS_IntList 
 sw $t0,-12($s7) 
 
 lw $zero,($sp)
 
 lw $t0,-16($s2) 
 subu $sp,$sp,8 
 sw $s5,4($sp)
 sw $t0,($sp)
 
 lw $zero,($sp)
 
 lw $t0,20($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $zero,($sp)
 lw $t0,12($sp) 
 beq $t0,$zero,nullPtrException 
 lw $t0,-12($t0) 
 lw $t0,4($t0) 
 jalr $t0 
 
 lw $t0,($sp) 
 sw $t0,12($sp) 
 addu $sp,$sp,4 
 
 
 
 
 lw $t0,-16($s2) 
 subu $sp,$sp,8 
 sw $s5,4($sp)
 sw $t0,($sp)
 
 
 subu $sp,$sp,8 
 sw $s5,4($sp)
 li $t0,1 
 sw $t0,($sp) 
 
 lw $t0,($sp) 
 lw $t1,8($sp) 
 addu $t0,$t0,$t1 
 addu $sp,$sp,8 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 sw $t0,-16($s2) 
 addu $sp,$sp,8 
 
 
 
 
 
 lw $t0,0($sp) 
 subu $sp,$sp,8 
 sw $s5,4($sp)
 sw $t0,($sp)
 
 
 subu $sp,$sp,8 
 sw $s5,4($sp)
 li $t0,1 
 sw $t0,($sp) 
 
 lw $t0,($sp) 
 lw $t1,8($sp) 
 addu $t0,$t0,$t1 
 addu $sp,$sp,8 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 sw $t0,8($sp) 
 addu $sp,$sp,8 
 
 
 while_enter_67: 
 
 
 lw $t0,0($sp) 
 subu $sp,$sp,8 
 sw $s5,4($sp)
 sw $t0,($sp)
 
 
 subu $sp,$sp,8 
 sw $s5,4($sp)
 li $t0,100 
 sw $t0,($sp) 
 
 lw $t0,($sp) 
 lw $t1,8($sp) 
 slt $t0,$t1,$t0 
 addu $sp,$sp,12 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 addu $sp,$sp,4 
 bne $t0,$zero,while_top_67 
 while_exit_67: 
 
 addu $sp,8 
 
 
 lw $t0,0($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $ra,12($sp) 
 lw $s2,8($sp) 
 lw $t0,($sp) 
 sw $t0,20($sp)
 addu $sp,$sp,20 
 jr $ra 
 
 
 .globl fcn_102_removeAlternateElements 
 fcn_102_removeAlternateElements: 
 subu $sp,$sp,8 
 sw $ra,4($sp) 
 sw $s2,($sp) 
 lw $s2,12($sp) 
 
 
 
 lw $t0,8($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $zero,($sp)
 
 
 j while_enter_99 
 while_top_99: 
 
 
 
 
 lw $t0,0($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 
 
 
 lw $t0,4($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 beq $t0,$zero,nullPtrException 
 lw $t0,0($t0) 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 beq $t0,$zero,nullPtrException 
 lw $t0,0($t0) 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 lw $t1,4($sp) 
 beq $t1,$zero,nullPtrException 
 sw $t0,0,($t1) 
 addu $sp,$sp,8 
 
 
 
 
 
 lw $t0,0($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 beq $t0,$zero,nullPtrException 
 lw $t0,0($t0) 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 sw $t0,4($sp) 
 addu $sp,$sp,4 
 
 
 while_enter_99: 
 
 
 
 
 lw $t0,0($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 
 subu $sp,$sp,4 
 sw $zero,($sp)
 
 lw $t0,($sp) 
 lw $t1,4($sp) 
 seq $t0,$t0,$t1 
 addu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 xori $t0,$t0,1 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 beq $t0,$zero, skip_86 
 addu $sp,$sp,4 
 
 
 
 
 lw $t0,0($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 beq $t0,$zero,nullPtrException 
 lw $t0,0($t0) 
 sw $t0,($sp)
 
 
 subu $sp,$sp,4 
 sw $zero,($sp)
 
 lw $t0,($sp) 
 lw $t1,4($sp) 
 seq $t0,$t0,$t1 
 addu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 xori $t0,$t0,1 
 sw $t0,($sp)
 
 skip_86: 
 
 lw $t0,($sp) 
 addu $sp,$sp,4 
 bne $t0,$zero,while_top_99 
 while_exit_99: 
 
 addu $sp,4 
 
 
 lw $t0,8($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $ra,8($sp) 
 lw $s2,4($sp) 
 lw $t0,($sp) 
 sw $t0,16($sp)
 addu $sp,$sp,16 
 jr $ra 
 
 
 
 
 
 .globl fcn_120_init 
 fcn_120_init: 
 subu $sp,$sp,8 
 sw $ra,4($sp) 
 sw $s2,($sp) 
 lw $s2,20($sp) 
 
 
 lw $t0,12($sp) 
 subu $sp,$sp,8 
 sw $s5,4($sp)
 sw $t0,($sp)
 
 lw $t0,($sp) 
 sw $t0,-16($s2) 
 addu $sp,$sp,8 
 
 
 
 lw $t0,8($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 sw $t0,0($s2) 
 addu $sp,$sp,4 
 
 
 subu $sp,$sp,4 
 sw $s2,($sp)
 
 lw $ra,8($sp) 
 lw $s2,4($sp) 
 lw $t0,($sp) 
 sw $t0,24($sp)
 addu $sp,$sp,24 
 jr $ra 
 
 
 .globl fcn_195_print 
 fcn_195_print: 
 subu $sp,$sp,8 
 sw $ra,4($sp) 
 sw $s2,($sp) 
 lw $s2,8($sp) 
 
 
 li $s6,1 
 li $s7,0 
 jal newObject 
 la $t0,CLASS_Lib 
 sw $t0,-12($s7) 
 
 lw $zero,($sp)
 
 
 
 subu $sp,$sp,8 
 sw $s5,4($sp)
 li $t0,0 
 sw $t0,($sp) 
 
 lw $zero,($sp)
 
 
 
 subu $sp,$sp,4 
 la $t0,strLit_129 
 sw $t0,($sp)
 
 lw $zero,($sp)
 
 
 
 
 subu $sp,$sp,4 
 sw $s2,($sp)
 
 lw $zero,($sp)
 
 
 j while_enter_183 
 while_top_183: 
 
 
 
 
 
 lw $t0,16($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $zero,($sp)
 
 lw $t0,8($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $zero,($sp)
 lw $t0,4($sp) 
 beq $t0,$zero,nullPtrException 
 lw $t0,-12($t0) 
 lw $t0,16($t0) 
 jalr $t0 
 
 
 
 
 
 
 lw $t0,8($sp) 
 subu $sp,$sp,8 
 sw $s5,4($sp)
 sw $t0,($sp)
 
 
 subu $sp,$sp,8 
 sw $s5,4($sp)
 li $t0,9 
 sw $t0,($sp) 
 
 lw $t0,($sp) 
 lw $t1,8($sp) 
 slt $t0,$t1,$t0 
 addu $sp,$sp,12 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 xori $t0,$t0,1 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 addu $sp,$sp,4 
 beq $t0,$zero,if_else_180 
 
 
 
 
 lw $t0,16($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $zero,($sp)
 
 
 lw $t0,4($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 beq $t0,$zero,nullPtrException 
 lw $t0,-16($t0) 
 subu $sp,$sp,4 
 sw $s5,4($sp)
 sw $t0,($sp)
 
 lw $zero,($sp)
 lw $t0,8($sp) 
 beq $t0,$zero,nullPtrException 
 lw $t0,-12($t0) 
 lw $t0,24($t0) 
 jalr $t0 
 
 
 
 
 
 lw $t0,16($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $zero,($sp)
 
 subu $sp,$sp,4 
 la $t0,strLit_156 
 sw $t0,($sp)
 
 lw $zero,($sp)
 lw $t0,4($sp) 
 beq $t0,$zero,nullPtrException 
 lw $t0,-12($t0) 
 lw $t0,16($t0) 
 jalr $t0 
 
 
 
 
 subu $sp,$sp,4 
 la $t0,strLit_160 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 sw $t0,8($sp) 
 addu $sp,$sp,4 
 
 
 
 subu $sp,$sp,8 
 sw $s5,4($sp)
 li $t0,0 
 sw $t0,($sp) 
 
 lw $t0,($sp) 
 sw $t0,16($sp) 
 addu $sp,$sp,8 
 
 
 j if_done_180 
 if_else_180: 
 
 
 
 
 lw $t0,16($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $zero,($sp)
 
 
 lw $t0,4($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 beq $t0,$zero,nullPtrException 
 lw $t0,-16($t0) 
 subu $sp,$sp,4 
 sw $s5,4($sp)
 sw $t0,($sp)
 
 lw $zero,($sp)
 lw $t0,8($sp) 
 beq $t0,$zero,nullPtrException 
 lw $t0,-12($t0) 
 lw $t0,24($t0) 
 jalr $t0 
 
 
 
 
 subu $sp,$sp,4 
 la $t0,strLit_172 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 sw $t0,8($sp) 
 addu $sp,$sp,4 
 
 
 
 
 lw $t0,8($sp) 
 subu $sp,$sp,8 
 sw $s5,4($sp)
 sw $t0,($sp)
 
 
 subu $sp,$sp,8 
 sw $s5,4($sp)
 li $t0,1 
 sw $t0,($sp) 
 
 lw $t0,($sp) 
 lw $t1,8($sp) 
 addu $t0,$t0,$t1 
 addu $sp,$sp,8 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 sw $t0,16($sp) 
 addu $sp,$sp,8 
 
 
 if_done_180: 
 
 
 
 
 
 lw $t0,0($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 beq $t0,$zero,nullPtrException 
 lw $t0,0($t0) 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 sw $t0,4($sp) 
 addu $sp,$sp,4 
 
 
 while_enter_183: 
 
 
 
 lw $t0,0($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 
 subu $sp,$sp,4 
 sw $zero,($sp)
 
 lw $t0,($sp) 
 lw $t1,4($sp) 
 seq $t0,$t0,$t1 
 addu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 xori $t0,$t0,1 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 addu $sp,$sp,4 
 bne $t0,$zero,while_top_183 
 while_exit_183: 
 
 addu $sp,4 
 
 
 
 
 lw $t0,4($sp) 
 subu $sp,$sp,8 
 sw $s5,4($sp)
 sw $t0,($sp)
 
 
 subu $sp,$sp,8 
 sw $s5,4($sp)
 li $t0,0 
 sw $t0,($sp) 
 
 lw $t0,($sp) 
 lw $t1,8($sp) 
 sgt $t0,$t1,$t0 
 addu $sp,$sp,12 
 sw $t0,($sp)
 
 lw $t0,($sp) 
 addu $sp,$sp,4 
 beq $t0,$zero,if_else_194 
 
 
 
 
 lw $t0,12($sp) 
 subu $sp,$sp,4 
 sw $t0,($sp)
 
 lw $zero,($sp)
 
 subu $sp,$sp,4 
 la $t0,strLit_189 
 sw $t0,($sp)
 
 lw $zero,($sp)
 lw $t0,4($sp) 
 beq $t0,$zero,nullPtrException 
 lw $t0,-12($t0) 
 lw $t0,16($t0) 
 jalr $t0 
 
 
 
 j if_done_194 
 if_else_194: 
 
 
 if_done_194: 
 
 
 lw $ra,20($sp) 
 lw $s2,16($sp) 
 addu $sp,$sp,28 
 jr $ra 
 
 
###############################################################







###############################################################

 .text

###############################################################



















###############################################################
readLine:
 
 subu $sp,$sp,8 
 sw $ra, 4($sp) 
 move $t1,$sp 

 doRead:

 
 jal readLogicalChar

 
 
 subu $t2,$v0,13
 bne $t2,$zero,notReturnRL
 jal readLogicalChar
 subu $t2,$v0,10 
 beq $t2,$zero,foundNewLine
 sw $v0,lastCharRead 
 j foundNewLine 

 notReturnRL:

 

 subu $t0,$v0,10
 beq $t0,$zero,foundNewLine
 blt $v0,$zero,foundEof

 
 subu $sp,$sp,4
 sw $v0,($sp)

 
 j doRead

 foundEof:
 
 
 bne $t1,$sp foundNewLine

 
 
 sw $zero,8($sp) 
 j rlReturn 

 foundNewLine:

 
 
 
 


 
 subu $t0,$t1,$sp 
 srl $s6,$t0,2 
 subu $sp,$sp,4 
 sw $s6,($sp) 
 addu $t2,$t0,5 
 sw $t2,($t1) 
 
 
 addu $s6,$s6,7 
 srl $s6,$s6,2 
 move $s7,$zero 
 jal newObject 
 
 
 la $t0,CLASS_String
 sw $t0,-12($s7) 
 lw $t2,4($sp) 
 sll $t1,$t2,2 
 subu $t2,$zero,$t2 
 sw $t2,-4($s7) 

 
 lw $t0,-8($s7) 
 sll $t0,$t0,2 
 subu $t0,$s7,$t0 
 subu $t0,$t0,$t2 
 addu $sp,$sp,8 
 addu $t1,$t1,$sp 

 
 
 
 

 

 beq $sp,$t1,doneCharCopy
 charCopyLoop:
 lw $t2,($sp)
 sb $t2,-9($t0)
 addu $sp,$sp,4
 subu $t0,$t0,1
 bne $sp,$t1,charCopyLoop
 doneCharCopy:

 
 sw $s7,8($sp)
 
 rlReturn:
 
 lw $ra,4($sp) 
 addu $sp,$sp,8 
 jr $ra

###################################################################











###################################################################
readInt:

 
 subu $sp,$sp,4
 sw $ra,($sp)

 riSkipWhiteLoop:
 
 jal readLogicalChar

 
 
 subu $t0,$v0,32
 bgt $t0,$zero,nonWhite
 beq $t0,$zero,riSkipWhiteLoop 
 subu $t0,$v0,10
 beq $t0,$zero,riSkipWhiteLoop 
 subu $t0,$v0,9
 beq $t0,$zero,riSkipWhiteLoop 
 subu $t0,$v0,13
 beq $t0,$zero,riSkipWhiteLoop 
 subu $t0,$v0,12
 beq $t0,$zero,riSkipWhiteLoop 
 j badIntegerFormat 

 nonWhite:
 subu $t0,$v0,'-'
 li $t4,1 
 bne $t0,$zero,helpReadInt 
 li $t4,-1 

 
 jal readLogicalChar

 helpReadInt:
 li $t2,10
 subu $t1,$v0,'0' 
 bgeu $t1,$t2,badIntegerFormat 
 move $t3,$t1 

 
 

 digitLoop:
 
 
 

 jal readLogicalChar 
 subu $t1,$v0,'0' 
 bgeu $t1,$t2,doneDigitLoop 

 mul $t3,$t3,$t2 
 addu $t3,$t3,$t1 
 j digitLoop

 doneDigitLoop:

 
 sw $v0,lastCharRead

 
 
 lw $ra,($sp)
 mult $t3,$t4 
 mflo $t3
 sw $t3,($sp) 
 sw $s5,4($sp) 
 lw $zero,4($sp)
 
 
 jr $ra

###################################################################









###################################################################
readChar:

 
 subu $sp,$sp,4
 sw $ra,($sp)

 
 jal readLogicalChar

 
 
 lw $ra,($sp)
 sw $s5,4($sp)
 lw $zero,4($sp)
 sw $v0,($sp)

 
 jr $ra

########################################################





########################################################
printStr:
 
 lw $t0,($sp)
 bne $t0,$zero,psNotNull

 
 la $a0,nullStr
 li $v0,4
 syscall
 j donePrintStr
 
 psNotNull:
 
 
 
 
 
 subu $t0,$t0,8
 lw $t1,($t0) 
 sll $t1,$t1,2
 subu $t1,$t0,$t1 
 lw $t0,4($t0) 
 subu $t0,$t1,$t0 

 
 beq $t0,$t1,donePrintStr
 psLoop:
 lb $a0,($t1) 
 li $v0,11 
 syscall 
 addu $t1,$t1,1 
 blt $t1,$t0,psLoop

 donePrintStr:
 
 addu $sp,$sp,8
 jr $ra

########################################################






########################################################
printInt:
 
 lw $a0,($sp)
 addu $sp,$sp,12

 
 li $v0,1 
 syscall

 
 jr $ra

########################################################





########################################################
printBool:
 
 lw $t0,($sp)
 addu $sp,$sp,8

 
 la $a0,falseString
 beq $t0,$zero,skipPB
 la $a0,trueString
 skipPB:
 li $v0,4 
 syscall

 
 jr $ra

########################################################










########################################################
substring:

 
 subu $sp,$sp,4
 sw $ra,($sp)

 
 lw $t0,20($sp)
 beq $t0,$zero,nullPtrException

 
 
 lw $t0,-4($t0) 
 subu $t0,$zero,$t0 
 lw $t1,4($sp) 
 lw $t2,12($sp) 
 bgt $zero,$t2,strIndexOutOfBounds
 bgt $t2,$t1,strIndexOutOfBounds
 bgt $t1,$t0,strIndexOutOfBounds

 
 subu $s6,$t1,$t2 
 addu $s6,$s6,7 
 srl $s6,$s6,2 
 move $s7,$zero 
 jal newObject

 
 la $t0,CLASS_String
 sw $t0,-12($s7)
 
 
 lw $t1,8($sp) 
 lw $t2,16($sp) 
 subu $t0,$t2,$t1 
 sw $t0,-4($s7) 
 
 
 lw $t3,24($sp) 
 sw $s7,24($sp) 
 
 
 beq $zero,$t0,doneSubCopyzz

 
 lw $t4,-8($t3) 
 sll $t4,$t4,2 
 subu $t3,$t3,$t4 
 addu $t3,$t3,$t2 
 subu $t1,$t3,$t0 
 lw $t2,-8($s7) 
 sll $t2,$t2,2 
 subu $t2,$s7,$t2 
 
 
 
 
 
 
 
 

 
 subCopyLoopzz:
 lb $t4,-8($t3)
 sb $t4,-8($t2)
 addu $t2,$t2,1
 addu $t3,$t3,1
 blt $t3,$t1,subCopyLoopzz
 
 doneSubCopyzz:
 
 lw $ra,4($sp) 
 addu $sp,$sp,24 
 
 
 jr $ra

########################################################







########################################################
length:

 
 lw $t0,($sp)
 
 
 subu $sp,$sp,4

 
 sw $s5,4($sp)
 lw $zero,4($sp)

 
 lw $t0,-4($t0) 
 subu $t0,$zero,$t0
 sw $t0,($sp) 

 
 jr $ra


########################################################







########################################################
concat:
 
 subu $sp,$sp,4
 sw $ra($sp)

 
 lw $t0,4($sp)
 beq $t0,$zero,nullPtrException
 lw $t1,8($sp)
 
 
 
 lw $t0,-4($t0) 
 lw $t1,-4($t1) 
 addu $s6,$t0,$t1 
 sra $s6,$s6,2 
 subu $s6,$zero,$s6 
 addu $s6,$s6,1 
 move $s7,$zero
 jal newObject

 
 la $t0,CLASS_String
 sw $t0,-12($s7)
 
 
 
 lw $ra,4($sp) 
 lw $t0,8($sp) 
 lw $t1,12($sp) 
 addu $sp,$sp,12 
 sw $s7,($sp) 
 
 
 lw $t2,-4($t0) 
 lw $t3,-4($t1) 
 addu $t4,$t2,$t3 
 sw $t4,-4($s7) 

 
 
 
 
 
 
 
 

 
 lw $t4,-8($t1) 
 sll $t4,$t4,2 
 subu $t1,$t1,$t4 
 lw $t4,-8($s7) 
 sll $t4,$t4,2 
 subu $s7,$s7,$t4 
 beq $zero,$t3,doneConcatLoop1zz 
 subu $t3,$t1,$t3 

 
 
 
 
 
 
 
 
 
 

 
 concatLoop1zz:
 lb $t4,-8($t1)
 sb $t4,-8($s7)
 addu $s7,$s7,1
 addu $t1,$t1,1
 blt $t1,$t3,concatLoop1zz
 doneConcatLoop1zz:
 
 
 beq $zero,$t2,doneConcatLoop2zz

 
 lw $t4,-8($t0) 
 sll $t4,$t4,2 
 subu $t1,$t0,$t4 
 subu $t3,$t1,$t2 

 
 
 
 
 
 
 
 

 
 concatLoop2zz:
 lb $t4,-8($t1)
 sb $t4,-8($s7)
 addu $s7,$s7,1
 addu $t1,$t1,1
 blt $t1,$t3,concatLoop2zz
 doneConcatLoop2zz:
 
 concatRtnzz:
 
 jr $ra

########################################################









########################################################
charAt:
 
 lw $t0,8($sp)

 
 lw $t1,-4($t0) 
 subu $t3,$zero,$t1 
 lw $t2,($sp) 
 bgeu $t2,$t3,strIndexOutOfBounds

 
 lw $t1,-8($t0) 
 sll $t1,$t1,2 
 subu $t1,$t2,$t1 
 addu $t0,$t0,$t1 
 lb $t0,-8($t0) 

 
 addu $sp,$sp,4
 sw $t0,($sp)
 sw $s5,4($sp)
 lw $zero,4($sp)

 
 jr $ra

########################################################









########################################################
intToString:

 
 subu $sp,$sp,8
 sw $ra,4($sp)

 
 move $t0,$sp

 
 li $t3,10

 
 lw $t1,8($sp)
 bge $t1,$zero,itsNonNegLoop
 subu $t1,$zero,$t1

 
 
 itsNonNegLoop:
 divu $t1,$t3
 mflo $t1 
 mfhi $t4 
 addu $t4,$t4,'0' 
 subu $sp,$sp,4
 sw $t4,($sp) 
 bne $t1,$zero,itsNonNegLoop

 
 lw $t4,8($t0)
 bge $t4,$zero,itsSkipNeg
 li $t4,'-'
 subu $sp,$sp,4
 sw $t4,($sp)
 itsSkipNeg:

 
 
 
 
 
 

 
 
 subu $s6,$t0,$sp
 addu $t3,$s6,5 
 sw $t3,($t0)
 srl $s6,$s6,2
 subu $sp,$sp,4
 sw $s6,($sp)
 
 
 addu $s6,$s6,7 
 srl $s6,$s6,2
 move $s7,$zero 
 jal newObject

 
 lw $t0,4($sp)
 addu $sp,$sp,8

 
 subu $s7,$s7,8 
 la $t1,CLASS_String
 sw $t1,-4($s7)
 
 
 subu $t0,$zero,$t0
 sw $t0,4($s7)

 lw $t1,($s7) 
 sll $t1,$t1,2 
 subu $t1,$s7,$t1 
 subu $t0,$t1,$t0 

 
 
 
 
 
 

 
 
 itsLoop:
 lw $t2,($sp)
 addu $sp,$sp,4
 sb $t2,($t1)
 addu $t1,$t1,1
 bne $t1,$t0,itsLoop

 
 
 
 
 
 

 
 lw $ra,4($sp)
 addu $sp,$sp,16
 addu $t0,$t0,15
 and $t0,$t0,0xfffffffc
 sw $t0,($sp)
 jr $ra

########################################################









########################################################
intToChar:
 
 subu $sp,$sp,4
 sw $ra,($sp)

 
 li $s6,2
 move $s7,$zero
 jal newObject

 
 
 lw $ra,4($sp)
 lw $t1,8($sp)
 addu $sp,$sp,16

 
 la $t0,CLASS_String
 sw $t0,-12($s7)

 
 sb $t1,-16($s7)
 
 
 li $t0,-1
 sw $t0,-4($s7)

 
 sw $s7,($sp)

 
 jr $ra

########################################################









########################################################
compareTo:
 
 lw $t0,($sp) 
 beq $t0,$zero,nullPtrException
 lw $t1,4($sp) 
 
 
 lw $t2,-4($t0) 
 lw $t3,-4($t1) 

 
 
 
 slt $t4,$t3,$t2
 slt $t5,$t2,$t3
 subu $t5,$t5,$t4
 
 
 
 
 
 

 
 lw $t2,-8($t0) 
 lw $t3,-8($t1) 
 sll $t2,$t2,2 
 sll $t3,$t3,2 
 subu $t0,$t0,$t2 
 subu $t1,$t1,$t3 
 
 
 beq $zero,$t5,skipStrCmpLenzz
 move $t2,$t3
 skipStrCmpLenzz:
 add $t2,$t1,$t2
 
 
 
 
 
 
 

 
 
 
 
 
 
 

 
 
 cmpLoopzz:
 lw $t3,-8($t1) 
 lw $t4,-8($t0) 
 bne $t3,$t4,cmpNotEqualzz
 addu $t1,$t1,4
 addu $t0,$t0,4
 bne $t1,$t2,cmpLoopzz

 
 j cmpHitLimitzz

 cmpNotEqualzz:
 
 
 slt $t5,$t4,$t3 
 sll $t5,$t5,1 
 subu $t5,$t5,1 
 cmpHitLimitzz:
 sw $t5,($sp) 
 sw $s5,4($sp) 
 lw $zero,4($sp)
 jr $ra 

########################################################








########################################################
readLogicalChar:

 
 lw $v0,lastCharRead
 li $t0,-2
 beq $t0,$v0 doReadCh

 
 
 sw $t0,lastCharRead 
 jr $ra 
 
 doReadCh:
 
 li $v0,12 
 syscall
 jr $ra 

########################################################




















########################################################
newObject:
 
 
 
 
 
 
 
 
 
 blt $s7,$zero arraySizeOutOfBounds

 
 move $t5,$zero

 
 
 
 
 

 gcJoin:
 
 
 move $t3,$s6
 bge $t3,$zero,newSkip
 move $t3,$zero

 newSkip:

 
 
 
 
 
 

 
 addu $t0,$t3,$s7
 sll $t0,$t0,2
 addu $t0,$t0,8 
 addu $t1,$t0,$s3
 bgtu $t1,$s4,doGC

 
 
 

 
 move $t2,$s3
 zeroObjLoop:
 sw $zero,($s3)
 lw $zero,($s3)

 addu $s3,4
 bltu $s3,$t1,zeroObjLoop

 
 
 

 
 sll $t0,$s7,2 
 subu $t0,$s3,$t0 

 
 sw $s6,-8($t0) 
 lw $zero,-8($t0)
 sw $s7,-4($t0) 
 lw $zero,-4($t0)
 
 
 move $s7,$t0
 subu $sp,$sp,4
 sw $t0,($sp)

 jr $ra
 
 doGC:
 
 
 
 
 
 
 
 
 
 
 
 bne $t5,$zero,outOfHeapMemory
 
 
 
 subu $sp,$sp,4
 sw $s2,($sp)

 
 
 
 lw $t0,cur_seg
 move $t7,$s4
 la $t6,seg1_start
 la $s3,seg0_start
 la $s4,seg0_end
 sw $zero,cur_seg
 bne $t0,$zero,skipGc1
 la $t6,seg0_start
 la $s3,seg1_start
 la $s4,seg1_end
 sw $s5,cur_seg
 skipGc1:
 li $t5,-2
 lw $t0,stack_bottom
 subu $t0,4

 
 
 
 
 
 
 

 
 
 
 
 
 
 
 
 
 
 
 


 

 gcStackCopyLoop:
 lw $t1,($t0) 

 
 sll $t2,$t1,31 
 bne $t2,$zero,gcBump 

 
 subu $t0,$t0,4

 
 
 
 bleu $t1,$t6,gcTestIterDone1
 bgtu $t1,$t7,gcTestIterDone1

 
 
 lw $t2,-8($t1) 
 bne $t2,$t5,gcNoForward1 
 lw $t2,-4($t1) 
 sw $t2,4($t0) 
 j gcTestIterDone1 

 gcNoForward1:
 
 
 

 
 bge $t2,$zero,gcSkip2
 move $t2,$zero 

 gcSkip2:
 sll $t2,$t2,2
 addu $t2,$t2,8
 subu $t4,$t1,$t2 
 lw $t3,-4($t1) 
 bge $t3,$zero,gcH2Neg1
 move $t3,$zero
 gcH2Neg1:
 sll $t3,$t3,2
 addu $t3,$t3,$t1 

 addu $t2,$s3,$t2 

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

 
 
 lw $s0,($t4)
 lw $s1,-8($t1)
 sw $s1,($t4)
 sw $s0,-8($t1)
 
 
 gCinnerCopy1:
 lw $s0,($t4)
 sw $s0,($s3)
 addu $t4,$t4,4
 addu $s3,$s3,4
 bltu $t4,$t3,gCinnerCopy1

 
 
 
 
 
 

 
 sw $t5,-8($t1) 
 sw $t2,-4($t1) 

 
 sw $t2,4($t0)
 lw $zero,-8($t2)
 lw $zero,-4($t2)

 
 j gcTestIterDone1

 gcBump:
 
 subu $t0,$t0,$t1
 subu $t0,$t0,3

 gcTestIterDone1:
 bgeu $t0,$sp,gcStackCopyLoop

 

 
 
 
 
 

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

 
 lw $t1,cur_seg
 la $t0,seg0_start
 beq $t1,$zero,gcSkip4
 la $t0,seg1_start

 
 
 
 
 
 
 

 gcSkip4:

 
 
 bgeu $t0,$s3,gcFinishUp

 

 gcHeapCopyLoop:
 
 lw $t1,($t0) 
 bge $t1,$zero,gcNotDataArray 

 
 
 lw $t1,4($t0) 
 addu $t1,$t1,2 
 sll $t1,$t1,2 
 addu $t0,$t0,$t1 
 j gcTestIterDone2 

 gcNotDataArray:
 
 
 sll $t2,$t1,2 
 addu $t2,$t2,8 
 addu $t2,$t0,$t2 
 lw $t3,-8($t2) 
 sw $t1,-8($t2) 
 sw $t3,($t0) 

 lw $t3,-4($t2) 
 bge $t3,$zero,gcH2Neg2
 move $t3,$zero
 gcH2Neg2:
 sll $t3,$t3,2 
 move $t0,$t2 
 add $s1,$t2,$t3 

 
 
 
 

 
 
 beq $t0,$s1,gcTestIterDone2
 
 gcNextPointerInObject:
 
 lw $t1,($t0)

 
 
 bleu $t1,$t6,gcGoNextPointerSlot
 bgtu $t1,$t7,gcGoNextPointerSlot

 
 
 lw $t8,-8($t1) 
 bne $t8,$t5,gcNoForward2 
 lw $t8,-4($t1) 
 sw $t8,($t0) 
 j gcGoNextPointerSlot 

 gcNoForward2:
 
 
 

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

 
 bge $t8,$zero,gcSkip5
 move $t8,$zero 

 gcSkip5:
 sll $t8,$t8,2
 addu $t8,$t8,8
 subu $t4,$t1,$t8 
 lw $t3,-4($t1)
 bge $t3,$zero,gcNoNeg
 move $t3,$zero
 gcNoNeg:
 sll $t3,$t3,2
 addu $t3,$t3,$t1 

 addu $t8,$s3,$t8 

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

 
 
 lw $s0,($t4)
 lw $t9,-8($t1)
 sw $t9,($t4)
 sw $s0,-8($t1)

 
 gCinnerCopy2:
 lw $s0,($t4)
 sw $s0,($s3)
 addu $t4,$t4,4
 addu $s3,$s3,4
 bltu $t4,$t3,gCinnerCopy2

 
 
 
 
 
 

 
 sw $t5,-8($t1) 
 sw $t8,-4($t1) 

 
 sw $t8,($t0)

 gcGoNextPointerSlot:
 
 addu $t0,$t0,4
 bltu $t0,$s1,gcNextPointerInObject

 gcTestIterDone2:
 bltu $t0,$s3,gcHeapCopyLoop

 

 gcFinishUp:
 
 lw $s2,($sp)
 addu $sp,$sp,4

 
 move $t5,$s5

 
 j gcJoin
 

########################################################








########################################################
vm_init:

 
 sw $sp,stack_bottom
 move $sp,$sp
 
 
 move $s2,$zero
 move $s2,$s2

 
 li $s5,5
 move $s5,$s5

 la $s3,seg0_start
 move $s3,$s3
 la $s4,seg0_end
 move $s4,$s4
 
 
 jr $ra

########################################################












########################################################
divide:
 
 lw $t0,($sp)
 lw $t1,8($sp)
 beq $t0,$zero,divByZeroError
 
 
 div $t1,$t0
 mflo $t0

 
 addu $sp,$sp,8 
 sw $t0,($sp) 
 jr $ra

########################################################












########################################################
remainder:
 
 lw $t0,($sp)
 lw $t1,8($sp)
 beq $t0,$zero,divByZeroError
 
 
 div $t1,$t0
 mfhi $t0

 
 addu $sp,$sp,8 
 sw $t0,($sp) 
 jr $ra
 
########################################################











########################################################
checkCast:
 
 lw $t2,($sp)
 beq $t2,$zero,checkCastReturn
 
 
 
 lw $t3,-8($t2) 
 lw $t2,-12($t2) 
 bgt $t3,$zero,skipArrayCast
 la $t2,CLASS_Object
 
 
 
 
 skipArrayCast:
 bge $t2,$t1,castException
 blt $t2,$t0,castException
 
 
 checkCastReturn: 
 jr $ra 
 
########################################################












########################################################
instanceOf:
 
 lw $t2,($sp)
 beq $t2,$zero,doneInstanceOf
 
 
 
 lw $t3,-8($t2) 
 lw $t2,-12($t2) 
 bgt $t3,$zero,skipArrayInstanceOf
 la $t2,CLASS_Object
 
 
 
 
 skipArrayInstanceOf:
 sge $t0,$t2,$t0
 slt $t1,$t2,$t1
 
 
 and $t2,$t0,$t1
 doneInstanceOf: 
 sw $t2,($sp)
 jr $ra

###########################################################



###########################################################

exitError:
 

 
 li $v0,4 
 syscall
exit:
 
 li $v0,4
 la $a0,exitString
 syscall

 
 li $v0,10 
 syscall

outOfHeapMemory:
 la $a0,heapMemoryMsg
 j exitError
divByZeroError:
 la $a0,divByZeroMsg
 j exitError
strIndexOutOfBounds:
 la $a0,strIndexOutOfBoundsMsg
 j exitError
arrayIndexOutOfBounds:
 la $a0,arrayIndexOutOfBoundsMsg
 j exitError
arraySizeOutOfBounds:
 la $a0,arraySizeOutOfBoundsMsg
 j exitError
nullPtrException:
 la $a0,nullPtrExceptionMsg
 j exitError
badIntegerFormat:
 la $a0,badIntegerFormatMsg
 j exitError
castException:
 la $a0,castExceptionMsg
 j exitError


 .data
 .align 2

cur_seg:
 .word 0

lastCharRead:
 .word -2 

heapMemoryMsg:
 .asciiz "ERROR: out of heap memory\n"
divByZeroMsg:
 .asciiz "ERROR: divide by zero\n"
strIndexOutOfBoundsMsg:
 .asciiz "ERROR: string index out of bounds\n"
arrayIndexOutOfBoundsMsg:
 .asciiz "ERROR: array index out of bounds\n"
arraySizeOutOfBoundsMsg:
 .asciiz "ERROR: array size out of bounds\n"
nullPtrExceptionMsg:
 .asciiz "ERROR: null-pointer exception\n"
badIntegerFormatMsg:
 .asciiz "ERROR: attempt to read badly formatted integer\n"
castExceptionMsg:
 .asciiz "ERROR: illegal cast\n"
gcMsg: 
 .asciiz "\nGC!\n"

nullStr:
 .asciiz "null"
trueString:
 .asciiz "true"
falseString:
 .asciiz "false"
exitString:
 .asciiz "Program terminated.\n"
 
 .align 2
stack_bottom:
 .word 0




seg0_start:
 .space 0x100000
seg0_end:
seg1_start:
 .space 0x100000
seg1_end:




