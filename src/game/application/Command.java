package game.application;

import game.application.exceptions.InvalidCommandException;
import java.util.Arrays;

public enum Command {
    GO,
    HELP,
    LOOK,
    BAG,
    TAKE,
    QUIT,
    USE,
    YES,
    NO,
    ATTACK,
    INVALID;

    /**
     * 
     * @param strScanned
     * @return Command
     * @throws game.application.exceptions.InvalidCommandException
     */
    public static Command getCommand(String strScanned) throws InvalidCommandException{
        
        String[] tabScanned = strScanned.split(" ");
        String sCommand;
        if(tabScanned[0].length() > 3) {
            sCommand = tabScanned[0].substring(0, 3);
        }
        else {
            sCommand = tabScanned[0];
        }
        
        String cmd = sCommand.toUpperCase();
        Command c;
        
        switch(cmd) {
            
            case "GO":
                c = Command.GO;
                break;
            case "HEL":
                c = Command.HELP;
                break;
            case "LOO":
                c = Command.LOOK;
                break;
            case "BAG":
                c = Command.BAG;
                break;
            case "TAK":
                c = Command.TAKE;
                break;
            case "QUI":
                c = Command.QUIT;
                break;
            case "USE":
                c = Command.USE;
                break;    
            case "YES":
                c = Command.YES;  
                break;
            case "NO":
                c = Command.NO;
                break;
            case "ATT":
            	c = Command.ATTACK;
            	break;
            default:
                c = Command.INVALID;
                break;
        }
        
        if(c == Command.INVALID) {
            throw new InvalidCommandException();
        }
        
        return c;
    }
    
    
    /**
     * 
     * @param s
     * @return 
     */
    public static String[] getParameters(String s) {
        String[] tabParams = s.split(" ");
        int ind = 2;
        String arg1 = null;
        String arg2 = "";
        boolean on = false;
        if (tabParams.length >= 2) {
            arg1=tabParams[1];
            while (ind < tabParams.length && !tabParams[ind].equalsIgnoreCase("on")) {
                arg1 = arg1 + " " + tabParams[ind];
                ind++;
            }
            ind++;
            while (ind < tabParams.length) {
                arg2 = arg2 + tabParams[ind];
                ind++;
                if (ind < tabParams.length-1) {
                    arg2+=" ";
                }
            }
        }
        if(arg1 != null && !arg2.isEmpty()) {
            return new String[]{arg1,arg2};
        }else if(arg1 !=null) {
            return new String[]{arg1};
        }else 
            return new String[]{};

    }
}
