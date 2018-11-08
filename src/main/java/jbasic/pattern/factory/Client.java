package jbasic.pattern.factory;

public class Client {
    public static void main(String[] args) {
        Parser parser=ParserFactory.getParser("xml");
        Employee employee=parser.parser("employee.json");
    }
}
