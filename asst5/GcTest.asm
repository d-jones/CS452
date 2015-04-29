.data # Program at 19.1   
CLASS_Object: # ClassDecl at 0.0  	
.word 0 # ClassDecl at 0.0  	
CLASS_Lib: # ClassDecl at 0.0	 
.word CLASS_Object # ClassDecl at 0.0  	
.word readLine # ClassDecl at 0.0	
.word readInt # ClassDecl at 0.0  
.word readChar # ClassDecl at 0.0   
.word printStr # ClassDecl at 0.0	  
.word printBool # ClassDecl at 0.0 	
.word printInt # ClassDecl at 0.0 	 
.word intToString # ClassDecl at 0.0	  
.word intToChar # ClassDecl at 0.0			
CLASS_END_Lib: # ClassDecl at 0.0			
CLASS_String: # ClassDecl at 0.0 	 
.word CLASS_Object # ClassDecl at 0.0  	
.word concat # ClassDecl at 0.0		
.word substring # ClassDecl at 0.0	 	
.word length # ClassDecl at 0.0  
.word charAt # ClassDecl at 0.0		 
.word compareTo # ClassDecl at 0.0	 	
CLASS_END_String: # ClassDecl at 0.0		
CLASS_RunMain: # ClassDecl at 0.0		
.word CLASS_Object # ClassDecl at 0.0  
CLASS_END_RunMain: # ClassDecl at 0.0		 
CLASS_Main: # ClassDecl at 19.7  	
.word CLASS_Object # ClassDecl at 19.7 		
.word fcn_41_main # ClassDecl at 19.7 	 
.word fcn_76_add100Elements # ClassDecl at 19.7	
.word fcn_123_removeAlternateElements # ClassDecl at 19.7  	
CLASS_END_Main: # ClassDecl at 19.7 		
CLASS_IntList: # ClassDecl at 82.7 	 
.word CLASS_Object # ClassDecl at 82.7	 
.word fcn_141_init # ClassDecl at 82.7   
.word fcn_211_print # ClassDecl at 82.7 	
CLASS_END_IntList: # ClassDecl at 82.7			
CLASS_END_Object: # ClassDecl at 0.0		 
 .data # Program at 19.1	
  .word CLASS_String # StringLiteral at 102.21	
  .word 1 # StringLiteral at 102.21	
  .word 0 # StringLiteral at 102.21			
strLit_150: # StringLiteral at 102.21		 
  .byte 32 # StringLiteral at 114.18 	 
  .byte 0 # StringLiteral at 114.18		
  .byte 0 # StringLiteral at 114.18		
  .byte 0 # StringLiteral at 114.18 	 
  .word CLASS_String # StringLiteral at 114.18	 	
  .word 2 # StringLiteral at 114.18			
  .word -1 # StringLiteral at 114.18	 
strLit_178: # StringLiteral at 114.18	 	
  .byte 10 # StringLiteral at 120.16 	
  .byte 0 # StringLiteral at 120.16	 
  .byte 0 # StringLiteral at 120.16	 	
  .byte 0 # StringLiteral at 120.16 	
  .word CLASS_String # StringLiteral at 120.16		
  .word 2 # StringLiteral at 120.16		
  .word -1 # StringLiteral at 120.16 	 
strLit_185: # StringLiteral at 120.16	 	
  .word CLASS_String # StringLiteral at 121.15	 	
  .word 1 # StringLiteral at 121.15		 
  .word 0 # StringLiteral at 121.15 	 
strLit_189: # StringLiteral at 121.15	 
  .byte 10 # StringLiteral at 129.19 		
  .byte 0 # StringLiteral at 129.19 	 
  .byte 0 # StringLiteral at 129.19	  
  .byte 0 # StringLiteral at 129.19	 
  .word CLASS_String # StringLiteral at 129.19			
  .word 2 # StringLiteral at 129.19 		
  .word -1 # StringLiteral at 129.19	 	
