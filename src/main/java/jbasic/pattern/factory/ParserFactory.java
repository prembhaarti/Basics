package jbasic.pattern.factory;

public class ParserFactory {
    public static Parser getParser(String fileName) {
        Parser parser=null;
        if (fileName == null||fileName.trim().equalsIgnoreCase("")) {
            return parser;
        }
        switch (fileName.toUpperCase()) {
            case "JSON":
                return new JsonParser();
            case "XML":
                return new XmlParser();
            case "CSV":
                return new XmlParser();
        }
        return parser;
    }

    public static void main(String ar[]) {

    }
}
