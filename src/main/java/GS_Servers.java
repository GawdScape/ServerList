import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Vinnie on 10/14/15.
 */
public class GS_Servers {

    public static List loadDefaultServers() {
        List serverList = Lists.newArrayList();
        try {
            InputStream in = GS_Servers.class.getResourceAsStream("assets/gawdscape/servers.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (!currentLine.contains("=")) {
                    continue;
                }
                String[] server = currentLine.split("=");
                if (server.length != 2) {
                    continue;
                }
                // Add server [Name, IP]
                serverList.add(new cew(server[0], server[1]));
            }
            in.close();
        } catch (IOException ex) {
            LogManager.getLogger().error("Error loading default servers.", ex);
        } catch (NullPointerException ex) {
            LogManager.getLogger().error("Default server list is null.");
        }
        return serverList;
    }

}