strLit_205: # StringLiteral at 129.19			
  # ENTER NODE # Program at 19.1	  
  .text # Program at 19.1		 
  .globl main # Program at 19.1	 
  main: # Program at 19.1  
  jal vm_init # Program at 19.1 	 
    # ENTER NODE # ExpStatement at 0.0 	 
      # ENTER NODE # Call at 0.0 
        # ENTER NODE # NewObject at 0.0			
        li $s6, 2 # NewObject at 0.0	
        li $s7, 0 # NewObject at 0.0			
        jal newObject # NewObject at 0.0  	
        la $t0, CLASS_Main # NewObject at 0.0	 
        sw $t0, -12($s7) # NewObject at 0.0		 
        # EXIT NODE # NewObject at 0.0	 
      lw $t0, 0($sp) # Call at 0.0	
      beq $t0, $zero, nullPtrException # Call at 0.0			
      lw $t0, -12($t0) # Call at 0.0	
      lw $t0, 4($t0) # Call at 0.0 	 
      jalr $t0 # Call at 0.0  	
      # EXIT NODE # Call at 0.0			
    # EXIT NODE # ExpStatement at 0.0  	
  li $v0, 10 # Program at 19.1	
  syscall # Program at 19.1		
    # ENTER NODE # MethodDeclVoid at 24.17   
    .globl fcn_41_main # MethodDeclVoid at 24.17	
    fcn_41_main: # MethodDeclVoid at 24.17  	
    subu $sp, $sp, 8 # MethodDeclVoid at 24.17			
    sw $ra, 4($sp) # MethodDeclVoid at 24.17 
    sw $s2, ($sp) # MethodDeclVoid at 24.17		 
    lw $s2, 8($sp) # MethodDeclVoid at 24.17 	
      # ENTER NODE # LocalVarDecl at 26.10	 	
        # ENTER NODE # Null at 26.19		
        subu $sp, $sp, 4 # Null at 26.19			
        sw $zero, ($sp) # Null at 26.19	 
        # EXIT NODE # Null at 26.19  	
      # EXIT NODE # LocalVarDecl at 26.10  	
      # ENTER NODE # LocalVarDecl at 30.10   
        # ENTER NODE # False at 30.24 
        subu $sp, $sp, 4 # False at 30.24	  
        sw $zero, ($sp) # False at 30.24	 	
        # EXIT NODE # False at 30.24 
      # EXIT NODE # LocalVarDecl at 30.10	
      # ENTER NODE # Block at 34.2		
        # ENTER NODE # LocalVarDecl at 34.11 	 
          # ENTER NODE # IntegerLiteral at 34.15	  
          subu $sp, $sp, 8 # IntegerLiteral at 34.15  	
          sw $s5, 4($sp) # IntegerLiteral at 34.15 		
          li $t0, 0 # IntegerLiteral at 34.15  
          sw $t0, ($sp) # IntegerLiteral at 34.15	 	
          # EXIT NODE # IntegerLiteral at 34.15 		
        # EXIT NODE # LocalVarDecl at 34.11 
        # ENTER NODE # While at 34.2	  
        j while_enter_36 # While at 34.2	 	
        while_top_36: # While at 34.2  	
          # ENTER NODE # Block at 34.2 	
            # ENTER NODE # Block at 34.33	 	
              # ENTER NODE # Assign at 35.13 	 
                # ENTER NODE # Call at 35.15 
                  # ENTER NODE # This at 35.15		 
                  subu $sp, $sp, 4 # This at 35.15 	 
                  sw $s2, ($sp) # This at 35.15   
                  # EXIT NODE # This at 35.15   
                  # ENTER NODE # IdentifierExp at 35.30	  
                  lw $t0, 16($sp) # IdentifierExp at 35.30		 
                  subu $sp, $sp, 4 # IdentifierExp at 35.30		 
                  sw $t0, ($sp) # IdentifierExp at 35.30	  
                  # EXIT NODE # IdentifierExp at 35.30 	 
                lw $t0, 4($sp) # Call at 35.15  
                beq $t0, $zero, nullPtrException # Call at 35.15  	
                lw $t0, -12($t0) # Call at 35.15 	
                lw $t0, 8($t0) # Call at 35.15	 	
                jalr $t0 # Call at 35.15  
                # EXIT NODE # Call at 35.15 	
              lw $t0, ($sp) # Assign at 35.13  
              sw $t0, 16($sp) # Assign at 35.13  	
              addu $sp, $sp, 4 # Assign at 35.13	  
              # EXIT NODE # Assign at 35.13   
              # ENTER NODE # Assign at 36.13	 	
                # ENTER NODE # Call at 36.15			
                  # ENTER NODE # This at 36.15   
                  subu $sp, $sp, 4 # This at 36.15 
                  sw $s2, ($sp) # This at 36.15		
                  # EXIT NODE # This at 36.15	 
                  # ENTER NODE # IdentifierExp at 36.39	  
                  lw $t0, 16($sp) # IdentifierExp at 36.39		 
                  subu $sp, $sp, 4 # IdentifierExp at 36.39		
                  sw $t0, ($sp) # IdentifierExp at 36.39	 	
                  # EXIT NODE # IdentifierExp at 36.39		 
                  # ENTER NODE # IdentifierExp at 36.47		 
                  lw $t0, 16($sp) # IdentifierExp at 36.47   
                  subu $sp, $sp, 4 # IdentifierExp at 36.47	 
                  sw $t0, ($sp) # IdentifierExp at 36.47 	 
                  # EXIT NODE # IdentifierExp at 36.47		
                lw $t0, 8($sp) # Call at 36.15	 
                beq $t0, $zero, nullPtrException # Call at 36.15 		
                lw $t0, -12($t0) # Call at 36.15	 	
                lw $t0, 12($t0) # Call at 36.15	 	
                jalr $t0 # Call at 36.15 
                # EXIT NODE # Call at 36.15	
              lw $t0, ($sp) # Assign at 36.13   
              sw $t0, 16($sp) # Assign at 36.13			
              addu $sp, $sp, 4 # Assign at 36.13	
              # EXIT NODE # Assign at 36.13 		
              # ENTER NODE # Assign at 37.18			
                # ENTER NODE # Not at 37.20   
                  # ENTER NODE # IdentifierExp at 37.21	 
                  lw $t0, 8($sp) # IdentifierExp at 37.21   
                  subu $sp, $sp, 4 # IdentifierExp at 37.21		 
                  sw $t0, ($sp) # IdentifierExp at 37.21 		
                  # EXIT NODE # IdentifierExp at 37.21			
                lw $t0, ($sp) # Not at 37.20	
                xor $t0, $t0, 1 # Not at 37.20	  
                sw $t0, ($sp) # Not at 37.20 
                # EXIT NODE # Not at 37.20  	
              lw $t0, ($sp) # Assign at 37.18	 	
              sw $t0, 12($sp) # Assign at 37.18 
              addu $sp, $sp, 4 # Assign at 37.18		
              # EXIT NODE # Assign at 37.18  	
            # EXIT NODE # Block at 34.33			
            # ENTER NODE # Assign at 34.28	 
              # ENTER NODE # Plus at 34.29  	
                # ENTER NODE # IdentifierExp at 34.28	
                lw $t0, 0($sp) # IdentifierExp at 34.28	 	
                subu $sp, $sp, 8 # IdentifierExp at 34.28		 
                sw $s5, 4($sp) # IdentifierExp at 34.28	 
                sw $t0, ($sp) # IdentifierExp at 34.28 		
                # EXIT NODE # IdentifierExp at 34.28	 	
                # ENTER NODE # IntegerLiteral at 34.29			
                subu $sp, $sp, 8 # IntegerLiteral at 34.29  	
                sw $s5, 4($sp) # IntegerLiteral at 34.29		
                li $t0, 1 # IntegerLiteral at 34.29		
                sw $t0, ($sp) # IntegerLiteral at 34.29  
                # EXIT NODE # IntegerLiteral at 34.29 		
              lw $t0, ($sp) # Plus at 34.29 		
              lw $t1, 8($sp) # Plus at 34.29 		
              addu $t0, $t0, $t1 # Plus at 34.29 	
              addu $sp, $sp, 8 # Plus at 34.29	 	
              sw $t0, ($sp) # Plus at 34.29		 
              # EXIT NODE # Plus at 34.29  	
            lw $t0, ($sp) # Assign at 34.28  
            sw $t0, 8($sp) # Assign at 34.28	  
            addu $sp, $sp, 8 # Assign at 34.28  	
            # EXIT NODE # Assign at 34.28	  
          # EXIT NODE # Block at 34.2	 
        while_enter_36: # While at 34.2   
          # ENTER NODE # LessThan at 34.20 		
            # ENTER NODE # IdentifierExp at 34.18 
            lw $t0, 0($sp) # IdentifierExp at 34.18 		
            subu $sp, $sp, 8 # IdentifierExp at 34.18  	
            sw $s5, 4($sp) # IdentifierExp at 34.18 		
            sw $t0, ($sp) # IdentifierExp at 34.18  
            # EXIT NODE # IdentifierExp at 34.18 	 
            # ENTER NODE # IntegerLiteral at 34.22	 	
            subu $sp, $sp, 8 # IntegerLiteral at 34.22	 
            sw $s5, 4($sp) # IntegerLiteral at 34.22	 
            li $t0, 1000 # IntegerLiteral at 34.22	
            sw $t0, ($sp) # IntegerLiteral at 34.22 
            # EXIT NODE # IntegerLiteral at 34.22		 
          lw $t0, ($sp) # LessThan at 34.20	 	
          lw $t1, 8($sp) # LessThan at 34.20 	 
          slt $t0, $t1, $t0 # LessThan at 34.20	
          addu $sp, $sp, 12 # LessThan at 34.20		 
          sw $t0, ($sp) # LessThan at 34.20 	 
          # EXIT NODE # LessThan at 34.20  	
        lw $t0, ($sp) # While at 34.2			
        addu $sp, $sp, 4 # While at 34.2	  
        bne $t0, $zero, while_top_36 # While at 34.2 	
        while_exit_36: # While at 34.2	 	
        # EXIT NODE # While at 34.2 	
      addu $sp, 8 # Block at 34.2 
      # EXIT NODE # Block at 34.2 	 
      # ENTER NODE # ExpStatement at 41.9 		
        # ENTER NODE # Call at 41.9 		
          # ENTER NODE # IdentifierExp at 41.2   
          lw $t0, 4($sp) # IdentifierExp at 41.2	  
          subu $sp, $sp, 4 # IdentifierExp at 41.2 
          sw $t0, ($sp) # IdentifierExp at 41.2	 	
          # EXIT NODE # IdentifierExp at 41.2   
        lw $t0, 0($sp) # Call at 41.9		 
        beq $t0, $zero, nullPtrException # Call at 41.9 	 
        lw $t0, -12($t0) # Call at 41.9  
        lw $t0, 8($t0) # Call at 41.9	 
        jalr $t0 # Call at 41.9  
        # EXIT NODE # Call at 41.9 	
      # EXIT NODE # ExpStatement at 41.9 	 
    lw $ra, 12($sp) # MethodDeclVoid at 24.17  
    lw $s2, 8($sp) # MethodDeclVoid at 24.17  	
    addu $sp, $sp, 20 # MethodDeclVoid at 24.17	 
    jr $ra # MethodDeclVoid at 24.17	
    # EXIT NODE # MethodDeclVoid at 24.17  	
    # ENTER NODE # MethodDeclNonVoid at 47.20		
    .globl fcn_76_add100Elements # MethodDeclNonVoid at 47.20			
    fcn_76_add100Elements: # MethodDeclNonVoid at 47.20	  
    subu $sp, $sp, 8 # MethodDeclNonVoid at 47.20		
    sw $ra, 4($sp) # MethodDeclNonVoid at 47.20  
    sw $s2, ($sp) # MethodDeclNonVoid at 47.20 	 
    lw $s2, 12($sp) # MethodDeclNonVoid at 47.20   
      # ENTER NODE # LocalVarDecl at 49.10 		
        # ENTER NODE # IdentifierExp at 49.19 	
        lw $t0, 8($sp) # IdentifierExp at 49.19	
        subu $sp, $sp, 4 # IdentifierExp at 49.19		 
        sw $t0, ($sp) # IdentifierExp at 49.19 
        # EXIT NODE # IdentifierExp at 49.19 	 
      # EXIT NODE # LocalVarDecl at 49.10	  
      # ENTER NODE # Block at 52.2 
        # ENTER NODE # LocalVarDecl at 52.11  	
          # ENTER NODE # IntegerLiteral at 52.15 	 
          subu $sp, $sp, 8 # IntegerLiteral at 52.15  	
          sw $s5, 4($sp) # IntegerLiteral at 52.15 	 
          li $t0, 0 # IntegerLiteral at 52.15		
          sw $t0, ($sp) # IntegerLiteral at 52.15		
          # EXIT NODE # IntegerLiteral at 52.15	 
        # EXIT NODE # LocalVarDecl at 52.11  
        # ENTER NODE # While at 52.2 		
        j while_enter_73 # While at 52.2 
        while_top_73: # While at 52.2 	 
          # ENTER NODE # Block at 52.2	  
            # ENTER NODE # Block at 52.32   
              # ENTER NODE # Assign at 53.13	
                # ENTER NODE # Call at 53.29			
                  # ENTER NODE # NewObject at 53.15  	
                  li $s6, 2 # NewObject at 53.15	  
                  li $s7, 1 # NewObject at 53.15	
                  jal newObject # NewObject at 53.15 	 
                  la $t0, CLASS_IntList # NewObject at 53.15	 	
                  sw $t0, -12($s7) # NewObject at 53.15	 
                  # EXIT NODE # NewObject at 53.15 		
                  # ENTER NODE # IdentifierExp at 53.34	
                  lw $t0, -16($s2) # IdentifierExp at 53.34		 
                  subu $sp, $sp, 8 # IdentifierExp at 53.34 		
                  sw $s5, 4($sp) # IdentifierExp at 53.34   
                  sw $t0, ($sp) # IdentifierExp at 53.34			
                  # EXIT NODE # IdentifierExp at 53.34		
                  # ENTER NODE # IdentifierExp at 53.41	
                  lw $t0, 20($sp) # IdentifierExp at 53.41 		
                  subu $sp, $sp, 4 # IdentifierExp at 53.41		
                  sw $t0, ($sp) # IdentifierExp at 53.41	 
                  # EXIT NODE # IdentifierExp at 53.41	  
                lw $t0, 12($sp) # Call at 53.29 	 
                beq $t0, $zero, nullPtrException # Call at 53.29	 
                lw $t0, -12($t0) # Call at 53.29 	 
                lw $t0, 4($t0) # Call at 53.29	 
                jalr $t0 # Call at 53.29 	
                # EXIT NODE # Call at 53.29		 
              lw $t0, ($sp) # Assign at 53.13	
              sw $t0, 12($sp) # Assign at 53.13 	
              addu $sp, $sp, 4 # Assign at 53.13	 
              # EXIT NODE # Assign at 53.13	
              # ENTER NODE # Assign at 54.6 		
                # ENTER NODE # Plus at 54.11 		
                  # ENTER NODE # IdentifierExp at 54.6		
                  lw $t0, -16($s2) # IdentifierExp at 54.6			
                  subu $sp, $sp, 8 # IdentifierExp at 54.6 	 
                  sw $s5, 4($sp) # IdentifierExp at 54.6	 	
                  sw $t0, ($sp) # IdentifierExp at 54.6 	
                  # EXIT NODE # IdentifierExp at 54.6 
                  # ENTER NODE # IntegerLiteral at 54.11 
                  subu $sp, $sp, 8 # IntegerLiteral at 54.11	
                  sw $s5, 4($sp) # IntegerLiteral at 54.11   
                  li $t0, 1 # IntegerLiteral at 54.11		
                  sw $t0, ($sp) # IntegerLiteral at 54.11  	
                  # EXIT NODE # IntegerLiteral at 54.11			
                lw $t0, ($sp) # Plus at 54.11 	 
                lw $t1, 8($sp) # Plus at 54.11			
                addu $t0, $t0, $t1 # Plus at 54.11		 
                addu $sp, $sp, 8 # Plus at 54.11   
                sw $t0, ($sp) # Plus at 54.11		
                # EXIT NODE # Plus at 54.11 	
              lw $t0, ($sp) # Assign at 54.6 		
              sw $t0, -16($s2) # Assign at 54.6	
              addu $sp, $sp, 8 # Assign at 54.6 		
              # EXIT NODE # Assign at 54.6  
            # EXIT NODE # Block at 52.32	
            # ENTER NODE # Assign at 52.27   
              # ENTER NODE # Plus at 52.28			
                # ENTER NODE # IdentifierExp at 52.27	  
                lw $t0, 0($sp) # IdentifierExp at 52.27  
                subu $sp, $sp, 8 # IdentifierExp at 52.27	 	
                sw $s5, 4($sp) # IdentifierExp at 52.27  	
                sw $t0, ($sp) # IdentifierExp at 52.27			
                # EXIT NODE # IdentifierExp at 52.27	
                # ENTER NODE # IntegerLiteral at 52.28 
                subu $sp, $sp, 8 # IntegerLiteral at 52.28	
                sw $s5, 4($sp) # IntegerLiteral at 52.28			
                li $t0, 1 # IntegerLiteral at 52.28  
                sw $t0, ($sp) # IntegerLiteral at 52.28  
                # EXIT NODE # IntegerLiteral at 52.28	 
              lw $t0, ($sp) # Plus at 52.28	 
              lw $t1, 8($sp) # Plus at 52.28   
              addu $t0, $t0, $t1 # Plus at 52.28 	 
              addu $sp, $sp, 8 # Plus at 52.28	
              sw $t0, ($sp) # Plus at 52.28		
              # EXIT NODE # Plus at 52.28   
            lw $t0, ($sp) # Assign at 52.27 		
            sw $t0, 8($sp) # Assign at 52.27 	
            addu $sp, $sp, 8 # Assign at 52.27 	
            # EXIT NODE # Assign at 52.27  	
          # EXIT NODE # Block at 52.2		 
        while_enter_73: # While at 52.2		
          # ENTER NODE # LessThan at 52.20	 
            # ENTER NODE # IdentifierExp at 52.18 	 
            lw $t0, 0($sp) # IdentifierExp at 52.18 	 
            subu $sp, $sp, 8 # IdentifierExp at 52.18  
            sw $s5, 4($sp) # IdentifierExp at 52.18 		
            sw $t0, ($sp) # IdentifierExp at 52.18	
            # EXIT NODE # IdentifierExp at 52.18		
            # ENTER NODE # IntegerLiteral at 52.22 	 
            subu $sp, $sp, 8 # IntegerLiteral at 52.22	 
            sw $s5, 4($sp) # IntegerLiteral at 52.22	
            li $t0, 100 # IntegerLiteral at 52.22	 	
            sw $t0, ($sp) # IntegerLiteral at 52.22	
            # EXIT NODE # IntegerLiteral at 52.22	
          lw $t0, ($sp) # LessThan at 52.20	
          lw $t1, 8($sp) # LessThan at 52.20 
          slt $t0, $t1, $t0 # LessThan at 52.20			
          addu $sp, $sp, 12 # LessThan at 52.20	 
          sw $t0, ($sp) # LessThan at 52.20	
          # EXIT NODE # LessThan at 52.20	 
        lw $t0, ($sp) # While at 52.2		
        addu $sp, $sp, 4 # While at 52.2 		
        bne $t0, $zero, while_top_73 # While at 52.2 	
        while_exit_73: # While at 52.2	  
        # EXIT NODE # While at 52.2	  
      addu $sp, 8 # Block at 52.2 	 
      # EXIT NODE # Block at 52.2		 
      # ENTER NODE # IdentifierExp at 58.9 		
      lw $t0, 0($sp) # IdentifierExp at 58.9		
      subu $sp, $sp, 4 # IdentifierExp at 58.9			
      sw $t0, ($sp) # IdentifierExp at 58.9		 
      # EXIT NODE # IdentifierExp at 58.9 
    lw $ra, 12($sp) # MethodDeclNonVoid at 47.20	  
    lw $s2, 8($sp) # MethodDeclNonVoid at 47.20   
    lw $t0, ($sp) # MethodDeclNonVoid at 47.20			
    sw $t0, 20($sp) # MethodDeclNonVoid at 47.20 	
    addu $sp, $sp, 20 # MethodDeclNonVoid at 47.20 	
    jr $ra # MethodDeclNonVoid at 47.20 	 
      # ENTER NODE # MethodDeclNonVoid at 47.20	  
        # ENTER NODE # MethodDeclNonVoid at 64.20		
        .globl fcn_123_removeAlternateElements # MethodDeclNonVoid at 64.20 	 
        fcn_123_removeAlternateElements: # MethodDeclNonVoid at 64.20	 
        subu $sp, $sp, 8 # MethodDeclNonVoid at 64.20	
        sw $ra, 4($sp) # MethodDeclNonVoid at 64.20	 	
        sw $s2, ($sp) # MethodDeclNonVoid at 64.20	 	
        lw $s2, 16($sp) # MethodDeclNonVoid at 64.20	  
          # ENTER NODE # If at 66.2		
            # ENTER NODE # And at 66.18	
              # ENTER NODE # IdentifierExp at 66.6		
              lw $t0, 8($sp) # IdentifierExp at 66.6   
              subu $sp, $sp, 4 # IdentifierExp at 66.6			
              sw $t0, ($sp) # IdentifierExp at 66.6	 
              # EXIT NODE # IdentifierExp at 66.6 
            lw $t0, ($sp) # And at 66.18	  
            beq $t0, $zero, skip_87 # And at 66.18   
            addu $sp, $sp, 4 # And at 66.18	 	
              # ENTER NODE # Not at 66.26 		
                # ENTER NODE # Equals at 66.26			
                  # ENTER NODE # IdentifierExp at 66.21		
                  lw $t0, 12($sp) # IdentifierExp at 66.21	  
                  subu $sp, $sp, 4 # IdentifierExp at 66.21		 
                  sw $t0, ($sp) # IdentifierExp at 66.21 
                  # EXIT NODE # IdentifierExp at 66.21  
                  # ENTER NODE # Null at 66.29 
                  subu $sp, $sp, 4 # Null at 66.29   
                  sw $zero, ($sp) # Null at 66.29	 	
                  # EXIT NODE # Null at 66.29 	 
                lw $t0, ($sp) # Equals at 66.26	  
                lw $t1, 4($sp) # Equals at 66.26	 	
                seq $t0, $t0, $t1 # Equals at 66.26		
                addu $sp, $sp, 4 # Equals at 66.26 
                sw $t0, ($sp) # Equals at 66.26	
                # EXIT NODE # Equals at 66.26 	
              lw $t0, ($sp) # Not at 66.26	  
              xor $t0, $t0, 1 # Not at 66.26	  
              sw $t0, ($sp) # Not at 66.26	 
              # EXIT NODE # Not at 66.26 		
            skip_87: # And at 66.18	 
            # EXIT NODE # And at 66.18	
          lw $t0, ($sp) # If at 66.2   
          addu $sp, $sp, 4 # If at 66.2 		
          beq $t0, $zero, if_else_94 # If at 66.2 		
            # ENTER NODE # Block at 66.35	
              # ENTER NODE # Assign at 67.11 
                # ENTER NODE # InstVarAccess at 67.17 	
                  # ENTER NODE # IdentifierExp at 67.13  	
                  lw $t0, 12($sp) # IdentifierExp at 67.13	 	
                  subu $sp, $sp, 4 # IdentifierExp at 67.13 	
                  sw $t0, ($sp) # IdentifierExp at 67.13 		
                  # EXIT NODE # IdentifierExp at 67.13	  
                lw $t0, ($sp) # InstVarAccess at 67.17			
                beq $t0, $zero, nullPtrException # InstVarAccess at 67.17	 	
                lw $t0, 0($t0) # InstVarAccess at 67.17  
                sw $t0, ($sp) # InstVarAccess at 67.17  	
                # EXIT NODE # InstVarAccess at 67.17  	
              lw $t0, ($sp) # Assign at 67.11 	
              sw $t0, 16($sp) # Assign at 67.11	 
              addu $sp, $sp, 4 # Assign at 67.11 	 
              # EXIT NODE # Assign at 67.11 		
            # EXIT NODE # Block at 66.35	
          j if_done_94 # If at 66.2	 	
          if_else_94: # If at 66.2 	
            # ENTER NODE # Block at 71.2 
            # EXIT NODE # Block at 71.2 	 
          if_done_94: # If at 66.2 	
          # EXIT NODE # If at 66.2			
          # ENTER NODE # Block at 71.2 	 
            # ENTER NODE # LocalVarDecl at 71.15	  
              # ENTER NODE # IdentifierExp at 71.19			
              lw $t0, 12($sp) # IdentifierExp at 71.19	  
              subu $sp, $sp, 4 # IdentifierExp at 71.19  
              sw $t0, ($sp) # IdentifierExp at 71.19  	
              # EXIT NODE # IdentifierExp at 71.19  	
            # EXIT NODE # LocalVarDecl at 71.15	 	
            # ENTER NODE # While at 71.2 		
            j while_enter_120 # While at 71.2 		
            while_top_120: # While at 71.2	 	
              # ENTER NODE # Block at 71.2		
                # ENTER NODE # Block at 71.66  
                  # ENTER NODE # Assign at 72.13 	 
                    # ENTER NODE # IdentifierExp at 72.6 	 
                    lw $t0, 0($sp) # IdentifierExp at 72.6		 
                    subu $sp, $sp, 4 # IdentifierExp at 72.6		 
                    sw $t0, ($sp) # IdentifierExp at 72.6		 
                    # EXIT NODE # IdentifierExp at 72.6	 	
                    # ENTER NODE # InstVarAccess at 72.21	  
                      # ENTER NODE # InstVarAccess at 72.16			
                        # ENTER NODE # IdentifierExp at 72.15 		
                        lw $t0, 4($sp) # IdentifierExp at 72.15	 	
                        subu $sp, $sp, 4 # IdentifierExp at 72.15 
                        sw $t0, ($sp) # IdentifierExp at 72.15		
                        # EXIT NODE # IdentifierExp at 72.15 	 
                      lw $t0, ($sp) # InstVarAccess at 72.16 	 
                      beq $t0, $zero, nullPtrException # InstVarAccess at 72.16	
                      lw $t0, 0($t0) # InstVarAccess at 72.16	 	
                      sw $t0, ($sp) # InstVarAccess at 72.16 
                      # EXIT NODE # InstVarAccess at 72.16  	
                    lw $t0, ($sp) # InstVarAccess at 72.21	 	
                    beq $t0, $zero, nullPtrException # InstVarAccess at 72.21 		
                    lw $t0, 0($t0) # InstVarAccess at 72.21	  
                    sw $t0, ($sp) # InstVarAccess at 72.21 
                    # EXIT NODE # InstVarAccess at 72.21 
                  lw $t0, ($sp) # Assign at 72.13	  
                  lw $t1, 4($sp) # Assign at 72.13		 
                  beq $t1, $zero, nullPtrException # Assign at 72.13   
                  sw $t0, 0($t1) # Assign at 72.13  	
                  addu $sp, $sp, 8 # Assign at 72.13  
                  # EXIT NODE # Assign at 72.13			
                # EXIT NODE # Block at 71.66			
                # ENTER NODE # Assign at 71.56  	
                  # ENTER NODE # InstVarAccess at 71.59 	
                    # ENTER NODE # IdentifierExp at 71.58			
                    lw $t0, 0($sp) # IdentifierExp at 71.58		
                    subu $sp, $sp, 4 # IdentifierExp at 71.58 	
                    sw $t0, ($sp) # IdentifierExp at 71.58 
                    # EXIT NODE # IdentifierExp at 71.58 		
                  lw $t0, ($sp) # InstVarAccess at 71.59	 
                  beq $t0, $zero, nullPtrException # InstVarAccess at 71.59	 	
                  lw $t0, 0($t0) # InstVarAccess at 71.59		
                  sw $t0, ($sp) # InstVarAccess at 71.59		
                  # EXIT NODE # InstVarAccess at 71.59	 
                lw $t0, ($sp) # Assign at 71.56 		
                sw $t0, 4($sp) # Assign at 71.56  	
                addu $sp, $sp, 4 # Assign at 71.56 
                # EXIT NODE # Assign at 71.56   
              # EXIT NODE # Block at 71.2   
            while_enter_120: # While at 71.2 
              # ENTER NODE # And at 71.35	  
                # ENTER NODE # Not at 71.27 	
                  # ENTER NODE # Equals at 71.27   
                    # ENTER NODE # IdentifierExp at 71.25 		
                    lw $t0, 0($sp) # IdentifierExp at 71.25	  
                    subu $sp, $sp, 4 # IdentifierExp at 71.25		
                    sw $t0, ($sp) # IdentifierExp at 71.25		 
                    # EXIT NODE # IdentifierExp at 71.25	 
                    # ENTER NODE # Null at 71.30	  
                    subu $sp, $sp, 4 # Null at 71.30		 
                    sw $zero, ($sp) # Null at 71.30	 	
                    # EXIT NODE # Null at 71.30	 
                  lw $t0, ($sp) # Equals at 71.27		
                  lw $t1, 4($sp) # Equals at 71.27 		
                  seq $t0, $t0, $t1 # Equals at 71.27	
                  addu $sp, $sp, 4 # Equals at 71.27			
                  sw $t0, ($sp) # Equals at 71.27  
                  # EXIT NODE # Equals at 71.27		
                lw $t0, ($sp) # Not at 71.27  	
                xor $t0, $t0, 1 # Not at 71.27		
                sw $t0, ($sp) # Not at 71.27	
                # EXIT NODE # Not at 71.27	
              lw $t0, ($sp) # And at 71.35 
              beq $t0, $zero, skip_107 # And at 71.35 	 
              addu $sp, $sp, 4 # And at 71.35	  
                # ENTER NODE # Not at 71.45	  
                  # ENTER NODE # Equals at 71.45		 
                    # ENTER NODE # InstVarAccess at 71.39	 
                      # ENTER NODE # IdentifierExp at 71.38	 
                      lw $t0, 0($sp) # IdentifierExp at 71.38 		
                      subu $sp, $sp, 4 # IdentifierExp at 71.38 	 
                      sw $t0, ($sp) # IdentifierExp at 71.38		 
                      # EXIT NODE # IdentifierExp at 71.38		 
                    lw $t0, ($sp) # InstVarAccess at 71.39	 
                    beq $t0, $zero, nullPtrException # InstVarAccess at 71.39 	
                    lw $t0, 0($t0) # InstVarAccess at 71.39 	 
                    sw $t0, ($sp) # InstVarAccess at 71.39	 	
                    # EXIT NODE # InstVarAccess at 71.39	  
                    # ENTER NODE # Null at 71.48  	
                    subu $sp, $sp, 4 # Null at 71.48		
                    sw $zero, ($sp) # Null at 71.48			
                    # EXIT NODE # Null at 71.48  
                  lw $t0, ($sp) # Equals at 71.45	
                  lw $t1, 4($sp) # Equals at 71.45 		
                  seq $t0, $t0, $t1 # Equals at 71.45			
                  addu $sp, $sp, 4 # Equals at 71.45   
                  sw $t0, ($sp) # Equals at 71.45   
                  # EXIT NODE # Equals at 71.45 	 
                lw $t0, ($sp) # Not at 71.45		 
                xor $t0, $t0, 1 # Not at 71.45   
                sw $t0, ($sp) # Not at 71.45			
                # EXIT NODE # Not at 71.45			
              skip_107: # And at 71.35  
              # EXIT NODE # And at 71.35 	
            lw $t0, ($sp) # While at 71.2  
            addu $sp, $sp, 4 # While at 71.2  
            bne $t0, $zero, while_top_120 # While at 71.2  	
            while_exit_120: # While at 71.2 	
            # EXIT NODE # While at 71.2	 	
          addu $sp, 4 # Block at 71.2	 
          # EXIT NODE # Block at 71.2	  
          # ENTER NODE # IdentifierExp at 76.9 	 
          lw $t0, 12($sp) # IdentifierExp at 76.9 		
          subu $sp, $sp, 4 # IdentifierExp at 76.9	 	
          sw $t0, ($sp) # IdentifierExp at 76.9		
          # EXIT NODE # IdentifierExp at 76.9 	 
        lw $ra, 8($sp) # MethodDeclNonVoid at 64.20 	
        lw $s2, 4($sp) # MethodDeclNonVoid at 64.20	  
        lw $t0, ($sp) # MethodDeclNonVoid at 64.20   
        sw $t0, 20($sp) # MethodDeclNonVoid at 64.20 		
        addu $sp, $sp, 20 # MethodDeclNonVoid at 64.20		
        jr $ra # MethodDeclNonVoid at 64.20	
          # ENTER NODE # MethodDeclNonVoid at 64.20 
            # ENTER NODE # MethodDeclNonVoid at 87.20			
            .globl fcn_141_init # MethodDeclNonVoid at 87.20			
            fcn_141_init: # MethodDeclNonVoid at 87.20			
            subu $sp, $sp, 8 # MethodDeclNonVoid at 87.20		 
            sw $ra, 4($sp) # MethodDeclNonVoid at 87.20		 
            sw $s2, ($sp) # MethodDeclNonVoid at 87.20			
            lw $s2, 20($sp) # MethodDeclNonVoid at 87.20 	 
              # ENTER NODE # Assign at 88.6	 
                # ENTER NODE # IdentifierExp at 88.8 	
                lw $t0, 12($sp) # IdentifierExp at 88.8 		
                subu $sp, $sp, 8 # IdentifierExp at 88.8   
                sw $s5, 4($sp) # IdentifierExp at 88.8  
                sw $t0, ($sp) # IdentifierExp at 88.8		
                # EXIT NODE # IdentifierExp at 88.8  	
              lw $t0, ($sp) # Assign at 88.6  
              sw $t0, -16($s2) # Assign at 88.6 	 
              addu $sp, $sp, 8 # Assign at 88.6	
              # EXIT NODE # Assign at 88.6 
              # ENTER NODE # Assign at 89.7			
                # ENTER NODE # IdentifierExp at 89.9 	 
                lw $t0, 8($sp) # IdentifierExp at 89.9	 
                subu $sp, $sp, 4 # IdentifierExp at 89.9		 
                sw $t0, ($sp) # IdentifierExp at 89.9			
                # EXIT NODE # IdentifierExp at 89.9  
              lw $t0, ($sp) # Assign at 89.7  
              sw $t0, 0($s2) # Assign at 89.7		
              addu $sp, $sp, 4 # Assign at 89.7	 	
              # EXIT NODE # Assign at 89.7			
              # ENTER NODE # This at 90.9	 
              subu $sp, $sp, 4 # This at 90.9 
              sw $s2, ($sp) # This at 90.9  	
              # EXIT NODE # This at 90.9	 	
            lw $ra, 8($sp) # MethodDeclNonVoid at 87.20	 	
            lw $s2, 4($sp) # MethodDeclNonVoid at 87.20   
            lw $t0, ($sp) # MethodDeclNonVoid at 87.20		 
            sw $t0, 24($sp) # MethodDeclNonVoid at 87.20	 	
            addu $sp, $sp, 24 # MethodDeclNonVoid at 87.20 		
            jr $ra # MethodDeclNonVoid at 87.20	 
              # ENTER NODE # MethodDeclNonVoid at 87.20	 
                # ENTER NODE # MethodDeclVoid at 94.17  	
                .globl fcn_211_print # MethodDeclVoid at 94.17	 
                fcn_211_print: # MethodDeclVoid at 94.17	
                subu $sp, $sp, 8 # MethodDeclVoid at 94.17		 
                sw $ra, 4($sp) # MethodDeclVoid at 94.17	 
                sw $s2, ($sp) # MethodDeclVoid at 94.17  	
                lw $s2, 8($sp) # MethodDeclVoid at 94.17  
                  # ENTER NODE # LocalVarDecl at 96.6 	 
                    # ENTER NODE # NewObject at 96.12 
                    li $s6, 1 # NewObject at 96.12  
                    li $s7, 0 # NewObject at 96.12 
                    jal newObject # NewObject at 96.12			
                    la $t0, CLASS_Lib # NewObject at 96.12		 
                    sw $t0, -12($s7) # NewObject at 96.12 		
                    # EXIT NODE # NewObject at 96.12			
                  # EXIT NODE # LocalVarDecl at 96.6	 
                  # ENTER NODE # LocalVarDecl at 99.6	
                    # ENTER NODE # IntegerLiteral at 99.23 
                    subu $sp, $sp, 8 # IntegerLiteral at 99.23		
                    sw $s5, 4($sp) # IntegerLiteral at 99.23	
                    li $t0, 0 # IntegerLiteral at 99.23	
                    sw $t0, ($sp) # IntegerLiteral at 99.23  
                    # EXIT NODE # IntegerLiteral at 99.23		
                  # EXIT NODE # LocalVarDecl at 99.6 	 
                  # ENTER NODE # LocalVarDecl at 102.9		 
                    # ENTER NODE # StringLiteral at 102.21  
                    subu $sp, $sp, 4 # StringLiteral at 102.21  
                    la $t0, strLit_150 # StringLiteral at 102.21  
                    sw $t0, ($sp) # StringLiteral at 102.21			
                    # EXIT NODE # StringLiteral at 102.21  
                  # EXIT NODE # LocalVarDecl at 102.9	
                  # ENTER NODE # Block at 106.2  
                    # ENTER NODE # LocalVarDecl at 106.15 
                      # ENTER NODE # This at 106.19  
                      subu $sp, $sp, 4 # This at 106.19		 
                      sw $s2, ($sp) # This at 106.19			
                      # EXIT NODE # This at 106.19	 	
                    # EXIT NODE # LocalVarDecl at 106.15  
                    # ENTER NODE # While at 106.2 
                    j while_enter_199 # While at 106.2		
                    while_top_199: # While at 106.2 	
                      # ENTER NODE # Block at 106.2 	
                        # ENTER NODE # Block at 106.48 		
                          # ENTER NODE # ExpStatement at 111.10  	
                            # ENTER NODE # Call at 111.10	 	
                              # ENTER NODE # IdentifierExp at 111.6	
                              lw $t0, 16($sp) # IdentifierExp at 111.6	  
                              subu $sp, $sp, 4 # IdentifierExp at 111.6 
                              sw $t0, ($sp) # IdentifierExp at 111.6  
                              # EXIT NODE # IdentifierExp at 111.6  	
                              # ENTER NODE # IdentifierExp at 111.19	 	
                              lw $t0, 8($sp) # IdentifierExp at 111.19 		
                              subu $sp, $sp, 4 # IdentifierExp at 111.19		 
                              sw $t0, ($sp) # IdentifierExp at 111.19  	
                              # EXIT NODE # IdentifierExp at 111.19		
                            lw $t0, 4($sp) # Call at 111.10	
                            beq $t0, $zero, nullPtrException # Call at 111.10			
                            lw $t0, -12($t0) # Call at 111.10  	
                            lw $t0, 16($t0) # Call at 111.10 	
                            jalr $t0 # Call at 111.10 	
                            # EXIT NODE # Call at 111.10			
                          # EXIT NODE # ExpStatement at 111.10 	 
                          # ENTER NODE # ExpStatement at 112.10 		
                            # ENTER NODE # Call at 112.10			
                              # ENTER NODE # IdentifierExp at 112.6  	
                              lw $t0, 16($sp) # IdentifierExp at 112.6			
                              subu $sp, $sp, 4 # IdentifierExp at 112.6		
                              sw $t0, ($sp) # IdentifierExp at 112.6	 	
                              # EXIT NODE # IdentifierExp at 112.6  	
                              # ENTER NODE # InstVarAccess at 112.20		
                                # ENTER NODE # IdentifierExp at 112.19 	 
                                lw $t0, 4($sp) # IdentifierExp at 112.19	 	
                                subu $sp, $sp, 4 # IdentifierExp at 112.19	  
                                sw $t0, ($sp) # IdentifierExp at 112.19			
                                # EXIT NODE # IdentifierExp at 112.19	
                              lw $t0, ($sp) # InstVarAccess at 112.20	  
                              beq $t0, $zero, nullPtrException # InstVarAccess at 112.20		 
                              lw $t0, -16($t0) # InstVarAccess at 112.20	 	
                              subu $sp, $sp, 4 # InstVarAccess at 112.20	
                              sw $s5, 4($sp) # InstVarAccess at 112.20	  
                              sw $t0, ($sp) # InstVarAccess at 112.20 
                              # EXIT NODE # InstVarAccess at 112.20 
                            lw $t0, 8($sp) # Call at 112.10  
                            beq $t0, $zero, nullPtrException # Call at 112.10  	
                            lw $t0, -12($t0) # Call at 112.10 	
                            lw $t0, 24($t0) # Call at 112.10	  
                            jalr $t0 # Call at 112.10		
                            # EXIT NODE # Call at 112.10  
                          # EXIT NODE # ExpStatement at 112.10   
                          # ENTER NODE # Assign at 113.6   
                            # ENTER NODE # Plus at 113.20	 	
                              # ENTER NODE # IdentifierExp at 113.6	 	
                              lw $t0, 8($sp) # IdentifierExp at 113.6   
                              subu $sp, $sp, 8 # IdentifierExp at 113.6	
                              sw $s5, 4($sp) # IdentifierExp at 113.6			
                              sw $t0, ($sp) # IdentifierExp at 113.6  	
                              # EXIT NODE # IdentifierExp at 113.6 		
                              # ENTER NODE # IntegerLiteral at 113.20 
                              subu $sp, $sp, 8 # IntegerLiteral at 113.20 	
                              sw $s5, 4($sp) # IntegerLiteral at 113.20	
                              li $t0, 1 # IntegerLiteral at 113.20 	
                              sw $t0, ($sp) # IntegerLiteral at 113.20		 
                              # EXIT NODE # IntegerLiteral at 113.20		 
                            lw $t0, ($sp) # Plus at 113.20   
                            lw $t1, 8($sp) # Plus at 113.20			
                            addu $t0, $t0, $t1 # Plus at 113.20   
                            addu $sp, $sp, 8 # Plus at 113.20		
                            sw $t0, ($sp) # Plus at 113.20 		
                            # EXIT NODE # Plus at 113.20  	
                          lw $t0, ($sp) # Assign at 113.6  
                          sw $t0, 16($sp) # Assign at 113.6	
                          addu $sp, $sp, 8 # Assign at 113.6   
                          # EXIT NODE # Assign at 113.6  
                          # ENTER NODE # Assign at 114.16 		
                            # ENTER NODE # StringLiteral at 114.18  
                            subu $sp, $sp, 4 # StringLiteral at 114.18  	
                            la $t0, strLit_178 # StringLiteral at 114.18	 	
                            sw $t0, ($sp) # StringLiteral at 114.18 	
                            # EXIT NODE # StringLiteral at 114.18   
                          lw $t0, ($sp) # Assign at 114.16  	
                          sw $t0, 8($sp) # Assign at 114.16   
                          addu $sp, $sp, 4 # Assign at 114.16	  
                          # EXIT NODE # Assign at 114.16	 	
                          # ENTER NODE # If at 119.6	  
                            # ENTER NODE # Not at 119.25   
                              # ENTER NODE # LessThan at 119.25  	
                                # ENTER NODE # IdentifierExp at 119.10  
                                lw $t0, 8($sp) # IdentifierExp at 119.10 	 
                                subu $sp, $sp, 8 # IdentifierExp at 119.10	 	
                                sw $s5, 4($sp) # IdentifierExp at 119.10	  
                                sw $t0, ($sp) # IdentifierExp at 119.10	  
                                # EXIT NODE # IdentifierExp at 119.10  
                                # ENTER NODE # IntegerLiteral at 119.28  
                                subu $sp, $sp, 8 # IntegerLiteral at 119.28	 
                                sw $s5, 4($sp) # IntegerLiteral at 119.28		
                                li $t0, 10 # IntegerLiteral at 119.28	 
                                sw $t0, ($sp) # IntegerLiteral at 119.28 
                                # EXIT NODE # IntegerLiteral at 119.28 	
                              lw $t0, ($sp) # LessThan at 119.25	 
                              lw $t1, 8($sp) # LessThan at 119.25   
                              slt $t0, $t1, $t0 # LessThan at 119.25		
                              addu $sp, $sp, 12 # LessThan at 119.25		
                              sw $t0, ($sp) # LessThan at 119.25 	 
                              # EXIT NODE # LessThan at 119.25 	 
                            lw $t0, ($sp) # Not at 119.25 	
                            xor $t0, $t0, 1 # Not at 119.25	 
                            sw $t0, ($sp) # Not at 119.25   
                            # EXIT NODE # Not at 119.25	
                          lw $t0, ($sp) # If at 119.6	
                          addu $sp, $sp, 4 # If at 119.6	
                          beq $t0, $zero, if_else_196 # If at 119.6		
                            # ENTER NODE # Block at 119.32 		
                              # ENTER NODE # ExpStatement at 120.7 
                                # ENTER NODE # Call at 120.7		 
                                  # ENTER NODE # IdentifierExp at 120.3   
                                  lw $t0, 16($sp) # IdentifierExp at 120.3 	 
                                  subu $sp, $sp, 4 # IdentifierExp at 120.3		
                                  sw $t0, ($sp) # IdentifierExp at 120.3			
                                  # EXIT NODE # IdentifierExp at 120.3	  
                                  # ENTER NODE # StringLiteral at 120.16			
                                  subu $sp, $sp, 4 # StringLiteral at 120.16	 	
                                  la $t0, strLit_185 # StringLiteral at 120.16	  
                                  sw $t0, ($sp) # StringLiteral at 120.16   
                                  # EXIT NODE # StringLiteral at 120.16		 
                                lw $t0, 4($sp) # Call at 120.7		
                                beq $t0, $zero, nullPtrException # Call at 120.7 
                                lw $t0, -12($t0) # Call at 120.7   
                                lw $t0, 16($t0) # Call at 120.7  	
                                jalr $t0 # Call at 120.7		
                                # EXIT NODE # Call at 120.7 
                              # EXIT NODE # ExpStatement at 120.7		
                              # ENTER NODE # Assign at 121.13	 
                                # ENTER NODE # StringLiteral at 121.15	 	
                                subu $sp, $sp, 4 # StringLiteral at 121.15	 
                                la $t0, strLit_189 # StringLiteral at 121.15 		
                                sw $t0, ($sp) # StringLiteral at 121.15 		
                                # EXIT NODE # StringLiteral at 121.15			
                              lw $t0, ($sp) # Assign at 121.13	
                              sw $t0, 8($sp) # Assign at 121.13  
                              addu $sp, $sp, 4 # Assign at 121.13	 
                              # EXIT NODE # Assign at 121.13		
                              # ENTER NODE # Assign at 122.18	  
                                # ENTER NODE # IntegerLiteral at 122.20		
                                subu $sp, $sp, 8 # IntegerLiteral at 122.20	 
                                sw $s5, 4($sp) # IntegerLiteral at 122.20  	
                                li $t0, 0 # IntegerLiteral at 122.20   
                                sw $t0, ($sp) # IntegerLiteral at 122.20		 
                                # EXIT NODE # IntegerLiteral at 122.20 	 
                              lw $t0, ($sp) # Assign at 122.18			
                              sw $t0, 16($sp) # Assign at 122.18	
                              addu $sp, $sp, 8 # Assign at 122.18	 	
                              # EXIT NODE # Assign at 122.18 		
                            # EXIT NODE # Block at 119.32   
                          j if_done_196 # If at 119.6	  
                          if_else_196: # If at 119.6	
                            # ENTER NODE # Block at 124.2	 	
                            # EXIT NODE # Block at 124.2	  
                          if_done_196: # If at 119.6 		
                          # EXIT NODE # If at 119.6  
                        # EXIT NODE # Block at 106.48  	
                        # ENTER NODE # Assign at 106.38 	
                          # ENTER NODE # InstVarAccess at 106.41		 
                            # ENTER NODE # IdentifierExp at 106.40			
                            lw $t0, 0($sp) # IdentifierExp at 106.40  	
                            subu $sp, $sp, 4 # IdentifierExp at 106.40  	
                            sw $t0, ($sp) # IdentifierExp at 106.40		 
                            # EXIT NODE # IdentifierExp at 106.40   
                          lw $t0, ($sp) # InstVarAccess at 106.41	 	
                          beq $t0, $zero, nullPtrException # InstVarAccess at 106.41		
                          lw $t0, 0($t0) # InstVarAccess at 106.41 		
                          sw $t0, ($sp) # InstVarAccess at 106.41 	
                          # EXIT NODE # InstVarAccess at 106.41 	 
                        lw $t0, ($sp) # Assign at 106.38 		
                        sw $t0, 4($sp) # Assign at 106.38 
                        addu $sp, $sp, 4 # Assign at 106.38 	 
                        # EXIT NODE # Assign at 106.38   
                      # EXIT NODE # Block at 106.2 	
                    while_enter_199: # While at 106.2		
                      # ENTER NODE # Not at 106.27 
                        # ENTER NODE # Equals at 106.27		 
                          # ENTER NODE # IdentifierExp at 106.25	  
                          lw $t0, 0($sp) # IdentifierExp at 106.25  
                          subu $sp, $sp, 4 # IdentifierExp at 106.25 	 
                          sw $t0, ($sp) # IdentifierExp at 106.25		 
                          # EXIT NODE # IdentifierExp at 106.25			
                          # ENTER NODE # Null at 106.30 	 
                          subu $sp, $sp, 4 # Null at 106.30 	
                          sw $zero, ($sp) # Null at 106.30		 
                          # EXIT NODE # Null at 106.30   
                        lw $t0, ($sp) # Equals at 106.27  	
                        lw $t1, 4($sp) # Equals at 106.27	  
                        seq $t0, $t0, $t1 # Equals at 106.27 	 
                        addu $sp, $sp, 4 # Equals at 106.27	 
                        sw $t0, ($sp) # Equals at 106.27 	
                        # EXIT NODE # Equals at 106.27		 
                      lw $t0, ($sp) # Not at 106.27		 
                      xor $t0, $t0, 1 # Not at 106.27	  
                      sw $t0, ($sp) # Not at 106.27 
                      # EXIT NODE # Not at 106.27	 	
                    lw $t0, ($sp) # While at 106.2		
                    addu $sp, $sp, 4 # While at 106.2	  
                    bne $t0, $zero, while_top_199 # While at 106.2   
                    while_exit_199: # While at 106.2 	 
                    # EXIT NODE # While at 106.2 
                  addu $sp, 4 # Block at 106.2  
                  # EXIT NODE # Block at 106.2 
                  # ENTER NODE # If at 128.2 	
                    # ENTER NODE # GreaterThan at 128.21	 
                      # ENTER NODE # IdentifierExp at 128.6  	
                      lw $t0, 4($sp) # IdentifierExp at 128.6   
                      subu $sp, $sp, 8 # IdentifierExp at 128.6	  
                      sw $s5, 4($sp) # IdentifierExp at 128.6		 
                      sw $t0, ($sp) # IdentifierExp at 128.6  	
                      # EXIT NODE # IdentifierExp at 128.6	  
                      # ENTER NODE # IntegerLiteral at 128.23   
                      subu $sp, $sp, 8 # IntegerLiteral at 128.23 	 
                      sw $s5, 4($sp) # IntegerLiteral at 128.23 	 
                      li $t0, 0 # IntegerLiteral at 128.23	 	
                      sw $t0, ($sp) # IntegerLiteral at 128.23	 	
                      # EXIT NODE # IntegerLiteral at 128.23	 
                    lw $t0, ($sp) # GreaterThan at 128.21	  
                    lw $t1, 8($sp) # GreaterThan at 128.21 	 
                    sgt $t0, $t1, $t0 # GreaterThan at 128.21		 
                    addu $sp, $sp, 12 # GreaterThan at 128.21		
                    sw $t0, ($sp) # GreaterThan at 128.21 
                    # EXIT NODE # GreaterThan at 128.21		 
                  lw $t0, ($sp) # If at 128.2	 
                  addu $sp, $sp, 4 # If at 128.2 	
                  beq $t0, $zero, if_else_210 # If at 128.2  
                    # ENTER NODE # Block at 128.26 
                      # ENTER NODE # ExpStatement at 129.10  
                        # ENTER NODE # Call at 129.10			
                          # ENTER NODE # IdentifierExp at 129.6		
                          lw $t0, 12($sp) # IdentifierExp at 129.6 	
                          subu $sp, $sp, 4 # IdentifierExp at 129.6		 
                          sw $t0, ($sp) # IdentifierExp at 129.6  	
                          # EXIT NODE # IdentifierExp at 129.6 		
                          # ENTER NODE # StringLiteral at 129.19 	
                          subu $sp, $sp, 4 # StringLiteral at 129.19 		
                          la $t0, strLit_205 # StringLiteral at 129.19  	
                          sw $t0, ($sp) # StringLiteral at 129.19	  
                          # EXIT NODE # StringLiteral at 129.19   
                        lw $t0, 4($sp) # Call at 129.10	 
                        beq $t0, $zero, nullPtrException # Call at 129.10 	
                        lw $t0, -12($t0) # Call at 129.10   
                        lw $t0, 16($t0) # Call at 129.10 	
                        jalr $t0 # Call at 129.10   
                        # EXIT NODE # Call at 129.10 		
                      # EXIT NODE # ExpStatement at 129.10	 	
                    # EXIT NODE # Block at 128.26  
                  j if_done_210 # If at 128.2			
                  if_else_210: # If at 128.2			
                    # ENTER NODE # Block at 131.5 	
                    # EXIT NODE # Block at 131.5  	
                  if_done_210: # If at 128.2 	
                  # EXIT NODE # If at 128.2 
                lw $ra, 20($sp) # MethodDeclVoid at 94.17 		
                lw $s2, 16($sp) # MethodDeclVoid at 94.17	 	
                addu $sp, $sp, 28 # MethodDeclVoid at 94.17 	 
                jr $ra # MethodDeclVoid at 94.17		
                # EXIT NODE # MethodDeclVoid at 94.17	  
              # EXIT NODE # Program at 19.1	 	
