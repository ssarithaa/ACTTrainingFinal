package resources;

import org.testng.annotations.DataProvider;


public class testdata {
    @DataProvider(name="credentials")
    public static Object[][] credentials()
    {
        return new Object[][]{

                {"stevenbaron@gmail.com","Qweqweqwe1!"},
                {"stevenbaron","Qweqweqwe1!"}
        };
    }
}
