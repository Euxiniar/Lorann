/**
 * <h1>The LevelDAO.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Level;

/**
 * @author vazvi
 *
 */
public class LevelDAO extends AbstractDAO{
    
    /** The string used for draw the level's map */ 
	private static String codeLevel   = "{CALL recuperer_code_niveau(?)}";
    
    public static Level getCodeLevel(final int id) throws SQLException {
    	final CallableStatement callStatement = prepareCall(codeLevel);
    	Level level = null;
    	callStatement.setInt(1, id);
    	if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                level = new Level(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4));
            }
            result.close();
        }
    	return level;
    }
}