###############################################################
# MiniJava/UP library for MIPS/Spim -- version that assumes
#    one-word boolean on stack
# author: Steven R. Vegdahl
# date: 7-13 July 2004
# modified 12-17 March 2007
# modified 3-25 May 2007
# status: reasonably debugged (allegedly)
###############################################################

	.text

###############################################################
# readLine() - library method (class Lib)
# - reads line from standard input
# - produces String that contains the line read, except that it
#   does not include the end-of-line character-sequence. An
#   end-of-line character-sequence is one of the following:
#   - a return character followed by a newline character
#   - a newline character not preceded by a return character
#   - a return character not followed by a newline character
#   - an end-of-file character that follows at least one data
#     character
# - returns null on end-of-file
# - parameter:
#   - ($sp) - this-pointer
# - return-value:
#   - ($sp) - pointer to string containing line that was read
# - anomalies:
#   - with bare "return", looks ahead one character to check for
#     newline.  This could cause non-intuitive behavior when
#     run interactively.
###############################################################
readLine:
	
	subu $sp,$sp,8 # allocate space for data tag, saving $ra
	sw $ra, 4($sp) # save $ra
	move $t1,$sp # save "original" sp

  doRead:

	# read the character
	jal readLogicalChar

	# if we have a 'return', read another character to check for
	# newline
	subu $t2,$v0,13
	bne $t2,$zero,notReturnRL
	jal readLogicalChar
	subu $t2,$v0,10 # check for newline
	beq $t2,$zero,foundNewLine
	sw $v0,lastCharRead # push back character into queue
	j foundNewLine # go process the line

  notReturnRL:

	# at this point, $v0 has our character

	subu $t0,$v0,10
	beq $t0,$zero,foundNewLine
	blt $v0,$zero,foundEof

	# we have a character, so push it onto stack
	subu $sp,$sp,4
	sw $v0,($sp)

	# loop back up to get next character
	j doRead

  foundEof:
	# if we had actually read some characters before hitting
        # the eof, go return them as if a newline had been read
	bne $t1,$sp foundNewLine

	# otherwise, we got end of file without having read any
  # new characters, so return null
	sw $zero,8($sp) # return-value: null
	j rlReturn # return

  foundNewLine:

	# at this point, we have our newline (or end-of-file), and all space
        # on the stack above $t1 are characters to be put into the string.
        # That is therefore the number of data words to allocate (plus 1
        # more for the class-pointer)


	# set up GC tag and char-count on stack
	subu $t0,$t1,$sp # number of chars we read (times 4)
	srl $s6,$t0,2 # number of words on stack with chars
	subu $sp,$sp,4 # push char-count ...
	sw $s6,($sp) # ... onto stack
	addu $t2,$t0,5 # GC tag, incl. for count-word
	sw $t2,($t1) # store GC tag
	
	# allocate the appropriate Object
	addu $s6,$s6,7 # 3 to round up, plus 1 for v-table pointer word
	srl $s6,$s6,2 # data words in object
	move $s7,$zero # # object words in object
	jal newObject # allocate space
	
	# store header words
	la $t0,CLASS_String
	sw $t0,-12($s7) # store class tag (String) into object
	lw $t2,4($sp) # char-count
	sll $t1,$t2,2 # 4 times number of chars
	subu $t2,$zero,$t2 # negative of char-count
	sw $t2,-4($s7) # store negative char-count as header-word 2

	# set up pointers to various parts of stack and object
	lw $t0,-8($s7) # data words in object
	sll $t0,$t0,2 # data bytes in object
	subu $t0,$s7,$t0 # place to store first character (plus 8)	
	subu $t0,$t0,$t2 # place to store last character (plus 9)
	addu $sp,$sp,8 # pop redundant object-pointer and count
	addu $t1,$t1,$sp # first non-char spot on stack

	# at this point:
	#  $t0 points to the target-spot for the last character (plus 9)
	#  $t1 contains top spot on the stack not containing a char
	#  $sp points to the word with the last source character

	# copy the characters, popping each off the stack

	beq $sp,$t1,doneCharCopy
  charCopyLoop:
	lw $t2,($sp)
	sb $t2,-9($t0)
	addu $sp,$sp,4
	subu $t0,$t0,1
	bne $sp,$t1,charCopyLoop
  doneCharCopy:

	# put our pointer (the return value) on the eventual top stack
	sw $s7,8($sp)
	
  rlReturn:
	# restore return address and return
	lw $ra,4($sp) # restore return address, ...
	addu $sp,$sp,8 # ... by popping it (and this-pointer) off stack
	jr $ra

