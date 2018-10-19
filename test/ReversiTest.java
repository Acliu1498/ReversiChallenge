import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class ReversiTest {
    private JSONArray jsonArray;
    private ReversiSolution testSolution;

    @Before
    public void init(){
        try {
            testSolution = new ReversiSolution();
            jsonArray = (JSONArray) (new JSONParser().parse(new FileReader("tests.json")));
        }catch (Exception e){
            e.printStackTrace();
            throw new IllegalArgumentException("bad file");
        }
    }


    @Test
    public void makeMover_GivenTestBoard_ReturnsExpectedBoard(){
        for (Object object: jsonArray){
            JSONObject testCase = (JSONObject) object;
            JSONObject input = (JSONObject) testCase.get("input");
            JSONObject expected = (JSONObject) testCase.get("expected");

            File output = new File("output.json");
            try {
                output.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }


            testSolution.run(input, output);
            JSONObject actual;
            try {
                actual = (JSONObject) (new JSONParser().parse(new FileReader(output)));
            }catch (Exception e){
                e.printStackTrace();
                throw new IllegalArgumentException("bad file");
            }
            Assert.assertEquals(expected, actual);
        }
    }
}
