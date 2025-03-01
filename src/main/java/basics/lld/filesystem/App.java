package basics.lld.filesystem;

import java.util.List;

/**
 * Input:
 * ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
 * [[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
 * Output:
 * [null,[],null,null,["a"],"hello"]
 */
public class App {

    public static void main(String[] args) {
        FileSystem obj = new FileSystem();
//        List<String> param_1 = obj.ls(path);
//        obj.mkdir(path);
//        obj.addContentToFile(filePath, content);
//        String param_4 = obj.readContentFromFile(filePath);
    }
}