###################################################################
# readInt() - library method (class Lib)
# - skips whitespace
# - then attempts to read a base-10 integer from standard input
# - aborts program if a valid integer is not found
# - returns the integer that is read
# - truncates on overflow
# - parameter:
#   - ($sp) - this-pointer
# - return-value:
#   - ($sp) - value that was read
#   - 4($sp) - (dummy) GC tag
###################################################################
readInt:

	# save $ra by pushing onto stack
	subu $sp,$sp,4
	sw $ra,($sp)

  riSkipWhiteLoop:
	# read a character
	jal readLogicalChar

	# if character <= 32 ascii, check for whitespace; if not
	# whitespace, abort 
	subu $t0,$v0,32
	bgt $t0,$zero,nonWhite
	beq $t0,$zero,riSkipWhiteLoop # start over if space
	subu $t0,$v0,10
	beq $t0,$zero,riSkipWhiteLoop # start over if newline
	subu $t0,$v0,9
	beq $t0,$zero,riSkipWhiteLoop # start over if tab
	subu $t0,$v0,13
	beq $t0,$zero,riSkipWhiteLoop # start over if carriage return
	subu $t0,$v0,12
	beq $t0,$zero,riSkipWhiteLoop # start over if form-feed
	j badIntegerFormat # illegal integer char: abort program

  nonWhite:
	subu $t0,$v0,'-'
	li $t4,1 # final multiplier
	bne $t0,$zero,helpReadInt # go read
	li $t4,-1 # -1 in final multiplier

	# read another character to make up for the '-'
	jal readLogicalChar

  helpReadInt:
	li $t2,10
	subu $t1,$v0,'0' # convert digit to 0-9 value
	bgeu $t1,$t2,badIntegerFormat # abort if not digit
	move $t3,$t1 #

	#### at this point, $t3 contains value of the first digit read,
	#### and $t2 contains the value 10

  digitLoop:
	# loop invariants:
	# - $t3 contains the value of the number we've read so far
	# - $t2 contains the value 10

	jal readLogicalChar # read next character
	subu $t1,$v0,'0' # convert digit to 0-9 value
	bgeu $t1,$t2,doneDigitLoop # abort if not digit

	mul $t3,$t3,$t2 # multiply old value by 10
	addu $t3,$t3,$t1 # add in value of new digit
	j digitLoop

  doneDigitLoop:

	# "push back" unused character into queue
	sw $v0,lastCharRead

	# restore return address and overwrite it with return-val;
	# write dummy GC tag as second word of return-val
	lw $ra,($sp)
	mult $t3,$t4 # multiply to account for poss. minus sign
	mflo $t3
	sw $t3,($sp) # result
	sw $s5,4($sp) # dummy GC tag
	#lw $zero,4($sp)#**"" #--FOR MEMORY TAGGING
	
	# return
	jr $ra

