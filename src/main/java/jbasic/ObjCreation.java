package jbasic;

public class ObjCreation {
  public static void main(String[] args) {
    Child ch= new Child();
  }
}

class Parent{
  D c= new D();

  static{
    System.out.println("A");
  }

  {
    System.out.println("B");
  }

  public Parent(){
    System.out.println("C");
  }

}

class Child extends Parent{

  C c = new C();
  static{
    System.out.println("D");
  }
  {
    System.out.println("E");
  }
  public Child(){
    System.out.println("F");
  }
}

class C {

  public C(){
    System.out.println("X");
  }
}

class D {

  public D(){
    System.out.println("Y");
  }
}