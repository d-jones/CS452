class Main extends Lib {
  int j;
  public void main() {
    for (int i = 0; i < 12; i++) {
    printInt(i);
    printStr("\n");
    for (int j = 0; j < i; j++) {
      printInt(i+j);
      printStr("\n");
      if (i == 5) break;
      }
    }
    printInt(j);
    printStr("\n");
    new Abc().main();
  }
}

class Abc extends Main {
  public void main() {
    super.main();
    printStr("The end\n");
  }
}
class Abcd extends Abc {
  public void main() {
    j = 3;
  }
}