###################################################################
# readChar() - library method (class Lib)
# - reads a single character from standard input
# - returns the integer that is the encoding of the character
# - returns -1 if end of file was encountered
# - parameter:
#   - ($sp) - this-pointer
# - return-value:
#   - ($sp) - value that was read
#   - 4($sp) - (dummy) GC tag
###################################################################
readChar:

	# save $ra by pushing onto stack
	subu $sp,$sp,4
	sw $ra,($sp)

  	# read the character
	jal readLogicalChar

	# restore return address; put value (and dummy GC tag),
	# replacing this-pointer saved return address
	lw $ra,($sp)
	sw $s5,4($sp)
	#lw $zero,4($sp)#**"" #--FOR MEMORY TAGGING
	sw $v0,($sp)

	# return
	jr $ra

########################################################
# printStr(str) - library method (class Lib)
# - prints string to standard output
# parameters:
#   - ($sp) - the string to print
#   - 4($sp) - this-pointer
########################################################
printStr:
	# check for null, printing "(null)", if so
	lw $t0,($sp)
	bne $t0,$zero,psNotNull

	# print "(null)"
	la $a0,nullStr
	li $v0,4
	syscall
	j donePrintStr
	
  psNotNull:
	##### we have a non-null string #####
	# this means that:
	# - number of data words in object is in -8($t0)
	# - negative of number of characters in string is in -4($t0)
	# - string begins at $t0-8-(#dataWords*4), stored 1 char per byte
	subu $t0,$t0,8
	lw $t1,($t0) # word just beyond end of string
	sll $t1,$t1,2
	subu $t1,$t0,$t1 # first word in string
	lw $t0,4($t0) # negative of string-length
	subu $t0,$t1,$t0 # byte just beyond last char in string

	# print the chars in the string
	beq $t0,$t1,donePrintStr
  psLoop:
	lb $a0,($t1) # next byte
	li $v0,11 # code for printing char
        syscall # print the char
	addu $t1,$t1,1 # go to next char
	blt $t1,$t0,psLoop

  donePrintStr:
	# pop stack and return
	addu $sp,$sp,8
	jr $ra

