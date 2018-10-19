import org.json.simple.JSONObject;

import java.io.File;

/**
 * This class will take in a JSON file of a reversi board state and a move
 * it will then process the move and write to a new JSON file the result
 */
public class ReversiSolution {

    /**
     * this method takes a JSOn file containing a board and a move
     * it the writes to the given output file
     * @param input the json object being given will contain two values
     *              board: an array containing the state of the board
     *              move: the move to be done
     * @param output the output file will contain a single JSON object
     *               That object will contain a value
     *               board: an array containing the new state of the board
     */
    public void run(JSONObject input, File output){ }
}
