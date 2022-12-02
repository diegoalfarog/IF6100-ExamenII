/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

/**
 *
 * @author diegoalfaro
 */
@RunWith(Parameterized.class)
public class AguinaldoTest {

    LocalDateTime startDate;
    LocalDateTime endDate;
    Integer amount;
    Float expectedResult;
    @Parameterized.Parameters
         public static Collection input(){
            return Arrays.asList(new Object[][] {
                {"2021-12-01 10:30", "2022-11-30 10:30",299999, -2}
                    ,{"2022-03-09 10:30", "2022-01-09 10:30",300000, -1}
                    ,{"2021-11-01 10:30", "2022-11-30 10:30",300000,-3}
                    ,{"2021-12-01 10:30", "2022-11-30 10:30",1000000,1000000}});
        }
    public AguinaldoTest(String startDateText,String endDateText ,Integer amount, Integer expectedResult) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        
        this.startDate = LocalDateTime.parse(startDateText, formatter);;
        this.endDate = LocalDateTime.parse(endDateText, formatter);;
        this.amount = amount;
        this.expectedResult = (float)expectedResult;
    }

   
    @Test
    public void testFindBonus() {
        System.out.println("FindBonus");
        Aguinaldo instance = new Aguinaldo();
        Float result = instance.findbonus(startDate, endDate, amount);
        System.out.println(result);
        assertEquals( expectedResult, result);
//        fail("The test case is a prototype.");
    }


    
}
