package resources;

import org.testng.annotations.DataProvider;


public class testdata {
    @DataProvider(name="invalidcredentials")
    public static Object[][] invalidcredentials()
    {
        return new Object[][]{

                {"stevenbaron@gmail.com","Qweqweqwe1!"},
                {"stevenbaron","Qweqweqwe1!"}
        };
    }
    @DataProvider(name="validcredentials")
    public static Object[][] validcredentials()
    {
        return new Object[][]{

                {"stevenbaron11@gmail.com","Qweqweqwe1!"},

        };
    }
}
