import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DateUtilsTest {

    DateUtils dateUtils;

    @BeforeAll
    public void initClass() {
        dateUtils = new DateUtils();
    }

    @AfterAll
    public void cleanClass() {
        dateUtils = null;
    }

    @Test
    public void testIsLeapYearTrue(){

        boolean resultTrue = dateUtils.isLeapYear(2020);
        Assertions.assertTrue(resultTrue);
    }

    @Test
    public void testIsLeapYearFalse(){

        boolean resultFalse = dateUtils.isLeapYear(2021);
        Assertions.assertFalse(resultFalse);
    }

    @Test
    public void testGetDaysInMonthFebruaryLeap(){

        int resultFebruaryLeap = dateUtils.getDaysInMonth(2020, 2);
        Assertions.assertEquals(29, resultFebruaryLeap);

    }

    @Test
    public void testGetDaysInMonthFebruaryNonLeap(){

        int resultFebruaryNonLeap = dateUtils.getDaysInMonth(2021, 2);
        Assertions.assertEquals(28, resultFebruaryNonLeap);
    }

    @Test
    public void testGetDaysInMonthInvalidMonth(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dateUtils.getDaysInMonth(2021, 13);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            dateUtils.getDaysInMonth(2021, 0);
        });
    }

    @Test
    public void testGetDaysInMonthValidMonth(){

        int resultValidMonth = dateUtils.getDaysInMonth(2021, 1);
        Assertions.assertEquals(31, resultValidMonth);
    }


}
