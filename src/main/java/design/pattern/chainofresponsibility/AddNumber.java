package design.pattern.chainofresponsibility;

public class AddNumber implements Handler {
  private Handler nextHandler;

  @Override
  public void setNextHandler(Handler handler) {
    this.nextHandler=handler;
  }

  @Override
  public void process(Request request) {
    if(request.getOperation().equals("add")){
      System.out.println(request.getNum1()+" + "+request.getNum2()+" = "+
      (request.getNum1()+request.getNum2()));
    }
    else {
      nextHandler.process(request);
    }
  }
}
