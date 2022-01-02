import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)//perclass also
class MathUtilTest {
//execute the code you want to test//\
    //verify the result is what you expect
    //create an instance of the class under test
    //set up inputs
    //execute the code you want to test
    //verify the result is what you expect



    //assertEquals(these are the three methods in assertEquals)
    //1.assets that expected and acutla are equal
    //2.assertArrayEquals(expectedArrray,acutalArray)
    //verifies each item in the arrays are euqal in the right position
    //assertIterableEquals(expectedArray,actualArray)
    //verifies each item in the iterabalb eare equal in the corresponding positoijns
MathUtil mathUtil;


@BeforeAll//if TestiNstance.lifecycle.perclass then we do not need static method because only one method created
static void beforeAllInit(){
    System.out.println("this need to run before all");
}

     @BeforeEach//will execute before each method executes
    void init(){
   mathUtil=new MathUtil();
}

@AfterEach
void clean()
{
    System.out.println("cleaning up....");
}


    @Test
    @DisplayName("testing add method")
    void add() {
       // MathUtil mathUtil=new MathUtil();
        int expected =2;
        int acutal=mathUtil.add(1,1);
        //assertEquals(expected,acutal);
        assertEquals(expected,acutal,"the method not get added");//string message will come it test cases fails
    }

    @Test
    @EnabledOnOs(OS.LINUX)//CASE will ignored
    void testComputeCircleRadius(){
      //  MathUtil mathUtil=new MathUtil();
        assertEquals(3.12,mathUtil.computeCircleRadius(10),"coucl not coumpte radius");
    }

    @Test
    void testDivide(){
      //  MathUtil mathUtil=new MathUtil();
    boolean isServerUp=false;
        assumeTrue(isServerUp);//i am assuming this//then it will ignore this case
        assertThrows(ArithmeticException.class,()->mathUtil.divide(1,0),"divide by zero shoudl throw");

    }

    @Test
    @Disabled
    void testDisabled(){
    fail("this test should be disabled");
    }



      @Test
    @DisplayName("multiply method")
    void testMulitply(){

    //assertEquals(4,mathUtil.mutliply(2,2),"should reuturn the right");
    assertAll(
            ()->assertEquals(4,mathUtil.mutliply(2,2),"should reuturn the right"),
            ()-> assertEquals(0,mathUtil.mutliply(2,0),"should reuturn the right"),
            ()->assertEquals(-2,mathUtil.mutliply(2,-1),"should reuturn the right")
    );
}





}