import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.junit.Before;
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
    public void run_GivenTestBoard_ReturnsExpectedBoard(){
        // runs through all test cases
        for (Object object: jsonArray){
            // inits the initial test data
            JSONObject testCase = (JSONObject) object;
            JSONObject input = (JSONObject) testCase.get("input");
            JSONObject expected = (JSONObject) testCase.get("expected");
            // creates the output file
            File output = new File("output.json");
            try {
                output.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }

            testSolution.run(input, output);

            // gets the returned JSON board
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