########################################################
# printInt(n) - library method (class Lib)
# - prints integer in decimal format to standard output
# - parameters:
#   - ($sp) - the integer to print
#   - 4($sp) - (dummy) GC tag
#   - 8($sp) - this-pointer
########################################################
printInt:
	# pop value off stack, along with 'this'
	lw $a0,($sp)
	addu $sp,$sp,12

	# print it
	li $v0,1 # code for print-int
	syscall

	# return
	jr $ra

########################################################
# printBool(n) - library method (class Lib)
# - prints boolean to standard output
# - parameters:
#   - ($sp) - the boolean to print
#   - 4($sp) - this-pointer
########################################################
printBool:
	# pop value off stack, along with 'this'
	lw $t0,($sp)
	addu $sp,$sp,8

	# print either 'true' or 'false', depending on the value
	la $a0,falseString
	beq $t0,$zero,skipPB
	la $a0,trueString
  skipPB:
	li $v0,4 # code for print-string
	syscall

	# return
	jr $ra

########################################################
# str.substring(n, k) - library method (class String)
# takes a substring of a string: Java: str.substring(n, k)
# - parameters:
#   - ($sp) - k: one beyond index of last char in subrange
#   - 4($sp) - (dummy) GC tag
#   - 8($sp) - n: index of first char in subrange
#   - 12($sp) - (dummy) GC tag
#   - 16($sp) - str: string to take substring of
# - return value:
#  - ($sp) - substring
########################################################
substring:

	# save $ra by pushing onto stack
	subu $sp,$sp,4
	sw $ra,($sp)

	# get string value off stack, test for null
	lw $t0,20($sp)
	beq $t0,$zero,nullPtrException

	# get both indices and string length, and ensure that
	#   0 <= n <= k <= length
	lw $t0,-4($t0) # negative of string length
	subu $t0,$zero,$t0 # string length
	lw $t1,4($sp) # k
	lw $t2,12($sp) # n
	bgt $zero,$t2,strIndexOutOfBounds
	bgt $t2,$t1,strIndexOutOfBounds
	bgt $t1,$t0,strIndexOutOfBounds

	# allocate memory
	subu $s6,$t1,$t2 # # chars in target-string
	addu $s6,$s6,7 # account for extra "class" (4) word + 3 to round up
	srl $s6,$s6,2 # convert bytes-count to word-count
	move $s7,$zero # (no object-bytes in string)
	jal newObject

	# store "String" tag in object-type field
	la $t0,CLASS_String
	sw $t0,-12($s7)
	
	# store negative of count (=n-k) into object-length header-word
	lw $t1,8($sp) # k
	lw $t2,16($sp) # n
	subu $t0,$t2,$t1 # value to store
	sw $t0,-4($s7) # store value
	
	# store result in return-spot on stack
	lw $t3,24($sp) # source string pointer
	sw $s7,24($sp) # store final result in return-spot on stack
	
	# skip byte-copy loop if length is zero
	beq $zero,$t0,doneSubCopyzz

	# get pointers set up in preparation for copy
	lw $t4,-8($t3) # # data words in source string
	sll $t4,$t4,2 # # data bytes in source string
	subu $t3,$t3,$t4 # addr. of first data word of source string (+8)
	addu $t3,$t3,$t2 # addr. of first source data byte to be copied (+8)
	subu $t1,$t3,$t0 # addr. beyond last source data byte to be copied (+8)
	lw $t2,-8($s7) # # data words in target string
	sll $t2,$t2,2 # # data bytes in target string
	subu $t2,$s7,$t2 # addr. of first target data byte (+8)
	
	############################################
	# at this point:
	# - we know that the string has a positive length
	# - $t3 contains 8 + address of the first source-byte
	# - $t1 contains 8 + limit-address of the first source-byte
	# - $t2 contains 8 + address first target byte
	############################################

	# copy the bytes from source to target
  subCopyLoopzz:
	lb $t4,-8($t3)
	sb $t4,-8($t2)
	addu $t2,$t2,1
	addu $t3,$t3,1
	blt $t3,$t1,subCopyLoopzz
	
  doneSubCopyzz:
	# restore return address, store return value, pop stack
	lw $ra,4($sp) # restore $ra
	addu $sp,$sp,24 # pop stack
	
	# return
	jr $ra

########################################################
# length() - library method (class String)
# returns length of a string: Java: str.length()
# - parameters:
#   - ($sp) - the string
# - return-value:
#   - ($sp) - length of string
#   - 4($sp) - (dummy) GC tag
########################################################
length:

	# get string pointer
	lw $t0,($sp)
	
	# grow stack
	subu $sp,$sp,4

	# store GC tag
	sw $s5,4($sp)
	#lw $zero,4($sp)#**"" #--FOR MEMORY TAGGING

	# push length onto stack
	lw $t0,-4($t0) # -length
	subu $t0,$zero,$t0
	sw $t0,($sp) #store length

	# return
	jr $ra


########################################################
# str1.concat(str2) - library method (class String)
# (as in Java)
# - parameters:
#   - ($sp) - the second string
#   - 4($sp) - the first string
# - returns:
#   - ($sp) - pointer to concatenated string
########################################################
concat:
 	# save $ra by pushing onto stack
	subu $sp,$sp,4
	sw $ra($sp)

	# get string pointers and check parameter for null
	lw $t0,4($sp)
	beq $t0,$zero,nullPtrException
	lw $t1,8($sp)
	
	# get lengths of two strings; allocate object whose size
	# is their sum divided by 4 (rounded up) plus 1
	lw $t0,-4($t0) # negative size of second object
	lw $t1,-4($t1) # negative size of first object
	addu $s6,$t0,$t1 # sum of negative sizes
	sra $s6,$s6,2 # negative word-size of char part
	subu $s6,$zero,$s6 # word size of char part
	addu $s6,$s6,1 # data word size, including v-table word
	move $s7,$zero
	jal newObject

	# store "String" tag in object-type field
	la $t0,CLASS_String
	sw $t0,-12($s7)
	
	# pop rtnVal, $ra and both parameters off stack; push rtnVal
	# onto stack
	lw $ra,4($sp) # return address
	lw $t0,8($sp) # second object
	lw $t1,12($sp) # first object
	addu $sp,$sp,12 # pop
	sw $s7,($sp) # store return value
	
	# get negative sizes; sum and store in new object size-field
	lw $t2,-4($t0) # negative length of second object
	lw $t3,-4($t1) # negative length of first object
	addu $t4,$t2,$t3 # sum of negative lengths
	sw $t4,-4($s7) # store sum as negated target-string length

	#########################################################
	# at this point:
	# - $t0 is pointer to second object
	# - $t1 is pointer to first object
	# - $t2 is negated length of second object
	# - $t3 is negated length of first object
	# - $s7 is pointer to new object
	#########################################################

	# compute addresses for moving data from first string
	lw $t4,-8($t1) # # data words in first string
	sll $t4,$t4,2 # # data bytes in first string
	subu $t1,$t1,$t4 # addr. (+8) of first byte in first string
	lw $t4,-8($s7) # # data words in new string
	sll $t4,$t4,2 # # data bytes in new string
	subu $s7,$s7,$t4 # addr. (+8) of first byte in new string
	beq $zero,$t3,doneConcatLoop1zz # skip first loop is no bytes to copy
	subu $t3,$t1,$t3 # limit (+8) address for first string

	#########################################################
	# at this point:
	# - $t0 is pointer to second object
	# - $t1 is address (+8) of first byte in first object
	# - $t2 is negated length of second object
	# - $t3 is limit-address (+8) of data in first object
	# - $s7 is address (+8) of first byte in new object
	# - note: if data-length of first object is zero, then
	#   we skip over this part, and go to 'doneConcatLoop1'
	#########################################################

	# copy the bytes from first source to target
  concatLoop1zz:
	lb $t4,-8($t1)
	sb $t4,-8($s7)
	addu $s7,$s7,1
	addu $t1,$t1,1
	blt $t1,$t3,concatLoop1zz
  doneConcatLoop1zz:
  
    # if second string is empty, skip rest of copy
    beq $zero,$t2,doneConcatLoop2zz

  	# compute addresses for moving data from second string
	lw $t4,-8($t0) # # data words in second string
	sll $t4,$t4,2 # # data bytes in second string
	subu $t1,$t0,$t4 # addr. (+8) of first byte in second string
	subu $t3,$t1,$t2 # limit (+8) address for second string

	#########################################################
	# at this point:
	# - $t1 is address (+8) of first byte in second object
	# - $t3 is limit-address (+8) of data in second object
	# - $s7 is address (+8) of next byte to write new object
	# - note: if data-length of second object is zero, then
	#   we skip over this part, and go to 'doneConcatLoop2'
	#########################################################

	# copy the bytes from first source to target
  concatLoop2zz:
	lb $t4,-8($t1)
	sb $t4,-8($s7)
	addu $s7,$s7,1
	addu $t1,$t1,1
	blt $t1,$t3,concatLoop2zz
  doneConcatLoop2zz:
 
  concatRtnzz:
	# return
	jr $ra

########################################################
# str.charAt(n) - library method (class String)
# accesses a character in a string, as in Java
# - parameters:
#   - ($sp) - the index, n
#   - 4($sp) - dummy GC tag
#   - 8($sp) - the string, str
# - returns:
#   - ($sp) - the character found
#   - 4($sp) - the dummy GC tag
########################################################
charAt:
	# get string
	lw $t0,8($sp)

	# check that index is in bounds
	lw $t1,-4($t0) # negative of # data words in string
	subu $t3,$zero,$t1 # # chars in string
	lw $t2,($sp) # index
	bgeu $t2,$t3,strIndexOutOfBounds

	# access element
	lw $t1,-8($t0) # # data words in object
	sll $t1,$t1,2 # - byte-offset from end of chars
	subu $t1,$t2,$t1 # - address of first char in string, offset by 8
	addu $t0,$t0,$t1 # - address of our char, offset by 8
	lb $t0,-8($t0) # our char

	# pop elements off stack, pushing rtnVal
	addu $sp,$sp,4
	sw $t0,($sp)
	sw $s5,4($sp)
	#lw $zero,4($sp)#**"" #--FOR MEMORY TAGGING

	# return
	jr $ra

########################################################
# intToString(n) - library method (class Lib)
# converts int to string: Java: ""+n
# - parameters:
#   - ($sp) - the value to convert, n
#   - 4($sp) - dummy GC tag
#   - 8($sp) - this-pointer
# - returns:
#   - ($sp) - the string, which is the string representation of
#     the integer
########################################################
intToString:

	# save return address on stack; allocate space for dummy GC tag
	subu $sp,$sp,8
	sw $ra,4($sp)

	# save current sp
	move $t0,$sp

	# move constant 10 into $t3
	li $t3,10

	# get argument, negate if negative
	lw $t1,8($sp)
	bge $t1,$zero,itsNonNegLoop
	subu $t1,$zero,$t1

	# loop through, computing unsigned remainder by 10, and
	# storing digits on stack until we reach 0
  itsNonNegLoop:
	divu $t1,$t3
	mflo $t1 # quotient
	mfhi $t4 # remainder
	addu $t4,$t4,'0' # turn remainder into digit
	subu $sp,$sp,4
	sw $t4,($sp) # push digit onto stack
	bne $t1,$zero,itsNonNegLoop

	# push '-' if negative
	lw $t4,8($t0)
	bge $t4,$zero,itsSkipNeg
	li $t4,'-'
	subu $sp,$sp,4
	sw $t4,($sp)
  itsSkipNeg:

	################################################
	# At this point, all of our digits have been pushed
	# onto the stack.  $sp points to the first one;
	# $t0 contains the limit-pointer (into which we need to
	# write a GC tag).
	################################################

	# compute number of characters on stack (one word per character);
	# write GC tag onto stack; push char-count onto stack
	subu $s6,$t0,$sp
	addu $t3,$s6,5 # GC tag (including for count-word, about to be pushed
	sw $t3,($t0)
	srl $s6,$s6,2
	subu $sp,$sp,4
	sw $s6,($sp)
	
	# allocate memory
	addu $s6,$s6,7 # 3 to round up, plus 4 for vtable word
	srl $s6,$s6,2
	move $s7,$zero # no "object" words in object
	jal newObject

	# restore char-count; pop it and return value from 'newObject'
	lw $t0,4($sp)
	addu $sp,$sp,8

	# store "String" tag into class field
	subu $s7,$s7,8 # address of header-1 word
	la $t1,CLASS_String
	sw $t1,-4($s7)
	
	# store negative of char-count into header-2 word
	subu $t0,$zero,$t0
	sw $t0,4($s7)

	lw $t1,($s7) # number of data words in string
	sll $t1,$t1,2 # number data bytes in string
	subu $t1,$s7,$t1 # first location to store chars in string
	subu $t0,$t1,$t0 # limit address for chars in string

	####################################################
	# at this point:
	# - $sp contains first source character address
	# - $t1 contains first target character address
	# - $t0 contains target-limit address
	####################################################

	# loop through and copy all elements as we pop them off the stack.
	# (In this case, we know that there is it least one.)
  itsLoop:
	lw $t2,($sp)
	addu $sp,$sp,4
	sb $t2,($t1)
	addu $t1,$t1,1
	bne $t1,$t0,itsLoop

	####################################################
	# At this point
	# - ($t0+15)&0xfffffffe is our return value
    # - ($sp) contains garbage (old GC tag)
	# - 4($sp) contains return address
	####################################################

	# adjust stack, restore return address; return
	lw $ra,4($sp)
	addu $sp,$sp,16
	addu $t0,$t0,15
	and $t0,$t0,0xfffffffc
	sw $t0,($sp)
	jr $ra

