class Main extends Lib {
  public void main() {
    int x = f(f(f(x)));
  }
  public int f(int x) {
    return x+1;
  }
}
