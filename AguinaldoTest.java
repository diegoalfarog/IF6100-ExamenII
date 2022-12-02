import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonathan Salazar Castro
 * @last edit 02/12/2022
 * @version 0.1
 */

public class AguinaldoTest {

    public AguinaldoTest() {
    }
//Test Dates
    //Dates (La fecha inicial es posterior a la fecha de fin del cálculo del bono)

      @Test
    public void testFindbonusStartDateGreaterEndDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("findbonus");
        LocalDateTime startDate = LocalDateTime.parse("2022-12-02 10:30", formatter);
        LocalDateTime endDate = LocalDateTime.parse("2022-12-01 10:30", formatter);
        float amount = 300000.0F;
        float expResult = -1.0F;
        float result = Aguinaldo.findbonus(startDate, endDate, amount);
        assertEquals(expResult, result, 0);
    }

    //Dates (La fecha inicial es igual a la fecha de fin del cálculo del bono)
     @Test
    public void testFindbonusStartDateEqualsEndDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("findbonus");
        LocalDateTime startDate = LocalDateTime.parse("2022-12-01 10:30", formatter);
        LocalDateTime endDate = LocalDateTime.parse("2022-12-01 10:30", formatter);
        float amount = 300000.0F;
        float expResult = 25000.0F;
        float result = Aguinaldo.findbonus(startDate, endDate, amount);
        assertEquals(expResult, result, 0);
    }
    
    //Dates (La fecha inicial es menor a la fecha de fin del cálculo del bono)
    @Test
    public void testFindbonusStartDateLessEndDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("findbonus");
        LocalDateTime startDate = LocalDateTime.parse("2022-01-01 10:30", formatter);
        LocalDateTime endDate = LocalDateTime.parse("2022-01-02 10:30", formatter);
        float amount = 300000.0F;
        float expResult = 25000.0F;
        float result = Aguinaldo.findbonus(startDate, endDate, amount);
        assertEquals(expResult, result, 0);
    }
    
//Amount
    //Amount (monto superior a 300 000)
      @Test
    public void testFindbonusAmountGreater300000() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("findbonus");
        LocalDateTime startDate = LocalDateTime.parse("2022-01-01 10:30", formatter);
        LocalDateTime endDate = LocalDateTime.parse("2022-02-01 10:30", formatter);
        float amount = 300001.0F;
        float expResult = 50000.1680F;
        float result = Aguinaldo.findbonus(startDate, endDate, amount);
        assertEquals(expResult, result, 0);
    }
    
    //Amount (monto igual a 300 000)
     @Test
    public void testFindbonusAmountGreaterEquals300000() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("findbonus");
        LocalDateTime startDate = LocalDateTime.parse("2022-01-01 10:30", formatter);
        LocalDateTime endDate = LocalDateTime.parse("2022-02-01 10:30", formatter);
        float amount = 300000.0F;
        float expResult = 50000.0F;
        float result = Aguinaldo.findbonus(startDate, endDate, amount);
        assertEquals(expResult, result, 0);
    }
    
    //Amount (monto menor a 300 000)
     @Test
    public void testFindbonusAmountGreaterLess300000() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("findbonus");
        LocalDateTime startDate = LocalDateTime.parse("2022-01-01 10:30", formatter);
        LocalDateTime endDate = LocalDateTime.parse("2022-02-01 10:30", formatter);
        float amount = 299999.0F;
        float expResult = -2.0F;
        float result = Aguinaldo.findbonus(startDate, endDate, amount);
        assertEquals(expResult, result, 0);
    }
    
//ProperRange 
    //ProperRange (fecha inicial sea diferente a diciembre de un año anterior de la fecha final)
    @Test
    public void testFindbonusProperRange() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("findbonus");
        LocalDateTime startDate = LocalDateTime.parse("2022-11-30 10:30", formatter);
        LocalDateTime endDate = LocalDateTime.parse("2023-01-01 10:30", formatter);
        float amount = 300000.0F;
        float expResult = -3.0F;
        float result = Aguinaldo.findbonus(startDate, endDate, amount);
        assertEquals(expResult, result, 0);
    }


}