########################################################
# intToChar(n) - library method (class Lib)
# converts int to a one-character string: Java: ""+(char)(n&0xff)
# - parameters:
#   - ($sp) - the value to convert, n
#   - 4($sp) - dummy GC tag
#   - 8($sp) - this-pointer
# - returns:
#   - ($sp) - the string, which is the converted character
# - note: only the low 8 bits of the value n are used
########################################################
intToChar:
	# save return address
	subu $sp,$sp,4
	sw $ra,($sp)

	# allocate object
	li $s6,2
	move $s7,$zero
	jal newObject

	# restore $ra, get 'n', popping then and 'newObject' rtnVal
	# off stack
	lw $ra,4($sp)
	lw $t1,8($sp)
	addu $sp,$sp,16

	# store "String" tag into class field
	la $t0,CLASS_String
	sw $t0,-12($s7)

	# store data in string
	sb $t1,-16($s7)
	
	# store negative of size in header-word 2
	li $t0,-1
	sw $t0,-4($s7)

	# store string pointer (return val) on stack for return
	sw $s7,($sp)

	# return
	jr $ra

########################################################
# str1.compareTo(str2) - library method (class String)
# compares two strings as in Java
# - parameters:
#   - ($sp) - second string
#   - 4($sp) - first string
# - returns:
#   - ($sp) - -1, 0, or 1 depending on whether str1 is
#       lexographically less than, equal to or greater than str2
#   - 4($sp) - (dummy) GC tag
########################################################
compareTo:
	# get string pointers and check parameter for null
	lw $t0,($sp) # second string
	beq $t0,$zero,nullPtrException
	lw $t1,4($sp) # first string
	
	# get (negatives of) respective byte-lengths
	lw $t2,-4($t0) # negative length of second string
	lw $t3,-4($t1) # negative length of first string

	# put tentative return value in $t5.
	# The tentative return value is the one that we will use if we get
	# to the end of the shorter string during our comparison-loop.
	slt $t4,$t3,$t2
	slt $t5,$t2,$t3
	subu $t5,$t5,$t4
	
	# at this point:
	# - $t0 contains the pointer to the second string object
	# - $t1 contains the pointer to the first string object
	# - $t5 contains the value to return if the strings compare equal up
	#   to the length of the shortest word

	# get begin-of-string addresses
	lw $t2,-8($t0) # # data words in second string
	lw $t3,-8($t1) # # data words in first string
	sll $t2,$t2,2 # byte-offset to beginning of str2 (+8)
	sll $t3,$t3,2 # byte-offset to beginning of str1 (+8)
	subu $t0,$t0,$t2 # beginning of str1 address (+8)
	subu $t1,$t1,$t3 # beginning of str2 address (+8)
	
	# put $t1-limit into $t2
	beq $zero,$t5,skipStrCmpLenzz
	move $t2,$t3
  skipStrCmpLenzz:
    add $t2,$t1,$t2
	
	# at this point:
	# - $t0 contains 8 plus the address of the first data-byte of str2
	# - $t1 contains 8 plus the address of the first data-byte of str1
	# - $t2 contains 8 plus the address of the last data-type of str1
	# - $t5 contains the value to return if the strings compare equal up
	#   to the length of the shortest word

	#######################################################
	# at this point, we have
	# - $t5 containing the tentative return-value
	# - $t1 containing address of first char in str2
	# - $t2 containing limit for $t1
	# - $t0 containing address of first char in str1
	#######################################################

	# loop through, until we find unequal words or we hit
	# our limit	
  cmpLoopzz:
	lw $t3,-8($t1) # word from str2
	lw $t4,-8($t0) # word from str1
	bne $t3,$t4,cmpNotEqualzz
	addu $t1,$t1,4
	addu $t0,$t0,4
	bne $t1,$t2,cmpLoopzz

	# # got to the end of one string: go set up return
	j cmpHitLimitzz

  cmpNotEqualzz:
	# found unequal characters: return -1 or 1, depending on which is
	# greater
	slt $t5,$t4,$t3 # 1 if str2 > str1, else 0
	sll $t5,$t5,1 # 2 if str2 > str1, else 0
	subu $t5,$t5,1 # 1 if str2 > str1, else -1
  cmpHitLimitzz:
	sw $t5,($sp) # store value
	sw $s5,4($sp) # GC tag
	#lw $zero,4($sp)#**"" #--FOR MEMORY TAGGING
	jr $ra # return

########################################################
# readLogicalChar (millicode)
#  - logically reads a character from standard input
#  - first checks character buffer, consuming it if possible
#  - return-result:
#    - returns character in $v0
#  - side-effects:
#    - reads a character
#    - clobbers $t0
########################################################
readLogicalChar:

	# check if we already have a character
	lw $v0,lastCharRead
	li $t0,-2
	beq $t0,$v0 doReadCh

	# we have our character from the buffer. Wipe out
	# buffer and return
	sw $t0,lastCharRead # store -2 into buffer (i.e. "empty")
	jr $ra # return
	
  doReadCh:
	# we need to actually read a character: read and return
	li $v0,12 # use system call to read a character
	syscall
	jr $ra # return

########################################################
# newObject (millicode)
#  - allocates a new object on the heap
#  - two-word header is set up properly
#  - all non-header words in object are set to zero
#  - parameters:
#    - $s6 = first header-word, which is -1 if it is a data-array
#      allocation, and is the number of data words in the object
#      otherwise
#    - $s7 - second header-word, which is the number of object
#      words in the object (unless $s6 is -1, in which case it
#      is the number of data words in the object
#    - it is illegal for $s6 to be less than -1 (this is not checked)
#    - it is illegal for $s7 to be less than 0 (this is checked)
#  - return-result:
#    - pushed onto the top of the stack
#    - also returned in $s7
#  - side-effects:
#  - may trash all $tx registers and all $sx registers, except the
#    "permanent" ones, which get updated with values that are
#    consistent with the new space
########################################################
newObject:
	# $s6 = # data words (or -1 if data-array allocation)
	#   - note: it is illegal for $s6 to be less than -1
	# $s7 = # object words (# data words if data-array allocation)
	# $ra = return address
	## on return, pointer to new memory is on
	##   top of stack, and also in $s7
	
	# abort if the object size is negative (this would be an array
	# allocation)
	blt $s7,$zero arraySizeOutOfBounds

	# mark the fact that we have not yet GC'd for this allocation
	move $t5,$zero

	###### TEMPORARY #######
	# for now, go a GC unconditionally, so that a full GC occurs
	# every time we allocate an object
	### let's not do that for now
	# j doGC

  gcJoin:
	# Determine actual size of "before-header" portion.
	# If negative, it really means zero
	move $t3,$s6
	bge $t3,$zero,newSkip
	move $t3,$zero

  newSkip:

	# at this point:
	#  $s6 contains the first header word
	#  $s7 contains the second header word, which is also the
	#    after-header word count
	#  $t3 contains the before-header word count
	#  $t5 is zero iff we have not GC'd for this allocation

	# determine if we have enough memory available
	addu $t0,$t3,$s7
	sll $t0,$t0,2
	addu $t0,$t0,8 # amount of memory needed
	addu $t1,$t0,$s3
	bgtu $t1,$s4,doGC

	# at this point:
	#  $s3 points to beginning of segment, and
	#  $t1 points just past the end

	# zero out the memory
	move $t2,$s3
  zeroObjLoop:
	sw $zero,($s3)
	#lw $zero,($s3)#**"" #--FOR MEMORY TAGGING	

	addu $s3,4
	bltu $s3,$t1,zeroObjLoop

	# at this point:
	#  $s3 has been updated to point to the next free slot,
	#    which is also the point just past our object

	# compute pointer value and set up header-words
	sll $t0,$s7,2    # number of post-header bytes
	subu $t0,$s3,$t0 # pointer that we will return

	# store header-values
	sw $s6,-8($t0)   # first header-word
	#lw $zero,-8($t0)#**"H1" #--FOR MEMORY TAGGING
	sw $s7,-4($t0)   # second header-word
	#lw $zero,-4($t0)#**"H2" #--FOR MEMORY TAGGING
	
	# put return-value into $s7 and also push it onto top of stack
	move $s7,$t0
	subu $sp,$sp,4
	sw $t0,($sp)

	jr $ra
	
  doGC:
	#####################################################
	# We need to do a garbage-collect
	#####################################################
 
         # print that we are doing a GC 
         #la $a0,gcMsg # prints message: "GC!" 
         #li $v0,4 # syscall-code for print-string 
         #syscall 
 	  
	# if we've already done a GC for this allocation, then
	# we are actually out heap-memory: abort program
	bne $t5,$zero,outOfHeapMemory
	  
	# save $s2 (our only rooted register) on the stack
	# so that the garbage collector processes it
	subu $sp,$sp,4
	sw $s2,($sp)

	# set $s3 to the address of the new segment and the
	# end-limit of the new segment, respectively,
	# Also, update cur_seg to refer to the other segment
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

	##################################
	# TEMPORARY HACK TO EXERCISE GC
	##################################
	#lw $t1,heapFudge
	#addu $t6,$t6,$t1
	#addu $t1,$t1,4
	#addu $s3,$s3,$t1 # fudge new heap pointer

	###############################################################
	# at this point:
	# - $t6 contains the first address of the source space
	# - $t7 contains the limit address of the source space
	# - $s3 contains the first address of the target space
	# - $s4 contains the limit address of the target space
	# - cur_seg has been updated to refer to the target space
	# - $t0 contains the address of the deepest stack element
	# - $sp contains the address of the top stack element
	# - $s2 is available for use, having been pushed onto the stack
	# - $t5 contains the value -2
	###############################################################


	###### begin outer loop to copy all stack-direct objects ######

  gcStackCopyLoop:
	lw $t1,($t0) # current stack element

	# test if we have a GC tag
	sll $t2,$t1,31 # zero iff low bit was zero
	bne $t2,$zero,gcBump # go skip data values if low bit not zero

	# bump stack-address pointer
	subu $t0,$t0,4

	# if value is out of range (which includes null=0), and is
	# therefore does not refer to an object on the heap, just go
	# loop back and do the next one
	bleu $t1,$t6,gcTestIterDone1
	bgtu $t1,$t7,gcTestIterDone1

	# if the object has already been moved, update the stack-value
	# via the forwarding pointer
	lw $t2,-8($t1) # possible forwarding tag
	bne $t2,$t5,gcNoForward1 # if not forwarding tag, go copy
	lw $t2,-4($t1) # forwarding pointer: object's new address
	sw $t2,4($t0) # update stack value
	j gcTestIterDone1 # do next iteration

  gcNoForward1:
	#########################################################
	# we actually need to copy the object into the new space
	#########################################################

	# compute the amount of space that is needed
	bge $t2,$zero,gcSkip2
	move $t2,$zero # set to zero if -1 (number of data words)

  gcSkip2:
	sll $t2,$t2,2
	addu $t2,$t2,8
	subu $t4,$t1,$t2 # address of first word of source
	lw $t3,-4($t1) # number of object words (negative treated as zero)
	bge $t3,$zero,gcH2Neg1
	move $t3,$zero
  gcH2Neg1:
	sll $t3,$t3,2
	addu $t3,$t3,$t1 # address one word past last word of source

	addu $t2,$s3,$t2 # pointer to target object

	#########################################################
	# At this point:
	# - $t0 contains the address of the stack slot we'll
	#   process next
	# - $t1 contains the contents of the stack slot we're
	#   currently working on, which is a pointer to the source
	#   object (i.e., the address just beyond the object's header
	# - $t2 contains the pointer to the target object
	# - $t3 contains the limit address of the source object
	# - $t4 contains the first address of the source object
	# - $t5 contains the value -2	
	# - $t6 contains the first address of the source space
	# - $t7 contains the limit address of the source space
	# - $s3 contains the first unallocated address of the
	#   target space, which is also the first address of the
	#   target object
	# - $s4 contains the limit address of the target space
	# - $s5 contains the value 5
	# - $s6-7 contain the original parameters to the call to
	#   'newObject'
	# - $sp contains the address of the top stack element
	# - available for use: $s0-2
	#########################################################

	# swap first header word and first data word so that header
    # can be found by "trailing finger" in the target space
	lw $s0,($t4)
	lw $s1,-8($t1)
	sw $s1,($t4)
	sw $s0,-8($t1)
	
	# copy all source bytes to the target
  gCinnerCopy1:
	lw $s0,($t4)
	sw $s0,($s3)
	addu $t4,$t4,4
	addu $s3,$s3,4
	bltu $t4,$t3,gCinnerCopy1

	###########################################################
	# All bytes have been copied to the target space.  We still
	# need to:
	# - set up forwarding pointer in source object
	# - update the pointer in the current stack slot
	###########################################################

	# set up the forwarding pointer
	sw $t5,-8($t1) # -2 in first header-slot
	sw $t2,-4($t1) # forwarding pointer in second header-slot

	# update the stack slot with the address in the target space
	sw $t2,4($t0)
	#lw $zero,-8($t2)#**"H1" #--FOR MEMORY TAGGING
	#lw $zero,-4($t2)#**"H2" #--FOR MEMORY TAGGING

	# go handle next stack slot (testing if done)
	j gcTestIterDone1

  gcBump:
	#### we have a GC tag.  Bytes to skip: tag value + 3.
	subu $t0,$t0,$t1
	subu $t0,$t0,3

  gcTestIterDone1:
	bgeu $t0,$sp,gcStackCopyLoop

	###### end outer loop to copy all stack-direct objects ######

	#############################################################
	# We have finished processing the stack elements.  Now we need
	# to update elements in the heap itself. This may itself involve
	# moving additional objects
	#############################################################

	#########################################################
	# At this point:
	# - $t5 contains the value -2	
	# - $t6 contains the first address of the source space
	# - $t7 contains the limit address of the source space
	# - $s3 contains the first unallocated address of the
	#   target space
	# - $s4 contains the limit address of the target space
	# - $s5 contains the value 5
	# - $s6-7 contain the original parameters to the call to
	#   'newObject'
	# We want to set things up so that in addition:
	# - $t0 is the "trailing finger", containing the address
	#   of the first slot in target space that we have yet
	#   to process.
	# Then during processing:
	# - $t1 will contain the contents of the heap slot we're
	#   currently working on, which is a pointer to the source
	#   object
	# And when we're actually copying an object:
	# - $t2 will contain pointer to the target object
	# - $t3 will contain the limit address of the source object
	# - $t4 will contain the first address of the source object
	# - $s1 will contain the the limit address for the current
	#   object that tells where the pointers in the object end
	# - available for use: $s0
	##########################################################

	# set $t0 to be at the beginning of target-space
	lw $t1,cur_seg
	la $t0,seg0_start
	beq $t1,$zero,gcSkip4
	la $t0,seg1_start

	##################################
	# TEMPORARY HACK TO EXERCISE GC
	##################################
	#lw $s0,heapFudge
	#addu $s0,$s0,4
	#addu $t0,$t0,$s0
	#sw $s0,heapFudge

  gcSkip4:

	# if there were no objects put into the heap during stack
	# processing, we're done, so go finish up
	bgeu $t0,$s3,gcFinishUp

	###### begin outer loop to copy all non-stack-direct objects ######

  gcHeapCopyLoop:
	# check if we have a data array
	lw $t1,($t0) # first header word for current object
	bge $t1,$zero,gcNotDataArray # test for neg. num (actually -1)

	# We have a -1 header-word, which means this object has no pointers.
	# Skip over it and go loop to do next object.
	lw $t1,4($t0) # data words
	addu $t1,$t1,2 # add in # header words
	sll $t1,$t1,2 # convert to byte-count
	addu $t0,$t0,$t1 # skip over object
	j gcTestIterDone2 # go do next object, if any

  gcNotDataArray:
	# get data count for object; swap header-word with first word
	# of object so that they're back in the right place
	sll $t2,$t1,2 # # data bytes
	addu $t2,$t2,8 # to skip header word
	addu $t2,$t0,$t2 # pointer to new object
	lw $t3,-8($t2) # word to swap
	sw $t1,-8($t2) # store header word
	sw $t3,($t0) # restore first word of object

	lw $t3,-4($t2) # # object words (negative treated as zero)
	bge $t3,$zero,gcH2Neg2
	move $t3,$zero
  gcH2Neg2:
	sll $t3,$t3,2 # # object bytes
	move $t0,$t2 # address of first pointer in object
	add $s1,$t2,$t3 # limit address for this object

	#####################################################
	# At this point, we have to "translate" all pointers,
	# starting at $t0 to (but not including) $s1
	#####################################################

	# if there are no pointer-slots (i.e., $t0=$s1), skip this
	# part
	beq $t0,$s1,gcTestIterDone2
	
  gcNextPointerInObject:
	# get pointer from object
	lw $t1,($t0)

	# if value is out of range, and is therefore does not refer
	# to an object, just go loop back and do the next one
	bleu $t1,$t6,gcGoNextPointerSlot
	bgtu $t1,$t7,gcGoNextPointerSlot

	# if the object has already been moved, update the stack-value
	# via the forwarding pointer
	lw $t8,-8($t1) # possible forwarding tag
	bne $t8,$t5,gcNoForward2 # if not forwarding tag, go copy
	lw $t8,-4($t1) # forwarding pointer: object's new address
	sw $t8,($t0) # update pointer in object
	j gcGoNextPointerSlot # do next iteration

  gcNoForward2:
	#########################################################
	# we actually need to copy the object into the new space
	#########################################################

	#########################################################
	# At this point:
	# - $t0 contains the address of the heap-slot we're translating
	# - $t1 will contain the contents of the heap-slot we're
	#   currently working on, which is a pointer to the source
	#   object
	# - $t2 will contains pointer to the object we're in the
	#   middle of translating
	# - $t5 contains the value -2	
	# - $t6 contains the first address of the source space
	# - $t7 contains the limit address of the source space
	# - $s3 contains the first unallocated address of the
	#   target space, which will also be the first address
	#   of the target object
	# - $s4 contains the limit address of the target space
	# - $s5 contains the value 5
	# - $s6-7 contain the original parameters to the call to
	#   'newObject'
	# Then during processing:
	# And when we're actually copying an object:
	# - $t3 will contain the limit address of the source object
	# - $t4 will contain the first address of the source object
	# - $s1 will contain the the limit address for the current
	#   object that tells where the pointers in the object end
	# - $t8 will contain a pointer to the target object
	# - available for use: $s0, $t8, $t9
	##########################################################

	# compute the amount of space that is needed
	bge $t8,$zero,gcSkip5
	move $t8,$zero # set to zero if -1

  gcSkip5:
	sll $t8,$t8,2
	addu $t8,$t8,8
	subu $t4,$t1,$t8 # address of first word of source
	lw $t3,-4($t1)
	bge $t3,$zero,gcNoNeg
	move $t3,$zero
  gcNoNeg:
	sll $t3,$t3,2
	addu $t3,$t3,$t1 # address one word past last word of source

	addu $t8,$s3,$t8 # pointer to target object

	#########################################################
	# At this point:
	# - $t0 contains the address of the stack slot we'll
	#   process next
	# - $t1 contains the contents of the stack slot we're
	#   currently working on, which is a pointer to the source
	#   object
	# - $t2 will contains pointer to the object we're in the
	#   middle of translating
	# - $t3 contains the limit address of the source object
	# - $t4 contains the first address of the source object
	# - $t5 contains the value -2	
	# - $t6 contains the first address of the source space
	# - $t7 contains the limit address of the source space
	# - $t8 contains the pointer to the target object
	# - $s1 contains the the limit address for the current
	#   object that tells where the pointers in the object end
	# - $s3 contains the first unallocated address of the
	#   target space, which is also the first address of the
	#   target object
	# - $s4 contains the limit address of the target space
	# - $s5 contains the value 5
	# - $s6-7 contain the original parameters to the call to
	#   'newObject'
	# - $sp contains the address of the top stack element
	# - available for use: $s0, $t9
	#########################################################

	# swap first header word and first data word so that header
        # can be found by "trailing finger"
	lw $s0,($t4)
	lw $t9,-8($t1)
	sw $t9,($t4)
	sw $s0,-8($t1)

	# copy all source bytes to the target
  gCinnerCopy2:
	lw $s0,($t4)
	sw $s0,($s3)
	addu $t4,$t4,4
	addu $s3,$s3,4
	bltu $t4,$t3,gCinnerCopy2

	###########################################################
	# All bytes have been copied to the target space.  We still
	# need to:
	# - set up forwarding pointer in source object
	# - update the pointer in the current stack slot
	###########################################################

	# set up the forwarding pointer
	sw $t5,-8($t1) # -2 in first header-slot
	sw $t8,-4($t1) # forwarding pointer in second header-slot

	# update the heap-slot with the address in the target space
	sw $t8,($t0)

  gcGoNextPointerSlot:
	# bump $t0 to next slot in object; if not done, loop back
	addu $t0,$t0,4
	bltu $t0,$s1,gcNextPointerInObject

  gcTestIterDone2:
	bltu $t0,$s3,gcHeapCopyLoop

	###### end outer loop to copy all non-stack-direct objects ######

  gcFinishUp:
	# restore $s2 to its updated value by popping off stack
	lw $s2,($sp)
	addu $sp,$sp,4

	# mark us as having already GC'd
	move $t5,$s5

	# go try and allocate again
	j gcJoin
	    

########################################################
# vm_init (millicode)
#  - initialzes the virtual machine
#  - values 5 stored in $s5
#  - zero ("this pointer") stored in $s2
#  - heap and heap-limit pointers stored respectively in $s3 and $s4
#  - address of bottom of stack stored in 'stack_bottom' memory
#    location
#  - (note: 'cur_seg' memory location is already set to 0)
########################################################
vm_init:

	# mark bottom of stack
	sw $sp,stack_bottom
	move $sp,$sp#**"stack pointer"  #--FOR MEMORY TAGGING
	
	# set "this" pointer to be null, for now
	move $s2,$zero
	move $s2,$s2#**"this pointer"  #--FOR MEMORY TAGGING

	#set up the "five" register
	li $s5,5
	move $s5,$s5#**"constant 5"  #--FOR MEMORY TAGGING

	la $s3,seg0_start
	move $s3,$s3#**"next-avail-heap"  #--FOR MEMORY TAGGING
	la $s4,seg0_end
	move $s4,$s4#**"end-heap"  #--FOR MEMORY TAGGING
	
	# return
	jr $ra

########################################################
# divide (millicode)
#  - divides first arg by second (signed divide)
#  - aborts if divisor is zero
#  - follows calling conventions for library methods
#  - parameters:
#    - ($sp) divisor
#    - 4($sp) (dummy) GC tag
#    - 8($sp) dividend
#    - 12($sp) (dummy) GC tag
#  - return value:
#    - ($sp) result
#    - 4($sp) (dummy) GC tag
########################################################
divide:
	# get parameters; abort if divisor zero
	lw $t0,($sp)
	lw $t1,8($sp)
	beq $t0,$zero,divByZeroError
	
	# perform division
	div $t1,$t0
	mflo $t0

	# store result, adjust stack and return
	addu $sp,$sp,8 # adjust stack
	sw $t0,($sp) # store result
	jr $ra

########################################################
# remainder (millicode)
#  - takes remainder first arg divided by second (signed divide)
#  - aborts if divisor is zero
#  - follows calling conventions for library methods
#  - parameters:
#    - ($sp) divisor
#    - 4($sp) (dummy) GC tag
#    - 8($sp) dividend
#    - 12($sp) (dummy) GC tag
#  - return value:
#    - ($sp) result
#    - 4($sp) (dummy) GC tag
########################################################
remainder:
	# get parameters; abort if divisor zero
	lw $t0,($sp)
	lw $t1,8($sp)
	beq $t0,$zero,divByZeroError
	
	# perform division
	div $t1,$t0
	mfhi $t0

	# store result, adjust stack and return
	addu $sp,$sp,8 # adjust stack
	sw $t0,($sp) # store result
	jr $ra
	
########################################################
# checkCast (millicode) - checks that a cast is legal
#  - aborts if null
#  - aborts if cast is illegal cast
#  - parameters:
#    - ($sp) object to check
#    - $t0 address of vtable for target-class
#    - $t1 address one past vtable address of last
#      subclass of target-class
#  - return value:
#    - ($sp) object to check (now checked)
#  - side-effects: clobbers $t2 and $t3
########################################################
checkCast:
	# get object, allow immediately if null
	lw $t2,($sp)
	beq $t2,$zero,checkCastReturn
	
	# get vtable address of object (using Object vtable
	# address for arrays)
	lw $t3,-8($t2) # <= 0 if array
	lw $t2,-12($t2) # vtable address (unless array)
	bgt $t3,$zero,skipArrayCast
	la $t2,CLASS_Object
	
	# get vtable address of object, abort if less than
	# lower limit or greater then or equal to higher
	# limit
  skipArrayCast:
	bge $t2,$t1,castException
	blt $t2,$t0,castException
	
	# return, leaving object unchanged on stack
  checkCastReturn:	
	jr $ra	
	
########################################################
# instanceOf (millicode) - tests whether an object is
#   a member of a given class (or subclass)
#  - returns false if object is null
#  - parameters:
#    - ($sp) object to check
#    - $t0 address of vtable for target-class
#    - $t1 address one past vtable address of last
#      subclass of target-class
#  - return value:
#    - ($sp) true (1) or false (0), depending on whether
#      object is a member
#  - side-effects: clobbers $t2 and $t3
########################################################
instanceOf:
	# get object, go return false if null
	lw $t2,($sp)
	beq $t2,$zero,doneInstanceOf
	
	# get vtable address of object.  If it's an array
	# (which would be H1 <= 0), use vtable address for Object
	lw $t3,-8($t2) # <= 0 if array
	lw $t2,-12($t2) # vtable address (unless array)
	bgt $t3,$zero,skipArrayInstanceOf
	la $t2,CLASS_Object
	
	# get vtable address of object, abort if less than
	# lower limit or greater then or equal to higher
	# limit
  skipArrayInstanceOf:
	sge $t0,$t2,$t0
	slt $t1,$t2,$t1
	
	# store the AND of the two conditions onto the stack; return
	and $t2,$t0,$t1
  doneInstanceOf: # if we reach here via branch, we know $t2=0
	sw $t2,($sp)
	jr $ra

###########################################################
# jump-targets to terminate program:
# - exit: returns normally
# - outOfHeapMemory: prints "out of memory" error and returns
###########################################################

exitError:
	# assumes $a0 has pointer to null-terminated string

	# print the string
	li $v0,4 # syscall-code for print-string
	syscall
exit:
	# print termination message
	li $v0,4
	la $a0,exitString
	syscall

	# terminate execution
	li $v0,10 #syscall-code for "exit"
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

############## data section ################
	.data
	.align 2

cur_seg:
	.word 0

lastCharRead:
	.word -2 # -2 => no buffered character

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

#heapFudge: # temporary fudge amount to exercise GC
#	.word 0

seg0_start:
	.space 0x100000
seg0_end:
seg1_start:
	.space 0x100000
seg1_end:



